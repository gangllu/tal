/*
 * Copyright (C) 2011 Fhpt All Rights Reserved.
 * 
 * zhanggang
 */
package com.tal.util;


/**
 * [文件名称]<br>
 * RequestUtil <br>
 * <br>
 * [文件描述]<br>
 * 数据类型的转换工具类<br>
 * <br>
 * [修改记录]<br>
 * 2011-8-5 ver1.00 创建 zhanggang<br>
 * 
 * @author zhanggang
 * @version 1.00
 */
public class RequestUtil {
	
	/**
	 * 获得请求前缀
	 * @param url
	 * @return
	 */
	public static String getPrefixUrl(String url){
		String result = "";
		int index = url.indexOf("/");
		url = url.substring(index+1);
		int secondIndex = url.indexOf("/");
		url = url.substring(0,secondIndex);
		result = "/"+url;
		return result;
	}
	
	public static void main(String args[]){
		System.out.println(getPrefixUrl("/test/getUser"));
	}
}
