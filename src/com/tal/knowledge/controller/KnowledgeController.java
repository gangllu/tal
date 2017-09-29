package com.tal.knowledge.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.tal.knowledge.service.KnowledgeService;
import com.tal.lesson.service.LessonService;
import com.tal.model.Knowledge;
import com.tal.model.Lesson;
import com.tal.model.StudentWork;
import com.tal.model.TbUser;
import com.tal.util.DateUtil;
import com.tal.util.IdGenerator;
import com.tal.util.page.Page;
import com.tal.util.page.PageObject;

@Controller
@RequestMapping("/k")
public class KnowledgeController {
	
	private static final Log log = LogFactory.getLog(KnowledgeController.class);
	
	@Autowired
	KnowledgeService service;
	
	@Autowired
	LessonService lessonService;
	
	@RequestMapping("/listPage")
	public String listPage(HttpServletRequest request){
		request.setAttribute("ktype", request.getParameter("ktype"));
		
		return "knowledge/kList";
	}
	
	@RequestMapping("/listK")
	@ResponseBody
	public PageObject<Knowledge> listK(@RequestParam Integer start,
			@RequestParam Integer length,HttpServletRequest request,
			@RequestParam String ktype){
		Knowledge b = new Knowledge();
		Page pageInfo = new Page((start/length) + 1,length);
		b.setPage(pageInfo);
		b.setkType(ktype);
		
		b.setTitle(request.getParameter("title"));
		
		Integer lessonId = (Integer)request.getSession().getAttribute("lessonId");
		if(lessonId != null){
			b.setLessonId(lessonId);
		}
		
		PageObject<Knowledge> pageModel = service.listPageKnowledge(b);
		return pageModel;
	}
	
	@RequestMapping(value = "/addOrUpdateKnowledge", method = RequestMethod.POST)
	public String addOrUpdateKnowledge(DefaultMultipartHttpServletRequest request,
			@RequestParam String title,HttpServletResponse response,
			@RequestParam String content,@RequestParam String ktype,
			@RequestParam MultipartFile file) {
		String message = "";
		String status = "1";
		BaseResult result = new BaseResult();
		Knowledge k = new Knowledge();
		try {
			k.setkType(ktype);
			k.setTitle(title);
			k.setContent(content);
			
			String answerContent = request.getParameter("answerContent");
			if("".equals(answerContent)){
				answerContent = null;
			}
			k.setAnswerContent(answerContent);
			
			Integer lessonId = (Integer)request.getSession().getAttribute("lessonId");
			k.setCreateDt(DateUtil.getCurrentTime());
			
			TbUser user = (TbUser)request.getSession().getAttribute("userInfo");
			
			Lesson lesson = lessonService.selectByPrimaryKey(lessonId);
			
			if(!file.isEmpty()){
				//保存文件，保存在课程目录下
				String foler = lesson.getLessonDesc();
				String filePath = foler + File.separator + IdGenerator.genOrdId16() + "--" + 
						file.getOriginalFilename();
				file.transferTo(new File(filePath));
				
				k.setkFile(filePath);
			}
			
			String id = request.getParameter("id");
			if (null == id || "".equals(id)) {
				// 新增
				k.setLessonId(lessonId);
				k.setUserId(user.getUserId());
				service.insertSelective(k);
				message = "新增成功！";
			} else {
				// 更新
				k.setId(Long.parseLong(id));
				service.updateByPrimaryKeySelective(k);
				message = "更新成功！";
			}
		} catch (Exception e) {
			status = "0";
			message = "处理失败！";
			log.error(message, e);
		}

		result.setMessage(message);
		result.setStatus(status);
		request.setAttribute("result", result);
		request.setAttribute("id", k.getId());
		log.debug("============" + k.getId());
		
		if("3".equals(ktype)){
			return "forward:/k/viewKWithAnswer?id=" + k.getId();
		}else{
			return "forward:/k/viewK?id=" + k.getId();
		}
		
	}
	
	@RequestMapping("/viewK")
	public String viewK(@RequestParam Long id,HttpServletRequest request){
		if(id == null){
			id = (Long)request.getAttribute("id");
		}
		Knowledge k = service.selectByPrimaryKey(id);
		
		request.setAttribute("k", k);
		
		return "knowledge/viewK";
	}
	
	@RequestMapping("/viewKWithAnswer")
	public String viewKWithAnswer(@RequestParam Long id,HttpServletRequest request){
		if(id == null){
			id = (Long)request.getAttribute("id");
		}
		Knowledge k = service.selectByPrimaryKey(id);
		
		request.setAttribute("k", k);
		
		return "knowledge/viewKWithAnswer";
	}
	
	@RequestMapping("/showEdit")
	public String showEdit(HttpServletRequest request){
		String id = request.getParameter("id");
		if(null != id && !"".equals(id)){
			Knowledge k = service.selectByPrimaryKey(Long.parseLong(id));
			
			request.setAttribute("k", k);
		}
		request.setAttribute("ktype", request.getParameter("ktype"));
		
		return "knowledge/editK";
	}
	
	@RequestMapping("/showEditWithAnswer")
	public String showEditWithAnswer(HttpServletRequest request){
		String id = request.getParameter("id");
		if(null != id && !"".equals(id)){
			Knowledge k = service.selectByPrimaryKey(Long.parseLong(id));
			
			request.setAttribute("k", k);
		}
		request.setAttribute("ktype", request.getParameter("ktype"));
		
		return "knowledge/editKWithAnswer";
	}
	
	
	@RequestMapping("/downloadFile")    
    public ResponseEntity<byte[]> downloadFile(@RequestParam Long id)
    		throws IOException { 
    	Knowledge k = service.selectByPrimaryKey(id);
    	
        String path = k.getkFile(); 
        File file = new File(path);  
        HttpHeaders headers = new HttpHeaders();    
        String fileName = path.substring(path.indexOf("--") + 2);
        fileName = new String(fileName
        		.getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
        headers.setContentDispositionFormData("attachment", fileName);   
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
                                          headers, HttpStatus.CREATED);    
    }
    
    @RequestMapping("/deleteK")
	@ResponseBody
	public BaseResult deleteK(@RequestParam Long id,
			HttpServletRequest request){
		BaseResult result = new BaseResult();
		try{
			service.deleteByPrimaryKey(id);
				result.setMessage("删除成功");
				result.setStatus("1");
		}catch(Exception e){
			log.error("删除失败", e);
			result.setMessage("删除失败");
			result.setStatus("0");
		}
		
		return result;
	}

}
