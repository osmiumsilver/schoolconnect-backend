-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- 主机： 172.17.0.1
-- 生成日期： 2022-10-16 11:38:29
-- 服务器版本： 10.9.3-MariaDB-1:10.9.3+maria~ubu2204
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
  `class_no` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '班级编号',
  `class_name` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '班级名称',
  `department_no` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '班级编号',
  `teacher_no` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '班主任编号',
  `instructor_no` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '辅导员编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='班级表';

-- --------------------------------------------------------

--
-- 表的结构 `course`
--

CREATE TABLE `course` (
  `course_no` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '课程编号',
  `course_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '课程名称',
  `course_duration` tinyint(4) DEFAULT NULL COMMENT '课程时长',
  `course_type` tinyint(4) DEFAULT NULL COMMENT '课程类型',
  `course_desc` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程描述',
  `course_place` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程地点',
  `course_status` tinyint(4) DEFAULT NULL COMMENT '课程状态 0正常，1:结束',
  `course_teacher` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程教师学号',
  `course_credits` float DEFAULT NULL COMMENT '课程学分'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `department`
--

CREATE TABLE `department` (
  `department_no` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '部门编号',
  `department_name` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '部门名称',
  `department_manager_no` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '部门负责人编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='部门表';

-- --------------------------------------------------------

--
-- 表的结构 `employee`
--

CREATE TABLE `employee` (
  `employee_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '人员编号',
  `name` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '姓名',
  `class_no` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所在班级编号',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别 0:m 1:f 2:o 3:secret',
  `residence_id` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证号',
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机',
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址',
  `second_contact` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '第二联系方式',
  `role` tinyint(4) DEFAULT 5 COMMENT '用户身份 0:超级 1:教职工/管理层 2:教师 3:学生 4:其他',
  `status` tinyint(4) DEFAULT 4 COMMENT '用户状态 0:在校 1:离校 2开除 3:注销 4:其他',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `employee`
--

INSERT INTO `employee` (`employee_id`, `name`, `class_no`, `sex`, `residence_id`, `email`, `phone`, `address`, `second_contact`, `role`, `status`, `create_time`) VALUES
('2200004001', '张三', NULL, 0, '320503200000012028', 'hello@example.com', '13813838438', '江苏省苏州市姑苏区平江路1号', '3444444332', 1, 1, '2022-09-28 13:07:36');

-- --------------------------------------------------------

--
-- 表的结构 `grade`
--

CREATE TABLE `grade` (
  `id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'generated id',
  `userno` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学生编号',
  `grade` float DEFAULT NULL COMMENT '成绩',
  `course_no` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `sysuser`
--

CREATE TABLE `sysuser` (
  `id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'GENERATED ID',
  `realname` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '真实姓名',
  `nickname` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `role` tinyint(4) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `createtime` datetime DEFAULT NULL,
  `lastlogintime` datetime DEFAULT NULL,
  `lastloginip` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `lastloginlocation` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `avatar` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
