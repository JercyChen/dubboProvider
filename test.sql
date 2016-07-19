/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2016-05-03 21:23:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_login
-- ----------------------------
DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `last_login_time` datetime NOT NULL,
  `user_status` int(11) NOT NULL,
  `user_type_code` int(11) DEFAULT NULL COMMENT '用户类型编号 PK',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_login
-- ----------------------------
INSERT INTO `user_login` VALUES ('1', '1001', '小前', '123456', '2014-12-25 11:01:27', '0', '1001');
INSERT INTO `user_login` VALUES ('2', '1002', '小明', '111111', '2014-12-23 11:03:43', '0', '1001');
INSERT INTO `user_login` VALUES ('3', '1003', '小A', '111111', '2014-12-21 11:03:43', '0', '1002');
INSERT INTO `user_login` VALUES ('4', '1004', '小B', '111111', '2014-12-02 11:03:43', '1', '1003');
INSERT INTO `user_login` VALUES ('5', '1005', '小C', '111111', '2014-12-01 11:03:43', '1', '1001');
INSERT INTO `user_login` VALUES ('6', '1006', '小D', '111111', '2014-12-26 11:03:43', '0', '1006');
INSERT INTO `user_login` VALUES ('7', '1007', '小E', '111111', '2014-12-09 11:03:43', '1', '1005');
INSERT INTO `user_login` VALUES ('8', '1008', '小F', '111111', '2014-12-26 11:03:43', '1', '1003');
INSERT INTO `user_login` VALUES ('12', '1010', 'test', 'test', '2014-12-21 00:00:00', '1', '1003');

-- ----------------------------
-- Table structure for user_mobile
-- ----------------------------
DROP TABLE IF EXISTS `user_mobile`;
CREATE TABLE `user_mobile` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `phonenumber` varchar(15) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`mid`),
  KEY `userid` (`userid`),
  CONSTRAINT `user_mobile_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user_login` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_mobile
-- ----------------------------
INSERT INTO `user_mobile` VALUES ('1', '13545318978', '1001');
INSERT INTO `user_mobile` VALUES ('2', '13687286034', '1001');

-- ----------------------------
-- Table structure for user_type
-- ----------------------------
DROP TABLE IF EXISTS `user_type`;
CREATE TABLE `user_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_type_code` int(11) DEFAULT NULL,
  `user_type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_type_code` (`user_type_code`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_type
-- ----------------------------
INSERT INTO `user_type` VALUES ('1', '1001', '超级管理员');
INSERT INTO `user_type` VALUES ('2', '1002', '总经理');
INSERT INTO `user_type` VALUES ('3', '1003', '部门经理');
INSERT INTO `user_type` VALUES ('4', '1005', '文员');
INSERT INTO `user_type` VALUES ('5', '1006', '普通用户');
INSERT INTO `user_type` VALUES ('6', '1004', '技术总监');
