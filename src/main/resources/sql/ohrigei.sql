/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : ohrigei

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 12/04/2020 17:24:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(10) UNSIGNED NOT NULL COMMENT '管理员用户ID',
  `title` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '职位',
  `committee_ID` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '委员会ID',
  `role_AG` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '全局学术管理员',
  `role_AD` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单一会场学术管理员',
  `role_D` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '管制行政管理员',
  `role_L` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '总务行政管理员',
  `role_F` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '财务行政管理员',
  `role_SG` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '秘书长级管理员',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `委员会ID`(`committee_ID`) USING BTREE,
  CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `admin_ibfk_2` FOREIGN KEY (`committee_ID`) REFERENCES `committee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (8, NULL, NULL, 1, 1, 1, 1, 1, 1);
INSERT INTO `admin` VALUES (11, '社联主席，亘古一人忠义无双', NULL, 1, 0, 0, 0, 0, 0);
INSERT INTO `admin` VALUES (12, '伟大的社联部长', NULL, 0, 0, 0, 1, 0, 1);
INSERT INTO `admin` VALUES (19, '测试头衔', NULL, 0, 1, 0, 1, 0, 0);

-- ----------------------------
-- Table structure for application_status
-- ----------------------------
DROP TABLE IF EXISTS `application_status`;
CREATE TABLE `application_status`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '申请状态的ID',
  `application_status_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '申请状态对应文字信息',
  `application_status_text_en` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '申请状态对应的英文文字信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of application_status
-- ----------------------------
INSERT INTO `application_status` VALUES (1, '报名待确认', 'Application Submitted');
INSERT INTO `application_status` VALUES (2, '报名确认未通过', 'Application Failed');
INSERT INTO `application_status` VALUES (3, '等待面试', 'To Be Interiewed');
INSERT INTO `application_status` VALUES (4, '面试未通过', 'Interiew Failed');
INSERT INTO `application_status` VALUES (5, '等待缴费', 'Fee to Be Paid');
INSERT INTO `application_status` VALUES (6, '缴费失败', 'Failed to Pay Fee');
INSERT INTO `application_status` VALUES (7, '席位待分配', 'Committee and Seat to Be Assigned');
INSERT INTO `application_status` VALUES (8, '席位分配待确认', 'Committee and Seat to Be Confirmed');
INSERT INTO `application_status` VALUES (9, '席位未能分配', 'Committee and Seat Failed');
INSERT INTO `application_status` VALUES (10, '报名成功', 'Application Succeeded');
INSERT INTO `application_status` VALUES (11, '主动退会', NULL);

-- ----------------------------
-- Table structure for application_status_description
-- ----------------------------
DROP TABLE IF EXISTS `application_status_description`;
CREATE TABLE `application_status_description`  (
  `id` int(10) UNSIGNED NOT NULL COMMENT '对应申请状态ID',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '对应申请状态的描述',
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `application_status_description_ibfk_1` FOREIGN KEY (`id`) REFERENCES `application_status` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of application_status_description
-- ----------------------------
INSERT INTO `application_status_description` VALUES (1, '您的参会申请已提交，请耐心等待管理员的审批。');
INSERT INTO `application_status_description` VALUES (2, '很遗憾，您的参会申请未被通过，可联系管理员询问具体原因。');
INSERT INTO `application_status_description` VALUES (3, '您的学测已顺利通过， 请等待管理员为您安排面试。');
INSERT INTO `application_status_description` VALUES (4, '很遗憾，您的面试未能通过，期待您的下次参会。');
INSERT INTO `application_status_description` VALUES (5, '您的面试已顺利通过，请在账单发出后及时缴费。');
INSERT INTO `application_status_description` VALUES (6, '您的缴费由于超时或金额不足等原因以失败，请联系管理员并重新缴费。');
INSERT INTO `application_status_description` VALUES (7, '您的缴费已被确认，请尽快完成席位选择或者等待管理员分配席位。');
INSERT INTO `application_status_description` VALUES (8, '您已完成席位选定，请等待管理员进行确认。');
INSERT INTO `application_status_description` VALUES (9, '您未能成功进行席位选定，请联系管理员重新选定席位。');
INSERT INTO `application_status_description` VALUES (10, '您已成功完成席位选定，请等待会议正式开始，会场见！');
INSERT INTO `application_status_description` VALUES (11, '由于您的选择，您已经退出本次会议，如有问题请及时联系管理员。');

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
-- Table structure for bill_amount_type
-- ----------------------------
DROP TABLE IF EXISTS `bill_amount_type`;
CREATE TABLE `bill_amount_type`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '账单类型ID',
  `bill_amount` int(10) NOT NULL COMMENT '账单金额',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `bill_status_type`(`bill_amount`) USING BTREE,
  CONSTRAINT `bill_amount_type_ibfk_1` FOREIGN KEY (`id`) REFERENCES `application_type` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bill_amount_type
-- ----------------------------
INSERT INTO `bill_amount_type` VALUES (3, 200);
INSERT INTO `bill_amount_type` VALUES (2, 300);
INSERT INTO `bill_amount_type` VALUES (1, 800);

-- ----------------------------
-- Table structure for bill_status
-- ----------------------------
DROP TABLE IF EXISTS `bill_status`;
CREATE TABLE `bill_status`  (
  `id` int(10) UNSIGNED NOT NULL COMMENT '代表ID',
  `bill_type_ID` int(10) UNSIGNED NOT NULL COMMENT '账单类型ID',
  `bill_serial_number` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '付款流水号',
  `bill_generate_date` datetime(0) NOT NULL COMMENT '账单生成时间',
  `bill_pay_date` datetime(0) NULL DEFAULT NULL COMMENT '账单支付时间',
  `bill_status` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '账单状态，0为未支付，1为已支付',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `delegate_ID`(`bill_type_ID`) USING BTREE,
  INDEX `bill_status_type_ID`(`bill_serial_number`) USING BTREE,
  CONSTRAINT `bill_status_ibfk_1` FOREIGN KEY (`id`) REFERENCES `delegate` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `bill_status_ibfk_2` FOREIGN KEY (`bill_type_ID`) REFERENCES `bill_amount_type` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bill_status
-- ----------------------------
INSERT INTO `bill_status` VALUES (20, 1, '21345678-0987654', '2020-03-31 00:46:07', '2020-03-12 02:09:00', 1);

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
  `committee_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '委员会名称',
  `seat_width` int(128) UNSIGNED NULL DEFAULT NULL COMMENT '一般席位容量',
  `chairman_ID` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '主席团ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `chairman_ID`(`chairman_ID`) USING BTREE,
  CONSTRAINT `committee_ibfk_1` FOREIGN KEY (`chairman_ID`) REFERENCES `admin` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of committee
-- ----------------------------
INSERT INTO `committee` VALUES (1, '', 10, NULL);
INSERT INTO `committee` VALUES (2, '', 10, NULL);
INSERT INTO `committee` VALUES (3, '测试委员会', 10, 8);

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
INSERT INTO `delegate` VALUES (9, 1, 4, NULL, 1);
INSERT INTO `delegate` VALUES (10, 1, 1, NULL, 1);
INSERT INTO `delegate` VALUES (20, 1, 7, 2, 1);
INSERT INTO `delegate` VALUES (21, 1, 1, NULL, 1);
INSERT INTO `delegate` VALUES (22, 1, 1, NULL, 1);
INSERT INTO `delegate` VALUES (23, 1, 1, NULL, 1);

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
-- Records of delegate_profile
-- ----------------------------

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
  `delete_status` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '代表团是否删除，1为删除0为可用',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `school_ID`(`school_ID`) USING BTREE,
  INDEX `head_delegate_ID`(`head_delegate_ID`) USING BTREE,
  CONSTRAINT `group_ibfk_1` FOREIGN KEY (`school_ID`) REFERENCES `school_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `group_ibfk_2` FOREIGN KEY (`head_delegate_ID`) REFERENCES `delegate` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group
-- ----------------------------
INSERT INTO `group` VALUES (1, 1, NULL, 23, 0);
INSERT INTO `group` VALUES (2, 2, 9, 2, 0);
INSERT INTO `group` VALUES (3, 4, NULL, 23, 1);
INSERT INTO `group` VALUES (4, 5, NULL, 23, 1);

-- ----------------------------
-- Table structure for interview_info
-- ----------------------------
DROP TABLE IF EXISTS `interview_info`;
CREATE TABLE `interview_info`  (
  `id` int(10) UNSIGNED NOT NULL COMMENT '代表ID',
  `admin_id` int(10) UNSIGNED NOT NULL COMMENT '面试官ID',
  `date` datetime(0) NOT NULL COMMENT '面试时间',
  `interview_score` float(10, 1) UNSIGNED NULL DEFAULT 0.0 COMMENT '面试得分',
  `academic_score` int(10) NULL DEFAULT 0 COMMENT '学术分数',
  `passion_score` int(10) NULL DEFAULT 0 COMMENT '热情分数',
  `interview_status` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '面试状态，0为未完成，1为完成',
  `comment` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '面试评价',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of interview_info
-- ----------------------------
INSERT INTO `interview_info` VALUES (9, 8, '2020-04-16 06:53:00', 3.6, 4, 3, 1, '234，235，236');
INSERT INTO `interview_info` VALUES (20, 8, '2020-03-30 19:40:00', 2.2, 3, 1, 1, '菜的抠脚');
INSERT INTO `interview_info` VALUES (21, 8, '2020-03-27 15:26:00', 0.0, 0, 0, 0, NULL);

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `post` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '公告内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES (2, '这是一条公告');
INSERT INTO `post` VALUES (3, '这是另一条公告');

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
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

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
INSERT INTO `school_info` VALUES (8, '大连外国语大学', '', 3, '大连市旅顺口区', 15, NULL);

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
-- Table structure for seat
-- ----------------------------
DROP TABLE IF EXISTS `seat`;
CREATE TABLE `seat`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '席位ID',
  `seat_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '席位名称',
  `delegate_ID` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '选中席位的代表ID',
  `committee_ID` int(10) UNSIGNED NOT NULL COMMENT '委员会ID',
  `seat_difficulty` int(2) UNSIGNED NULL DEFAULT 1 COMMENT '席位难度',
  `seat_select_status` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '席位被代表选中为1，未选为0',
  `seat_select_date` datetime(0) NULL DEFAULT NULL COMMENT '席位被选中时插入当前时间',
  `seat_confirm_status` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '席位选定未被确认为0，被确认为1',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `committee_ID`(`committee_ID`) USING BTREE,
  CONSTRAINT `seat_ibfk_1` FOREIGN KEY (`committee_ID`) REFERENCES `committee` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seat
-- ----------------------------
INSERT INTO `seat` VALUES (1, '美国', NULL, 3, 1, 0, NULL, 0);
INSERT INTO `seat` VALUES (2, '美国', 20, 3, 1, 1, '2020-04-03 00:10:56', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓氏拼音',
  `first_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名拼音',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '电子邮箱',
  `password` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话号',
  `enable_login` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否启用登录，1为启用，0为关闭',
  `role_ID` int(10) UNSIGNED NULL DEFAULT NULL,
  `avatar_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '头像路径',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_name`(`name`) USING BTREE,
  INDEX `user_phone`(`phone`) USING BTREE,
  INDEX `user_email`(`email`) USING BTREE,
  INDEX `role_ID`(`role_ID`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_ID`) REFERENCES `user_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (8, '冬马和纱', 'TOMA', 'KAZUSA', '123@qq.com', '$2a$10$lJWw3hxO2uy6X5CUDaMlNOeiUsQaGvEBdHeanYjrIVthjqXCSLoTC', '13112345678', 1, 1, '../冬马和纱2020-04-06 22-02-48.jpg');
INSERT INTO `user` VALUES (9, '小木曾雪菜', 'OGISO', 'SETSUNA', '321@qq.com', '$2a$10$RxKxtC430Yv1EQ7IAKNpVOt4WcflsJjMEP148dMBHGIq8xlyKY3Xe', '13212345678', 1, 2, NULL);
INSERT INTO `user` VALUES (10, '被封锁', 'BEI', 'FENGSUO', '111@qq.com', '$2a$10$R949ZxJt/PaChm8s0hdl..P0U.6dmqYbMLhpxVYpeF7MVDPLvKBxi', '11111111111', 0, 2, NULL);
INSERT INTO `user` VALUES (11, '孙征', NULL, NULL, '123456@qq.com', '$2a$10$8H31vOXwWS5k.9W8Zmgbte1K67ITeMZcWgWpDctxhGr3NJHkuOj/S', '12312312312', 1, 1, NULL);
INSERT INTO `user` VALUES (12, '郑羡之', NULL, NULL, '112@qq.com', '$2a$10$ZDK.eW2StJ.VPEorRFqdUeKrJyGAn84ya0CCki.M.bdc/tV1.w77a', '12312312321', 1, 1, NULL);
INSERT INTO `user` VALUES (19, '测试', NULL, NULL, '123@gmail.com', '$2a$10$OSEnNFqm8jaIf7wN9jERa.VgZu7MiJQOzTtx4fUB281fr0oaB609m', '13212345678', 1, 1, NULL);
INSERT INTO `user` VALUES (20, '测试用户', 'CESHI', 'YONGHU', 'user@qq.com', '$2a$10$D31wVtnn9UIgAbG2I9d9UeCZngQZsQR.AK841XSK4S79hI/SCqL1i', '13211111111', 1, 2, '../测试用户2020-04-06 22-38-19.jpg');
INSERT INTO `user` VALUES (21, 'A', 'KAGA', 'AKAGA', '372462650@qq.com', '$2a$10$UQ5rRIwor826iHoN9p8LN.TZtfjTMxloHm.8Hgao7794nOudiEusy', '18912681000', 1, 2, NULL);
INSERT INTO `user` VALUES (22, '测试3', 'CESHI', 'CESHI', 'test3@qq.com', '$2a$10$DBkR9/.Fz3yCMWrXvOpWF.zwIA8Zaw1RKzA8ZL6vLdIKCjCo30Wsq', '13111111111', 1, 2, '../测试32020-04-08 17-25-07.jpg');
INSERT INTO `user` VALUES (23, '测试4', 'CESHI', 'CESHI', 'test4@qq.com', '$2a$10$6mOCLPTtCcDyD0jNQw5/FOn/GfAsvIWxn3Ya22lI/YqGYp1/7sgCG', '13111111111', 1, 2, NULL);

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
