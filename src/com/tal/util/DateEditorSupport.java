/*
 * Copyright (C) 2011 Fhpt All Rights Reserved.
 * 
 * DateEditorSupport.java
 */
package com.tal.util;


import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * [文件名称]<br>
 * DateEditorSupport <br>
 * <br>
 * [文件描述]<br>
 * 内容摘要.<br>
 * <br>
 * [修改记录]<br>
 * 2011-9-19 ver1.00 创建 zhuyingxi<br>
 * 
 * @author zhuyingxi
 * @version 1.00
 */
public class DateEditorSupport extends PropertyEditorSupport {
	
	/**
	 * string to date
	 */
	public void setAsText(String value) {
		try {
			setValue(new SimpleDateFormat("yyyy-MM-dd").parse(value));
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * date to string
	 */
	public String getAsText() {
		return new SimpleDateFormat("yyyy-MM-dd").format((Date)getValue());
	}

}
