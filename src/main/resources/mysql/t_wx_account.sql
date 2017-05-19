/*
Navicat MySQL Data Transfer

Source Server         : Lin
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2017-04-25 09:41:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_wx_account
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_account`;
CREATE TABLE `t_wx_account` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '公众号ID',
  `WX_Name` varchar(50) NOT NULL COMMENT '公众号名称',
  `WX_Code` varchar(50) DEFAULT NULL COMMENT '公众号的唯一微信号',
  `WX_Type` int(1) NOT NULL COMMENT '类型',
  `WX_Introduction` varchar(200) DEFAULT NULL COMMENT '公众号介绍',
  `WX_Is_Identify` int(1) DEFAULT '1' COMMENT '公众号是否已经认证',
  `WX_Applet_ID` bigint(20) DEFAULT NULL COMMENT '微信小程序id',
  `User_ID` bigint(20) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
