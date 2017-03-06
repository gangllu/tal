package com.tal.studentwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tal.dao.StudentWorkMapper;

@Service
public class StudentWorkService {

	@Autowired
	StudentWorkMapper mapper;
	
	public int getStudentWorkCountByWorkId(Long workId){
		return mapper.getStudentWorkCountByWorkId(workId);
	}
}
