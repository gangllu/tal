package com.tal.model;

import java.util.Date;

import com.tal.util.page.Page;

public class Lesson {
	
	private Page page;
	
	private Integer teacherId;
	
    public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lesson.lesson_id
     *
     * @mbggenerated
     */
    private Integer lessonId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lesson.year
     *
     * @mbggenerated
     */
    private String year;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lesson.lesson_name
     *
     * @mbggenerated
     */
    private String lessonName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lesson.create_dt
     *
     * @mbggenerated
     */
    private Date createDt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lesson.lesson_desc
     *
     * @mbggenerated
     */
    private String lessonDesc;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lesson.lesson_id
     *
     * @return the value of lesson.lesson_id
     *
     * @mbggenerated
     */
    public Integer getLessonId() {
        return lessonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lesson.lesson_id
     *
     * @param lessonId the value for lesson.lesson_id
     *
     * @mbggenerated
     */
    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lesson.year
     *
     * @return the value of lesson.year
     *
     * @mbggenerated
     */
    public String getYear() {
        return year;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lesson.year
     *
     * @param year the value for lesson.year
     *
     * @mbggenerated
     */
    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lesson.lesson_name
     *
     * @return the value of lesson.lesson_name
     *
     * @mbggenerated
     */
    public String getLessonName() {
        return lessonName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lesson.lesson_name
     *
     * @param lessonName the value for lesson.lesson_name
     *
     * @mbggenerated
     */
    public void setLessonName(String lessonName) {
        this.lessonName = lessonName == null ? null : lessonName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lesson.create_dt
     *
     * @return the value of lesson.create_dt
     *
     * @mbggenerated
     */
    public Date getCreateDt() {
        return createDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lesson.create_dt
     *
     * @param createDt the value for lesson.create_dt
     *
     * @mbggenerated
     */
    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lesson.lesson_desc
     *
     * @return the value of lesson.lesson_desc
     *
     * @mbggenerated
     */
    public String getLessonDesc() {
        return lessonDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lesson.lesson_desc
     *
     * @param lessonDesc the value for lesson.lesson_desc
     *
     * @mbggenerated
     */
    public void setLessonDesc(String lessonDesc) {
        this.lessonDesc = lessonDesc == null ? null : lessonDesc.trim();
    }
}