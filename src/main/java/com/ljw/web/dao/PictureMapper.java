package com.ljw.web.dao;

import com.ljw.web.entity.Picture;

public interface PictureMapper {
    Picture selectByUserId(Long userId);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    int insert(Picture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    int insertSelective(Picture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    Picture selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    int updateByPrimaryKeySelective(Picture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table picture
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    int updateByPrimaryKey(Picture record);
}