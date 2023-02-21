-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 172.17.0.1
-- Generation Time: Feb 14, 2023 at 11:46 AM
-- Server version: 10.9.3-MariaDB-1:10.9.3+maria~ubu2204
-- PHP Version: 8.0.23

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
-- Table structure for table `t_class`
--

CREATE TABLE `t_class` (
  `class_no` varchar(7) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '班级编号  7位',
  `class_name` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '班级名称',
  `department_no` varchar(4) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所在部门编号 4位',
  `class_status` tinyint(1) NOT NULL COMMENT '班级状态 0默认 1毕业'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='班级表';

--
-- Dumping data for table `t_class`
--

INSERT INTO `t_class` (`class_no`, `class_name`, `department_no`, `class_status`) VALUES
('0111111', '毕业班', '0001', 1),
('1678041', '测试班级1', '0001', 0),
('1678042', '测试班级', '0001', 0);

-- --------------------------------------------------------

--
-- Table structure for table `t_class_manager_info`
--

CREATE TABLE `t_class_manager_info` (
  `class_no` varchar(7) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '班级编号',
  `employee_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '人员编号',
  `role` tinyint(1) NOT NULL COMMENT '0：班主任 1 辅导员',
  `status` tinyint(1) NOT NULL COMMENT '0 正常 1 结束'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='班级管理人员信息';

--
-- Dumping data for table `t_class_manager_info`
--

INSERT INTO `t_class_manager_info` (`class_no`, `employee_id`, `role`, `status`) VALUES
('0111111', '000000000004', 0, 0),
('0111111', '000000000004', 1, 0),
('1678041', '000000000002', 0, 0),
('1678041', '000000000004', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `t_class_schedule`
--

CREATE TABLE `t_class_schedule` (
  `user_id` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学生id',
  `course_id` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程id',
  `weeks` tinyint(1) DEFAULT NULL COMMENT '星期',
  `lessons` tinyint(1) DEFAULT NULL COMMENT '节次'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='课程表表';

--
-- Dumping data for table `t_class_schedule`
--

INSERT INTO `t_class_schedule` (`user_id`, `course_id`, `weeks`, `lessons`) VALUES
('2113504069', '9002602020', 1, 7),
('2113504069', '9002602021', 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `t_course`
--

CREATE TABLE `t_course` (
  `employee_id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `course_no` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='学生参与的课程表';

-- --------------------------------------------------------

--
-- Table structure for table `t_course_info`
--

CREATE TABLE `t_course_info` (
  `course_no` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '课程编号 10位',
  `course_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '课程名称',
  `course_name_en` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程英文名称',
  `course_duration` tinyint(4) DEFAULT NULL COMMENT '课程学时',
  `course_type` tinyint(4) DEFAULT NULL COMMENT '课程类型 0 必修课	1 校公共选修课	2 限选课	3 任选课	4 集中性实践	5 课外培养必选	6 课外培养任选	7 通识课程必修',
  `course_desc` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程描述',
  `course_place` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程地点',
  `course_status` tinyint(4) DEFAULT NULL COMMENT '课程状态 0正常，1:不再开课',
  `course_teacher` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程教师学号',
  `course_credits` float DEFAULT NULL COMMENT '课程学分',
  `course_textbook` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '教材用书 可以为url 或者文字',
  `course_outline` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '教材大纲'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='课程表';

--
-- Dumping data for table `t_course_info`
--

INSERT INTO `t_course_info` (`course_no`, `course_name`, `course_name_en`, `course_duration`, `course_type`, `course_desc`, `course_place`, `course_status`, `course_teacher`, `course_credits`, `course_textbook`, `course_outline`) VALUES
('9002602020', '中华诗词之美', 'Beauty of Chinese Poetry', 32, 0, '好', '教学楼1号', 0, '0000000000002', 2, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `t_department_info`
--

CREATE TABLE `t_department_info` (
  `department_no` varchar(4) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '部门编号',
  `department_name` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '部门名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='部门表';

--
-- Dumping data for table `t_department_info`
--

INSERT INTO `t_department_info` (`department_no`, `department_name`) VALUES
('0001', '计算机工程学院'),
('0002', '商学院');

-- --------------------------------------------------------

--
-- Table structure for table `t_department_manager_info`
--

CREATE TABLE `t_department_manager_info` (
  `department_no` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '部门编号',
  `manager_no` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '负责人编号',
  `status` tinyint(1) NOT NULL COMMENT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='部门负责人信息';

-- --------------------------------------------------------

--
-- Table structure for table `t_grade`
--

CREATE TABLE `t_grade` (
  `id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'generated id',
  `user_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学生编号',
  `course_no` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '课程编号',
  `grade` float DEFAULT NULL COMMENT '成绩',
  `semester` tinyint(6) DEFAULT NULL COMMENT '学年',
  `import_date` date DEFAULT NULL COMMENT '导入日期'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='成绩表';

--
-- Dumping data for table `t_grade`
--

INSERT INTO `t_grade` (`id`, `user_id`, `course_no`, `grade`, `semester`, `import_date`) VALUES
('da9ff370-7473-11ed-8b4b-000c29d0688e', '2113504069', '9002602020', 100, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `t_login`
--

CREATE TABLE `t_login` (
  `username` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='登录信息表';

--
-- Dumping data for table `t_login`
--

INSERT INTO `t_login` (`username`, `password`) VALUES
('000000000001', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('000000000002', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('000000000003', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('000000000004', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('000000000005', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('000000000006', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('2113504069', '$2a$10$4uJOmfARoJgFKZTL2rAlT.g70Bh2yGNY/33GXKh7jW1gyH.1BPoM6'),
('2200004001', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy');

-- --------------------------------------------------------

--
-- Table structure for table `t_openid`
--

CREATE TABLE `t_openid` (
  `openid` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '微信id',
  `user_id` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `t_openid`
--

INSERT INTO `t_openid` (`openid`, `user_id`) VALUES
('o0RXO4kWcWqZXruPk0h7iA2ktJmw', '2113504069');

-- --------------------------------------------------------

--
-- Table structure for table `t_school`
--

CREATE TABLE `t_school` (
  `school_id` int(5) UNSIGNED ZEROFILL NOT NULL COMMENT '学校ID',
  `school_name` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学校名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='学校表';

--
-- Dumping data for table `t_school`
--

INSERT INTO `t_school` (`school_id`, `school_name`) VALUES
(00000, 'RESERVED'),
(00001, '金陵科技学院');

-- --------------------------------------------------------

--
-- Table structure for table `t_user`
--

CREATE TABLE `t_user` (
  `employee_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '人员工号',
  `user_id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '生成唯一ID',
  `picture_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片url',
  `name` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '姓名',
  `class_no` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所在班级编号',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别 0:M 1:F 2:O',
  `residence_id` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证号',
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机',
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址',
  `second_contact` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '第二联系方式',
  `role` tinyint(4) NOT NULL DEFAULT 4 COMMENT '用户身份 0:超级 1:教职工/管理层 2:教师 3:学生 4:其他',
  `status` tinyint(4) NOT NULL DEFAULT 3 COMMENT '用户状态 0:在校 1:离校 2 开除 3:其他',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `school_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

--
-- Dumping data for table `t_user`
--

INSERT INTO `t_user` (`employee_id`, `user_id`, `picture_url`, `name`, `class_no`, `sex`, `residence_id`, `email`, `phone`, `address`, `second_contact`, `role`, `status`, `create_time`, `school_id`) VALUES
('000000000001', '5ecc867f3297c5e10898980f823490e6', NULL, '校长姚', NULL, 0, '32050319680212032X', 'dean@school.com', '13798765932', '江苏省苏州市姑苏区平江路1号', 'weicvivwvb', 1, 0, '2022-12-05 15:34:34', 1),
('000000000002', '62c8b9a03b55defae9f74ff18ee7a2ac', NULL, '老师李', NULL, 1, '32050119730814618X', 't@school.com', '18894691145', '江苏省苏州市姑苏区平江路1号', 'nfiaufvgff', 2, 0, '2022-12-05 15:36:09', 1),
('000000000003', '253c3a81f642bfe6fe0a5729a5514b0b', NULL, '超管', NULL, 0, '32528u502735023582', 'super@school.com', '312983461294', '江苏省苏州市姑苏区平江路1号', NULL, 0, 0, '2022-12-05 15:36:46', 1),
('000000000004', 'd162a354a4d7790466778afecdb2ce54', NULL, '辅导员林', NULL, 1, '320501194189471029', 'lin@school.com', '124it1i24yo', '江苏省苏州市姑苏区平江路1号', 'fhfuwebfwefwechat', 1, 0, '2022-12-06 20:21:37', 1),
('000000000005', '4d8e37166077fbe7ceaf48015cdc30e6', NULL, 'A老师', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 4, 3, NULL, 1),
('000000000006', '4aa4bf2f9a07d9f326bb9e856172aa5e', NULL, 'B老师', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 4, 3, NULL, 1),
('2113504069', 'b94b0711e9206aa82f0cc56c57c2364c', NULL, '姚博乾', '1678042', 0, '320503200000000000', 'osmium@hotmail.com', '13810000000', '江苏省苏州市姑苏区平江路1号', '12312312313123131', 3, 0, '2022-12-05 15:32:46', 1),
('2200004001', '3e3d5384a7507e305eff68ea64286be9', NULL, '张三', '1678042', 0, '320503200000012028', 'hello@example.com', '13813838438', '江苏省苏州市姑苏区平江路1号', '3444444332', 1, 1, '2022-09-28 13:07:36', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `t_class`
--
ALTER TABLE `t_class`
  ADD PRIMARY KEY (`class_no`);

--
-- Indexes for table `t_class_manager_info`
--
ALTER TABLE `t_class_manager_info`
  ADD UNIQUE KEY `t_class_manager_info_pk` (`class_no`,`employee_id`,`role`,`status`),
  ADD UNIQUE KEY `t_class_manager_info_pk2` (`class_no`,`employee_id`,`role`),
  ADD KEY `t_class_manager_info_t_employee_employee_id_fk` (`employee_id`);

--
-- Indexes for table `t_course`
--
ALTER TABLE `t_course`
  ADD UNIQUE KEY `t_course_pk` (`course_no`,`employee_id`),
  ADD UNIQUE KEY `employee_id` (`employee_id`,`course_no`);

--
-- Indexes for table `t_course_info`
--
ALTER TABLE `t_course_info`
  ADD PRIMARY KEY (`course_no`);

--
-- Indexes for table `t_department_info`
--
ALTER TABLE `t_department_info`
  ADD PRIMARY KEY (`department_no`);

--
-- Indexes for table `t_department_manager_info`
--
ALTER TABLE `t_department_manager_info`
  ADD UNIQUE KEY `t_department_manager_info_pk` (`department_no`,`manager_no`,`status`),
  ADD UNIQUE KEY `t_department_manager_info_pk2` (`manager_no`,`department_no`);

--
-- Indexes for table `t_grade`
--
ALTER TABLE `t_grade`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `t_login`
--
ALTER TABLE `t_login`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `t_openid`
--
ALTER TABLE `t_openid`
  ADD PRIMARY KEY (`openid`),
  ADD KEY `t_openid_t_user_employee_id_fk` (`user_id`);

--
-- Indexes for table `t_school`
--
ALTER TABLE `t_school`
  ADD PRIMARY KEY (`school_id`);

--
-- Indexes for table `t_user`
--
ALTER TABLE `t_user`
  ADD PRIMARY KEY (`employee_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `t_class_manager_info`
--
ALTER TABLE `t_class_manager_info`
  ADD CONSTRAINT `t_class_manager_info_t_employee_employee_id_fk` FOREIGN KEY (`employee_id`) REFERENCES `t_user` (`employee_id`);

--
-- Constraints for table `t_department_manager_info`
--
ALTER TABLE `t_department_manager_info`
  ADD CONSTRAINT `t_department_manager_info_t_employee_employee_id_fk` FOREIGN KEY (`manager_no`) REFERENCES `t_user` (`employee_id`);

--
-- Constraints for table `t_openid`
--
ALTER TABLE `t_openid`
  ADD CONSTRAINT `t_openid_t_user_employee_id_fk` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`employee_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
