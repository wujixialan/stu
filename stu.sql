/*
Navicat MySQL Data Transfer

Source Server         : MariaDB
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : stu

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-05-27 16:45:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for clazz
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz` (
  `cid` varchar(60) NOT NULL COMMENT '班级编号',
  `clazzName` varchar(20) DEFAULT NULL COMMENT '班级名',
  `college` varchar(20) DEFAULT NULL COMMENT '学院',
  `profess` varchar(30) DEFAULT NULL COMMENT '专业',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of clazz
-- ----------------------------
INSERT INTO `clazz` VALUES ('101', '软件1403', '计算机学院', '软件工程');
INSERT INTO `clazz` VALUES ('102', '软件1402', '计算机学院', '软件工程');
INSERT INTO `clazz` VALUES ('103', '软件1401', '计算机学院', '软件工程');

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info` (
  `info_id` varchar(60) NOT NULL COMMENT '信息发布的id',
  `info_title` varchar(120) DEFAULT NULL COMMENT '信息标题',
  `info_content` text COMMENT '信息发布的内容',
  `info_time` date DEFAULT NULL COMMENT '信息发布的时间',
  `info_type` varchar(20) DEFAULT NULL,
  `info_user_id` varchar(60) DEFAULT NULL COMMENT '信息发布者的id',
  PRIMARY KEY (`info_id`),
  KEY `info_user_id` (`info_user_id`),
  CONSTRAINT `info_user_id` FOREIGN KEY (`info_user_id`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of info
-- ----------------------------

-- ----------------------------
-- Table structure for mark
-- ----------------------------
DROP TABLE IF EXISTS `mark`;
CREATE TABLE `mark` (
  `mark_id` varchar(60) NOT NULL,
  `subject_id` varchar(60) NOT NULL COMMENT '科目编号',
  `subject_name` varchar(30) DEFAULT NULL COMMENT '科目名称',
  `score` float(11,2) DEFAULT NULL COMMENT '成绩',
  `hang` varchar(5) DEFAULT NULL COMMENT '是否有挂科（1为挂科，0为未挂科）',
  `study` varchar(10) DEFAULT NULL COMMENT '是否初修？',
  `review_id` int(11) DEFAULT NULL,
  `subject_type` varchar(10) DEFAULT NULL COMMENT '科目类别',
  `team` varchar(50) DEFAULT NULL COMMENT '学期',
  `credit` float(11,1) DEFAULT NULL COMMENT '学分',
  `gpa` float(11,1) DEFAULT NULL COMMENT '绩点',
  `stu_id` varchar(60) DEFAULT NULL COMMENT '学生的学号',
  PRIMARY KEY (`mark_id`),
  KEY `m_stu_id` (`stu_id`),
  CONSTRAINT `m_stu_id` FOREIGN KEY (`stu_id`) REFERENCES `student` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of mark
-- ----------------------------
INSERT INTO `mark` VALUES ('1dd2257a65454372b495bbbf0e65ee4e', 'm05', '数据结构', '84.00', '是', '补考', '0', '计算机', '2014-2015 第二学期', '4.0', '3.4', '201405060102');
INSERT INTO `mark` VALUES ('1f1a01510e114a01b6f34ea302767644', 'm03', '数学', '65.00', '否', '初修', '0', '理科', '2014-2015 第二学期', '1.0', '1.5', '201405060101');
INSERT INTO `mark` VALUES ('222b984126154640b200df84521acaf5', 'm04', 'java', '80.00', '否', '初修', '0', '计算机', '2014-2015 第二学期', '3.0', '3.0', '201405060101');
INSERT INTO `mark` VALUES ('24a0e593466146059ac30ccee8e6c72a', 'm05', '数据结构', '44.00', '是', '初修', '0', '计算机', '2014-2015 第二学期', '4.0', '0.0', '201405060105');
INSERT INTO `mark` VALUES ('2ba99fe606cd436ebe1899b9501fed34', 'm01', '英语', '55.00', '是', '初修', '0', '文科', '2014-2015 第二学期', '2.0', '0.0', '201405060101');
INSERT INTO `mark` VALUES ('320128c67c0c436b8b7df62aa38ab883', 'm02', '语文', '60.00', '否', '初修', '0', '文科', '2014-2015 第二学期', '1.5', '1.0', '201405060105');
INSERT INTO `mark` VALUES ('42f8f61052e84c478a63ab1023ad58aa', 'm04', 'java', '72.00', '否', '初修', '0', '计算机', '2014-2015 第二学期', '3.0', '2.2', '201405060102');
INSERT INTO `mark` VALUES ('58d6f0fdd1744be099e9b5449fe5ba81', 'm02', '语文', '90.00', '否', '初修', '0', '文科', '2014-2015 第二学期', '1.5', '4.0', '201202030102');
INSERT INTO `mark` VALUES ('5a058bcaa9e74e9db9ae0f0dcb445428', 'm02', '语文', '65.00', '否', '初修', '0', '文科', '2014-2015 第二学期', '1.5', '1.5', '201405060102');
INSERT INTO `mark` VALUES ('5cdb9df7c7234f56b8b2352115c82dfa', 'm05', '数据结构', '69.00', '是', '补考', '0', '计算机', '2014-2015 第二学期', '4.0', '1.9', '201202030102');
INSERT INTO `mark` VALUES ('6184733c80104d649daf09df3698039d', 'm02', '语文', '70.00', '否', '初修', '0', '文科', '2014-2015 第二学期', '1.5', '2.0', '201405060101');
INSERT INTO `mark` VALUES ('69ffae7aecf84a69a5a9384738d7ef00', 'm03', '数学', '90.00', '是', '重修', '0', '理科', '2014-2015 第二学期', '1.0', '4.0', '201405060105');
INSERT INTO `mark` VALUES ('7dfb83b7da0845d39551e17fcdb25a92', 'm03', '数学', '45.00', '是', '初修', '0', '理科', '2014-2015 第二学期', '1.0', '0.0', '201202030102');
INSERT INTO `mark` VALUES ('83cf9c350dcd4e218f6630124a40c814', 'm05', '数据结构', '90.00', '否', '初修', '0', '计算机', '2014-2015 第二学期', '4.0', '4.0', '201405060101');
INSERT INTO `mark` VALUES ('9c51bab6a5ad4c989de4e97e2848c89a', 'm04', 'java', '56.00', '是', '初修', '0', '计算机', '2014-2015 第二学期', '3.0', '0.0', '201405060105');
INSERT INTO `mark` VALUES ('b5bb86f44678427ea8115ab24da6f07b', 'm01', '英语', '60.00', '否', '初修', '0', '文科', '2014-2015 第二学期', '2.0', '1.0', '201202030102');
INSERT INTO `mark` VALUES ('d1f83796f83940428e0ceb4dbda8ee34', 'm01', '英语', '84.00', '是', '重修', '0', '文科', '2014-2015 第二学期', '2.0', '3.4', '201405060102');
INSERT INTO `mark` VALUES ('d2c3552eda3c48548612ae0db129b859', 'm01', '英语', '75.00', '是', '补考', '0', '文科', '2014-2015 第二学期', '2.0', '2.5', '201405060105');
INSERT INTO `mark` VALUES ('d565fec79a644fbcac7e20a6865d4b8b', 'm03', '数学', '55.00', '是', '补考', '0', '理科', '2014-2015 第二学期', '1.0', '0.0', '201405060102');
INSERT INTO `mark` VALUES ('fd1a76855c6946cc8e0640f80f468563', 'm04', 'java', '55.00', '是', '补考', '0', '计算机', '2014-2015 第二学期', '3.0', '0.0', '201202030102');

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `review_id` varchar(60) NOT NULL COMMENT '申请id',
  `review_content` text COMMENT '申请内容',
  `mark_id` varchar(60) NOT NULL COMMENT '成绩id',
  `stu_id` varchar(60) NOT NULL COMMENT '学生学号',
  PRIMARY KEY (`review_id`),
  KEY `review_mark_id` (`mark_id`),
  KEY `review_stu_id` (`stu_id`),
  CONSTRAINT `review_mark_id` FOREIGN KEY (`mark_id`) REFERENCES `mark` (`mark_id`),
  CONSTRAINT `review_stu_id` FOREIGN KEY (`stu_id`) REFERENCES `student` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of review
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` varchar(60) NOT NULL COMMENT '学号',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `gender` varchar(3) DEFAULT NULL COMMENT '性别',
  `nation` varchar(20) DEFAULT NULL COMMENT '民族',
  `origin` varchar(20) DEFAULT NULL COMMENT '籍贯',
  `birth` date DEFAULT NULL COMMENT '出生年月',
  `idCard` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `address` varchar(30) DEFAULT NULL COMMENT '家庭住址',
  `photo` varchar(120) DEFAULT NULL COMMENT '照片URL',
  `review_id` int(11) DEFAULT NULL COMMENT '反馈标识',
  `review_content` varchar(255) DEFAULT NULL COMMENT '反馈内容',
  `clazzId` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `clazzId` (`clazzId`),
  CONSTRAINT `clazzId` FOREIGN KEY (`clazzId`) REFERENCES `clazz` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('201202030102', '费米', '女', '中国', '中国四川成都', '1992-06-25', '610121199206250231', '中国四川成都', null, '0', '学生未审核', '103');
INSERT INTO `student` VALUES ('201405060101', '小王', '女', '德国', '德国汉堡', '1990-03-15', '71012419900315020X', '德国汉堡', null, '0', '学生未审核', '102');
INSERT INTO `student` VALUES ('201405060102', '赵小名', '男', '美国', '美国洛杉矶', '1992-06-25', '21001019920625010x', '美国洛杉矶', null, '0', '学生未审核', '103');
INSERT INTO `student` VALUES ('201405060105', '陆运', '男', '德国', '德国汉堡', '1992-06-25', '710124199206250112', '德国汉堡', null, '0', '学生未审核', '102');
INSERT INTO `student` VALUES ('201505060102', '小明', '男', '美国', '美国纽约', '1990-04-02', '210012199004020123', '美国纽约', null, '0', '学生未审核', '102');
INSERT INTO `student` VALUES ('201505060103', '小浩', '男', '中国', '中国上海', '1985-02-02', '610125198502020101', '中国上海', null, '0', '学生未审核', '103');
INSERT INTO `student` VALUES ('201505060104', '小马', '女', '日本', '日本东京', '1986-01-02', '410132198601020103', '日本东京', null, '0', '学生未审核', '101');
INSERT INTO `student` VALUES ('201505060105', '小云', '男', '韩国', '韩国首尔', '1980-09-01', '510195198009010223', '韩国首尔', null, '0', '学生未审核', '103');
INSERT INTO `student` VALUES ('201505060108', '李铭', '女', '日本', '日本东京', '1991-03-02', '410132199103020206', '日本东京', null, '0', '学生未审核', '101');
INSERT INTO `student` VALUES ('201505060109', '赵云', '男', '美国', '美国纽约', '1996-12-02', '210012199612020130', '美国纽约', null, '0', '学生未审核', '101');
INSERT INTO `student` VALUES ('201505060110', '赵宇', '女', '中国', '中国北京', '1996-12-02', '610123199612020220', '中国北京', null, '0', '学生未审核', '103');
INSERT INTO `student` VALUES ('201505060111', '张佳', '女', '日本', '日本东京', '1992-06-25', '410132199206250204', '日本东京', null, '0', '学生未审核', '101');
INSERT INTO `student` VALUES ('201505060112', '赵雪', '男', '美国', '美国洛杉矶', '1996-12-02', '210010199612020106', '美国洛杉矶', null, '0', '学生未审核', '101');
INSERT INTO `student` VALUES ('201505060115', '卢娜', '女', '美国', '美国洛杉矶', '1996-12-02', '210010199612020235', '美国洛杉矶', null, '0', '学生未审核', '101');
INSERT INTO `student` VALUES ('201505060116', '小米', '女', '韩国', '韩国首尔', '1990-12-25', '51019519901225020X', '韩国首尔', null, '0', '学生未审核', '103');
INSERT INTO `student` VALUES ('201505060117', '小娜', '男', '中国', '中国陕西西安', '1990-04-02', '610222199004020103', '中国陕西西安', null, '0', '学生未审核', '102');
INSERT INTO `student` VALUES ('201505060118', '小鱼', '女', '中国', '中国浙江杭州', '1985-02-02', '610021198502020209', '中国浙江杭州', null, '0', '学生未审核', '101');
INSERT INTO `student` VALUES ('201505060119', '小雪', '男', '德国', '德国汉堡', '1986-01-02', '710124198601020107', '德国汉堡', null, '0', '学生未审核', '102');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` varchar(60) NOT NULL COMMENT '用户id(如教师代码，学号，管理员id等)',
  `username` varchar(30) DEFAULT NULL COMMENT '用户姓名',
  `password` varchar(60) DEFAULT NULL COMMENT '用户密码',
  `userType` varchar(20) DEFAULT NULL COMMENT '登录的用户类型',
  `stu_user_id` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `stu_user_id` (`stu_user_id`),
  CONSTRAINT `stu_user_id` FOREIGN KEY (`stu_user_id`) REFERENCES `student` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('020102', '程悦', 'e4e348cd96d068f8e6de856512ee6207', '教师', null);
INSERT INTO `user` VALUES ('030203', '侠岚', 'e4e348cd96d068f8e6de856512ee6207', '管理员', null);
INSERT INTO `user` VALUES ('201202030102', '费米', 'e4e348cd96d068f8e6de856512ee6207', '学生', null);
INSERT INTO `user` VALUES ('201405060101', '小王', 'e4e348cd96d068f8e6de856512ee6207', '学生', null);
INSERT INTO `user` VALUES ('201405060102', '赵小名', 'e4e348cd96d068f8e6de856512ee6207', '学生', null);
INSERT INTO `user` VALUES ('201405060105', '陆运', 'e4e348cd96d068f8e6de856512ee6207', '学生', null);
INSERT INTO `user` VALUES ('201505060102', '小明', 'e4e348cd96d068f8e6de856512ee6207', '学生', null);
INSERT INTO `user` VALUES ('201505060103', '小浩', 'e4e348cd96d068f8e6de856512ee6207', '学生', null);
INSERT INTO `user` VALUES ('201505060104', '小马', 'e4e348cd96d068f8e6de856512ee6207', '学生', null);
INSERT INTO `user` VALUES ('201505060105', '小云', 'e4e348cd96d068f8e6de856512ee6207', '学生', null);
INSERT INTO `user` VALUES ('201505060108', '李铭', 'e4e348cd96d068f8e6de856512ee6207', '学生', null);
INSERT INTO `user` VALUES ('201505060109', '赵云', 'e4e348cd96d068f8e6de856512ee6207', '学生', null);
INSERT INTO `user` VALUES ('201505060110', '赵宇', 'e4e348cd96d068f8e6de856512ee6207', '学生', null);
INSERT INTO `user` VALUES ('201505060111', '张佳', 'e4e348cd96d068f8e6de856512ee6207', '学生', null);
INSERT INTO `user` VALUES ('201505060112', '赵雪', 'e4e348cd96d068f8e6de856512ee6207', '学生', null);
INSERT INTO `user` VALUES ('201505060115', '卢娜', 'e4e348cd96d068f8e6de856512ee6207', '学生', null);
INSERT INTO `user` VALUES ('201505060116', '小米', 'e4e348cd96d068f8e6de856512ee6207', '学生', null);
INSERT INTO `user` VALUES ('201505060117', '小娜', 'e4e348cd96d068f8e6de856512ee6207', '学生', null);
INSERT INTO `user` VALUES ('201505060118', '小鱼', 'e4e348cd96d068f8e6de856512ee6207', '学生', null);
INSERT INTO `user` VALUES ('201505060119', '小雪', 'e4e348cd96d068f8e6de856512ee6207', '学生', null);
