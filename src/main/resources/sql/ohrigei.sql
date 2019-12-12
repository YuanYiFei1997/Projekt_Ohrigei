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

 Date: 12/12/2019 17:57:03
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
  `id` int(10) UNSIGNED NOT NULL COMMENT '管理员用户ID',
  `title` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '职位',
  `committee_ID` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '委员会ID',
  `role_AG` smallint(1) NOT NULL DEFAULT 0 COMMENT '全局学术管理员',
  `role_AD` smallint(1) NOT NULL DEFAULT 0 COMMENT '单一会场学术管理员',
  `role_D` smallint(1) NOT NULL DEFAULT 0 COMMENT '管制行政管理员',
  `role_L` smallint(1) NOT NULL DEFAULT 0 COMMENT '总务行政管理员',
  `role_F` smallint(1) NOT NULL DEFAULT 0 COMMENT '财务行政管理员',
  `role_SG` smallint(1) NOT NULL DEFAULT 0 COMMENT '秘书长级管理员',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `委员会ID`(`committee_ID`) USING BTREE,
  CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `admin_ibfk_2` FOREIGN KEY (`committee_ID`) REFERENCES `committee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (2, '社联主席', 1, 1, 1, 0, 0, 0, 0);

-- ----------------------------
-- Table structure for application_status
-- ----------------------------
DROP TABLE IF EXISTS `application_status`;
CREATE TABLE `application_status`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '申请状态的ID',
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
-- Table structure for application_type
-- ----------------------------
DROP TABLE IF EXISTS `application_type`;
CREATE TABLE `application_type`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '申请类型ID',
  `application_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '申请类型文本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of application_type
-- ----------------------------
INSERT INTO `application_type` VALUES (1, '参会代表');
INSERT INTO `application_type` VALUES (2, '指导教师');
INSERT INTO `application_type` VALUES (3, '观察员');

-- ----------------------------
-- Table structure for bill_status
-- ----------------------------
DROP TABLE IF EXISTS `bill_status`;
CREATE TABLE `bill_status`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '账单id',
  `delegate_ID` int(10) UNSIGNED NOT NULL COMMENT '代表ID',
  `bill_status_type_ID` int(10) UNSIGNED NOT NULL COMMENT '账单状态ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `delegate_ID`(`delegate_ID`) USING BTREE,
  INDEX `bill_status_type_ID`(`bill_status_type_ID`) USING BTREE,
  CONSTRAINT `bill_status_ibfk_1` FOREIGN KEY (`delegate_ID`) REFERENCES `delegate` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `bill_status_ibfk_2` FOREIGN KEY (`bill_status_type_ID`) REFERENCES `bill_status_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bill_status_type
-- ----------------------------
DROP TABLE IF EXISTS `bill_status_type`;
CREATE TABLE `bill_status_type`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '账单状态ID',
  `bill_status_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '账单状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `bill_status_type`(`bill_status_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bill_status_type
-- ----------------------------
INSERT INTO `bill_status_type` VALUES (3, '已支付');
INSERT INTO `bill_status_type` VALUES (4, '已逾期');
INSERT INTO `bill_status_type` VALUES (2, '待确认');
INSERT INTO `bill_status_type` VALUES (1, '未支付');

-- ----------------------------
-- Table structure for club_info
-- ----------------------------
DROP TABLE IF EXISTS `club_info`;
CREATE TABLE `club_info`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '社团id',
  `school_ID` int(10) NOT NULL COMMENT '学校id',
  `club_set_up_date` date NULL DEFAULT NULL COMMENT '社团建立时间',
  `club_size` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '社团规模',
  `club_meeting` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '社团参加过的会议',
  `club_daily` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '社团日常活动',
  `club_influence` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '社团影响力',
  PRIMARY KEY (`id`, `school_ID`) USING BTREE,
  INDEX `schoolID`(`school_ID`) USING BTREE,
  INDEX `id`(`id`) USING BTREE,
  CONSTRAINT `schoolID` FOREIGN KEY (`school_ID`) REFERENCES `school_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of club_info
-- ----------------------------
INSERT INTO `club_info` VALUES (1, 1, '2008-02-14', '50+', 'test texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest text', 'test texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest text', 'test texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest texttest text');
INSERT INTO `club_info` VALUES (2, 2, '2019-11-06', '20~30', 'fddddsfcAefhdjasfiaiweruiaodnajghijhwefiojuasoithioaj', '142r3trgfbvwteyhhtjmbvaqsfgthn', 'fgbhgbhngTEDTGVC AWSTRFAH');
INSERT INTO `club_info` VALUES (3, 3, '2008-07-08', '15~25', 'dabhfgsdfsdgdsgdtjsfhsdjdfg', 'ghsdfghsertgrert', 'argadfgefdaeasfa3w');
INSERT INTO `club_info` VALUES (4, 4, '2015-07-17', '30~40', 'ghghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh', 'hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhgfhdfghd', 'gdhfddhhhhhhhhhhhhhhhhhhhhh');

-- ----------------------------
-- Table structure for committee
-- ----------------------------
DROP TABLE IF EXISTS `committee`;
CREATE TABLE `committee`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '委员会ID',
  `committee_name` varchar(0) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '委员会名称',
  `seat_width` int(128) UNSIGNED NULL DEFAULT NULL COMMENT '一般席位容量',
  `chairman_ID` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '主席团ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `chairman_ID`(`chairman_ID`) USING BTREE,
  CONSTRAINT `committee_ibfk_1` FOREIGN KEY (`chairman_ID`) REFERENCES `admin` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of committee
-- ----------------------------
INSERT INTO `committee` VALUES (1, '', 10, 2);
INSERT INTO `committee` VALUES (2, '', 10, NULL);

-- ----------------------------
-- Table structure for delegate
-- ----------------------------
DROP TABLE IF EXISTS `delegate`;
CREATE TABLE `delegate`  (
  `id` int(10) UNSIGNED NOT NULL COMMENT '用户ID',
  `application_type_ID` int(10) UNSIGNED NULL DEFAULT 1 COMMENT '申请类型1:普通代表，2:指导教师，3:观察员',
  `application_status_ID` int(10) UNSIGNED NULL DEFAULT 1 COMMENT '申请状态',
  `group_ID` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '所在代表团',
  `role_ID` int(10) UNSIGNED NULL DEFAULT 1 COMMENT '参见delegate_role_type表',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `role_ID`(`role_ID`) USING BTREE,
  INDEX `application_status_ID`(`application_status_ID`) USING BTREE,
  INDEX `application_type_ID`(`application_type_ID`) USING BTREE,
  INDEX `group_ID`(`group_ID`) USING BTREE,
  CONSTRAINT `delegate_ibfk_1` FOREIGN KEY (`role_ID`) REFERENCES `delegate_role_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `delegate_ibfk_2` FOREIGN KEY (`application_status_ID`) REFERENCES `application_status` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `delegate_ibfk_3` FOREIGN KEY (`application_type_ID`) REFERENCES `application_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `delegate_ibfk_4` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `delegate_ibfk_5` FOREIGN KEY (`group_ID`) REFERENCES `group` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of delegate
-- ----------------------------
INSERT INTO `delegate` VALUES (1, 1, 2, 1, 1);
INSERT INTO `delegate` VALUES (6, 2, 1, NULL, 2);

-- ----------------------------
-- Table structure for delegate_profile
-- ----------------------------
DROP TABLE IF EXISTS `delegate_profile`;
CREATE TABLE `delegate_profile`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '资料ID',
  `delegate_ID` int(10) UNSIGNED NOT NULL COMMENT '代表ID',
  `profile_Type` enum('basic_profile','Academic\r\nacademic_profile') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '资料类型',
  `value` json NULL COMMENT '资料内容',
  `last_modified` datetime(6) NULL DEFAULT NULL COMMENT '最后更改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `delegate_ID`(`delegate_ID`) USING BTREE,
  CONSTRAINT `delegate_profile_ibfk_1` FOREIGN KEY (`delegate_ID`) REFERENCES `delegate` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for delegate_role_type
-- ----------------------------
DROP TABLE IF EXISTS `delegate_role_type`;
CREATE TABLE `delegate_role_type`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '代表角色ID',
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of delegate_role_type
-- ----------------------------
INSERT INTO `delegate_role_type` VALUES (1, '代表');
INSERT INTO `delegate_role_type` VALUES (2, '观察员');
INSERT INTO `delegate_role_type` VALUES (3, '指导教师');
INSERT INTO `delegate_role_type` VALUES (4, '领队');

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '代表团ID',
  `school_ID` int(10) NOT NULL COMMENT '学校ID',
  `head_delegate_ID` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '负责代表ID',
  `group_size` int(10) UNSIGNED NOT NULL COMMENT '代表团规模',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `school_ID`(`school_ID`) USING BTREE,
  INDEX `head_delegate_ID`(`head_delegate_ID`) USING BTREE,
  CONSTRAINT `group_ibfk_1` FOREIGN KEY (`school_ID`) REFERENCES `school_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `group_ibfk_2` FOREIGN KEY (`head_delegate_ID`) REFERENCES `delegate` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group
-- ----------------------------
INSERT INTO `group` VALUES (1, 5, 1, 10);

-- ----------------------------
-- Table structure for school_info
-- ----------------------------
DROP TABLE IF EXISTS `school_info`;
CREATE TABLE `school_info`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '学校信息ID',
  `school_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学校名称',
  `school_name_EN` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '学校名称（英文）',
  `school_type_ID` int(255) NOT NULL COMMENT '学校类型ID',
  `school_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '学校地址',
  `size` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '预计参会人数',
  `club_ID` int(10) NULL DEFAULT NULL COMMENT '社团id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `school_type_ID`(`school_type_ID`) USING BTREE,
  INDEX `club_ID`(`club_ID`) USING BTREE,
  CONSTRAINT `school_info_ibfk_1` FOREIGN KEY (`school_type_ID`) REFERENCES `school_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `school_info_ibfk_2` FOREIGN KEY (`club_ID`) REFERENCES `club_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of school_info
-- ----------------------------
INSERT INTO `school_info` VALUES (1, '瑞典皇家文法学校', NULL, 1, '瑞典斯德哥尔摩市', 24, 1);
INSERT INTO `school_info` VALUES (2, '瑞典皇家文法学校北校区', NULL, 1, '瑞典斯德哥尔摩市北大营', 20, 2);
INSERT INTO `school_info` VALUES (3, '瑞典国立大学附属中学', NULL, 2, '瑞典斯德哥尔摩市国立大学', 30, NULL);
INSERT INTO `school_info` VALUES (4, '市立斯德哥尔摩市陶然亭中学', NULL, 2, '斯德哥尔摩市', 15, NULL);
INSERT INTO `school_info` VALUES (5, '峰城大附属', NULL, 2, '东京市', 3, NULL);
INSERT INTO `school_info` VALUES (6, '北大青鸟职业技术学院', NULL, 3, '北京市北大青鸟培训基地', 40, NULL);
INSERT INTO `school_info` VALUES (7, '第三新东京市第二中学', NULL, 4, '日本第三新东京市', 5, NULL);

-- ----------------------------
-- Table structure for school_type
-- ----------------------------
DROP TABLE IF EXISTS `school_type`;
CREATE TABLE `school_type`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '学校类型ID',
  `school_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学校类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of school_type
-- ----------------------------
INSERT INTO `school_type` VALUES (1, '文法学校');
INSERT INTO `school_type` VALUES (2, '综合中学');
INSERT INTO `school_type` VALUES (3, '职业学校');
INSERT INTO `school_type` VALUES (4, '博洛尼亚协定框架外的其他类型');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓氏拼音',
  `first_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名拼音',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '电子邮箱',
  `password` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话号',
  `enable_login` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否启用登录，1为启用，0为关闭',
  `role_ID` int(10) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_name`(`name`) USING BTREE,
  INDEX `user_phone`(`phone`) USING BTREE,
  INDEX `user_email`(`email`) USING BTREE,
  INDEX `role_ID`(`role_ID`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_ID`) REFERENCES `user_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '孙征', '', '', '1020154356@qq.com', 'zz1020154356', '17615107203', 1, 2);
INSERT INTO `user` VALUES (2, '管理员', NULL, '', '123@qq.com', '123', '1234567890', 1, 1);
INSERT INTO `user` VALUES (5, '原', '逸非', '逸非原', '1234@qq.com', '123456', '17615107203', 1, 2);
INSERT INTO `user` VALUES (6, '冬马和纱', 'TOMA', 'KAZUSA', '123456@dlufl.edu.com', '123456', '13111111111111', 1, 2);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ADMIN/USER',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 'ROLE_ADMIN');
INSERT INTO `user_role` VALUES (2, 'ROLE_USER');

SET FOREIGN_KEY_CHECKS = 1;
