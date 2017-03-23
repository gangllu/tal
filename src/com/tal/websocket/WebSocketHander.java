package com.tal.websocket;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.tal.bbs.service.ChatService;
import com.tal.model.Chat;
import com.tal.util.DateUtil;  

@Component
public class WebSocketHander implements WebSocketHandler {  
    
   private static final Logger logger = org.slf4j.LoggerFactory.getLogger(WebSocketHander.class);  
      
    private static final ArrayList<WebSocketSession> users = new ArrayList<WebSocketSession>();  

    @Autowired
	ChatService service;
    
    /** 
     * after connection establish 
     */  
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {  
        logger.info("connect success...");  
        users.add(session);  
    }  

    /** 
     * process the received message  
     */  
    @Override  
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {  
    	System.out.println("来自客户端的消息:" + webSocketMessage.getPayload());
    	
    	
    	if(webSocketMessage.getPayloadLength() > 0){
    		String message = (String) webSocketMessage.getPayload();
    		String[] chatInfo = message.split(";");
            String lessonId = chatInfo[0];
            String userId = chatInfo[1];
            String userName = chatInfo[2];
            String msg = chatInfo[3];
            Date date = DateUtil.getCurrentTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = sdf.format(date);
            
            Chat chat = new Chat();
            chat.setDt(date);
            chat.setLessonId(Integer.parseInt(lessonId));
            chat.setUserId(Integer.parseInt(userId));
            chat.setMsg(msg);
            service.insertSelective(chat);
            
            String returnMsg = "{userId:" + userId + ",userName:\"" + userName + "\",dt:\"" + dateStr + "\","
            		+ "msg:\"" + msg + "\"}";
            
        	sendMessageToUsers(new TextMessage(returnMsg)); 
    	}
         
    }  

    @Override  
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {  
        if(webSocketSession.isOpen()){  
            webSocketSession.close();  
        }  
        logger.info("connenction error,close the connection...");  
        users.remove(webSocketSession);  
    }  

    @Override  
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {  
        logger.info("close the connenction..."+closeStatus.toString());  
        users.remove(webSocketSession);  
    }  

    @Override  
    public boolean supportsPartialMessages() {  
        return false;  
    }  
    /** 
     * 给所有在线用户发送消息 
     * 
     * @param message 
     */  
    public void sendMessageToUsers(TextMessage message) {  
        for (WebSocketSession user : users) {  
            try {  
                if (user.isOpen()) {  
                    user.sendMessage(message);  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }}  