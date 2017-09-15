package com.tal.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tal.util.CustomDateTimeSerializer;
import com.tal.util.page.Page;

public class BbsReply {
	
	private String replyUserName;
	
	private Page page;
	
	private String referReplyContent;
	
	private Long referReplyId;
	
	private String correct;
	
	private String imagePath;
	
	
    public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getCorrect() {
		return correct;
	}

	public void setCorrect(String correct) {
		this.correct = correct;
	}

	public String getReferReplyContent() {
		return referReplyContent;
	}

	public void setReferReplyContent(String referReplyContent) {
		this.referReplyContent = referReplyContent;
	}

	public Long getReferReplyId() {
		return referReplyId;
	}

	public void setReferReplyId(Long referReplyId) {
		this.referReplyId = referReplyId;
	}

	public String getReplyUserName() {
		return replyUserName;
	}

	public void setReplyUserName(String replyUserName) {
		this.replyUserName = replyUserName;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bbs_reply.reply_id
     *
     * @mbggenerated
     */
    private Long replyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bbs_reply.topic_id
     *
     * @mbggenerated
     */
    private Long topicId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bbs_reply.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bbs_reply.reply_dt
     *
     * @mbggenerated
     */
    private Date replyDt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bbs_reply.reply_content
     *
     * @mbggenerated
     */
    private String replyContent;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bbs_reply.reply_id
     *
     * @return the value of bbs_reply.reply_id
     *
     * @mbggenerated
     */
    public Long getReplyId() {
        return replyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bbs_reply.reply_id
     *
     * @param replyId the value for bbs_reply.reply_id
     *
     * @mbggenerated
     */
    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bbs_reply.topic_id
     *
     * @return the value of bbs_reply.topic_id
     *
     * @mbggenerated
     */
    public Long getTopicId() {
        return topicId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bbs_reply.topic_id
     *
     * @param topicId the value for bbs_reply.topic_id
     *
     * @mbggenerated
     */
    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bbs_reply.user_id
     *
     * @return the value of bbs_reply.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bbs_reply.user_id
     *
     * @param userId the value for bbs_reply.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bbs_reply.reply_dt
     *
     * @return the value of bbs_reply.reply_dt
     *
     * @mbggenerated
     */
    @JsonSerialize(using=CustomDateTimeSerializer.class)
    public Date getReplyDt() {
        return replyDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bbs_reply.reply_dt
     *
     * @param replyDt the value for bbs_reply.reply_dt
     *
     * @mbggenerated
     */
    public void setReplyDt(Date replyDt) {
        this.replyDt = replyDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bbs_reply.reply_content
     *
     * @return the value of bbs_reply.reply_content
     *
     * @mbggenerated
     */
    public String getReplyContent() {
        return replyContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bbs_reply.reply_content
     *
     * @param replyContent the value for bbs_reply.reply_content
     *
     * @mbggenerated
     */
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }
}