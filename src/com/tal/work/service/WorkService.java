package com.tal.work.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tal.dao.TbWorkMapper;
import com.tal.model.TbWork;
import com.tal.util.page.PageObject;

@Service
public class WorkService {

	@Autowired
	TbWorkMapper workMapper;
	
	public PageObject<TbWork> listPageworkByUser(TbWork work){
		//Integer count = 10;//userMapper.getUserInfoCount(userInfo);
		List<TbWork> list = workMapper.listPageWork(work);
		
		return new PageObject<TbWork>(work.getPage().getTotalResult(),list);
	}
	
	
}
