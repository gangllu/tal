/*
 * Copyright (C) 2011 Fhpt All Rights Reserved.
 * 
 * chenghong
 */
package com.tal.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * [文件名称]<br>
 * DateUtil <br>
 * <br>
 * [文件描述]<br>
 * 数据类型的转换工具类<br>
 * <br>
 * [修改记录]<br>
 * 2011-8-5 ver1.00 创建 chenghong<br>
 * 
 * @author chenghong
 * @version 1.00
 */
public class DataFormat {

	/**
	 * FMT_DATE_YYYYMMDD
	 */
	public static final int FMT_DATE_YYYYMMDD = 1;
	
	/**
	 * FMT_DATE_YYYYMMDD_HHMMSS
	 */
	public static final int FMT_DATE_YYYYMMDD_HHMMSS = 2;
	
	/**
	 * FMT_DATE_HHMMSS
	 */
	public static final int FMT_DATE_HHMMSS = 3;
	
	/**
	 * FMT_DATE_HHMM
	 */
	public static final int FMT_DATE_HHMM = 4;
	
	/**
	 * FMT_DATE_SPECIAL
	 */
	public static final int FMT_DATE_SPECIAL = 5;
	
	/**
	 * FMT_DATE_YYYYMMDDHHMMSS
	 */
	public static final int FMT_DATE_YYYYMMDDHHMMSS = 6;
	
	/**
	 * 保留两位小数
	 */
	public static final DecimalFormat df = new DecimalFormat("#.00");  

	/**
	 * 构造文件隐藏
	 */
	private DataFormat() {

	}

	/**
	 * 日期格式
	 */
	public static final String DATESTYLE_LONG = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 将日期转换成指定格式的字符串
	 * 
	 * @param date
	 *            日期
	 * @param style
	 *            日期格式
	 * @return 指定格式的字符串
	 */
	public static String dateToString(Date date, String style) {
		SimpleDateFormat dFmt = new SimpleDateFormat(style);
		return dFmt.format(date);
	}

	/**
	 * this function is to format date into a string @ param date the date to be
	 * formatted.
	 * 
	 * @param nFmt
	 *            FMT_DATE_YYYYMMDD to format string like 'yyyy-mm-dd' or to
	 *            format string like 'yyyy-mm-dd hh:mm:ss'
	 * @param      date d
	 * @return String 
	 */
	public static String formatDate(Date date, int nFmt) {
		if(date==null) return null;
		SimpleDateFormat fmtDate = new SimpleDateFormat();
		switch (nFmt) {
		case DataFormat.FMT_DATE_YYYYMMDD:
			fmtDate.applyPattern("yyyy-MM-dd");
			break;
		case DataFormat.FMT_DATE_YYYYMMDD_HHMMSS:
			fmtDate.applyPattern("yyyy-MM-dd HH:mm:ss");
			break;
		case DataFormat.FMT_DATE_HHMM:
			fmtDate.applyPattern("HH:mm");
			break;
		case DataFormat.FMT_DATE_HHMMSS:
			fmtDate.applyPattern("HH:mm:ss");
			break;
		case DataFormat.FMT_DATE_SPECIAL:
			fmtDate.applyPattern("yyyyMMdd");
			break;
		case DataFormat.FMT_DATE_YYYYMMDDHHMMSS:
			fmtDate.applyPattern("yyyyMMddHHmmss");
			break;
		default:
		}
		return fmtDate.format(date);
	}

	/**
	 * parse date from string with specific format.
	 * 
	 * @param strDate
	 *            a date string
	 * @param nFmtDate
	 *            specific date string format defined in this class.
	 * @exception raise
	 *                ParseException, if string format dismathed.
	 * @return Date 日期类型
	 */
	public static Date parseDate(String strDate, int nFmtDate) throws Exception {
		SimpleDateFormat fmtDate = new SimpleDateFormat();
		switch (nFmtDate) {
		case DataFormat.FMT_DATE_YYYYMMDD:
			fmtDate.applyPattern("yyyy-MM-dd");
			break;
		case DataFormat.FMT_DATE_YYYYMMDD_HHMMSS:
			fmtDate.applyPattern("yyyy-MM-dd HH:mm:ss");
			break;
		case DataFormat.FMT_DATE_HHMM:
			fmtDate.applyPattern("HH:mm");
			break;
		case DataFormat.FMT_DATE_HHMMSS:
			fmtDate.applyPattern("HH:mm:ss");
			break;
		default:
		}
		return fmtDate.parse(strDate);
	}

	/**
	 * 格式化数字，例如：12345转化为12,345
	 * 
	 * @param dValue
	 *            被格式化的数值
	 * @param iScale
	 *            小数点后保留位数,不足补0
	 * @return 转换后的数据
	 */
	public static String formatNumber(double dValue, int iScale) {
		DecimalFormat df = null;
		StringBuffer sPattern = new StringBuffer(",##0");
		if (iScale > 0) {
			sPattern.append(".");
			for (int i = 0; i < iScale; i++) {
				sPattern.append("0");
			}
		}
		df = new DecimalFormat(sPattern.toString());
		return df.format(dValue);
	}

	/**
	 * 将long转化为string
	 * 
	 * @param lValue 需要转换的数据
	 * @param iScale 精确度
	 * @return 转换后的数据
	 */
	public static String formatNumber(long lValue, int iScale) {
		return formatNumber((double) lValue, iScale);
	}
	
	/**
	 * 格式化浮点数，保留两位小数  "1000.000" 转为 1000.00
	 * @param dValue 需要转换的数据
	 * @return 转换后的数据
	 */
	public static String formatNumber(double dValue) {
		java.text.DecimalFormat   ft = new   java.text.DecimalFormat("#0.00"); 		
		return ft.format(dValue);
	}
	
	

	/**
	 * 解析格式化的字符串，转化为数值，例如：12,345.00转化为12345
	 * 
	 * @param text
	 *            被格式化的数值
	 * @return 格式化后的数据
	 */
	public static double parseNumber(String text) {
		int index = text.indexOf(",");
		String sbNumber = "";
		while (index != -1) {
			sbNumber += text.substring(0, index);
			text = text.substring(index + 1, text.length());
			index = text.indexOf(",");
		}
		sbNumber += text;
		return Double.parseDouble(sbNumber);
	}

	/**
	 * 解析格式化的字符串，转化为long，例如：12,345转化为12345
	 * 
	 * @param text
	 *            被格式化的数值
	 * @return 格式化后的数据
	 */
	public static long parseLong(String text) {
		int index = text.indexOf(",");
		String sbNumber = "";
		while (index != -1) {
			sbNumber += text.substring(0, index);
			text = text.substring(index + 1, text.length());
			index = text.indexOf(",");
		}
		sbNumber += text;
		return Long.parseLong(sbNumber);
	}

	/**
	 * 数字型字符串检查
	 * 
	 * @param number
	 *            待检查的数字型字符串
	 * @return 如果是数字型字符串返回true，否则返回false
	 * 
	 */
	public static boolean checkNumberValid(String number) {
		if (StringUtil.isEmpty(number)) {
			return false;
		}
		boolean bDot = false;
		int nChar;
		for (int i = 0; i < number.length(); i++) {
			nChar = number.charAt(i);
			if (nChar == '-' && i == 0) {
				continue;
			} else if (nChar == '-' && i != 0) {
				return false;
			}
			if (nChar > '9') {
				return false;
			}
			if ((nChar < '0') && (nChar != ',') && (nChar != '.')) {
				return false;
			}
			if (nChar == '.') {
				if (!bDot) {
					bDot = true;
					continue;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 将字符串转换为long*1000.如：21.236转换为：21236
	 * 
	 * @param text 需要转化的数据
	 * @return 格式化后的数据
	 */
	public static long stringTolong(String text) {
		if(StringUtil.isEmpty(text)){
			return 0L;
		}
		double number = DataFormat.parseNumber(text) * 1000;
		return DataFormat.cutNumberAfterDecimal(number);
	}
	
	/**
	 * 将字符串转换为long*1000.如：21.236转换为：21236
	 * 
	 * @param text 需要转化的数据
	 * @return 格式化后的数据
	 */
	public static Long stringToLong(String text) {
		if(StringUtil.isEmpty(text)){
			return null;
		}
		double number = DataFormat.parseNumber(text) * 1000;
		return DataFormat.cutNumberAfterDecimal(number);
	}

	/**
	 * 将long转换为String.long/1000.保留两位小数
	 * 
	 @param number 需要转化的数据
	 * @return 格式化后的数据
	 */
	public static String longToString(long number) {
		String str = DataFormat.formatNumber((double) number / 1000.00, 5);
		str = str.substring(0, str.length() - 3);
		return str;
	}
	
	/**
	 * 不除以1000 将long转换为String.long.保留两位小数
	 * @param number
	 * @return
	 */
	public static String longAllToString(long number){
		String str = DataFormat.formatNumber((double) number / 1.00, 5);
		str = str.substring(0, str.length() - 3);
		str=str.substring(0, str.lastIndexOf("."));
		return str;
	}

	/**
	 * 截掉double数后小数部分，不进行四舍五入
	 * 
	 * @param beforeDouble 需要被格式化的数据
	 * @return 格式后的数据
	 */
	public static long cutNumberAfterDecimal(double beforeDouble) {
		Double before = new Double(beforeDouble);
		long afterDouble = (long) before.longValue();
		return afterDouble;
	}

	/**
	 * 舍弃最后一位,如11156转换为：11150
	 * 
	 * @param number 需要格式化的数据
	 * @return 转化后的数据
	 */
	public static long roundDown(long number) {
		return number / 10 * 10;
	}

	/**
	 * 最后一位直接进1，如：11156转换为：11160
	 * 
	 * @param number
	 *            需要格式化的数据
	 * @return 转化后的数据
	 */
	public static long roundUp(long number) {
		long tempNum = 10 - number % 10;
		if (tempNum != 10) {
			number += tempNum;
		}
		return number;
	}
	
	/**
	 * 万分比转百分比字符串
	 * @param tenThousandth 万分比
	 * @return 百分比字符串
	 */
	public static String tenThousandthToPercentage(long tenThousandth) {
		return df.format((double)tenThousandth / 100);
	}
	
	/**
	 * 百分比转万分比
	 * @param tenThousandth 百分比
	 * @return 万分比
	 */
	public static Long percentageToThousandth(double percentage) {
		return (long)(percentage * 100);
	}
	
}
