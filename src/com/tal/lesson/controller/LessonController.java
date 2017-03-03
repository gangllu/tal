package com.tal.lesson.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
import com.tal.lesson.service.LessonService;
import com.tal.model.Lesson;
import com.tal.model.TbUser;
import com.tal.user.service.UserService;
import com.tal.util.DateUtil;
import com.tal.util.ExcelReader;
import com.tal.util.page.Page;
import com.tal.util.page.PageObject;

@Controller
@RequestMapping("/lesson")
public class LessonController {

	private static final Log log = LogFactory.getLog(LessonController.class);
	
	private static final String USER_DEFAULT_PASSWORD = "123456";
	
	@Autowired
	LessonService service;
	
	@Autowired
	UserService userService;
	
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
		
		PageObject<Lesson> pageModel = service.listPagelessonByUser(b);
		return pageModel;
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
			//lesson.setUserId(user.getUserId());
			
			if(!file.isEmpty()){
				List<TbUser> list = getStudents(file.getInputStream());
				for(TbUser u : list){
					u.setPassword(USER_DEFAULT_PASSWORD);
					u.setRole("student");
					userService.insertSelective(u);
				}
			}

			String lessonId = request.getParameter("lessonId");
			if (null == lessonId || "".equals(lessonId)) {
				// 新增
				lesson.setCreateDt(DateUtil.getCurrentTime());
				service.insertSelective(lesson);
				message = "新增成功！";

			} else {
				// 更新
				lesson.setLessonId(Integer.parseInt(lessonId));
				service.updateByPrimaryKeySelective(lesson);
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
			
			response.getWriter().write("window.parent.lessonTable.ajax.reload();");
			response.getWriter().write("window.parent.$('#myModal-add-info').modal('hide');");
			response.getWriter().write("</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public List<TbUser> getStudents(InputStream is) throws Exception {
		ExcelReader er = new ExcelReader(is);

		List<TbUser> list = new ArrayList<TbUser>();
		er.open();
		er.setSheetNum(0); // 设置读取索引为0的工作表
		// 总行数
		int count = er.getRowCount();
		for (int i = 4; i <= count; i++) {
			String[] cols = er.readExcelLine(i);
			TbUser user = new TbUser();
			user.setUserNo(cols[0]);
			user.setUserName(cols[2].trim());
		
			list.add(user);
		}

		return list;
	}
}
