/*
 * Copyright (C) 2011 Fhpt All Rights Reserved.
 * 
 * ResourceUtil.java
 */
package com.tal.util;


import java.util.Locale;
import java.util.ResourceBundle;

/**
 * [文件名称]<br>
 * ResourceUtil <br>
 * <br>
 * [文件描述]<br>
 * 资源文件.<br>
 * <br>
 * [修改记录]<br>
 * 2011-8-31 ver1.00 创建 chenghong<br>
 * 
 * @author chenghong
 * @version 1.00
 */
public class ResourceUtil {
	
	/**
	 * 隐藏构造器
	 */
	private ResourceUtil(){
		
	}
	
	/**
	 * 本地语言类型，中文 
	 */
	private static Locale locale = new Locale("zh", "CN"); 	
	
	/**
	 * 资源文件名
	 */
    private static  ResourceBundle resBundle = ResourceBundle.getBundle("resource", locale);
    

    /**
     * 从资源文件获取message
     * @author chenghong
     * @param key 资源文件里的键
     * @return  资源文件里的message
     */
    public static String  getMessage(String key){
    	String message=null;
    	try{
    		message= resBundle.getString(key);
    	}
    	catch(Exception e){
    		e.printStackTrace();    		
    	}
    	return message;
    }



}
