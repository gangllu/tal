package com.tal.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tal.model.TbWork;
import com.tal.model.TbWorkExample;

public interface TbWorkMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_work
     *
     * @mbggenerated
     */
    int deleteByExample(TbWorkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_work
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long workId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_work
     *
     * @mbggenerated
     */
    int insert(TbWork record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_work
     *
     * @mbggenerated
     */
    int insertSelective(TbWork record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_work
     *
     * @mbggenerated
     */
    TbWork selectByPrimaryKey(Long workId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_work
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") TbWork record, @Param("example") TbWorkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_work
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") TbWork record, @Param("example") TbWorkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_work
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TbWork record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_work
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TbWork record);
    
    List<TbWork> listPageWork(TbWork work);
}