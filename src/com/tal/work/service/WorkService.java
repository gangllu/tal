package com.tal.work.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tal.dao.LessonMapper;
import com.tal.dao.TbWorkMapper;
import com.tal.model.Lesson;
import com.tal.model.TbWork;
import com.tal.util.page.PageObject;

@Service
public class WorkService {

	@Autowired
	TbWorkMapper workMapper;
	
	@Autowired
	LessonMapper lessonMapper;
	
	public PageObject<TbWork> listPageworkByUser(TbWork work){
		//Integer count = 10;//userMapper.getUserInfoCount(userInfo);
		List<TbWork> list = workMapper.listPageWork(work);
		
		return new PageObject<TbWork>(work.getPage().getTotalResult(),list);
	}
	
	/**
	 * 保存老师布置作业附件
	 * @param lessonId
	 * @param work
	 * @param workId
	 * @param workFile
	 * @return
	 * @throws Exception
	 */
	public String saveWorkFile(Integer lessonId,TbWork work,String workId,
			MultipartFile workFile)throws Exception{
		String fullFileName = "";
		
		Lesson lesson = lessonMapper.selectByPrimaryKey(lessonId);
		String workFolderPath = lesson.getLessonDesc() + File.separator + work.getWorkTile();
		if(workId == null || "".equals(workId)){
			//新增文件及目录
			File workFolder = new File(workFolderPath);
			if(!workFolder.exists()){
				workFolder.mkdir();
			}
			
			fullFileName = workFolderPath + File.separator + workFile.getOriginalFilename();
			workFile.transferTo(new File(fullFileName));
		}else{
			TbWork oldWork = workMapper.selectByPrimaryKey(Long.parseLong(workId));
			//如果名称修改，则新建目录
			if(!work.getWorkTile().equals(oldWork.getWorkTile())){
				//File oldFile = new File(lesson.getLessonDesc() + File.separator + oldWork.getWorkTile());
				File workFolder = new File(workFolderPath);
				if(!workFolder.exists()){
					workFolder.mkdir();
				}
			}
			
			//删除旧文件，保存新文件
			File oldFile = new File(oldWork.getWorkFile());
			oldFile.delete();
			
			fullFileName = workFolderPath + File.separator + workFile.getOriginalFilename();
			workFile.transferTo(new File(fullFileName));
		}
		
		
		return fullFileName;
	}
	
	public TbWork selectByPrimaryKey(Long workId){
		return workMapper.selectByPrimaryKey(workId);
	}
	
	public List<TbWork> getTodoWork(Integer userId,Integer lessonId){
		return workMapper.getTodoWork(userId, lessonId);
	}
	
	public List<TbWork> getWorkByLesson(Integer lessonId){
		return workMapper.getWorkByLesson(lessonId);
	}
}
