package com.ljw.web.dao;

import com.ljw.web.entity.WxAccount;

public interface WxAccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_account
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_account
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    int insert(WxAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_account
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    int insertSelective(WxAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_account
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    WxAccount selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_account
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    int updateByPrimaryKeySelective(WxAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_account
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    int updateByPrimaryKey(WxAccount record);
}