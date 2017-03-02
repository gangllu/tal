package com.tal.dao;

import com.tal.model.Knowledge;
import com.tal.model.KnowledgeExample;
import org.apache.ibatis.annotations.Param;

public interface KnowledgeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbggenerated
     */
    int deleteByExample(KnowledgeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbggenerated
     */
    int insert(Knowledge record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbggenerated
     */
    int insertSelective(Knowledge record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbggenerated
     */
    Knowledge selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Knowledge record, @Param("example") KnowledgeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Knowledge record, @Param("example") KnowledgeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Knowledge record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table knowledge
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Knowledge record);
}