package com.tal.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;  
  
@Configuration  
@EnableWebMvc  
@EnableWebSocket  
public class WebSocketConfig implements WebSocketConfigurer { 
	
	@Autowired
	WebSocketHander webSocketHander;
	
    @Override  
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {  
          
        /** 
         * 支持websocket 的 connection 
         */  
        registry.addHandler(webSocketHander,"/websocket").addInterceptors(new HandshakeInterceptor());  
          
        /** 
         * 不支持websocket的connenction,采用sockjs 
         */  
        registry.addHandler(webSocketHander,"/sockjs/websocket").addInterceptors(new HandshakeInterceptor()).withSockJS();  
    }  
}