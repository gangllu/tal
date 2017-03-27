package com.tal.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tal.app.BaseResult;
import com.tal.dao.TbUserMapper;
import com.tal.lesson.service.LessonService;
import com.tal.model.Lesson;
import com.tal.model.StudentWork;
import com.tal.model.TbUser;
import com.tal.model.TbWork;
import com.tal.studentwork.service.StudentWorkService;
import com.tal.work.service.WorkService;

@Controller
public class UserController {
	
	private static final Log log = LogFactory.getLog(UserController.class);

	@Autowired
	TbUserMapper userMapper;
	
	@Autowired
	LessonService lessonService;
	
	@Autowired
	WorkService workService;
	
	@Autowired
	StudentWorkService studentWorkService;

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/main")
	public String showMain(HttpServletRequest request) {
		TbUser user = (TbUser) request.getSession().getAttribute("userInfo");
		Integer lessonId = (Integer)request.getSession().getAttribute("lessonId");
		//获取学生的待完成作业列表
		if("student".equals(user.getRole())){
			List<TbWork> workList = workService.getTodoWork(user.getUserId(), lessonId);
			request.setAttribute("workList", workList);
		}
		
		//获取老师的待批改作业列表
		if("teacher".equals(user.getRole())){
			List<StudentWork> studentWorkList = studentWorkService.getToScoreStudentWork(
					lessonId);
			request.setAttribute("studentWorkList", studentWorkList);
		}
		return "main";
	}
	
	@RequestMapping("/index")
	public String showIndex(HttpServletRequest request) {
		TbUser user = (TbUser) request.getSession().getAttribute("userInfo");
		
		List<Lesson> list = lessonService.getLessons(user.getRole(),user.getUserId());
		request.setAttribute("lessons", list);
		
		Integer lessonId = (Integer)request.getSession().getAttribute("lessonId");
		if(lessonId == null){
			//如果当前课程没有设置，则设置当前课程
			if(list.size() > 0){
				lessonId = list.get(0).getLessonId();
				request.getSession().setAttribute("lessonId", list.get(0).getLessonId());
				request.getSession().setAttribute("lesson", list.get(0));
			}
		}
		
		
		
		return "index";
	}
	
	@RequestMapping("/showSignUp")
	public String showSignUp() {
		return "signup2";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().setAttribute("lessonId", null);
		request.getSession().setAttribute("userInfo",null);
		return "login";
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	@ResponseBody
	public String signUp(@RequestBody TbUser user) {
		String message = "";
		try {
			userMapper.insert(user);
			message = "注册成功！";
		} catch (Exception e) {
			log.error("注册出错", e);
			message = "注册出错";
		}

		return message;
	}
	
	@RequestMapping(value="/doLogin",method=RequestMethod.POST)
	@ResponseBody
	public String doLogin(HttpServletRequest request,HttpServletResponse response,
			@RequestBody TbUser pUserInfo){
		String message = "";
		
		try{
			TbUser userInfo = userMapper.selectByNameAndPwd(pUserInfo);
			if(userInfo != null){
				request.getSession().setAttribute("userInfo", userInfo);
				message = "登陆成功";
			}else{
				message = "用户名或密码不存在，请重新输入！";
			}
		}catch(Exception e){
			log.error("登陆出错", e);
			message = "登陆出错";
		}
		
		return message;
	}
	
	@RequestMapping(value = "/changeCurrentLesson", method = RequestMethod.POST)
	@ResponseBody
	public String changeCurrentLesson(@RequestBody Lesson lesson,
			HttpServletRequest request) {
		String message = "";
		try {
			request.getSession().setAttribute("lessonId", lesson.getLessonId());
			request.getSession().setAttribute("lesson", lesson);
			message = "修改成功！";
		} catch (Exception e) {
			log.error("修改出错", e);
			message = "修改出错";
		}

		return message;
	}
	
	@RequestMapping("/showUpdateUser")
	public String showUpdateUser() {
		return "user";
	}
	
	@RequestMapping("/updateUser")
	@ResponseBody
	public BaseResult updateUser(@RequestParam String password,
			@RequestParam String email,
			@RequestParam String contact,HttpServletRequest request){
		BaseResult result = new BaseResult();
		try{
			TbUser user = (TbUser) request.getSession().getAttribute("userInfo");
			
			user.setContact(contact);
			user.setPassword(password);
			user.setEmail(email);
			
			userMapper.updateByPrimaryKeySelective(user);
			result.setMessage("修改成功");
			result.setStatus("1");
		}catch(Exception e){
			log.error("修改失败", e);
			result.setMessage("修改失败");
			result.setStatus("0");
		}
		
		return result;
	}

}
