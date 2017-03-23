package com.tal.model;

import java.util.Date;

public class Chat {
	private String userName;
	
    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chat.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chat.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chat.msg
     *
     * @mbggenerated
     */
    private String msg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chat.dt
     *
     * @mbggenerated
     */
    private Date dt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chat.lesson_id
     *
     * @mbggenerated
     */
    private Integer lessonId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chat.id
     *
     * @return the value of chat.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chat.id
     *
     * @param id the value for chat.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chat.user_id
     *
     * @return the value of chat.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chat.user_id
     *
     * @param userId the value for chat.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chat.msg
     *
     * @return the value of chat.msg
     *
     * @mbggenerated
     */
    public String getMsg() {
        return msg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chat.msg
     *
     * @param msg the value for chat.msg
     *
     * @mbggenerated
     */
    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chat.dt
     *
     * @return the value of chat.dt
     *
     * @mbggenerated
     */
    public Date getDt() {
        return dt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chat.dt
     *
     * @param dt the value for chat.dt
     *
     * @mbggenerated
     */
    public void setDt(Date dt) {
        this.dt = dt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chat.lesson_id
     *
     * @return the value of chat.lesson_id
     *
     * @mbggenerated
     */
    public Integer getLessonId() {
        return lessonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chat.lesson_id
     *
     * @param lessonId the value for chat.lesson_id
     *
     * @mbggenerated
     */
    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }
}