/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : mytest

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 09/07/2020 09:38:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `cla_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级id',
  `cla_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '班级姓名',
  `cla_teacher` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '班主任老师',
  `cla_student` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '班级所属学生',
  PRIMARY KEY (`cla_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------

-- ----------------------------
-- Table structure for error_analysis
-- ----------------------------
DROP TABLE IF EXISTS `error_analysis`;
CREATE TABLE `error_analysis`  (
  `ti_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '对应题的id',
  `project` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '科目类别',
  `test_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '记录试卷id',
  `topic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '题目描述',
  `A` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '如果为选择，给出选项（不为非空）',
  `B` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `C` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `D` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `answer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '答案',
  `parsing` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '题目解析',
  `correct_rate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '正确率',
  `difficult` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '难易程度',
  PRIMARY KEY (`ti_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of error_analysis
-- ----------------------------

-- ----------------------------
-- Table structure for ku_jianda
-- ----------------------------
DROP TABLE IF EXISTS `ku_jianda`;
CREATE TABLE `ku_jianda`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '题目id',
  `project` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学科类别',
  `test_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '记录试卷id',
  `topic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '题目描述',
  `answer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '答案详解',
  `difficult` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '难易程度',
  `fraction` double NULL DEFAULT NULL COMMENT '题目分数',
  `person` int(11) NULL DEFAULT NULL COMMENT '提交人数',
  `rig` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '正确人数',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `test_id`(`test_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ku_jianda
-- ----------------------------

-- ----------------------------
-- Table structure for ku_xuanze
-- ----------------------------
DROP TABLE IF EXISTS `ku_xuanze`;
CREATE TABLE `ku_xuanze`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '题目id',
  `test_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '记录来源的试卷id',
  `project` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学科类别',
  `types` int(10) NOT NULL COMMENT '选择类型：1为单选  2为多选',
  `topic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '题目',
  `A` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '选项A',
  `B` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '选项B',
  `C` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '选项C',
  `D` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '选项D',
  `answer` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '答案',
  `parsing` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '题目解析',
  `difficult` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '难易程度',
  `fraction` double NOT NULL COMMENT '题目分数',
  `person` int(11) NULL DEFAULT NULL COMMENT '提交人数',
  `rig` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '正确人数',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `test_id`(`test_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ku_xuanze
-- ----------------------------
INSERT INTO `ku_xuanze` VALUES (50, '08d90302-1204-4801-ae67-337231320ef2', '数据结构', 1, '从数组开始吧', '0', '1', '2', '3', 'A', '数组最简单，但是你会吗？', '易', 5, 3, '3');
INSERT INTO `ku_xuanze` VALUES (51, '08d90302-1204-4801-ae67-337231320ef2', '数据结构', 2, '链表接着', '4', '5', '6', '7', 'ACD', '链表简单吧，但是你真的会吗', '易', 20, 1, '1');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stu_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `pwd` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录密码',
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '注册手机号',
  `cla_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所属班级',
  `sex` int(11) NULL DEFAULT NULL COMMENT '性别（0女  1 男）',
  PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('103f056a-fe7d-44e8-9700-0b77394cacc3', 'zhao', '201810', '670b14728ad9902aecba32e22fa4f6bd', '99999999999', '软1', NULL);
INSERT INTO `student` VALUES ('30019b86-c2f4-4b15-9a69-e49d03a2f7d0', 'student', '201811', 'e10adc3949ba59abbe56e057f20f883e', '18233000670', '软工3班', NULL);
INSERT INTO `student` VALUES ('e12d1c8c-86de-4ba3-940e-26d549c1f2c2', '张三', '201812', 'e10adc3949ba59abbe56e057f20f883e', '13315263817', '软工3班', NULL);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teac_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '教师ID（UUID生成）',
  `teac_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `user_phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '注册手机号',
  `teac_pwd` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `sex` int(11) NULL DEFAULT NULL COMMENT '性别（0女  1男）',
  PRIMARY KEY (`teac_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('7253a26b-7996-4898-82b3-3ca8d11f2844', '不详', '1302', '', 'c33367701511b4f6020ec61ded352059', NULL);
INSERT INTO `teacher` VALUES ('b6a0daf6-7bc0-4985-8634-0c2b430ab4a8', '西瓜哥哥', '1111', '', '96e79218965eb72c92a549dd5a330112', NULL);
INSERT INTO `teacher` VALUES ('f3172fd1-c240-40db-a7fb-4702c05e8b3e', 'teacher', '1103', '', 'e10adc3949ba59abbe56e057f20f883e', NULL);

-- ----------------------------
-- Table structure for test_paper
-- ----------------------------
DROP TABLE IF EXISTS `test_paper`;
CREATE TABLE `test_paper`  (
  `test_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '试卷id',
  `test_project` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '试卷科目',
  `date` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '试卷起始截止时间',
  `teacher_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '出题教师id',
  `cla_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '发放班级',
  `isRelease` int(10) NOT NULL COMMENT '试卷是否发布(0：未发布   1：发布)',
  `difficult` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '试卷难易程度',
  PRIMARY KEY (`test_id`) USING BTREE,
  INDEX `test_id`(`test_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_paper
-- ----------------------------
INSERT INTO `test_paper` VALUES ('08d90302-1204-4801-ae67-337231320ef2', '数据结构', '2020-06-01 00:00:00 - 2020-06-10 00:00:00', 'f3172fd1-c240-40db-a7fb-4702c05e8b3e', '软工3班', 1, '易');

-- ----------------------------
-- Table structure for test_student
-- ----------------------------
DROP TABLE IF EXISTS `test_student`;
CREATE TABLE `test_student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生id',
  `test_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '对应测试试卷id',
  `project` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '考试科目',
  `fraction` double NOT NULL COMMENT '试卷分数',
  `rank` int(11) NULL DEFAULT NULL COMMENT '测试排名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_student
-- ----------------------------
INSERT INTO `test_student` VALUES (7, '30019b86-c2f4-4b15-9a69-e49d03a2f7d0', '08d90302-1204-4801-ae67-337231320ef2', '数据结构', 25.000000000000004, NULL);
INSERT INTO `test_student` VALUES (10, 'e12d1c8c-86de-4ba3-940e-26d549c1f2c2', '08d90302-1204-4801-ae67-337231320ef2', '数据结构', 5, NULL);

-- ----------------------------
-- Table structure for tiku
-- ----------------------------
DROP TABLE IF EXISTS `tiku`;
CREATE TABLE `tiku`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '题目序列号',
  `project` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学科类别',
  `type` int(10) NOT NULL COMMENT '题目类型：1单选  2多选  3简单',
  `topic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '题目描述',
  `A` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'A选项（选择题）',
  `B` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '选项B',
  `C` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '选项C',
  `D` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '选项D',
  `answer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '答案',
  `parsing` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '题目解析',
  `difficult` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '难易程度',
  `fraction` double NULL DEFAULT NULL,
  `rig` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '正确率',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tiku
-- ----------------------------
INSERT INTO `tiku` VALUES (1, '数据结构', 1, 'gogo', '1', '2', '3', '4', 'A', 'test', '易', 5, '25%');
INSERT INTO `tiku` VALUES (2, '数据结构', 1, 'oto', '-1', '0', '1', '2', 'B', 'test', '中等', 20, '13%');
INSERT INTO `tiku` VALUES (3, '数据结构', 1, 'toto', '2', '3', '4', '5', 'C', 'test', '难', 30, '5%');
INSERT INTO `tiku` VALUES (4, '数据结构', 2, 'ffu', 'a', 'b', 'c', 'd', 'ACD', 'test', '中等', 25, '15%');
INSERT INTO `tiku` VALUES (5, '数据结构', 2, 'est', 'zx', 'zr', 'zt', 'zv', 'BC', 'only', '难', 30, '12%');
INSERT INTO `tiku` VALUES (6, '数据结构', 3, 'easy', '', '', '', '', 'byte', '暂无', '易', 40, '50%');
INSERT INTO `tiku` VALUES (7, '计算机组成原理', 1, 'break', '1', '2', '3', '4', 'B', '结束循环', '易', 5, '99%');
INSERT INTO `tiku` VALUES (8, '计算机组成原理', 2, 'continue', '0', '1', '5', '9', 'AD', '继续', '易', 5, '95%');
INSERT INTO `tiku` VALUES (9, '计算机组成原理', 3, 'for', '', '', '', '', 'int i = 0', '来吧', '易', 10, '100%');

SET FOREIGN_KEY_CHECKS = 1;
