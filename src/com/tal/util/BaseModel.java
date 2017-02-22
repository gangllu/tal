/*
 Copyright (C) 2011 Fhpt All Rights Reserved.
 * 
 * BaseModel.java
 */
package com.tal.util;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * [文件名称]<br>
 * BaseModel <br>
 * <br>
 * [文件描述]<br>
 * 内容摘要.<br>
 * 模型基类
 * <br>
 * [修改记录]<br>
 * 2011-8-10 ver1.00 创建 zhuyingxi<br>
 * 
 * @author zhuyingxi
 * @version 1.00
 */
public class BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 简单实现toString方法
	 * @return string
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	/**
	 * toJson序列化
	 * @return json
	 */
	public String toJson() {
		return null;
	}

	/**
	 * toXml序列化
	 * @return xml
	 */
	public String toXml() {
		return null;
	}

}
