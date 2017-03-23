package com.tal.knowledge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tal.dao.KnowledgeMapper;

@Service
public class KnowledgeService {

	@Autowired
	KnowledgeMapper mapper;
	
	public int insertKnowledgeWithCorrectTopic(Long replyId){
		return mapper.insertKnowledgeWithCorrectTopic(replyId);
	}
}
