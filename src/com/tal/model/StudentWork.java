package com.tal.model;

import java.util.Date;

public class StudentWork {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_work.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_work.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_work.lesson_id
     *
     * @mbggenerated
     */
    private Integer lessonId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_work.work_id
     *
     * @mbggenerated
     */
    private Long workId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_work.score
     *
     * @mbggenerated
     */
    private Double score;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_work.work_file
     *
     * @mbggenerated
     */
    private String workFile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_work.work_dt
     *
     * @mbggenerated
     */
    private Date workDt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_work.teacher_comment
     *
     * @mbggenerated
     */
    private String teacherComment;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_work.id
     *
     * @return the value of student_work.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_work.id
     *
     * @param id the value for student_work.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_work.user_id
     *
     * @return the value of student_work.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_work.user_id
     *
     * @param userId the value for student_work.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_work.lesson_id
     *
     * @return the value of student_work.lesson_id
     *
     * @mbggenerated
     */
    public Integer getLessonId() {
        return lessonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_work.lesson_id
     *
     * @param lessonId the value for student_work.lesson_id
     *
     * @mbggenerated
     */
    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_work.work_id
     *
     * @return the value of student_work.work_id
     *
     * @mbggenerated
     */
    public Long getWorkId() {
        return workId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_work.work_id
     *
     * @param workId the value for student_work.work_id
     *
     * @mbggenerated
     */
    public void setWorkId(Long workId) {
        this.workId = workId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_work.score
     *
     * @return the value of student_work.score
     *
     * @mbggenerated
     */
    public Double getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_work.score
     *
     * @param score the value for student_work.score
     *
     * @mbggenerated
     */
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_work.work_file
     *
     * @return the value of student_work.work_file
     *
     * @mbggenerated
     */
    public String getWorkFile() {
        return workFile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_work.work_file
     *
     * @param workFile the value for student_work.work_file
     *
     * @mbggenerated
     */
    public void setWorkFile(String workFile) {
        this.workFile = workFile == null ? null : workFile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_work.work_dt
     *
     * @return the value of student_work.work_dt
     *
     * @mbggenerated
     */
    public Date getWorkDt() {
        return workDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_work.work_dt
     *
     * @param workDt the value for student_work.work_dt
     *
     * @mbggenerated
     */
    public void setWorkDt(Date workDt) {
        this.workDt = workDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_work.teacher_comment
     *
     * @return the value of student_work.teacher_comment
     *
     * @mbggenerated
     */
    public String getTeacherComment() {
        return teacherComment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_work.teacher_comment
     *
     * @param teacherComment the value for student_work.teacher_comment
     *
     * @mbggenerated
     */
    public void setTeacherComment(String teacherComment) {
        this.teacherComment = teacherComment == null ? null : teacherComment.trim();
    }
}