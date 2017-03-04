package com.tal.lesson.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tal.dao.LessonMapper;
import com.tal.dao.StudentLessonMapper;
import com.tal.dao.TbUserMapper;
import com.tal.dao.TeacherLessonMapper;
import com.tal.model.Lesson;
import com.tal.model.StudentLesson;
import com.tal.model.TbUser;
import com.tal.model.TeacherLesson;
import com.tal.util.DateUtil;
import com.tal.util.ExcelReader;
import com.tal.util.page.PageObject;

@Service
public class LessonService {

	@Autowired
	LessonMapper mapper;
	
	@Autowired
	StudentLessonMapper slMapper;
	
	@Autowired
	TeacherLessonMapper tlMapper;
	
	@Autowired
	TbUserMapper userMapper;
	
	public Lesson selectByPrimaryKey(Integer lessonId){
		return mapper.selectByPrimaryKey(lessonId);
	}
	
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
	
	public String addOrUpdatelesson(Lesson lesson,String lessonId,int teacherId,
			String defaultPassword,InputStream excelIs)throws Exception{
		String message = "";
		
		List<TbUser> list = getStudents(excelIs);
		
		if (null == lessonId || "".equals(lessonId)) {
			// 新增
			lesson.setCreateDt(DateUtil.getCurrentTime());
			mapper.insertSelective(lesson);
			
			//新增老师课程关系
			TeacherLesson tl = new TeacherLesson();
			tl.setLessonId(lesson.getLessonId());
			tl.setUserId(teacherId);
			tlMapper.insert(tl);
			
			//新增学生、学生课程关系
			addStudents(defaultPassword,list,lesson.getLessonId());
			
			message = "新增成功！";

		} else {
			//更新
			lesson.setLessonId(Integer.parseInt(lessonId));
			mapper.updateByPrimaryKeySelective(lesson);
			
			//删除学生课程关系
			slMapper.deleteByLesson(Integer.parseInt(lessonId));
			
			//增加学生以及学生课程关系
			addStudents(defaultPassword,list,Integer.parseInt(lessonId));
			
			message = "更新成功！";
		}
		return message;
	}
	
	public List<TbUser> getStudents(InputStream is) throws Exception {
		ExcelReader er = new ExcelReader(is);

		List<TbUser> list = new ArrayList<TbUser>();
		er.open();
		er.setSheetNum(0); // 设置读取索引为0的工作表
		// 总行数
		int count = er.getRowCount();
		for (int i = 4; i <= count; i++) {
			String[] cols = er.readExcelLine(i);
			TbUser user = new TbUser();
			user.setUserNo(cols[0]);
			user.setUserName(cols[2].trim());
		
			list.add(user);
		}

		return list;
	}
	
	public void addStudents(String defaultPassword,List<TbUser> list,int lessonId){
		for(TbUser u : list){
			u.setPassword(defaultPassword);
			u.setRole("student");
			TbUser dbUser = userMapper.selectByUserNo(u.getUserNo());
			if(dbUser == null){
				//根据学号查找学生，没有找到学生，新增该学生
				userMapper.insertSelective(u);
			}else{
				u.setUserId(dbUser.getUserId());
			}
			
			StudentLesson sl = new StudentLesson();
			sl.setLessonId(lessonId);
			sl.setUserId(u.getUserId());
			
			slMapper.insertSelective(sl);
		}
	}
	
	public void deleteLesson(int teacherId,int lessonId){
		//删除课程老师关系
		tlMapper.deleteByTearchAndLesson(teacherId, lessonId);
		
		//删除课程信息
		mapper.deleteByPrimaryKey(lessonId);
	}
	
	public List<Lesson> getLessons(String role,Integer userId){
		return mapper.getLessons(role, userId);
	}
}
