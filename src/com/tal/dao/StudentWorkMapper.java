package com.tal.dao;

import com.tal.model.StudentWork;
import com.tal.model.StudentWorkExample;
import org.apache.ibatis.annotations.Param;

public interface StudentWorkMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_work
     *
     * @mbggenerated
     */
    int deleteByExample(StudentWorkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_work
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_work
     *
     * @mbggenerated
     */
    int insert(StudentWork record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_work
     *
     * @mbggenerated
     */
    int insertSelective(StudentWork record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_work
     *
     * @mbggenerated
     */
    StudentWork selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_work
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") StudentWork record, @Param("example") StudentWorkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_work
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") StudentWork record, @Param("example") StudentWorkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_work
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(StudentWork record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student_work
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(StudentWork record);
}