package com.tal.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SmsSend {
	
	private static String ACCOUNT = "meiyue";
	
	private static String PASSWORD = "meiyue123";
	
	private static String POST_URL = "http://sms.106jiekou.com/utf8/sms.aspx";

    public static String SMS(String postData, String postUrl) {
        try {
            //发送POST请求
            URL url = new URL(postUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setUseCaches(false);
            conn.setDoOutput(true);

            conn.setRequestProperty("Content-Length", "" + postData.length());
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), 
            		"UTF-8");
            out.write(postData);
            out.flush();
            out.close();

            //获取响应状态
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.out.println("connect failed!");
                return "";
            }
            //获取响应内容体
            String line, result = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(
            		conn.getInputStream(), "utf-8"));
            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }
            in.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return "";
    }
    
    public static String sendSms(String mobile,String content){
    	String postData = "account=" + ACCOUNT + "&password=" + PASSWORD + "&mobile=" +
				mobile + "&content=";;
		try {
			postData = postData + URLEncoder.encode(content,"UTF-8");
			System.out.println(postData);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String result = SMS(postData, POST_URL);
		return result;
    }
    
    public static void main(String[] args) {
		String r = SmsSend.sendSms("13971132564", "您的验证码是：【5588】。如需帮助请联系客服。");
		System.out.println(r);
	}
}