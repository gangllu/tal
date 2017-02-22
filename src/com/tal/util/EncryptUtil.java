package com.tal.util;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * [文件名称]<br>
 * EncryptUtil <br>
 * <br>
 * [文件描述]<br>
 * 内容摘要.<br>
 * <br>
 * [修改记录]<br>
 * 2011-10-26 ver1.00 创建 zhuyingxi<br>
 * 
 * @author zhuyingxi
 * @version 1.00
 */
public class EncryptUtil {
	
	private static final String CHARSET_ENCODING = "UTF-8";
	
	public enum EncryptType {
		
		//DES加密引擎(8位密钥)
		DES, 
		
		//3DES加密引擎(24位密钥)
		DESede, 
		
		//AES加密引擎(16位密钥)
		AES
	}

	/**
	 * 加密
	 * @param src 原文
	 * @param key key
	 * @param encryptType 算法
	 * @return 密文
	 */
	public static String encrypt(String src, String key, EncryptType encryptType) {
		
		if(src==null){
			return null;
		}
		
		String dest = null;
		String type = encryptType.name();
		try {
			Cipher cipher = Cipher.getInstance(type);
			SecretKey securekey = new SecretKeySpec(key.getBytes(), type);
			cipher.init(Cipher.ENCRYPT_MODE, securekey);
			dest = byte2hex(cipher.doFinal(src.getBytes(CHARSET_ENCODING)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dest;
	}
	
	/**
	 * 解密
	 * @param src 密文
	 * @param key key
	 * @param encryptType 算法
	 * @return 原文
	 */
	public static String decrypt(String src, String key, EncryptType encryptType) {
		
		if(src==null){
			return null;
		}
		
		String dest = null;
		String type = encryptType.name();
		try {
			Cipher cipher = Cipher.getInstance(type);
			SecretKey securekey = new SecretKeySpec(key.getBytes(), type);
			cipher.init(Cipher.DECRYPT_MODE, securekey);
			dest = new String(cipher.doFinal(hex2byte(src.getBytes(CHARSET_ENCODING))), CHARSET_ENCODING);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dest;
	}
	
	/**
	 * byte2hexStr
	 * @param b byte array
	 * @return hexStr
	 */
	private static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = Integer.toHexString(b[n] & 0XFF);
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs.toUpperCase();
	}

	/**
	 * hex2byte
	 * @param b hexByte
	 * @return byte array
	 */
	private static byte[] hex2byte(byte[] b) {
		byte[] b2 = new byte[b.length / 2];
		for (int n = 0; n < b.length; n += 2) {
			String item = new String(b, n, 2);
			b2[n / 2] = (byte) Integer.parseInt(item, 16);
		}
		return b2;
	}
	
}
