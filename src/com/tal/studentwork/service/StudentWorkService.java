package com.tal.studentwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tal.dao.StudentWorkMapper;
import com.tal.model.StudentWork;

@Service
public class StudentWorkService {

	@Autowired
	StudentWorkMapper mapper;
	
	public int getStudentWorkCountByWorkId(Long workId){
		return mapper.getStudentWorkCountByWorkId(workId);
	}
	
	public int insertSelective(StudentWork record){
		return mapper.insertSelective(record);
	}
	
	public int updateByPrimaryKeySelective(StudentWork record){
		return mapper.updateByPrimaryKeySelective(record);
	}
	
	public StudentWork selectByPrimaryKey(Long id){
		return mapper.selectByPrimaryKey(id);
	}
	
	public StudentWork getStudentWorkByWorkIdAndStudent(Long workId,Integer studentId){
		return mapper.getStudentWorkByWorkIdAndStudent(workId, studentId);
	}
}
