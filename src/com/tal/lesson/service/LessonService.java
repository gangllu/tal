package com.tal.lesson.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tal.dao.LessonMapper;
import com.tal.model.Lesson;
import com.tal.util.page.PageObject;

@Service
public class LessonService {

	@Autowired
	LessonMapper mapper;
	
	public PageObject<Lesson> listPagelessonByUser(Lesson lesson){
		//Integer count = 10;//userMapper.getUserInfoCount(userInfo);
		List<Lesson> list = mapper.listPageLesson(lesson);
		
		return new PageObject<Lesson>(lesson.getPage().getTotalResult(),list);
	}
	
	public int insertSelective(Lesson record){
		return mapper.insertSelective(record);
	}
	
	public int updateByPrimaryKeySelective(Lesson record){
		return mapper.updateByPrimaryKeySelective(record);
	}
}
