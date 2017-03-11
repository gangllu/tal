package com.tal.work.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.tal.app.BaseResult;
import com.tal.dao.TbWorkMapper;
import com.tal.lesson.service.LessonService;
import com.tal.model.Lesson;
import com.tal.model.StudentWork;
import com.tal.model.TbUser;
import com.tal.model.TbWork;
import com.tal.studentwork.service.StudentWorkService;
import com.tal.util.DateUtil;
import com.tal.util.DateUtil2;
import com.tal.util.IdGenerator;
import com.tal.util.page.Page;
import com.tal.util.page.PageObject;
import com.tal.work.service.WorkService;

@Controller
@RequestMapping("/work")
public class WorkController {
	
	private static final Log log = LogFactory.getLog(WorkController.class);
	
	@Autowired
	TbWorkMapper workMapper;
	
	@Autowired
	WorkService workService;
	
	@Autowired
	LessonService lessonService;
	
	@Autowired
	StudentWorkService studentWorkService;
	
	@RequestMapping("/listPage")
	public String listPage(){
		return "work/work";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public PageObject<TbWork> listWork(@RequestParam Integer start,
			@RequestParam Integer length,HttpServletRequest request){
		TbWork b = new TbWork();
		Page pageInfo = new Page((start/length) + 1,length);
		b.setPage(pageInfo);
		
		b.setWorkTile(request.getParameter("workTitle"));
		b.setWorkDate1Start(request.getParameter("workDate1Start"));
		b.setWorkDate1End(request.getParameter("workDate1End"));
		
		Integer lessonId = (Integer)request.getSession().getAttribute("lessonId");
		if(lessonId != null){
			b.setLessonId(lessonId);
		}
		
		PageObject<TbWork> pageModel = workService.listPageworkByUser(b);
		return pageModel;
	}
	
	@RequestMapping("/getWorkById")
	@ResponseBody
	public TbWork getWorkById(@RequestParam Long workId,
			HttpServletRequest request){
		
		return workMapper.selectByPrimaryKey(workId);
	}
	
	//新增作业
	@RequestMapping(value = "/addOrUpdateWork", method = RequestMethod.POST)
	@ResponseBody
	public BaseResult addOrUpdateWork(DefaultMultipartHttpServletRequest request,
			@RequestParam String workText1,HttpServletResponse response,
			@RequestParam String workTitle,@RequestParam MultipartFile workFile,
			@RequestParam String completeDt) {
		String message = "";
		String status = "1";
		BaseResult result = new BaseResult();
		try {
			TbWork work = new TbWork();
			work.setWorkTile(workTitle);
			work.setWorkText1(workText1);
			work.setWorkDate1(DateUtil.getCurrentTime());
			work.setCompleteDt(DateUtil2.parseDate(completeDt));
			

			String workId = request.getParameter("workId");
			Integer lessonId = (Integer)request.getSession().getAttribute("lessonId");
			Lesson lesson = lessonService.selectByPrimaryKey(lessonId);
			//创建作业的目录
			String workFolderPath = lesson.getLessonDesc() + File.separator +
					work.getWorkTile();
			File workFolderPathFile = new File(workFolderPath);
			if(!workFolderPathFile.exists()){
				workFolderPathFile.mkdir();
			}
			
			work.setWorkPath(workFolderPath);
			
			String workFilePath = "";
			if(!workFile.isEmpty()){
				workFilePath = workService.saveWorkFile(lessonId, work, workId, workFile);
				work.setWorkFile(workFilePath);
			}
			
			if (null == workId || "".equals(workId)) {
				// 新增
				work.setLessonId(lessonId);
				
				workMapper.insertSelective(work);
				message = "新增成功！";

			} else {
				// 更新
				work.setWorkId(Long.parseLong(workId));
				workMapper.updateByPrimaryKeySelective(work);
				message = "更新成功！";
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
			
			response.getWriter().write("window.parent.workTable.ajax.reload();");
			response.getWriter().write("window.parent.$('#myModal-add-info').modal('hide');");
			response.getWriter().write("</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@RequestMapping("/deleteWork")
	@ResponseBody
	public BaseResult deleteWork(@RequestParam Long workId,
			HttpServletRequest request){
		BaseResult result = new BaseResult();
		try{
			Integer studentWorkCount = studentWorkService.getStudentWorkCountByWorkId(workId);
			if(studentWorkCount > 0){
				result.setMessage("该课程已有学生完成作业，不能删除");
				result.setStatus("0");
			}else{
				workMapper.deleteByPrimaryKey(workId);
				result.setMessage("删除课程成功");
				result.setStatus("1");
			}
		}catch(Exception e){
			log.error("删除课程失败", e);
			result.setMessage("删除课程失败");
			result.setStatus("0");
		}
		
		return result;
	}
	
	@RequestMapping("/showDoWork")
	public String showDoWork(@RequestParam Long workId,HttpServletRequest request){
		TbWork work = workMapper.selectByPrimaryKey(workId);
		request.setAttribute("work", work);
		return "work/doWork";
	}
	
	@RequestMapping(value = "/addOrUpdateStudentWork", method = RequestMethod.POST)
	public String addOrUpdateStudentWork(DefaultMultipartHttpServletRequest request,
			@RequestParam Long workId,HttpServletResponse response,
			@RequestParam String workContent,@RequestParam MultipartFile studentWorkFile) {
		String message = "";
		String status = "1";
		BaseResult result = new BaseResult();
		String id = request.getParameter("id");
		try {
			
			StudentWork work = new StudentWork();
			work.setWorkDt(DateUtil.getCurrentTime());
			work.setWorkId(workId);
			work.setWorkContent(workContent);
			TbUser user = (TbUser) request.getSession().getAttribute("userInfo");
			work.setUserId(user.getUserId());

			
			
			TbWork w = workService.selectByPrimaryKey(workId);
			String workFilePath = w.getWorkPath();
			if(!studentWorkFile.isEmpty()){
				//保存文件
				work.setWorkFileName(studentWorkFile.getOriginalFilename());
				String newFileName = IdGenerator.genOrdId16() + "-" + 
						studentWorkFile.getOriginalFilename();
				workFilePath = workFilePath + File.separator + newFileName;
				work.setWorkFilePath(workFilePath);
				studentWorkFile.transferTo(new File(workFilePath));
			}
			
			if (null == id || "".equals(id)) {
				// 新增
				studentWorkService.insertSelective(work);
				
				id = String.valueOf(work.getId());
				message = "新增成功！";

			} else {
				// 更新
				work.setId(Long.parseLong(id));
				studentWorkService.updateByPrimaryKeySelective(work);
				message = "更新成功！";
			}
		} catch (Exception e) {
			message = "处理失败！";
			log.error(message, e);
			status = "0";
		}

		result.setStatus(status);
		result.setMessage(message);
		
		request.setAttribute("message", message);

		return "forward:viewWork?id=" + id + "&workId=" + workId;
	}
	
	@RequestMapping("/viewWork")
	public String viewWork(@RequestParam Long workId,@RequestParam Long id,
			HttpServletRequest request){
		StudentWork studentWork = studentWorkService.selectByPrimaryKey(id);
		TbWork work = workService.selectByPrimaryKey(workId);
		request.setAttribute("work", work);
		request.setAttribute("studentWork", studentWork);
		
		return "work/viewWork";
	}

}
