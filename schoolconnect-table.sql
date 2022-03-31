-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 172.17.0.1
-- Generation Time: Mar 31, 2022 at 02:02 PM
-- Server version: 8.0.28
-- PHP Version: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `schoolconnect`
--

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `clno` int NOT NULL COMMENT '班级编号',
  `clname` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '班级名称',
  `dno` int DEFAULT NULL COMMENT '班级编号',
  `tname` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '当前班主任',
  `tno` int DEFAULT NULL COMMENT '班主任编号',
  `iname` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '辅导员姓名',
  `ino` int DEFAULT NULL COMMENT '辅导员编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='班级表';

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `courseno` int NOT NULL COMMENT '课程编号',
  `coursename` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '课程名称',
  `courseduration` tinyint DEFAULT NULL COMMENT '课程时长',
  `coursetype` tinyint DEFAULT NULL COMMENT '课程类型',
  `coursedesc` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程描述',
  `courseplace` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程地点',
  `coursestatus` tinyint check(coursestatus in ('0','1')) DEFAULT NULL COMMENT '课程状态 0正常，1:结束',
  `courseteacher` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程教师',
  `coursecredits` float check(coursecredits > 0) DEFAULT NULL COMMENT '课程学分'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='课程表';

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `dno` int NOT NULL COMMENT '部门编号',
  `dname` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '部门名称',
  `dmanagerno` int DEFAULT NULL COMMENT '部门负责人编号',
  `dmanagername` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '部门负责人姓名'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='部门表';

-- --------------------------------------------------------

--
-- Table structure for table `grade`
--

CREATE TABLE `grade` (
  `id` varchar(64) NOT NULL COMMENT 'generated id',
  `userno` int NOT NULL COMMENT '学生编号',
  `grade` float check(grade>0 and grade<200) DEFAULT NULL COMMENT '成绩',
  `courseno` int DEFAULT NULL COMMENT '课程编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='课程数据';

-- --------------------------------------------------------

--
-- Table structure for table `sysuser`
--

CREATE TABLE `sysuser` (
  `id` varchar(64) NOT NULL COMMENT 'GENERATED ID',
  `realname` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '真实姓名\n',
  `nickname` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `role` tinyint check(role in ('0','1','2','3','4')) NOT NULL,
  `status` tinyint check(status in ('0','1','2','3','4')) NOT NULL,
  `createtime` datetime DEFAULT NULL,
  `lastlogintime` datetime DEFAULT NULL,
  `lastloginip` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `lastloginlocation` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` varchar(64) NOT NULL COMMENT 'GENERATED ID',
  `userno` int NOT NULL COMMENT '人员编号',
  `clno` int NOT NULL COMMENT '所在班级编号',
  `sex` tinyint check(sex in ('0','1','2','3')) DEFAULT NULL COMMENT '性别 0:m 1:f 2:o 3:secret',
  `idnumber` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证号',
  `realname` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '真实姓名',
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机',
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址',
  `qq` varchar(24) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `role` tinyint check(role in ('0','1','2','3','4')) DEFAULT '4' COMMENT '用户身份 0:超级 1:教师/教职工 2:学生 3：家长 4:其他',
  `status` tinyint check(status in ('0','1','2','3','4')) DEFAULT '0' COMMENT '用户状态 0:在校 1:离校 2开除 3:注销 4:其他',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='信息';

--
-- Indexes for dumped tables
--

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`clno`),
  ADD UNIQUE KEY `class_clno_uindex` (`clno`),
  ADD KEY `class_department_dno_fk` (`dno`),
  ADD KEY `class_user_userno_realname_fk` (`tno`,`tname`),
  ADD KEY `class_user_userno_realname_fk_2` (`ino`,`iname`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`courseno`),
  ADD UNIQUE KEY `course_coursename_uindex` (`coursename`),
  ADD UNIQUE KEY `course_courseno_uindex` (`courseno`),
  ADD KEY `course_user_realname_fk` (`courseteacher`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`dno`),
  ADD UNIQUE KEY `department_dname_uindex` (`dname`),
  ADD UNIQUE KEY `department_dno_uindex` (`dno`),
  ADD KEY `department_user_realname_fk` (`dmanagername`),
  ADD KEY `department_user_userno_realname_fk` (`dmanagerno`,`dmanagername`);

--
-- Indexes for table `grade`
--
ALTER TABLE `grade`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `coursedata_id_uindex` (`id`),
  ADD KEY `coursedata_course_courseno_fk` (`courseno`),
  ADD KEY `grade_user_userno_fk` (`userno`);

--
-- Indexes for table `sysuser`
--
ALTER TABLE `sysuser`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `sysuser_username_uindex` (`username`),
  ADD UNIQUE KEY `sysuser_id_uindex` (`id`),
  ADD KEY `sysuser_user_realname_fk` (`realname`),
  ADD KEY `sysuser_user_email_fk` (`email`),
  ADD KEY `sysuser_user_phone_fk` (`phone`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `user_id_uindex` (`id`),
  ADD KEY `user_class_clno_fk` (`clno`),
  ADD KEY `user_realname_index` (`realname`),
  ADD KEY `user_userno_index` (`userno`),
  ADD KEY `user_userno_realname_index` (`userno`,`realname`),
  ADD KEY `user_email_index` (`email`),
  ADD KEY `user_phone_index` (`phone`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `class`
--
ALTER TABLE `class`
  ADD CONSTRAINT `class_department_dno_fk` FOREIGN KEY (`dno`) REFERENCES `department` (`dno`),
  ADD CONSTRAINT `class_user_userno_realname_fk` FOREIGN KEY (`tno`,`tname`) REFERENCES `user` (`userno`, `realname`),
  ADD CONSTRAINT `class_user_userno_realname_fk_2` FOREIGN KEY (`ino`,`iname`) REFERENCES `user` (`userno`, `realname`);

--
-- Constraints for table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `course_user_realname_fk` FOREIGN KEY (`courseteacher`) REFERENCES `user` (`realname`);

--
-- Constraints for table `department`
--
ALTER TABLE `department`
  ADD CONSTRAINT `department_user_userno_realname_fk` FOREIGN KEY (`dmanagerno`,`dmanagername`) REFERENCES `user` (`userno`, `realname`);

--
-- Constraints for table `grade`
--
ALTER TABLE `grade`
  ADD CONSTRAINT `coursedata_course_courseno_fk` FOREIGN KEY (`courseno`) REFERENCES `course` (`courseno`),
  ADD CONSTRAINT `grade_user_userno_fk` FOREIGN KEY (`userno`) REFERENCES `user` (`userno`);

--
-- Constraints for table `sysuser`
--
ALTER TABLE `sysuser`
  ADD CONSTRAINT `sysuser_user_email_fk` FOREIGN KEY (`email`) REFERENCES `user` (`email`),
  ADD CONSTRAINT `sysuser_user_id_fk` FOREIGN KEY (`id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `sysuser_user_phone_fk` FOREIGN KEY (`phone`) REFERENCES `user` (`phone`),
  ADD CONSTRAINT `sysuser_user_realname_fk` FOREIGN KEY (`realname`) REFERENCES `user` (`realname`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_class_clno_fk` FOREIGN KEY (`clno`) REFERENCES `class` (`clno`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
