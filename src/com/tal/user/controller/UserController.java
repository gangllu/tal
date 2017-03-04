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

import com.tal.dao.TbUserMapper;
import com.tal.lesson.service.LessonService;
import com.tal.model.Lesson;
import com.tal.model.TbUser;

@Controller
public class UserController {
	
	private static final Log log = LogFactory.getLog(UserController.class);

	@Autowired
	TbUserMapper userMapper;
	
	@Autowired
	LessonService lessonService;

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/main")
	public String showMain() {
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

}
