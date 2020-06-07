/*
Navicat MySQL Data Transfer

Source Server         : 公用Mysql
Source Server Version : 50718
Source Host           : bj-cynosdbmysql-grp-0tg87biu.sql.tencentcdb.com:28838
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2020-06-07 20:52:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for class_info
-- ----------------------------
DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info` (
  `cla_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级id',
  `cla_name` varchar(15) NOT NULL COMMENT '班级姓名',
  `cla_project` varchar(15) NOT NULL COMMENT '班级学科',
  `cla_teacid` varchar(64) NOT NULL COMMENT '教师id',
  PRIMARY KEY (`cla_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for jianda_analysis
-- ----------------------------
DROP TABLE IF EXISTS `jianda_analysis`;
CREATE TABLE `jianda_analysis` (
  `id` int(11) NOT NULL COMMENT '题目id',
  `ti_id` int(11) NOT NULL COMMENT '对应题的id',
  `correct_rate` varchar(15) NOT NULL COMMENT '正确率分析',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for ku_jianda
-- ----------------------------
DROP TABLE IF EXISTS `ku_jianda`;
CREATE TABLE `ku_jianda` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '题目id',
  `test_title` varchar(255) DEFAULT NULL COMMENT '试卷标题',
  `project` varchar(15) NOT NULL COMMENT '学科类别',
  `test_id` varchar(64) NOT NULL COMMENT '记录试卷id',
  `topic` varchar(255) NOT NULL COMMENT '题目描述',
  `answer` varchar(255) NOT NULL COMMENT '答案详解',
  `difficult` varchar(10) NOT NULL COMMENT '难易程度',
  `fraction` double DEFAULT NULL COMMENT '题目分数',
  `person` int(11) DEFAULT NULL COMMENT '提交人数',
  `rig` int(10) DEFAULT NULL COMMENT '正确人数',
  PRIMARY KEY (`id`),
  KEY `test_id` (`test_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for ku_xuanze
-- ----------------------------
DROP TABLE IF EXISTS `ku_xuanze`;
CREATE TABLE `ku_xuanze` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '题目id',
  `test_id` varchar(64) NOT NULL COMMENT '记录来源的试卷id',
  `test_title` varchar(255) DEFAULT NULL COMMENT '试卷标题',
  `project` varchar(15) NOT NULL COMMENT '学科类别',
  `types` int(10) NOT NULL COMMENT '选择类型：1为单选  2为多选',
  `topic` varchar(255) NOT NULL COMMENT '题目',
  `A` varchar(255) NOT NULL COMMENT '选项A',
  `B` varchar(255) NOT NULL COMMENT '选项B',
  `C` varchar(255) NOT NULL COMMENT '选项C',
  `D` varchar(255) NOT NULL COMMENT '选项D',
  `answer` varchar(10) NOT NULL COMMENT '答案',
  `parsing` varchar(255) DEFAULT NULL COMMENT '题目解析',
  `difficult` varchar(10) NOT NULL COMMENT '难易程度',
  `fraction` double NOT NULL COMMENT '题目分数',
  `person` int(11) DEFAULT NULL COMMENT '提交人数',
  `rig` int(10) DEFAULT NULL COMMENT '正确人数',
  PRIMARY KEY (`id`),
  KEY `test_id` (`test_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for stu_errti
-- ----------------------------
DROP TABLE IF EXISTS `stu_errti`;
CREATE TABLE `stu_errti` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` varchar(64) NOT NULL COMMENT '记录学生id',
  `type` int(11) NOT NULL COMMENT '题目类型：1单选 2多选 3简答',
  `ti_id` int(11) NOT NULL COMMENT '对应题目id',
  `err_answer` varchar(255) DEFAULT NULL COMMENT '错误答案',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stu_id` varchar(64) NOT NULL COMMENT '学生id',
  `name` varchar(32) NOT NULL COMMENT '姓名',
  `user` varchar(255) NOT NULL COMMENT '用户名',
  `pwd` varchar(64) NOT NULL COMMENT '登录密码',
  `phone` varchar(15) DEFAULT NULL COMMENT '注册手机号',
  `cla_name` varchar(15) DEFAULT NULL COMMENT '所属班级',
  `sex` int(11) DEFAULT NULL COMMENT '性别（0女  1 男）',
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teac_id` varchar(64) NOT NULL COMMENT '教师ID（UUID生成）',
  `teac_name` varchar(64) NOT NULL COMMENT '姓名',
  `user` varchar(255) NOT NULL COMMENT '用户名',
  `user_phone` varchar(15) NOT NULL COMMENT '注册手机号',
  `teac_pwd` varchar(64) NOT NULL COMMENT '密码',
  `sex` int(11) DEFAULT NULL COMMENT '性别（0女  1男）',
  PRIMARY KEY (`teac_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for test_paper
-- ----------------------------
DROP TABLE IF EXISTS `test_paper`;
CREATE TABLE `test_paper` (
  `test_id` varchar(64) NOT NULL COMMENT '试卷id',
  `test_title` varchar(255) DEFAULT NULL COMMENT '试卷标题',
  `test_project` varchar(15) NOT NULL COMMENT '试卷科目',
  `date` varchar(64) NOT NULL COMMENT '试卷起始截止时间',
  `teacher_id` varchar(64) NOT NULL COMMENT '出题教师id',
  `cla_name` varchar(15) NOT NULL COMMENT '发放班级',
  `isRelease` int(10) NOT NULL COMMENT '试卷是否发布(0：未发布   1：发布)',
  `difficult` varchar(15) DEFAULT NULL COMMENT '试卷难易程度',
  PRIMARY KEY (`test_id`),
  KEY `test_id` (`test_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for test_student
-- ----------------------------
DROP TABLE IF EXISTS `test_student`;
CREATE TABLE `test_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` varchar(64) NOT NULL COMMENT '学生id',
  `test_id` varchar(64) NOT NULL COMMENT '对应测试试卷id',
  `project` varchar(15) NOT NULL COMMENT '考试科目',
  `fraction` double NOT NULL COMMENT '试卷分数',
  `rank` int(11) DEFAULT NULL COMMENT '测试排名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for tiku
-- ----------------------------
DROP TABLE IF EXISTS `tiku`;
CREATE TABLE `tiku` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '题目序列号',
  `project` varchar(15) NOT NULL COMMENT '学科类别',
  `type` int(10) NOT NULL COMMENT '题目类型：1单选  2多选  3简单',
  `topic` varchar(255) NOT NULL COMMENT '题目描述',
  `A` varchar(255) DEFAULT NULL COMMENT 'A选项（选择题）',
  `B` varchar(255) DEFAULT NULL COMMENT '选项B',
  `C` varchar(255) DEFAULT NULL COMMENT '选项C',
  `D` varchar(255) DEFAULT NULL COMMENT '选项D',
  `answer` varchar(255) NOT NULL COMMENT '答案',
  `parsing` varchar(255) NOT NULL COMMENT '题目解析',
  `difficult` varchar(10) NOT NULL COMMENT '难易程度',
  `fraction` double DEFAULT NULL COMMENT '分数',
  `rig` varchar(10) DEFAULT NULL COMMENT '正确率',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for xuanze_analysis
-- ----------------------------
DROP TABLE IF EXISTS `xuanze_analysis`;
CREATE TABLE `xuanze_analysis` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ti_id` int(11) NOT NULL COMMENT '对应题的id',
  `correct_rate` varchar(15) NOT NULL COMMENT '正确率',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4;
