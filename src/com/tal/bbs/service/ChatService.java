package com.tal.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tal.dao.ChatMapper;
import com.tal.model.Chat;

@Service
public class ChatService {
	
	@Autowired
	ChatMapper mapper;
	
	public List<Chat> getLastest10MsgByLesson(Integer lessonId){
		return mapper.getLastest10MsgByLesson(lessonId);
	}
	
	public int insertSelective(Chat record){
		return mapper.insertSelective(record);
	}
	
	public List<Chat> getAllClassmate(Integer lessonId,Integer toUserId){
		return mapper.getAllClassmate(lessonId, toUserId);
	}
	
	public List<Chat> getUserMsgByLesson(Chat chat){
		return mapper.getUserMsgByLesson(chat);
	}
	
	public int updateToRead(Integer lessonId,Integer userId){
		return mapper.updateToRead(lessonId, userId);
	}

}
