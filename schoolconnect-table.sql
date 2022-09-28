-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- 主机： 172.17.0.1
-- 生成日期： 2022-09-28 13:18:34
-- 服务器版本： 8.0.30
-- PHP 版本： 8.0.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `schoolconnect`
--

-- --------------------------------------------------------

--
-- 表的结构 `class`
--

CREATE TABLE `class` (
  `clno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '班级编号',
  `clname` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '班级名称',
  `dno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '班级编号',
  `tno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '班主任编号',
  `ino` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '辅导员编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='班级表';

-- --------------------------------------------------------

--
-- 表的结构 `course`
--

CREATE TABLE `course` (
  `courseno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '课程编号',
  `coursename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '课程名称',
  `courseduration` tinyint DEFAULT NULL COMMENT '课程时长',
  `coursetype` tinyint DEFAULT NULL COMMENT '课程类型',
  `coursedesc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程描述',
  `courseplace` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程地点',
  `coursestatus` tinyint DEFAULT NULL COMMENT '课程状态 0正常，1:结束',
  `courseteacher` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程教师',
  `coursecredits` float DEFAULT NULL COMMENT '课程学分'
) ;

-- --------------------------------------------------------

--
-- 表的结构 `department`
--

CREATE TABLE `department` (
  `dno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '部门编号',
  `dname` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '部门名称',
  `dmanagerno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '部门负责人编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='部门表';

-- --------------------------------------------------------

--
-- 表的结构 `employee`
--

CREATE TABLE `employee` (
  `employeeid` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '人员编号',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '姓名',
  `clno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所在班级编号',
  `sex` tinyint DEFAULT NULL COMMENT '性别 0:m 1:f 2:o 3:secret',
  `residenceid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证号',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址',
  `secondcontact` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '第二联系方式',
  `role` tinyint DEFAULT '5' COMMENT '用户身份 0:超级 1:教职工/管理层 2:教师 3:学生 4:其他',
  `status` tinyint DEFAULT '4' COMMENT '用户状态 0:在校 1:离校 2开除 3:注销 4:其他',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间'
) ;

--
-- 转存表中的数据 `employee`
--

INSERT INTO `employee` (`employeeid`, `name`, `clno`, `sex`, `residenceid`, `email`, `phone`, `address`, `secondcontact`, `role`, `status`, `createtime`) VALUES
('2200004001', '张三', NULL, 0, '320503200000012028', 'hello@example.com', '13813838438', '江苏省苏州市姑苏区平江路1号', '3444444332', 1, 1, '2022-09-28 13:07:36');

-- --------------------------------------------------------

--
-- 表的结构 `grade`
--

CREATE TABLE `grade` (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'generated id',
  `userno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学生编号',
  `grade` float DEFAULT NULL COMMENT '成绩',
  `courseno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程编号'
) ;

-- --------------------------------------------------------

--
-- 表的结构 `sysuser`
--

CREATE TABLE `sysuser` (
  `id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'GENERATED ID',
  `realname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '真实姓名',
  `nickname` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `role` tinyint NOT NULL,
  `status` tinyint NOT NULL,
  `createtime` datetime DEFAULT NULL,
  `lastlogintime` datetime DEFAULT NULL,
  `lastloginip` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `lastloginlocation` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ;

--
-- 转储表的索引
--

--
-- 表的索引 `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`clno`),
  ADD UNIQUE KEY `clno` (`clno`),
  ADD KEY `dno` (`dno`),
  ADD KEY `ino` (`ino`),
  ADD KEY `tno` (`tno`);

--
-- 表的索引 `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`courseno`),
  ADD UNIQUE KEY `courseno` (`courseno`),
  ADD KEY `courseteacher` (`courseteacher`);

--
-- 表的索引 `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`dno`),
  ADD UNIQUE KEY `dno` (`dno`),
  ADD KEY `dmanagerno` (`dmanagerno`);

--
-- 表的索引 `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employeeid`),
  ADD UNIQUE KEY `employeeid` (`employeeid`),
  ADD UNIQUE KEY `residenceid` (`residenceid`),
  ADD KEY `name` (`name`);

--
-- 表的索引 `grade`
--
ALTER TABLE `grade`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `userno` (`userno`),
  ADD KEY `courseno` (`courseno`);

--
-- 表的索引 `sysuser`
--
ALTER TABLE `sysuser`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `realname` (`realname`);

--
-- 限制导出的表
--

--
-- 限制表 `class`
--
ALTER TABLE `class`
  ADD CONSTRAINT `class_ibfk_1` FOREIGN KEY (`dno`) REFERENCES `department` (`dno`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `class_ibfk_2` FOREIGN KEY (`ino`) REFERENCES `employee` (`employeeid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `class_ibfk_3` FOREIGN KEY (`tno`) REFERENCES `employee` (`employeeid`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- 限制表 `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `course_ibfk_1` FOREIGN KEY (`courseteacher`) REFERENCES `employee` (`employeeid`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- 限制表 `department`
--
ALTER TABLE `department`
  ADD CONSTRAINT `department_ibfk_1` FOREIGN KEY (`dmanagerno`) REFERENCES `employee` (`employeeid`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- 限制表 `grade`
--
ALTER TABLE `grade`
  ADD CONSTRAINT `grade_ibfk_1` FOREIGN KEY (`userno`) REFERENCES `employee` (`employeeid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `grade_ibfk_2` FOREIGN KEY (`courseno`) REFERENCES `course` (`courseno`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- 限制表 `sysuser`
--
ALTER TABLE `sysuser`
  ADD CONSTRAINT `sysuser_ibfk_1` FOREIGN KEY (`realname`) REFERENCES `employee` (`name`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
