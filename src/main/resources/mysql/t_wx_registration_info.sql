/*
Navicat MySQL Data Transfer

Source Server         : Lin
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2017-04-25 09:35:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_wx_registration_info
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_registration_info`;
CREATE TABLE `t_wx_registration_info` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Login_Mail` varchar(50) NOT NULL,
  `Origion_ID` varchar(50) NOT NULL,
  `User_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
