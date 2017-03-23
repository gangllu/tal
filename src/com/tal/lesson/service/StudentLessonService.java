package com.tal.lesson.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tal.dao.StudentLessonMapper;
import com.tal.model.StudentLesson;

@Service
public class StudentLessonService {
	
	@Autowired
	StudentLessonMapper mapper;
	
	public int updateAnswercount(StudentLesson record){
		return mapper.updateAnswercount(record);
	}

}
