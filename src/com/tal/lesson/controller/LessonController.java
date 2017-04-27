package com.tal.lesson.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.tal.app.BaseResult;
import com.tal.lesson.service.LessonService;
import com.tal.model.Lesson;
import com.tal.model.TbUser;
import com.tal.model.TbWork;
import com.tal.studentwork.service.StudentWorkService;
import com.tal.user.service.UserService;
import com.tal.util.ExcelWriter;
import com.tal.util.IdGenerator;
import com.tal.util.page.Page;
import com.tal.util.page.PageObject;
import com.tal.work.service.WorkService;

@Controller
@RequestMapping("/lesson")
public class LessonController {

	private static final Log log = LogFactory.getLog(LessonController.class);
	
	private static final String USER_DEFAULT_PASSWORD = "111111";
	
	@Value("${doc.dir}")
	String docDir;
	
	@Autowired
	LessonService service;
	
	@Autowired
	UserService userService;
	
	@Autowired
	StudentWorkService studentWorkService;
	
	@Autowired
	WorkService workService;
	
	@RequestMapping("/listPage")
	public String listPage(){
		return "lesson/lesson";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public PageObject<Lesson> listlesson(@RequestParam Integer start,
			@RequestParam Integer length,HttpServletRequest request){
		
		Lesson b = new Lesson();
		Page pageInfo = new Page((start/length) + 1,length);
		b.setPage(pageInfo);
		
		b.setLessonName(request.getParameter("lessonName"));
		TbUser user = (TbUser) request.getSession().getAttribute("userInfo");
		b.setTeacherId(user.getUserId());
		
		PageObject<Lesson> pageModel = service.listPagelessonByUser(b);
		return pageModel;
	}
	
	@RequestMapping("/getLesson")
	@ResponseBody
	public List<Lesson> getLesson(HttpServletRequest request){
		TbUser user = (TbUser) request.getSession().getAttribute("userInfo");
		
		List<Lesson> list = service.getLessons(user.getRole(),user.getUserId());
		return list;
	}
	
	@RequestMapping("/getLessonById")
	@ResponseBody
	public Lesson getLessonById(@RequestParam Integer lessonId,
			HttpServletRequest request){
		
		return service.selectByPrimaryKey(lessonId);
	}
	
	//新增或修改课程
	@RequestMapping(value = "/addOrUpdatelesson", method = RequestMethod.POST)
	@ResponseBody
	public BaseResult addOrUpdatelesson(DefaultMultipartHttpServletRequest request, 
			@RequestParam String lessonName,@RequestParam MultipartFile file,
			@RequestParam String year,HttpServletResponse response) {
		String message = "";
		String status = "1";
		BaseResult result = new BaseResult();
		try {
			Lesson lesson = new Lesson();
			lesson.setLessonName(lessonName);
			lesson.setYear(year);
			TbUser user = (TbUser) request.getSession().getAttribute("userInfo");
			
			if(file.isEmpty()){
				message = "请上传文件！";
				status = "0";
			}else{
				String lessonId = request.getParameter("lessonId");
				message = service.addOrUpdatelesson(lesson, lessonId, user.getUserId(), 
						USER_DEFAULT_PASSWORD, file.getInputStream());
			}
			
		} catch (Exception e) {
			message = "处理失败！";
			log.error(message, e);
			status = "0";
		}

		result.setStatus(status);
		result.setMessage(message);
		
		try {
			response.getWriter().write("<script type=\"text/javascript\">");
			if("0".equals(status)){
				response.getWriter().write("window.parent.showError('" + message + "');");
			}else{
				response.getWriter().write("window.parent.showTips('" + message + "');");
			}
			
			response.getWriter().write("window.parent.lessonTable.ajax.reload();");
			response.getWriter().write("window.parent.$('#myModal-add-info').modal('hide');");
			response.getWriter().write("</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@RequestMapping("/deleteLesson")
	@ResponseBody
	public BaseResult deleteLesson(@RequestParam Integer lessonId,
			HttpServletRequest request){
		BaseResult result = new BaseResult();
		try{
			TbUser user = (TbUser) request.getSession().getAttribute("userInfo");
			service.deleteLesson(user.getUserId(), lessonId);
			result.setMessage("删除课程成功");
			result.setStatus("1");
		}catch(Exception e){
			log.error("删除课程失败", e);
			result.setMessage("删除课程失败");
			result.setStatus("0");
		}
		
		return result;
	}
	
	
	@RequestMapping("/lessonScorePage")
	public String lessonScorePage(HttpServletRequest request){
		Integer lessonId = (Integer)request.getSession().getAttribute("lessonId");
		List<TbWork> workList = workService.getWorkByLesson(lessonId);
		List<Map<String,String>> studentWorkList = studentWorkService
				.getLessonStudentWorkScore(lessonId);
		
		request.setAttribute("workList", workList);
		request.setAttribute("studentWorkList", studentWorkList);
		
		
		return "lesson/lessonScore";
	}
	
	@RequestMapping("/downloadLessonScore")
	public ResponseEntity<byte[]> downloadLessonScore(HttpServletRequest request)
			throws IOException{
		Integer lessonId = (Integer)request.getSession().getAttribute("lessonId");
		List<TbWork> workList = workService.getWorkByLesson(lessonId);
		List<Map<String,String>> studentWorkList = studentWorkService
				.getLessonStudentWorkScore(lessonId);
		Lesson lesson = service.selectByPrimaryKey(lessonId);
		
		String fileName = IdGenerator.genOrdId16() + ".xls";
		File f = new File(docDir + File.separator + fileName);
		ExcelWriter e = new ExcelWriter();

		try {
			e = new ExcelWriter(new FileOutputStream(f));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		//写入execl
		//写标题
		e.createRow(0);
		e.setCell(0, "学生");
		for(int i = 0; i < workList.size() ; i ++){
			e.setCell(i + 1, workList.get(i).getWorkTile());
		}
		
		//写数据
		for(int i = 0; i < studentWorkList.size(); i ++){
			e.createRow(i + 1);
			Map<String,String> s = studentWorkList.get(i);
			
      		e.setCell(0,s.get("userName"));
      		
      		for(int j = 0; j < workList.size() ; j ++){
      			TbWork w = workList.get(j);
    			e.setCell(j + 1, (s.get(w.getWorkTile()).equals("null") ? "" : s.get(w.getWorkTile())));
    		}
      	}
		
		try {
			e.export();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		HttpHeaders headers = new HttpHeaders();    
        try {
			String downloadName = new String((lesson.getLessonName() + ".xls")
					.getBytes("UTF-8"),"iso-8859-1");
			headers.setContentDispositionFormData("attachment", downloadName);   
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//为了解决中文名称乱码问题  
        
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(f),    
                                          headers, HttpStatus.CREATED);
		
	}
	
}
