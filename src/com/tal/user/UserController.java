package com.tal.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tal.dao.TbUserMapper;
import com.tal.model.TbUser;

@Controller
public class UserController {
	
	private static final Log log = LogFactory.getLog(UserController.class);

	@Autowired
	TbUserMapper userMapper;

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/index")
	public String showIndex() {
		return "index";
	}
	
	@RequestMapping("/showSignUp")
	public String showSignUp() {
		return "signup2";
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	@ResponseBody
	public String signUp(@RequestBody TbUser user) {
		String message = "";
		userMapper.insert(user);
		try {
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

}
