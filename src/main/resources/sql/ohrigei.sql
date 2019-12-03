/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : ohrigei

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 03/12/2019 11:33:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '管理员用户ID',
  `title` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '职位',
  `committee_ID` smallint(5) UNSIGNED NULL DEFAULT NULL COMMENT '委员会ID',
  `role_AG` smallint(1) NOT NULL DEFAULT 0 COMMENT '全局学术管理员',
  `role_AD` smallint(1) NOT NULL DEFAULT 0 COMMENT '单一会场学术管理员',
  `role_D` smallint(1) NOT NULL DEFAULT 0 COMMENT '管制行政管理员',
  `role_L` smallint(1) NOT NULL DEFAULT 0 COMMENT '总务行政管理员',
  `role_F` smallint(1) NOT NULL DEFAULT 0 COMMENT '财务行政管理员',
  `role_SG` smallint(1) NOT NULL DEFAULT 0 COMMENT '秘书长级管理员',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `委员会ID`(`committee_ID`) USING BTREE,
  CONSTRAINT `委员会ID` FOREIGN KEY (`committee_ID`) REFERENCES `committee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for committee
-- ----------------------------
DROP TABLE IF EXISTS `committee`;
CREATE TABLE `committee`  (
  `id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '委员会ID',
  `name` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '委员会名称',
  `abbr` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '委员会缩写',
  `seat_width` int(128) UNSIGNED NULL DEFAULT NULL COMMENT '一般席位容量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for delegate
-- ----------------------------
DROP TABLE IF EXISTS `delegate`;
CREATE TABLE `delegate`  (
  `id` smallint(5) NOT NULL COMMENT '用户ID',
  `application_type` enum('delegate','obsever','teacher') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '申请类型',
  `application_status` enum('application_imported','review_passed','review_refused','interview_assigned','interview_arranged','interview_completed','waitlist_entered','seat_assigned','seat_selected','invoice_issued','payment_received','locked','quitted','deleted') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '申请状态',
  `group_id` smallint(5) NULL DEFAULT NULL COMMENT '所在代表团',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for delegate_profile
-- ----------------------------
DROP TABLE IF EXISTS `delegate_profile`;
CREATE TABLE `delegate_profile`  (
  `id` mediumint(8) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '资料ID',
  `delegate_ID` smallint(5) UNSIGNED NOT NULL COMMENT '代表ID',
  `profile_Type` enum('basic_profile','Academic\r\nacademic_profile') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '资料类型',
  `value` json NULL COMMENT '资料内容',
  `last_modified` datetime(6) NULL DEFAULT NULL COMMENT '最后更改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`  (
  `id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '代表团ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '代表团名称',
  `head_delegate` smallint(5) UNSIGNED NULL DEFAULT NULL COMMENT '负责代表ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` smallint(6) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓氏拼音',
  `first_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名拼音',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '电子邮箱',
  `password` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话号',
  `type` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '用户类型：用户(1)或者管理员(0)',
  `enable_login` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否启用登录，1为启用，0为关闭',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_name`(`name`) USING BTREE,
  INDEX `user_phone`(`phone`) USING BTREE,
  INDEX `user_email`(`email`) USING BTREE,
  INDEX `user_type`(`type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '孙征', '', '', '1020154356@qq.com', 'zz1020154356', '17615107203', 1, 1);
INSERT INTO `user` VALUES (2, '管理员', NULL, '', '123@qq.com', '123', '1234567890', 0, 1);

SET FOREIGN_KEY_CHECKS = 1;
