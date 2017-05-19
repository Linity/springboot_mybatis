package com.ljw.web.entity;

import java.io.Serializable;
import java.util.Date;

public class WxRgisterInfo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wx_rgister_info.ID
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wx_rgister_info.LOGIN_MAIL
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    private String loginMail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wx_rgister_info.ORIGION_ID
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    private String origionId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wx_rgister_info.USER_ID
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wx_rgister_info.CREATE_TIME
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wx_rgister_info
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_rgister_info.ID
     *
     * @return the value of wx_rgister_info.ID
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_rgister_info.ID
     *
     * @param id the value for wx_rgister_info.ID
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_rgister_info.LOGIN_MAIL
     *
     * @return the value of wx_rgister_info.LOGIN_MAIL
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    public String getLoginMail() {
        return loginMail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_rgister_info.LOGIN_MAIL
     *
     * @param loginMail the value for wx_rgister_info.LOGIN_MAIL
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    public void setLoginMail(String loginMail) {
        this.loginMail = loginMail == null ? null : loginMail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_rgister_info.ORIGION_ID
     *
     * @return the value of wx_rgister_info.ORIGION_ID
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    public String getOrigionId() {
        return origionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_rgister_info.ORIGION_ID
     *
     * @param origionId the value for wx_rgister_info.ORIGION_ID
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    public void setOrigionId(String origionId) {
        this.origionId = origionId == null ? null : origionId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_rgister_info.USER_ID
     *
     * @return the value of wx_rgister_info.USER_ID
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_rgister_info.USER_ID
     *
     * @param userId the value for wx_rgister_info.USER_ID
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_rgister_info.CREATE_TIME
     *
     * @return the value of wx_rgister_info.CREATE_TIME
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_rgister_info.CREATE_TIME
     *
     * @param createTime the value for wx_rgister_info.CREATE_TIME
     *
     * @mbg.generated Wed May 03 21:59:17 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}