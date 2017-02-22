package com.tal.system.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserFilter extends HttpServlet implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0; 
		HttpServletResponse response = (HttpServletResponse) arg1; 
		
		String url = request.getRequestURI();
        if(url.indexOf("/index.jsp") >= 0 || url.indexOf("/login") >= 0 
        		|| url.indexOf("/doLogin") >= 0 || url.indexOf("resource/") >= 0
        		|| url.indexOf("Ukey") > 0 || url.indexOf("app/") > 0
        		|| url.indexOf("/doFLogin") >= 0
        		|| url.indexOf(".jpg") >= 0 || url.indexOf(".png") >= 0
        		|| url.indexOf(".gif") >= 0 || url.indexOf(".js") >= 0
        		|| url.indexOf(".css") >= 0 || url.indexOf(".html") >= 0
        		|| url.indexOf("*.apk") >= 0 || url.indexOf("/notify") >= 0
        		|| url.indexOf("showSignUp") >= 0 || url.indexOf("signup") >= 0
        		|| url.indexOf("signUp") >= 0
        		){
        	filterChain.doFilter(request, response);
        	return;
        }
		
		if(request.getSession().getAttribute("userInfo") == null){
			request.getRequestDispatcher("/").forward(request, response);
		}else{
			filterChain.doFilter(request, response);   
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
