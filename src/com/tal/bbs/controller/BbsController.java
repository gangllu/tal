package com.tal.bbs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tal.app.BaseResult;
import com.tal.bbs.service.BbsService;
import com.tal.bbs.service.ChatService;
import com.tal.dao.KnowledgeMapper;
import com.tal.knowledge.service.KnowledgeService;
import com.tal.lesson.service.StudentLessonService;
import com.tal.model.BbsReply;
import com.tal.model.BbsTopic;
import com.tal.model.Chat;
import com.tal.model.StudentLesson;
import com.tal.model.TbUser;
import com.tal.util.DateUtil;
import com.tal.util.page.Page;
import com.tal.util.page.PageObject;

@Controller
@RequestMapping("/bbs")
public class BbsController {
	
	private static final Log log = LogFactory.getLog(BbsController.class);
	
	@Autowired
	BbsService service;
	
	@Autowired
	StudentLessonService studentLessonService;
	
	@Autowired
	KnowledgeService knowledgeService;
	
	@Autowired
	ChatService chatService;

	@RequestMapping("/chat")
	public String chat(){
		return "bbs/chat";
	}
	
	@RequestMapping("/listPage")
	public String listPage(HttpServletRequest request){
		Integer lessonId = (Integer)request.getSession().getAttribute("lessonId");
		TbUser user = (TbUser)request.getSession().getAttribute("userInfo");
		List<Chat> chats = chatService.getAllClassmate(lessonId, user.getUserId());
		request.setAttribute("chats", chats);
		
		return "bbs/bbsList";
	}
	
	@RequestMapping("/listBbsTopic")
	@ResponseBody
	public PageObject<BbsTopic> listBbsTopic(@RequestParam Integer start,
			@RequestParam Integer length,HttpServletRequest request){
		BbsTopic b = new BbsTopic();
		Page pageInfo = new Page((start/length) + 1,length);
		b.setPage(pageInfo);
		
		b.setTopicName(request.getParameter("topicName"));
		
		Integer lessonId = (Integer)request.getSession().getAttribute("lessonId");
		if(lessonId != null){
			b.setLessonId(lessonId);
		}
		
		PageObject<BbsTopic> pageModel = service.listPageBbsTopic(b);
		return pageModel;
	}
	
	@RequestMapping("/getTopicById")
	@ResponseBody
	public BbsTopic getTopicById(@RequestParam Long topicId,
			HttpServletRequest request){
		
		return service.selectTopicByPrimaryKey(topicId);
	}
	
	
	@RequestMapping(value = "/addOrUpdateBbsTopic", method = RequestMethod.POST)
	@ResponseBody
	public BaseResult addOrUpdateBbsTopic(HttpServletRequest request,
			@RequestParam String topicName,HttpServletResponse response,
			@RequestParam String replyContent) {
		String message = "";
		String status = "1";
		BaseResult result = new BaseResult();
		try {
			BbsTopic topic = new BbsTopic();
			BbsReply reply = new BbsReply();
			topic.setTopicName(topicName);
			reply.setReplyContent(replyContent);
			
			Integer lessonId = (Integer)request.getSession().getAttribute("lessonId");
			TbUser user = (TbUser)request.getSession().getAttribute("userInfo");
			
			String topicId = request.getParameter("topicId");
			String replyId = request.getParameter("replyId");
			if (null == topicId || "".equals(topicId)) {
				// 新增
				topic.setLessonId(lessonId);
				topic.setUserId(user.getUserId());
				reply.setUserId(user.getUserId());
				service.insertTopicSelective(topic,reply);
				message = "新增成功！";

			} else {
				// 更新
				topic.setTopicId(Long.parseLong(topicId));
				reply.setReplyId(Long.parseLong(replyId));
				service.updateTopicByPrimaryKeySelective(topic, reply);
				message = "更新成功！";
			}
		} catch (Exception e) {
			status = "0";
			message = "处理失败！";
			log.error(message, e);
		}

		result.setMessage(message);
		result.setStatus(status);
		
		return result;
	}
	
	@RequestMapping("/viewTopic")
	public String viewTopic(@RequestParam Long topicId,@RequestParam Integer start,
			@RequestParam Integer length,HttpServletRequest request){
		BbsTopic topic = service.selectTopicByPrimaryKey(topicId);
		
		BbsReply reply = new BbsReply();
		reply.setTopicId(topicId);
		Page page = new Page((start/length) + 1,length);
		reply.setPage(page);
		PageObject<BbsReply> replyPage = service.listPageBbsReply(reply);
		
		BbsReply correctReply = service.selectCorrectReply(topicId);
		
		request.setAttribute("replyPage", replyPage);
		request.setAttribute("reply", reply);
		request.setAttribute("topic", topic);
		request.setAttribute("correctReply", correctReply);
		
		return "bbs/topic";
	}
	
	@RequestMapping(value = "/addBbsReply", method = RequestMethod.POST)
	@ResponseBody
	public BaseResult addBbsReply(HttpServletRequest request,
			@RequestParam Long topicId,HttpServletResponse response,
			@RequestParam String replyContent) {
		String message = "";
		String status = "1";
		BaseResult result = new BaseResult();
		try {
			BbsReply reply = new BbsReply();
			reply.setReplyContent(replyContent);
			reply.setTopicId(topicId);
			
			TbUser user = (TbUser)request.getSession().getAttribute("userInfo");
			// 新增
			reply.setUserId(user.getUserId());
			reply.setReplyDt(DateUtil.getCurrentTime());
			service.insertReplySelective(reply);
			message = "回复成功！";
		} catch (Exception e) {
			status = "0";
			message = "处理失败！";
			log.error(message, e);
		}

		result.setMessage(message);
		result.setStatus(status);
		
		return result;
	}
	
	@RequestMapping(value = "/modifyReply", method = RequestMethod.POST)
	@ResponseBody
	public BaseResult modifyReply(HttpServletRequest request,
			@RequestParam Long replyId,HttpServletResponse response,
			@RequestParam String replyContent) {
		String message = "";
		String status = "1";
		BaseResult result = new BaseResult();
		try {
			BbsReply reply = new BbsReply();
			reply.setReplyContent(replyContent);
			reply.setReplyId(replyId);
			
			//更新
			service.updateReplyByPrimaryKeySelective(reply);
			message = "编辑成功！";
		} catch (Exception e) {
			status = "0";
			message = "处理失败！";
			log.error(message, e);
		}

		result.setMessage(message);
		result.setStatus(status);
		
		return result;
	}
	
	@RequestMapping(value = "/correctReply", method = RequestMethod.POST)
	@ResponseBody
	public BaseResult correctReply(HttpServletRequest request,@RequestParam Integer userId,
			@RequestParam Long replyId,HttpServletResponse response) {
		String message = "";
		String status = "1";
		BaseResult result = new BaseResult();
		try {
			BbsReply reply = new BbsReply();
			reply.setReplyId(replyId);
			reply.setCorrect("1");
			
			//更新
			service.updateReplyByPrimaryKeySelective(reply);
			message = "编辑成功！";
			
			//更新回答正确学生的课程回答次数
			Integer lessonId = (Integer)request.getSession().getAttribute("lessonId");
			StudentLesson sl = new StudentLesson();
			sl.setUserId(userId);
			sl.setLessonId(lessonId);
			studentLessonService.updateAnswercount(sl);
			
			//讲该问题转为知识库
			knowledgeService.insertKnowledgeWithCorrectTopic(replyId);
			
		} catch (Exception e) {
			status = "0";
			message = "处理失败！";
			log.error(message, e);
		}

		result.setMessage(message);
		result.setStatus(status);
		
		return result;
	}
	
	
	@RequestMapping(value = "/replyWithOther", method = RequestMethod.POST)
	@ResponseBody
	public BaseResult replyWithOther(HttpServletRequest request,
			@RequestParam Long referReplyId,HttpServletResponse response,
			@RequestParam Long topicId,@RequestParam String replyContent) {
		String message = "";
		String status = "1";
		BaseResult result = new BaseResult();
		try {
			BbsReply reply = new BbsReply();
			reply.setReplyContent(replyContent);
			reply.setReferReplyId(referReplyId);
			reply.setReplyContent(replyContent);
			reply.setTopicId(topicId);
			reply.setReplyDt(DateUtil.getCurrentTime());
			TbUser user = (TbUser)request.getSession().getAttribute("userInfo");
			reply.setUserId(user.getUserId());
			
			//回复他人的回复
			service.insertReplySelective(reply);
			message = "回复成功！";
		} catch (Exception e) {
			status = "0";
			message = "处理失败！";
			log.error(message, e);
		}

		result.setMessage(message);
		result.setStatus(status);
		
		return result;
	}
	
	@RequestMapping("/viewChat")
	public String viewChat(HttpServletRequest request){
		Integer lessonId = (Integer)request.getSession().getAttribute("lessonId");
		List<Chat> list = chatService.getLastest10MsgByLesson(lessonId);
		request.setAttribute("list", list);
		
		return "bbs/chatOnline";
	}
}
