/*
 * Copyright (C) 2011 Fhpt All Rights Reserved.
 * 
 * xyl
 */
package com.tal.util;


import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

/**
 * [文件名称]<br>
 * RSAKey <br>
 * <br>
 * [文件描述]<br>
 * 生成RSA的公钥、密钥<br>
 * <br>
 * [修改记录]<br>
 * 2011-11-23 ver1.00 创建 xyl<br>
 * 
 * @author xyl
 * @version 1.00
 */
public class RSAKey {

	/**
	 * 根据keyInfo产生公钥和私钥，并且保存到publicKey.dat和privateKey.dat文件中
	 * 
	 * @param keyInfo
	 *            keyinfo
	 * @throws Exception
	 *             e
	 */
	public void getKeys(String keyInfo) throws Exception {
		KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
		SecureRandom random = new SecureRandom();
		random.setSeed(keyInfo.getBytes());
		// 初始加密，长度为1024
		keygen.initialize(1024, random);
		// 取得密钥对
		KeyPair kp = keygen.generateKeyPair();
		// 取得公钥
		PublicKey publicKey = kp.getPublic();
		System.out.println("公钥-->\n" + publicKey);
		saveFile(publicKey, "src/main/resources/RSAPublicKey.dat");
		// 取得私钥
		PrivateKey privateKey = kp.getPrivate();
		saveFile(privateKey, "src/main/resources/RSAPrivateKey.dat");
		System.out.println("私钥-->\n" + privateKey);
	}

	/**
	 * 保存KEY到文件
	 * 
	 * @param obj
	 *            obj
	 * @param fileName
	 *            路径
	 * @throws Exception
	 *             e
	 */
	private void saveFile(Object obj, String fileName) throws Exception {
		ObjectOutputStream output = new ObjectOutputStream(
				new FileOutputStream(fileName));
		output.writeObject(obj);
		output.close();
	}
	
	public static void main(String[] args) throws Exception {
		// 加密的种子信息
		String keyInfo = "ASDFSDFNUGD__TYTY";
		RSAKey rsa = new RSAKey();
		rsa.getKeys(keyInfo);
	}
}
