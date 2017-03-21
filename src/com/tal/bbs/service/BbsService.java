package com.tal.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tal.dao.BbsReplyMapper;
import com.tal.dao.BbsTopicMapper;
import com.tal.model.BbsReply;
import com.tal.model.BbsTopic;
import com.tal.util.DateUtil;
import com.tal.util.page.PageObject;

@Service
public class BbsService {
	
	@Autowired
	BbsTopicMapper topicMapper;
	
	@Autowired
	BbsReplyMapper replyMapper;
	
	public PageObject<BbsTopic> listPageBbsTopic(BbsTopic record){
		List<BbsTopic> list = topicMapper.listPageBbsTopic(record);
		
		return new PageObject<BbsTopic>(record.getPage().getTotalResult(),list);
	}
	
	public PageObject<BbsReply> listPageBbsReply(BbsReply record){
		List<BbsReply> list = replyMapper.listPageBbsReply(record);
		
		return new PageObject<BbsReply>(record.getPage().getTotalResult(),list);
	}
	
	public int insertTopicSelective(BbsTopic topic,BbsReply reply){
		topic.setTopicDt(DateUtil.getCurrentTime());
		topicMapper.insertSelective(topic);
		
		reply.setReplyDt(DateUtil.getCurrentTime());
		reply.setTopicId(topic.getTopicId());
		
		return replyMapper.insertSelective(reply);
	}
	
	public BbsTopic selectTopicByPrimaryKey(Long topicId){
		return topicMapper.selectByPrimaryKey(topicId);
	}
	
	public int updateTopicByPrimaryKeySelective(BbsTopic record,BbsReply reply){
		return topicMapper.updateByPrimaryKeySelective(record);
	}
	
	public int insertReplySelective(BbsReply record){
		return replyMapper.insertSelective(record);
	}
	
	public BbsReply selectReplyByPrimaryKey(Long topicId){
		return replyMapper.selectByPrimaryKey(topicId);
	}
	
	public int updateReplyByPrimaryKeySelective(BbsReply record){
		return replyMapper.updateByPrimaryKeySelective(record);
	}

}
