/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.26
Source Server Version : 50173
Source Host           : 192.168.1.26:3306
Source Database       : spring_boot_demo

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2016-01-22 13:31:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user_demo`
-- ----------------------------
DROP TABLE IF EXISTS `user_demo`;
CREATE TABLE `user_demo` (
  `id` varchar(32) NOT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `user_pwd` varchar(32) DEFAULT NULL,
  `nick_name` varchar(128) DEFAULT NULL,
  `create_by` varchar(32) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `last_modified_by` varchar(32) DEFAULT NULL,
  `last_modified_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_demo
-- ----------------------------
INSERT INTO `user_demo` VALUES ('a813457230a542dc9355e91b7ca72b1f', 'sean', '1234567', 'sean', null, '2016-01-22', null, '2016-01-22');
INSERT INTO `user_demo` VALUES ('22d5f27f8b7d4e638724b4bef2733347', 'admin', '1234567', 'admin', null, '2016-01-22', null, '2016-01-22');
INSERT INTO `user_demo` VALUES ('a878f356ff764d87855965df02938be5', 'admin', '1234567', 'admin', null, '2016-01-22', null, '2016-01-22');
