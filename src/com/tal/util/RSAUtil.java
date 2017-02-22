/*
 * Copyright (C) 2011 Fhpt All Rights Reserved.
 * 
 * xyl
 */
package com.tal.util;


import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.Cipher;

/**
 * [文件名称]<br>
 * RSAUtil <br>
 * <br>
 * [文件描述]<br>
 * RSA加密、解密、签名、验签<br>
 * <br>
 * [修改记录]<br>
 * 2011-11-23 ver1.00 创建 xyl<br>
 * 
 * @author xyl
 * @version 1.00
 */
public class RSAUtil {

	/**
	 * 字符集
	 */
	private String inputCharset;

	/**
	 * 构造器
	 * 
	 * @param inputCharset
	 *            字符集
	 */
	public RSAUtil(String inputCharset) {
		this.inputCharset = inputCharset;
	}

	/**
	 * 加密,key是默认私钥   src/main/resources下
	 * 
	 * @param msg
	 *            加密信息
	 * @return String
	 * @throws Exception
	 *             e
	 */
	public String encrypt(String msg) throws Exception {
		RSAPrivateKey privateKey = (RSAPrivateKey) readFromFile("src/main/resources/RSAPrivateKey.dat");
		return encrypt(msg, privateKey);
	}

	/**
	 * 解密，key是默认公钥   src/main/resources下
	 * 
	 * @param msg
	 *            解密信息
	 * @return String
	 * @throws Exception
	 *             e
	 */
	public String decrypt(String msg) throws Exception {
		RSAPublicKey publickKey = (RSAPublicKey) readFromFile("src/main/resources/RSAPublicKey.dat");
		return decrypt(msg, publickKey);
	}

	/**
	 * 加密,key可以是公钥，也可以是私钥
	 * 
	 * @param msg
	 *            加密信息
	 * @param key
	 *            key
	 * @return String
	 * @throws Exception
	 *             e
	 */
	public String encrypt(String msg, Key key) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] bytes = cipher.doFinal(msg.getBytes(inputCharset));

		return toHexString(bytes);
	}

	/**
	 * 解密，key可以是公钥，也可以是私钥，如果是公钥加密就用私钥解密，反之亦然
	 * 
	 * @param msg
	 *            解密信息
	 * @param key
	 *            key
	 * @return String
	 * @throws Exception
	 *             e
	 */
	public String decrypt(String msg, Key key) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] bytes = cipher.doFinal(toBytes(msg));

		return new String(bytes, inputCharset);
	}

	/**
	 * 用默认私钥签名   src/main/resources下
	 * 
	 * @param msg
	 *            签名信息
	 * @return String
	 * @throws Exception
	 *             e
	 */
	public String sign(String msg) throws Exception {
		RSAPrivateKey privateKey = (RSAPrivateKey) readFromFile("src/main/resources/RSAPrivateKey.dat");
		return sign(msg, privateKey);
	}

	/**
	 * 用默认公钥验签   src/main/resources下
	 * 
	 * @param msg
	 *            签名信息
	 * @param signStr
	 *            签名
	 * @return boolean
	 * @throws Exception
	 *             e
	 */
	public boolean verifySign(String msg, String signStr) throws Exception {
		RSAPublicKey publickKey = (RSAPublicKey) readFromFile("src/main/resources/RSAPublicKey.dat");
		return verifySign(msg, signStr, publickKey);
	}

	/**
	 * 用私钥签名
	 * 
	 * @param msg
	 *            签名信息
	 * @param key
	 *            key
	 * @return String
	 * @throws Exception
	 *             e
	 */
	public String sign(String msg, PrivateKey key) throws Exception {
		Signature signetcheck = Signature.getInstance("MD5withRSA");
		signetcheck.initSign(key);
		signetcheck.update(msg.getBytes(inputCharset));

		return toHexString(signetcheck.sign());
	}

	/**
	 * 用公钥验证签名
	 * 
	 * @param msg
	 *            签名信息
	 * @param signStr
	 *            签名
	 * @param key
	 *            公钥
	 * @return boolean
	 * @throws Exception
	 *             e
	 */
	public boolean verifySign(String msg, String signStr, PublicKey key)
			throws Exception {
		if (msg == null || signStr == null || key == null) {
			return false;
		}
		Signature signetcheck = Signature.getInstance("MD5withRSA");
		signetcheck.initVerify(key);
		signetcheck.update(msg.getBytes(inputCharset));
		return signetcheck.verify(toBytes(signStr));
	}

	/**
	 * 从文件读取KEY
	 * 
	 * @param fileName
	 *            路径
	 * @return Object
	 * @throws Exception
	 *             e
	 */
	private Object readFromFile(String fileName) throws Exception {
		ObjectInputStream input = new ObjectInputStream(new FileInputStream(
				fileName));
		Object obj = input.readObject();
		input.close();
		return obj;
	}

	/**
	 * 
	 */
	private static final char[] HEXCHAR = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	/**
	 * byte转String
	 * 
	 * @param b
	 *            b
	 * @return String 
	 */
	private String toHexString(byte[] b) {
		StringBuilder sb = new StringBuilder(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			sb.append(HEXCHAR[(b[i] & 0xf0) >>> 4]);
			sb.append(HEXCHAR[b[i] & 0x0f]);
		}
		return sb.toString();
	}

	/**
	 * String转byte
	 * 
	 * @param str
	 *            str
	 * @return byte[]
	 */
	private byte[] toBytes(String str) {
		byte[] bytes;
		bytes = new byte[str.length() / 2];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) Integer.parseInt(str.substring(2 * i, 2 * i + 2),
					16);
		}
		return bytes;
	}

	public static void main(String[] args) throws Exception {
		String str = "hello,有中文的情况";
		System.out.println("原文：" + str);

		RSAUtil rsa = new RSAUtil("UTF-8");
		RSAPublicKey publickKey = (RSAPublicKey) rsa
				.readFromFile("publicKey.dat");
		RSAPrivateKey privateKey = (RSAPrivateKey) rsa
				.readFromFile("privateKey.dat");

		System.out.println("私钥加密后：");
		String encStr = rsa.encrypt(str, privateKey);
		System.out.println(encStr);

		String signStr = "";
		System.out.println("签名值1：");
		signStr = rsa.sign(str, privateKey);
		System.out.println(signStr);
		System.out.println("签名值2：");
		signStr = rsa.sign(str);
		System.out.println(signStr);

		System.out.println("公钥解密后：");
		String decStr = rsa.decrypt(encStr, publickKey);
		System.out.println(decStr);

		if (rsa.verifySign(str, signStr, publickKey)) {
			System.out.println("rsa sign check success");
		} else {
			System.out.println("rsa sign check failure");
		}
	}
}