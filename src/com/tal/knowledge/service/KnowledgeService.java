package com.tal.knowledge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tal.dao.KnowledgeMapper;
import com.tal.model.Knowledge;
import com.tal.util.page.PageObject;

@Service
public class KnowledgeService {

	@Autowired
	KnowledgeMapper mapper;
	
	public int insertKnowledgeWithCorrectTopic(Long replyId){
		return mapper.insertKnowledgeWithCorrectTopic(replyId);
	}
	
	public PageObject<Knowledge> listPageKnowledge(Knowledge k){
		List<Knowledge> list = mapper.listPageKnowledge(k);
		return new PageObject<Knowledge>(k.getPage().getTotalResult(),list);
	}
	
	public int updateByPrimaryKeySelective(Knowledge record){
		return mapper.updateByPrimaryKeySelective(record);
	}
	
	public Knowledge selectByPrimaryKey(Long id){
		return mapper.selectByPrimaryKey(id);
	}
	
	public int insertSelective(Knowledge record){
		return mapper.insertSelective(record);
	}
	
	public int deleteByPrimaryKey(Long id){
		return mapper.deleteByPrimaryKey(id);
	}
}
