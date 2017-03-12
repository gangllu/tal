package com.tal.studentwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tal.dao.StudentWorkMapper;
import com.tal.model.Lesson;
import com.tal.model.StudentWork;
import com.tal.util.page.PageObject;

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
	
	public PageObject<StudentWork> listPageStudentWork(StudentWork record){
		List<StudentWork> list = mapper.listPageStudentWork(record);
		return new PageObject<StudentWork>(record.getPage().getTotalResult(),list);
	}
}
