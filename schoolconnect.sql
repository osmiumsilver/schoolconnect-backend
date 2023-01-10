-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 172.17.0.1
-- Generation Time: Jan 10, 2023 at 12:42 PM
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
('0111111', '000000000004', 1, 0),
('1678041', '000000000002', 0, 0),
('1678041', '000000000004', 1, 1);

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
-- Table structure for table `t_employee`
--

CREATE TABLE `t_employee` (
  `employee_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '人员工号',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='人员信息表';

--
-- Dumping data for table `t_employee`
--

INSERT INTO `t_employee` (`employee_id`, `picture_url`, `name`, `class_no`, `sex`, `residence_id`, `email`, `phone`, `address`, `second_contact`, `role`, `status`, `create_time`, `school_id`) VALUES
('000000000001', NULL, '校长姚', NULL, 0, '32050319680212032X', 'dean@school.com', '13798765932', '江苏省苏州市姑苏区平江路1号', 'weicvivwvb', 1, 0, '2022-12-05 15:34:34', 1),
('000000000002', NULL, '老师李', NULL, 1, '32050119730814618X', 't@school.com', '18894691145', '江苏省苏州市姑苏区平江路1号', 'nfiaufvgff', 2, 0, '2022-12-05 15:36:09', 1),
('000000000003', NULL, '超管', NULL, 0, '32528u502735023582', 'super@school.com', '312983461294', '江苏省苏州市姑苏区平江路1号', NULL, 0, 0, '2022-12-05 15:36:46', 1),
('000000000004', NULL, '辅导员林', NULL, 1, '320501194189471029', 'lin@school.com', '124it1i24yo', '江苏省苏州市姑苏区平江路1号', 'fhfuwebfwefwechat', 1, 0, '2022-12-06 20:21:37', 1),
('000000000005', NULL, 'A老师', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 4, 3, NULL, 1),
('000000000006', NULL, 'B老师', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 4, 3, NULL, 1),
('2113504069', NULL, '姚博乾', NULL, 0, '320503200000000000', 'osmium@hotmail.com', '13810000000', '江苏省苏州市姑苏区平江路1号', '12312312313123131', 3, 0, '2022-12-05 15:32:46', 1),
('2200004001', NULL, '张三', NULL, 0, '320503200000012028', 'hello@example.com', '13813838438', '江苏省苏州市姑苏区平江路1号', '3444444332', 1, 1, '2022-09-28 13:07:36', 1);

-- --------------------------------------------------------

--
-- Table structure for table `t_grade`
--

CREATE TABLE `t_grade` (
  `id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'generated id',
  `user_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学生编号',
  `course_no` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '课程编号',
  `grade` float DEFAULT NULL COMMENT '成绩'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='成绩表';

--
-- Dumping data for table `t_grade`
--

INSERT INTO `t_grade` (`id`, `user_id`, `course_no`, `grade`) VALUES
('da9ff370-7473-11ed-8b4b-000c29d0688e', '2113504069', '9002602020', 100);

-- --------------------------------------------------------

--
-- Table structure for table `t_login`
--

CREATE TABLE `t_login` (
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '连接人员表的唯一id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='登录信息表';

-- --------------------------------------------------------

--
-- Table structure for table `t_openid`
--

CREATE TABLE `t_openid` (
  `openid` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '微信id',
  `user_id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
-- Table structure for table `t_sys_user`
--

CREATE TABLE `t_sys_user` (
  `user_id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'GENERATED ID',
  `employee_id` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学校人员对应的工号',
  `realname` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '真实姓名',
  `nickname` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '昵称',
  `sex` tinyint(4) DEFAULT NULL,
  `residence_id` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `role` tinyint(4) NOT NULL COMMENT '0:本校 1:非本校',
  `create_time` datetime DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `last_login_ip` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_login_location` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `avatar_url` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统用户表';

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
  ADD KEY `t_class_manager_info_t_employee_employee_id_fk` (`employee_id`);

--
-- Indexes for table `t_course`
--
ALTER TABLE `t_course`
  ADD UNIQUE KEY `t_course_pk` (`course_no`,`employee_id`);

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
  ADD KEY `t_department_manager_info_t_employee_employee_id_fk` (`manager_no`);

--
-- Indexes for table `t_employee`
--
ALTER TABLE `t_employee`
  ADD PRIMARY KEY (`employee_id`);

--
-- Indexes for table `t_grade`
--
ALTER TABLE `t_grade`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `t_login`
--
ALTER TABLE `t_login`
  ADD KEY `t_login_t_sysuser_user_id_fk` (`user_id`);

--
-- Indexes for table `t_openid`
--
ALTER TABLE `t_openid`
  ADD PRIMARY KEY (`openid`),
  ADD KEY `t_openid_t_sysuser_user_id_fk` (`user_id`);

--
-- Indexes for table `t_school`
--
ALTER TABLE `t_school`
  ADD PRIMARY KEY (`school_id`);

--
-- Indexes for table `t_sys_user`
--
ALTER TABLE `t_sys_user`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `t_sys_user_t_employee_employee_id_fk` (`employee_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `t_class_manager_info`
--
ALTER TABLE `t_class_manager_info`
  ADD CONSTRAINT `t_class_manager_info_t_employee_employee_id_fk` FOREIGN KEY (`employee_id`) REFERENCES `t_employee` (`employee_id`);

--
-- Constraints for table `t_department_manager_info`
--
ALTER TABLE `t_department_manager_info`
  ADD CONSTRAINT `t_department_manager_info_t_employee_employee_id_fk` FOREIGN KEY (`manager_no`) REFERENCES `t_employee` (`employee_id`);

--
-- Constraints for table `t_login`
--
ALTER TABLE `t_login`
  ADD CONSTRAINT `t_login_t_sysuser_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `t_sys_user` (`user_id`);

--
-- Constraints for table `t_openid`
--
ALTER TABLE `t_openid`
  ADD CONSTRAINT `t_openid_t_sysuser_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `t_sys_user` (`user_id`);

--
-- Constraints for table `t_sys_user`
--
ALTER TABLE `t_sys_user`
  ADD CONSTRAINT `t_sys_user_t_employee_employee_id_fk` FOREIGN KEY (`employee_id`) REFERENCES `t_employee` (`employee_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
