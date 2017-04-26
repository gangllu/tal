package com.tal.studentwork.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tal.dao.StudentWorkMapper;
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
	
	public List<StudentWork> getToScoreStudentWork(Integer lessonId){
		return mapper.getToScoreStudentWork(lessonId);
	}
	
	public List<Map<String,String>> getLessonStudentWorkScore(Integer lessonId){
		List<StudentWork> list = mapper.getLessonStudentWorkScore(lessonId);
		
		List<StudentWork> students = mapper.getStudentsByLesson(lessonId);
		
		List<Map<String,String>> studentWorks = new ArrayList<Map<String,String>>();
		
		//初始化每个学生的map list
		for(StudentWork sw : students){
			Map<String,String> map = new HashMap<>();
			map.put("userName", sw.getUserName());
			studentWorks.add(map);
		}
		
		//组装每个学生的所有课程的成绩
		for(int i = 0; i < list.size(); i ++){
			StudentWork s = list.get(i);
			for(Map<String,String> sw : studentWorks){
				//int workOrder = (i + 1) / students.size() + 1;
				if(sw.get("userName").equals(s.getUserName())){
					if(sw.get(s.getWorkTile()) == null){
						sw.put(s.getWorkTile(), String.valueOf(s.getScore()));
					}
				}
			}
		}
		
		return studentWorks;
	}
}
