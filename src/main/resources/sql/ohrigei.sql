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

 Date: 05/12/2019 17:50:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for academic_test_status
-- ----------------------------
DROP TABLE IF EXISTS `academic_test_status`;
CREATE TABLE `academic_test_status`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `academic_test_status_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学测状态的文本信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of academic_test_status
-- ----------------------------
INSERT INTO `academic_test_status` VALUES (1, '待填写');
INSERT INTO `academic_test_status` VALUES (2, '已过期');
INSERT INTO `academic_test_status` VALUES (3, '待批改');
INSERT INTO `academic_test_status` VALUES (4, '已通过');
INSERT INTO `academic_test_status` VALUES (5, '未通过');

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
-- Table structure for application_status
-- ----------------------------
DROP TABLE IF EXISTS `application_status`;
CREATE TABLE `application_status`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '申请状态的ID',
  `application_status_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '申请状态对应文字信息',
  `application_status_text_en` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '申请状态对应的英文文字信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of application_status
-- ----------------------------
INSERT INTO `application_status` VALUES (1, '报名待确认', 'Application Submitted');
INSERT INTO `application_status` VALUES (2, '报名确认未通过', 'Application Failed');
INSERT INTO `application_status` VALUES (3, '学测待完成', 'Academic Test to Be Done');
INSERT INTO `application_status` VALUES (4, '学测未完成', 'Academic Test Uncomplished');
INSERT INTO `application_status` VALUES (5, '学测待评估', 'Academic Test to Be Estimated');
INSERT INTO `application_status` VALUES (6, '学测未通过', 'Academic Test Failed');
INSERT INTO `application_status` VALUES (7, '等待面试', 'To Be Interiewed');
INSERT INTO `application_status` VALUES (8, '面试未通过', 'Interiew Failed');
INSERT INTO `application_status` VALUES (9, '等待缴费', 'Fee to Be Paid');
INSERT INTO `application_status` VALUES (10, '缴费失败', 'Failed to Pay Fee');
INSERT INTO `application_status` VALUES (11, '席位待分配', 'Committee and Seat to Be Assigned');
INSERT INTO `application_status` VALUES (12, '席位分配待确认', 'Committee and Seat to Be Confirmed');
INSERT INTO `application_status` VALUES (13, '席位未能分配', 'Committee and Seat Failed');
INSERT INTO `application_status` VALUES (14, '报名成功', 'Application Succeeded');

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
  `application_type` smallint(6) NULL DEFAULT NULL COMMENT '申请类型1:普通代表，2:观察员，3:指导教师',
  `application_status` smallint(6) NULL DEFAULT NULL COMMENT '申请状态',
  `group_id` smallint(5) NULL DEFAULT NULL COMMENT '所在代表团',
  `role_delegate` smallint(1) NULL DEFAULT 1 COMMENT '普通代表角色，默认为1，代表true，0代表false',
  `role_observer` smallint(1) NULL DEFAULT 0 COMMENT '观察员角色，默认为0',
  `role_leader` smallint(1) NULL DEFAULT 0 COMMENT '领队角色，默认为0',
  `role_teacher` smallint(1) NULL DEFAULT 0 COMMENT '指导教师角色，默认为0',
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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '孙征', '', '', '1020154356@qq.com', 'zz1020154356', '17615107203', 1, 1);
INSERT INTO `user` VALUES (2, '管理员', NULL, '', '123@qq.com', '123', '1234567890', 0, 1);
INSERT INTO `user` VALUES (3, '原', '逸非', '逸非原', '12345@qq.com', '123456', '17615107203', 1, 1);
INSERT INTO `user` VALUES (4, '原', '逸非', '逸非原', '6@qq.com', '123456', '17615107203', 1, 1);
INSERT INTO `user` VALUES (5, '原', '逸非', '逸非原', '1234@qq.com', '123456', '17615107203', 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
