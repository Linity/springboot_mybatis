/*
Navicat MySQL Data Transfer

Source Server         : Lin
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2017-05-02 15:56:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `AGE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
