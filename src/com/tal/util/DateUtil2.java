/*
 * Copyright (C) 2011 Fhpt All Rights Reserved.
 * 
 * DateUtil.java
 */
package com.tal.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date; 

/**
 * [文件名称]<br>
 * DateUtil <br>
 * <br>
 * [文件描述]<br>
 * 内容摘要.<br>
 * 日期工具类
 * <br>
 * [修改记录]<br>
 * 2011-8-10 ver1.00 创建 zhuyingxi<br>
 * 
 * @author zhuyingxi
 * @version 1.00
 */
public class DateUtil2 {
	
	/**
	 * 完整日期格式
	 */
	private static final SimpleDateFormat DF_TIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 年月日日期格式
	 */
	private static final SimpleDateFormat DF_DATE = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 隐藏构造方法
	 */
	private DateUtil2() {
		super();
	}
	
	/**
	 * 获取当前时间
	 * @return 当前时间
	 */
	public static Date getCurrentTime() {
		return new Date();
	}
	
	/**
	 * 获取当前时间
	 * @return 当前时间
	 */
	public static String getCurrentTimeStr() {
		return DF_TIME.format(System.currentTimeMillis());
	}
	
	/**
	 * 获取当前日期
	 * @return 当前日期
	 */
	public static String getCurrentDateStr() {
		return DF_DATE.format(System.currentTimeMillis());
	}
	
	/**
	 * 转换日期
	 * @param date 日期字符串
	 * @return 日期
	 * @throws ParseException 输入格式有误
	 */
	public static Date parseDate(String date) throws ParseException {
		return DF_DATE.parse(date);
	}
	
	/**
	 * 转换日期时间
	 * @param date 日期字符串
	 * @return 日期
	 * @throws ParseException 输入格式有误
	 */
	public static Date parseDateTime(String dateTime) throws ParseException {
		return DF_TIME.parse(dateTime);
	}
	
	/**
	 * 格式化日期
	 * @param date 日期
	 * @return 日期字符串
	 */
	public static String formatDate(Date date) {
		return DF_DATE.format(date);
	}
	
	/**
	 * 格式化时间
	 * @param time 时间
	 * @return 时间字符串
	 */
	public static String formatTime(Date time) {
		return DF_TIME.format(time);
	}
	
	/**
	 * 获取前一天日期
	 * @param date 日期
	 * @return 前一天日期
	 */
	public static Date getLastDayDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
		return calendar.getTime();
	}

}
