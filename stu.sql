/*
Navicat MySQL Data Transfer

Source Server         : MariaDB
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : stu

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-05-05 17:55:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` varchar(60) NOT NULL,
  `book_name` varchar(50) DEFAULT NULL,
  `borrow_time` date DEFAULT NULL,
  `return_time` date DEFAULT NULL,
  `expiration_time` int(11) DEFAULT NULL,
  `expiration` varchar(5) DEFAULT NULL,
  `book_sid` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`book_id`),
  KEY `book_sid` (`book_sid`),
  CONSTRAINT `book_sid` FOREIGN KEY (`book_sid`) REFERENCES `student` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of book
-- ----------------------------

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
INSERT INTO `info` VALUES ('372b10ceb16c41a3a52dd39c91d0b1d4', '哈哈', '<p>哈哈怎么样。</p>\n', '2018-04-27', '主动公开', '201407040324');
INSERT INTO `info` VALUES ('37e6d680efde4383882f93aecfa9e837', '工作111', '<p>工作怎么样。</p>\n', '2018-04-03', '主动公开', '201407040324');
INSERT INTO `info` VALUES ('42c9d8a723904359a1a163c214ef4e7a', '/info/to/info发布标题', '<pre>\n/info/to/info发布标题</pre>\n\n<pre>\n/info/to/info发布标题</pre>\n\n<pre>\n/info/to/info发布标题7654546d5fdsf</pre>\n', '2018-04-28', '主动公开', '201407040324');
INSERT INTO `info` VALUES ('4c7ea59c6ccc4174a99abb91d34847ce', 'dsad', '<p>sdadsadsd</p>\n', '2018-04-28', '主动公开', '201407040324');
INSERT INTO `info` VALUES ('5e780d85b5594a2e9e731e148b5ef8a2', 'layui官网', '<pre>\n<code>/*\n * ======================================================================\n * See javadoc API for class org.thymeleaf.expression.Dates\n * ======================================================================\n */\n\n/*\n * Format date with the standard locale format\n * Also works with arrays, lists or sets\n */\n${#dates.format(date)}\n${#dates.arrayFormat(datesArray)}\n${#dates.listFormat(datesList)}\n${#dates.setFormat(datesSet)}\n\n/*\n * Format date with the ISO8601 format\n * Also works with arrays, lists or sets\n */\n${#dates.formatISO(date)}\n${#dates.arrayFormatISO(datesArray)}\n${#dates.listFormatISO(datesList)}\n${#dates.setFormatISO(datesSet)}\n\n/*\n * Format date with the specified pattern\n * Also works with arrays, lists or sets\n */\n${#dates.format(date, &#39;dd/MMM/yyyy HH:mm&#39;)}\n${#dates.arrayFormat(datesArray, &#39;dd/MMM/yyyy HH:mm&#39;)}\n${#dates.listFormat(datesList, &#39;dd/MMM/yyyy HH:mm&#39;)}\n${#dates.setFormat(datesSet, &#39;dd/MMM/yyyy HH:mm&#39;)}\n\n/*\n * Obtain date properties\n * Also works with arrays, lists or sets\n */\n${#dates.day(date)}                    // also arrayDay(...), listDay(...), etc.\n${#dates.month(date)}                  // also arrayMonth(...), listMonth(...), etc.\n${#dates.monthName(date)}              // also arrayMonthName(...), listMonthName(...), etc.\n${#dates.monthNameShort(date)}         // also arrayMonthNameShort(...), listMonthNameShort(...), etc.\n${#dates.year(date)}                   // also arrayYear(...), listYear(...), etc.\n${#dates.dayOfWeek(date)}              // also arrayDayOfWeek(...), listDayOfWeek(...), etc.\n${#dates.dayOfWeekName(date)}          // also arrayDayOfWeekName(...), listDayOfWeekName(...), etc.\n${#dates.dayOfWeekNameShort(date)}     // also arrayDayOfWeekNameShort(...), listDayOfWeekNameShort(...), etc.\n${#dates.hour(date)}                   // also arrayHour(...), listHour(...), etc.\n${#dates.minute(date)}                 // also arrayMinute(...), listMinute(...), etc.\n${#dates.second(date)}                 // also arraySecond(...), listSecond(...), etc.\n${#dates.millisecond(date)}            // also arrayMillisecond(...), listMillisecond(...), etc.\n\n/*\n * Create date (java.util.Date) objects from its components\n */\n${#dates.create(year,month,day)}\n${#dates.create(year,month,day,hour,minute)}\n${#dates.create(year,month,day,hour,minute,second)}\n${#dates.create(year,month,day,hour,minute,second,millisecond)}\n\n/*\n * Create a date (java.util.Date) object for the current date and time\n */\n${#dates.createNow()}\n\n${#dates.createNowForTimeZone()}\n\n/*\n * Create a date (java.util.Date) object for the current date (time set to 00:00)\n */\n${#dates.createToday()}\n\n${#dates.createTodayForTimeZone()}</code></pre>\n', '2018-04-27', '主动公开', '201407040324');
INSERT INTO `info` VALUES ('6246bfe0c6ab41acb7a9f12aa258e309', '发布标题', '<p>发布标题发布标题发布标题的师傅的说法</p>\n', '2018-04-27', '主动公开', '201407040324');
INSERT INTO `info` VALUES ('d83a80cfa77a40dd93143d9c45576c9a', '学习', '<p>学习怎么样。佛挡杀佛六点十分</p>\n', '2018-04-27', '主动公开', '201407040324');
INSERT INTO `info` VALUES ('d83a80cfa77a40dd93143d9csd576c9a', '看电影', '<p>想玩。</p>\n', '2018-04-28', '主动公开', '201407040324');

-- ----------------------------
-- Table structure for mark
-- ----------------------------
DROP TABLE IF EXISTS `mark`;
CREATE TABLE `mark` (
  `subject_id` varchar(60) NOT NULL COMMENT '科目编号',
  `subject_name` varchar(30) DEFAULT NULL COMMENT '科目名称',
  `score` float(11,2) DEFAULT NULL COMMENT '成绩',
  `hang` varchar(5) DEFAULT NULL COMMENT '是否有挂科（1为挂科，0为未挂科）',
  `study` varchar(10) DEFAULT NULL COMMENT '是否初修？',
  `subject_type` varchar(10) DEFAULT NULL COMMENT '科目类别',
  `team` varchar(50) DEFAULT NULL COMMENT '学期',
  `credit` float(11,1) DEFAULT NULL COMMENT '学分',
  `gpa` float(11,1) DEFAULT NULL COMMENT '绩点',
  `stu_id` varchar(60) DEFAULT NULL COMMENT '学生的学号',
  PRIMARY KEY (`subject_id`),
  KEY `m_stu_id` (`stu_id`),
  CONSTRAINT `m_stu_id` FOREIGN KEY (`stu_id`) REFERENCES `student` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of mark
-- ----------------------------
INSERT INTO `mark` VALUES ('z020', 'os', '67.00', '否', '初修', '理科', '2014-2015 第二学期', '2.0', '1.7', '201407040322');
INSERT INTO `mark` VALUES ('z022', '组成原理', '80.00', '否', '初修', '理科', '2014-2015 第二学期', '3.0', '3.0', '201203020101');
INSERT INTO `mark` VALUES ('z023', '数学', '80.00', '是', '重修', '理科', '2014-2015 第二学期', '2.0', '3.0', '201203020101');
INSERT INTO `mark` VALUES ('z024', '政治', '50.00', '是', '重修', '理科', '2014-2015 第二学期', '4.5', '0.0', '201203020101');
INSERT INTO `mark` VALUES ('z025', '英语', '50.00', '是', '重修', '理科', '2014-2015 第二学期', '2.5', '0.0', '201203020102');
INSERT INTO `mark` VALUES ('z026', '语文', '80.00', '是', '重修', '理科', '2014-2015 第二学期', '1.0', '3.0', '201203020101');
INSERT INTO `mark` VALUES ('z027', 'java', '80.00', '否', '初修', '理科', '2014-2015 第二学期', '1.5', '3.0', '201203020102');
INSERT INTO `mark` VALUES ('z028', '数据结构', '60.00', '是', '重修', '理科', '2014-2015 第二学期', '5.0', '1.0', '201203020101');
INSERT INTO `mark` VALUES ('z029', 'os', '90.00', '否', '初修', '理科', '2014-2015 第二学期', '2.0', '4.0', '201203020101');

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
  `idCard` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `address` varchar(30) DEFAULT NULL COMMENT '家庭住址',
  `photo` varchar(120) DEFAULT NULL COMMENT '照片URL',
  `clazzId` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `clazzId` (`clazzId`),
  CONSTRAINT `clazzId` FOREIGN KEY (`clazzId`) REFERENCES `clazz` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('201202030102', '小昭', '女', '美国', '日本东港', '1983-12-31', '610222198401010112', '陕西省西安市', null, '102');
INSERT INTO `student` VALUES ('201203010203', '程云', '女', '美国', '洛杉矶', '2018-04-27', '210213199504120112', '美国洛杉矶', '/img/favicon.ico', '103');
INSERT INTO `student` VALUES ('201203020101', '赵小刚', '女', '美国', '陕西西安', '2018-04-22', '210222198401020112', '陕西省西安市', null, '102');
INSERT INTO `student` VALUES ('201203020102', '赵小刚', '女', '日本', '日本东港', '2008-04-26', '201000200804280105', '日本东港', null, '102');
INSERT INTO `student` VALUES ('201203020103', '侠岚小哥', '男', '请选择', '陕西西安', '2018-04-18', '610222198401020115', '陕西省西安市', '/img/favicon.ico', '101');
INSERT INTO `student` VALUES ('201203020108', '啛啛喳喳', '女', '中国', '陕西西安', '2018-04-20', '610222198401020126', '陕西洛阳', '/img/favicon.ico', '103');
INSERT INTO `student` VALUES ('201407040322', '侠岚', '男', '中国', '陕西西安', '2018-04-12', '610222199602120112', '陕西西安', '/img/favicon.ico', '103');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` varchar(60) NOT NULL COMMENT '用户id(如教师代码，学号，管理员id等)',
  `username` varchar(30) DEFAULT NULL COMMENT '用户姓名',
  `password` varchar(60) DEFAULT NULL COMMENT '用户密码',
  `userType` varchar(20) DEFAULT NULL COMMENT '登录的用户类型',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('201203050103', '陌名', 'zxc031209', '学生');
INSERT INTO `user` VALUES ('201302030102', '侠岚', '031205ssss', '教师');
INSERT INTO `user` VALUES ('201404070302', 'fdkds放大看电视', 'efkewhfkwe', '学生');
INSERT INTO `user` VALUES ('201404070325', 'xialan', 'dsd1d2s1ad', '管理员');
INSERT INTO `user` VALUES ('201404070365', '那你呢', '022aaada', '学生');
INSERT INTO `user` VALUES ('201407040324', '无极侠岚', '0wujixiala', '管理员');
INSERT INTO `user` VALUES ('201703020356', '辗迟', 'xialan11', '教师');
