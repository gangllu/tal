/*
 * Copyright (C) 2011 Fhpt All Rights Reserved.
 * 
 * xyl
 */
package com.tal.util;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * [文件名称]<br>
 * MD5Util <br>
 * <br>
 * [文件描述]<br>
 * MD5加密<br>
 * <br>
 * [修改记录]<br>
 * 2011-11-23 ver1.00 创建 xyl<br>
 * 
 * @author xyl
 * @version 1.00
 */
public class MD5Util {

	/**
	 * MD5加密
	 * 
	 * @param msg
	 *            密文
	 * @param charset
	 *            字符集
	 * @return String
	 * @throws NoSuchAlgorithmException
	 *             e
	 * @throws UnsupportedEncodingException
	 *             e
	 */
	public static String encrypt(String msg, String charset)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		StringBuffer signMsg = new StringBuffer();

		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.reset();

		byte[] inputBytes = msg.getBytes(charset);
		messageDigest.update(inputBytes);
		byte[] outputBytes = messageDigest.digest();

		for (int i = 0; i < outputBytes.length; i++) {
			if (Integer.toHexString(0xFF & outputBytes[i]).length() == 1) {
				signMsg.append("0").append(
						Integer.toHexString(0xFF & outputBytes[i]));
			} else {
				signMsg.append(Integer.toHexString(0xFF & outputBytes[i]));
			}
		}
		return signMsg.toString();
	}
}
