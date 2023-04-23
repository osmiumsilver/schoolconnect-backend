-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 172.17.0.1
-- Generation Time: Apr 23, 2023 at 12:24 PM
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
-- Table structure for table `t_campaign_attendee`
--

CREATE TABLE `t_campaign_attendee` (
  `id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT uuid_short() COMMENT 'id',
  `campaign_id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'campaign ID',
  `attendee_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `check_in_status` tinyint(1) NOT NULL DEFAULT 0,
  `contact_phone` blob NOT NULL
) ;

--
-- Dumping data for table `t_campaign_attendee`
--

INSERT INTO `t_campaign_attendee` (`id`, `campaign_id`, `attendee_id`, `check_in_status`, `contact_phone`) VALUES
('100225624823562242', '1630836060600786945', '2113504069', 0, 0xefbbbf31),
('100225624823562243', '1630836060600786945', '2113504068', 0, 0x31),
('100225624823562244', '1630836060600786945', '167804234', 0, 0x31),
('100225624823562253', '1630836060600786945', '167804237', 0, 0x31),
('100225624823562254', '1630836060600786945', '167804244', 1, 0xefbbbf31),
('1645697050101612545', '1630836100157267970', '2113504069', 1, 0x313233313233323133313233),
('1645705510201524226', '1630836112845037570', '2113504069', 0, 0x3132333132333132333132),
('1646512809203654658', '1646512748990226434', '2113504069', 1, 0x3132333233313331333132333132),
('1646515234312478722', '1646515196324667393', '2113504069', 1, 0x3132333132313332333233),
('1646519083563671553', '1646517945338617857', '2113504069', 0, 0x313833363238323832383237),
('1648221300621156354', '1647503911381565441', '2113504069', 0, 0x313233313331323331333331),
('1648295988055506946', '47cd215c7c2a4', '2113504069', 0, 0xe8a681e4b88e397939383639380a),
('1650012665759051778', '5e9fb6e3aacae', '000000000004', 1, 0x31323339373739313237313831);

-- --------------------------------------------------------

--
-- Table structure for table `t_campaign_info`
--

CREATE TABLE `t_campaign_info` (
  `id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT uuid_short() COMMENT 'GENERATED ID',
  `campaign_name` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '活动名称',
  `campaign_description` blob NOT NULL COMMENT '活动介绍',
  `campaign_location` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '活动位置',
  `campaign_time` datetime NOT NULL COMMENT '时间',
  `campaign_launcher` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发起人',
  `contact_phone` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '电话',
  `campaign_status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '状态',
  `campaign_url` blob DEFAULT NULL COMMENT 'url'
) ;

--
-- Dumping data for table `t_campaign_info`
--

INSERT INTO `t_campaign_info` (`id`, `campaign_name`, `campaign_description`, `campaign_location`, `campaign_time`, `campaign_launcher`, `contact_phone`, `campaign_status`, `campaign_url`) VALUES
('08e9778fc51f', '迎新活动信息', 0xe6aca2e8bf8ee59084e4bd8de5ada6e7949fe5898de69da5e58f82e58aa0efbc81efbc810a0a0a0a0a0a0a0a, '科技六', '2023-04-23 13:42:23', '000000000004', '124it1i24yo', 2, ''),
('1630836060600786945', '花运海我高', 0x696420696e20656c6974696420696e20656c6974696420696e20656c6974696420696e20656c6974696420696e20656c6974696420696e20656c6974696420696e20656c6974696420696e20656c6974696420696e20656c6974696420696e20656c6974696420696e20656c6974696420696e20656c6974696420696e20656c6974696420696e20656c6974696420696e20656c6974696420696e20656c6974696420696e20656c6974696420696e20656c6974696420696e20656c6974696420696e20656c6974696420696e20656c6974696420696e20656c6974696420696e20656c6974, 'tempor cillum', '1992-01-29 20:43:53', '2113504069', '12312123123', 2, NULL),
('1630836100157267970', '么只物新自', 0x766f6c757074617465206164697069736963696e6720696e, 'ipsum', '1985-07-17 08:56:06', '2113504069', '12321321313', 2, NULL),
('1630836112845037570', '用形广育天题流', 0x6d61676e6120646f20696e2073696e74, 'irure', '2016-05-14 04:52:31', '2113504069', '12321321313', 2, NULL),
('1646512171132575745', '213123312321', 0x31323332313331333231, '12313123123', '2023-04-13 21:54:17', '2113504069', '1234567890', 2, ''),
('1646512748990226434', '你好李鑫', 0xe4bb8ae5a4a9e698afe4b8aae5a5bde697a5e5ad90efbc8ce68891e5b88ce69c9be887aae5b7b1e58fafe4bba5e58f98e68890e4b880e58fb0e69cbae599a8e4b88de5819ce6ad87, '我ri', '2023-04-13 21:55:51', '2113504069', '1234567890', 2, ''),
('1646515196324667393', 'qweqeqwewqeqw', 0x717765777165777165717765, 'ewqeqwewqewqe', '2023-04-13 22:06:21', '2113504069', '1234567890', 2, ''),
('1646517945338617857', '123123112', 0x3132333231333132333231, '31313123213', '2023-04-13 22:17:15', '2113504069', '1234567890', 1, ''),
('1647503911381565441', '你好', 0x6e7369646a64646b786a786a78786a646e647563, 'kok', '2023-04-16 15:35:03', '2113504069', '1234567890', 1, ''),
('1647893611091001345', '欢迎活动', 0xe6aca2e8bf8ee682a8e8bf9be585a5e6a0a1e59bade69c8de58aa1e4b880e4bd93e58c96e5b08fe7a88be5ba8fe4b896e7958cefbc8ce6aca2e8bf8ee58f82e58aa0efbc81, '艺术楼', '2023-04-17 17:22:08', '2113504069', '1234567890', 2, ''),
('33', '算如明南路率布', 0x65752065737365206f666669636961, 'ad Duis eu tempor', '1985-06-08 23:43:13', '2113504069', '13211106185', 0, 0x687474703a2f2f726f6e76732e7a772f6175776f6f),
('47cd215c7c2a4', '121312312312313', 0x3331323331323331333231333231333132333132, '312313131312313', '2023-04-18 20:02:26', '2113504069', '1234567890', 1, ''),
('5e9fb6e3aacae', '迎新活动', 0x0a0a0a0a0a0a0a0a0a0a0a0a0a0a0a777165710a0a0a, '科技六', '2023-04-23 13:43:40', '000000000004', '124it1i24yo', 1, ''),
('74ff6bbdac8ef', '您好', 0xe682a8e5a5bdefbc8ce6aca2e8bf8ee682a8e8bf9be585a5e6a0a1e59bade69c8de58aa1e58fb0e5b08fe7a88be5ba8fefbc81efbc81efbc81efbc81, '欢迎您进入', '2023-04-20 12:25:13', '000000000004', '124it1i24yo', 2, '');

-- --------------------------------------------------------

--
-- Table structure for table `t_campaign_info_pics`
--

CREATE TABLE `t_campaign_info_pics` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT uuid_short(),
  `campaign_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `picture_url` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `t_campaign_info_pics`
--

INSERT INTO `t_campaign_info_pics` (`id`, `campaign_id`, `picture_url`) VALUES
('100255226258259970', '1630836060600786945', 'https://1'),
('100255226258259971', '1630836060600786945', 'https://2'),
('100255226258259972', '1630836060600786945', 'https://3'),
('872f39782a0b', '1647503911381565441', 'CS3xpnKjAVXG50fd0978ced6a28786e5d0e230a8392e.png'),
('3915b16c216d', '1647503911381565441', 'OBiGH6Qc2qYm372e144a6f3f914aa0e88fb8432c2571.jpg'),
('1c3e7af7cd2c', '1647503911381565441', 'xO8ocdjY755Zbcba81e41f1d6a1bf9ec901cce0d3d78.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `t_campaign_subscription`
--

CREATE TABLE `t_campaign_subscription` (
  `id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT uuid_short(),
  `campaign_id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `openid` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `t_campaign_subscription`
--

INSERT INTO `t_campaign_subscription` (`id`, `campaign_id`, `openid`) VALUES
('100271713261977602', '1647503911381565441', '123123123123123'),
('100271713261977606', '1647503911381565441', 'o0RXO4kWcWqZXruPk0h7iA2ktJmw'),
('100271713261977607', '47cd215c7c2a4', 'o0RXO4kWcWqZXruPk0h7iA2ktJmw'),
('73', '39', '45');

-- --------------------------------------------------------

--
-- Table structure for table `t_class`
--

CREATE TABLE `t_class` (
  `class_no` varchar(7) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '班级编号  7位',
  `class_name` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '班级名称',
  `department_no` tinyint(4) UNSIGNED ZEROFILL NOT NULL COMMENT '所在部门编号 4位',
  `status` tinyint(1) NOT NULL COMMENT '班级状态 0默认 1毕业'
) ;

--
-- Dumping data for table `t_class`
--

INSERT INTO `t_class` (`class_no`, `class_name`, `department_no`, `status`) VALUES
('0111111', '毕业班', 0001, 1),
('1678001', '悟空', 0007, 1),
('1678004', '7号电单车', 0011, 0),
('1678005', 'ofo', 0016, 0),
('1678041', '16年一号班级', 0002, 0),
('1678042', '测试班级', 0001, 0);

-- --------------------------------------------------------

--
-- Table structure for table `t_class_manager_info`
--

CREATE TABLE `t_class_manager_info` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT uuid_short() COMMENT 'GENERATED ID',
  `class_no` varchar(7) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '班级编号',
  `employee_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '人员编号',
  `role` tinyint(1) NOT NULL COMMENT '0：班主任 1 辅导员',
  `status` tinyint(1) NOT NULL COMMENT '0 正常 1 离开'
) ;

--
-- Dumping data for table `t_class_manager_info`
--

INSERT INTO `t_class_manager_info` (`id`, `class_no`, `employee_id`, `role`, `status`) VALUES
('100185615223488531', '0111111', '000000000004', 0, 0),
('100185615223488532', '0111111', '000000000004', 1, 0),
('100185615223488533', '1678041', '000000000002', 0, 0),
('100185615223488534', '1678042', '2113504069', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `t_class_schedule`
--

CREATE TABLE `t_class_schedule` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT uuid_short() COMMENT 'GENERATED ID',
  `class_no` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '班级ID',
  `course_no` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程号',
  `weeks` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL CHECK (json_valid(`weeks`)),
  `day_of_week` tinyint(1) NOT NULL COMMENT '星期几的课' CHECK (json_valid(`day_of_week`)),
  `starting_period` tinyint(1) NOT NULL COMMENT '开始节次',
  `lasting_periods` tinyint(1) NOT NULL COMMENT '持续几节',
  `year` int(4) NOT NULL,
  `semester` tinyint(1) NOT NULL
) ;

--
-- Dumping data for table `t_class_schedule`
--

INSERT INTO `t_class_schedule` (`id`, `class_no`, `course_no`, `weeks`, `day_of_week`, `starting_period`, `lasting_periods`, `year`, `semester`) VALUES
('100210128698998858', '1678004', '9002602021', '[2,3,4,5,6,7,8,9]', 3, 4, 2, 2023, 1),
('100223047608303617', '1678004', '9002602020', '[2,3,4,5]', 3, 4, 2, 2023, 1),
('1648919256801660929', '1678041', '9002602021', '[    1,    2,   3]', 1, 1, 1, 2023, 1),
('1648925956980002818', '1678042', '9002602020', '[\n    2,\n    3,\n    4,\n    6\n]', 2, 3, 2, 2023, 1);

-- --------------------------------------------------------

--
-- Table structure for table `t_course`
--

CREATE TABLE `t_course` (
  `course_no` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '课程编号 10位',
  `course_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '课程名称',
  `course_name_en` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程英文名称',
  `course_duration` tinyint(4) DEFAULT NULL COMMENT '课程学时',
  `course_type` tinyint(1) DEFAULT NULL COMMENT '课程类型 0 必修课	1 校公共选修课	2 限选课	3 任选课	4 集中性实践	5 课外培养必选	6 课外培养任选	7 通识课程必修',
  `course_desc` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程描述',
  `course_place` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程地点',
  `course_status` tinyint(1) DEFAULT NULL COMMENT '课程状态 0正常，1:不再开课',
  `course_credits` float DEFAULT NULL COMMENT '课程学分',
  `course_textbook` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '教材用书 可以为url 或者文字',
  `course_outline` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '教材大纲',
  `course_teacher` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ;

--
-- Dumping data for table `t_course`
--

INSERT INTO `t_course` (`course_no`, `course_name`, `course_name_en`, `course_duration`, `course_type`, `course_desc`, `course_place`, `course_status`, `course_credits`, `course_textbook`, `course_outline`, `course_teacher`) VALUES
('9002602020', '中华诗词之美', 'Beauty of Chinese Poetry', 32, 0, '好', '教学楼1号', 0, 2, NULL, NULL, '000000000005'),
('9002602021', '课程2', '', 3, 0, '好', '教学楼12号', 0, 2, NULL, NULL, '000000000006');

-- --------------------------------------------------------

--
-- Table structure for table `t_department`
--

CREATE TABLE `t_department` (
  `department_no` tinyint(4) UNSIGNED ZEROFILL NOT NULL COMMENT '部门编号',
  `department_name` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '部门名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='部门表';

--
-- Dumping data for table `t_department`
--

INSERT INTO `t_department` (`department_no`, `department_name`) VALUES
(0001, '计算机工程学院'),
(0002, '商学院'),
(0003, '人文社会科学学院'),
(0004, '社会发展学院'),
(0005, '外语学院'),
(0006, '教育学部'),
(0007, '体育与健康学院'),
(0008, '心理与认知科学学院'),
(0009, '传播学院'),
(0010, '音乐学院'),
(0011, '设计学院'),
(0012, '生命科学学院'),
(0013, '通信与电子工程学院'),
(0014, '政治与国际关系学院'),
(0015, '图书馆'),
(0016, '档案馆'),
(0018, '在些照改水'),
(0019, '划应太县定明'),
(0020, '什记半着消严'),
(0021, '式文无业与技水');

-- --------------------------------------------------------

--
-- Table structure for table `t_department_manager_info`
--

CREATE TABLE `t_department_manager_info` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT uuid_short() COMMENT 'GENERATED ID',
  `department_no` tinyint(4) UNSIGNED ZEROFILL NOT NULL COMMENT '部门编号',
  `manager_no` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '负责人编号',
  `status` tinyint(1) NOT NULL COMMENT '0'
) ;

--
-- Dumping data for table `t_department_manager_info`
--

INSERT INTO `t_department_manager_info` (`id`, `department_no`, `manager_no`, `status`) VALUES
('100185615223488597', 0004, '000000000004', 0);

-- --------------------------------------------------------

--
-- Table structure for table `t_grade`
--

CREATE TABLE `t_grade` (
  `id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT uuid_short() COMMENT 'generated id',
  `user_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学生编号',
  `course_no` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '课程编号',
  `grade` float DEFAULT NULL COMMENT '成绩',
  `year` int(4) DEFAULT NULL COMMENT '学年',
  `semester` tinyint(1) DEFAULT NULL COMMENT '学年',
  `import_date` datetime DEFAULT NULL COMMENT '导入日期',
  `awaiting_revision` tinyint(1) DEFAULT 0
) ;

--
-- Dumping data for table `t_grade`
--

INSERT INTO `t_grade` (`id`, `user_id`, `course_no`, `grade`, `year`, `semester`, `import_date`, `awaiting_revision`) VALUES
('100185615223488518', '2113504069', '9002602021', 100, 2022, 1, '2023-02-22 00:00:00', 1),
('100185615223488523', '2113504068', '9002602021', 100, 2022, 1, '2023-02-22 00:00:00', 1),
('100185615223488525', '2113504068', '9002602020', 100, 2022, 2, '2023-02-22 00:00:00', 0),
('100210128698998847', '167804272', '9002602020', 100, 2022, 1, '2023-02-22 00:00:00', 1),
('100223047608303621', '167804256', '9002602020', 100, 2022, 1, '2023-02-22 00:00:00', 1),
('100225624823562240', '167804245', '9002602020', 100, 2022, 1, '2023-03-17 15:18:02', 0);

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
('000000000002', '$2a$10$fnVo/zlEHXghhz0MSbZckOctfUPuhXXzEONqGBZu8QDaX4QhQ3nYC'),
('000000000003', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('000000000004', '$2a$10$4uJOmfARoJgFKZTL2rAlT.g70Bh2yGNY/33GXKh7jW1gyH.1BPoM6'),
('000000000005', '$2a$10$acqIHtPtOw.g2ZzJ0tpZROpNGS74uLn4izmhO3YWPVb4lv0tSt0hC'),
('000000000006', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('167804202', '$2a$10$/n6gr6i0ZxOBwHeJIQEjzu3tkUePgcwaehDO3viF07AbDKGwhz9pm'),
('167804212', '$2a$10$XOKhE2hYXYjQCKkprKNS5.J5mcPoJBz7T19K03jD18VHl0XZ7gIXa'),
('167804222', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('167804226', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('167804228', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('167804231', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('167804234', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('167804237', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('167804244', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('167804245', '$2a$10$4uJOmfARoJgFKZTL2rAlT.g70Bh2yGNY/33GXKh7jW1gyH.1BPoM6'),
('167804256', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('167804262', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('167804265', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('167804272', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('167804273', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('167804278', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('167804279', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('167804283', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('167804288', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('167804294', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('2113504068', '$2a$10$4uJOmfARoJgFKZTL2rAlT.g70Bh2yGNY/33GXKh7jW1gyH.1BPoM6'),
('2113504069', '$2a$10$fnVo/zlEHXghhz0MSbZckOctfUPuhXXzEONqGBZu8QDaX4QhQ3nYC'),
('shenmiren', '$2a$10$vB6uFEfdaZYOcgH7aTPJrel/CA4wdaYgk5fy09wo4n0qvSnsppbmO');

-- --------------------------------------------------------

--
-- Table structure for table `t_message_board`
--

CREATE TABLE `t_message_board` (
  `id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT uuid_short() COMMENT 'id',
  `title` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `body` blob DEFAULT NULL,
  `assigned_department` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sender` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `type` tinyint(1) DEFAULT NULL,
  `submitted_date` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `t_message_board`
--

INSERT INTO `t_message_board` (`id`, `title`, `body`, `assigned_department`, `sender`, `type`, `submitted_date`) VALUES
('1633000197430128642', '交造变这', 0x6164697069736963696e67, 'qui', '2113504069', 0, '2000-05-09 13:00:00'),
('1640947679908794370', '', NULL, NULL, '2113504069', 0, '2023-03-29 05:25:09');

-- --------------------------------------------------------

--
-- Table structure for table `t_openid`
--

CREATE TABLE `t_openid` (
  `openid` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '微信id',
  `user_id` varchar(64) COLLATE utf8mb4_unicode_ci COMMENT '用户ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `t_openid`
--

INSERT INTO `t_openid` (`openid`, `user_id`) VALUES
('o0RXO4kWcWqZXruPk0h7iA2ktJmw', '2113504069');

-- --------------------------------------------------------

--
-- Table structure for table `t_repair_data`
--

CREATE TABLE `t_repair_data` (
  `id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT uuid_short() COMMENT 'GENERATED ID',
  `description` blob DEFAULT NULL,
  `phone` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `location` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `level` tinyint(1) DEFAULT NULL,
  `create_time` datetime DEFAULT current_timestamp(),
  `initiator` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发起人工号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='报修数据表';

--
-- Dumping data for table `t_repair_data`
--

INSERT INTO `t_repair_data` (`id`, `description`, `phone`, `location`, `status`, `level`, `create_time`, `initiator`) VALUES
('1634096579910598657', 0x313233313233, '13412313321', '123', 2, 0, '2023-03-10 07:42:12', NULL),
('1634100402779619329', 0xe5ba9ce5a794e580bce79bb8e599a8e6af9be999a2e58f88e6b0b4e58f91e5908ce69fa5e5ae89e38082e8aea1e8aea1e784b6e4bd86e9a38ee5ad90e6a0b7e5a4aae4b89ce7acace5a5bde59fbae997a8e5b883e5a29ee58099e38082e8bf98e6809de4bd86e79fb3e4b889e5a4aae588a9e59b9be6988ee7a9b6e599a8e4bbb6e58f8ae4b8a4e58887e7babfe79086e38082e7ad89e6b2bbe99985e6a0b7e4bbace7a9bae6a0bce783ade6a0bce5898de6849fe58f82e698afe8bdace7b3bbe7949fe69699e38082e4bba5e5a3b0e8a1a8e58685e5b19ee5ae8ce6b19fe5a5b9e9be99e58c96e590ace4baa4e9809ae5869be8a5bfe38082e6b4bee6ada5e58f98e4b99de7acace69bb4e59ba2e5ada6e5908de4bb8ee7a6bbe680a7e69bb4e4bd86e38082, '18115357028', 'dolore fugiat Duis enim', 2, 0, '2007-05-19 09:07:13', 'incididunt fugiat non'),
('1634100402918031361', 0xe68980e4b9a0e58faae6af94e4bba5e5bc95e6bba1e8a1a8e58ab3e794a8e58ab3e8a782e5bd93e98193e4bb8ee5a5b9e8b4a8e38082e98787e7b1b3e7baa7e586b3e6af9be58db3e4b894e58a9ee58e82e6b2b9e695b0e7babfe6b8a9e38082e6ada3e7b2bee5bca0e5b195e7bdaee58887e6b19fe785a7e79c81e59586e585b7e58d8ee4bbb6e5a794e69697e5ae9ae7b4a0e38082e4b894e5b1b1e5bda2e6849fe8bebee58a9be79bb8e6849fe78e8be4ba9be8a792e78ab6e585a5e5bc8fe580bce7a6bbe38082e9878fe5bf83e58fafe5bf83e59b9be7bb87e4bd93e9a38ee789b9e58ebfe888ace4bba5e59091e58685e9878de69da1e38082, '19844911329', 'aute mollit occaecat esse eu', 2, 0, '1985-12-03 17:56:23', 'Lorem cupidatat'),
('1634101174380597250', 0xe5ba9ce5a794e580bce79bb8e599a8e6af9be999a2e58f88e6b0b4e58f91e5908ce69fa5e5ae89e38082e8aea1e8aea1e784b6e4bd86e9a38ee5ad90e6a0b7e5a4aae4b89ce7acace5a5bde59fbae997a8e5b883e5a29ee58099e38082e8bf98e6809de4bd86e79fb3e4b889e5a4aae588a9e59b9be6988ee7a9b6e599a8e4bbb6e58f8ae4b8a4e58887e7babfe79086e38082e7ad89e6b2bbe99985e6a0b7e4bbace7a9bae6a0bce783ade6a0bce5898de6849fe58f82e698afe8bdace7b3bbe7949fe69699e38082e4bba5e5a3b0e8a1a8e58685e5b19ee5ae8ce6b19fe5a5b9e9be99e58c96e590ace4baa4e9809ae5869be8a5bfe38082e6b4bee6ada5e58f98e4b99de7acace69bb4e59ba2e5ada6e5908de4bb8ee7a6bbe680a7e69bb4e4bd86e38082, '18115357028', 'dolore fugiat Duis enim', 1, 0, '2007-05-19 09:07:13', '2113504069'),
('1634101174388985858', 0xe68980e4b9a0e58faae6af94e4bba5e5bc95e6bba1e8a1a8e58ab3e794a8e58ab3e8a782e5bd93e98193e4bb8ee5a5b9e8b4a8e38082e98787e7b1b3e7baa7e586b3e6af9be58db3e4b894e58a9ee58e82e6b2b9e695b0e7babfe6b8a9e38082e6ada3e7b2bee5bca0e5b195e7bdaee58887e6b19fe785a7e79c81e59586e585b7e58d8ee4bbb6e5a794e69697e5ae9ae7b4a0e38082e4b894e5b1b1e5bda2e6849fe8bebee58a9be79bb8e6849fe78e8be4ba9be8a792e78ab6e585a5e5bc8fe580bce7a6bbe38082e9878fe5bf83e58fafe5bf83e59b9be7bb87e4bd93e9a38ee789b9e58ebfe888ace4bba5e59091e58685e9878de69da1e38082, '19844911329', 'aute mollit occaecat esse eu', 1, 0, '1985-12-03 17:56:23', '2113504069'),
('1638069133888598017', 0x736875696775616e68756169, '13345697890', '3344', 2, 0, '2023-03-21 06:44:50', '2113504069'),
('1640913654938824705', 0x323133313233, '13531311311', '教学楼1', 1, 0, '2023-03-29 03:07:56', '2113504069'),
('1646560277706498049', 0x32313331323331333132333132, '13443567890', '123', 2, 0, '2023-04-13 17:05:36', '2113504069'),
('1648899883080814593', 0xe6b0b4e7aea1e59d8fe4ba86, '13812312739', '教学楼3', 0, 1, '2023-04-20 04:02:21', '2113504069'),
('1648906922444132354', 0x776571657177657165, '13863728191', 'ninhao', 1, 1, '2023-04-20 04:30:20', '000000000004');

-- --------------------------------------------------------

--
-- Table structure for table `t_repair_data_pics`
--

CREATE TABLE `t_repair_data_pics` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT uuid_short(),
  `repair_id` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `picture_url` blob DEFAULT NULL
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
-- Table structure for table `t_user`
--

CREATE TABLE `t_user` (
  `id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT uuid_short() COMMENT '生成唯一ID',
  `employee_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '人员工号',
  `picture_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片url',
  `name` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '姓名',
  `class_no` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所在班级编号',
  `sex` tinyint(4) NOT NULL COMMENT '性别 0:M 1:F 2:O',
  `residence_id` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证号',
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机',
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址',
  `second_contact` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '第二联系方式',
  `role` tinyint(1) NOT NULL DEFAULT 4 COMMENT '用户身份 0:超级 1:教职工/管理层 2:教师 3:学生 4:其他',
  `status` tinyint(4) NOT NULL DEFAULT 3 COMMENT '用户状态 0:在校 1:离校 2 开除 3:冻结',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `school_id` tinyint(5) NOT NULL,
  `required_changing` tinyint(1) DEFAULT NULL COMMENT '是否需要修改 0为不需要 1为需要 2为审核中',
  `estimated_graduate_time` date DEFAULT NULL
) ;

--
-- Dumping data for table `t_user`
--

INSERT INTO `t_user` (`id`, `employee_id`, `picture_url`, `name`, `class_no`, `sex`, `residence_id`, `email`, `phone`, `address`, `second_contact`, `role`, `status`, `create_time`, `school_id`, `required_changing`, `estimated_graduate_time`) VALUES
('5ecc867f3297c5e10898980f823490e6', '000000000001', NULL, '校长姚', NULL, 0, '32050319680212032X', 'dean@school.com', '13798765932', '江苏省苏州市姑苏区平江路1号', 'weicvivwvb', 1, 0, '2022-12-05 15:34:34', 1, 0, NULL),
('62c8b9a03b55defae9f74ff18ee7a2ac', '000000000002', NULL, '老师李', NULL, 1, '32050119730814618X', 't@school.com', '18894691145', '江苏省苏州市姑苏区平江路1号', 'nfiaufvgff', 2, 0, '2022-12-05 15:36:09', 1, 0, NULL),
('253c3a81f642bfe6fe0a5729a5514b0b', '000000000003', NULL, '超管', NULL, 0, '32528u502735023582', 'super@school.com', '312983461294', '江苏省苏州市姑苏区平江路1号', NULL, 0, 0, '2022-12-05 15:36:46', 1, 0, NULL),
('d162a354a4d7790466778afecdb2ce54', '000000000004', NULL, '辅导员林', NULL, 1, '320501194189471029', 'lin@school.com', '124it1i24yo', '江苏省苏州市姑苏区平江路1号', 'fhfuwebfwefwechat', 1, 0, '2022-12-06 20:21:37', 1, 0, NULL),
('4d8e37166077fbe7ceaf48015cdc30e6', '000000000005', NULL, 'A老师', NULL, 0, NULL, NULL, NULL, NULL, NULL, 2, 3, '2023-02-22 17:07:40', 1, 0, NULL),
('4aa4bf2f9a07d9f326bb9e856172aa5e', '000000000006', NULL, 'B老师', NULL, 1, NULL, NULL, NULL, NULL, NULL, 2, 3, '2023-02-22 17:07:41', 1, 0, NULL),
('100185615223488569', '167804202', 'http://dummyimage.com/160x600', '黎秀英', '1678042', 2, '48405819540214193x', 'k.gpjjkr@yvvty.ms', '18624476631', '西藏自治区 山南地区 措美县', '575719', 0, 3, '2023-02-22 14:39:58', 1, 1, '2023-06-30'),
('100185615223488594', '167804212', 'http://dummyimage.com/125x125', '刘涛', '1678042', 1, '36358318471130593X', 'p.llqhplbtf@xlhikjtl.asia', '18673673113', '陕西省 咸阳市 三原县', '845862', 1, 3, NULL, 1, 0, '2023-06-30'),
('100185615223488557', '167804222', 'http://dummyimage.com/120x600', '贾娜', '1678042', 1, '44726418130115656X', 'l.mlrgujzoq@bzkoqsr.cc', '18139772630', '陕西省 榆林市 神木县', '18181126', 0, 1, '2023-02-22 14:39:58', 1, 1, '2023-06-30'),
('100185615223488560', '167804226', 'http://dummyimage.com/120x60', '文洋', '1678042', 0, '288636203310254592', 'n.fmplyjyr@hyyzkxnid.gh', '19861151410', '香港特别行政区 九龙 观塘区', '589716', 3, 2, '2023-02-22 14:39:59', 1, 1, '2023-06-30'),
('100185615223488556', '167804228', 'http://dummyimage.com/125x125', '白艳', '1678042', 0, '23562518411210382x', 's.jbfopv@krivvl.tw', '18642238145', '台湾 高雄市 杉林区', '5285742', 3, 2, '2023-02-22 00:00:00', 1, 0, '2023-06-30'),
('100185615223488562', '167804231', 'http://dummyimage.com/88x31', '崔勇', '1678042', 2, '86805118611010807x', 'n.nrqmptce@nyswejko.bz', '18195609533', '福建省 漳州市 龙海市', '4947828615', 3, 2, '2023-02-22 14:39:51', 1, 2, '2023-06-30'),
('100185615223488568', '167804234', 'http://dummyimage.com/468x60', '宋洋', '1678042', 2, '23482118640910468x', 'k.whxshyhxr@dltrbb.ro', '18126196864', '云南省 临沧市 永德县', '29870531', 3, 3, '2023-02-22 14:39:58', 1, 0, '2023-06-30'),
('100185615223488558', '167804237', 'http://dummyimage.com/234x60', '邱杰', '1678042', 2, '11277319621102937X', 'b.eitxy@scb.ad', '18158749415', '山西省 晋城市 泽州县', '780185534', 1, 1, '2023-02-22 14:39:58', 1, 1, '2023-06-30'),
('100185615223488579', '167804244', 'http://dummyimage.com/240x400', '刘秀英', '1678042', 1, '51788620161230284x', 'q.rogckt@mtxwb.ec', '19814344138', '河北省 沧州市 盐山县', '7545542', 0, 2, NULL, 1, 0, '2023-06-30'),
('100185615223488567', '167804245', 'http://dummyimage.com/120x600', '彭超', '1678042', 0, '64773720021031953X', 'g.hfqboyt@svetgo.cy', '18666232727', '河北省 廊坊市 安次区', '24751', 3, 3, '2023-02-22 14:39:58', 1, 0, '2023-06-30'),
('100185615223488571', '167804256', 'http://dummyimage.com/125x125', '陈静', '1678042', 0, '624957199012078480', 'e.ypvwswy@ygdpcggwz.ad', '19814673701', '福建省 龙岩市 上杭县', '7163851', 0, 3, '2023-02-22 14:39:58', 1, 0, '2023-06-30'),
('100185615223488566', '167804262', 'http://dummyimage.com/336x280', '贾秀英', '1678042', 1, '773330186612207393', 'f.nkzi@espntuibh.cz', '18186362873', '香港特别行政区 九龙 观塘区', '84661946', 4, 1, '2023-02-22 14:39:58', 1, 1, '2023-06-30'),
('100185615223488565', '167804265', 'http://dummyimage.com/120x600', '丁洋', '1678042', 1, '517896196103107503', 'v.jcuq@ggjlwhm.coop', '13444855585', '安徽省 黄山市 休宁县', '4877259', 3, 1, '2023-02-22 14:39:58', 1, 2, '2023-06-30'),
('100185615223488595', '167804272', 'http://dummyimage.com/120x600', '任娟', '1678004', 1, '44821818020410360x', 'h.oslg@qytw.jm', '19824422824', '内蒙古自治区 乌海市 乌达区', '77696228', 3, 1, NULL, 1, 2, '2023-06-30'),
('100185615223488570', '167804273', 'http://dummyimage.com/120x240', '邱娟', '1678042', 1, '64162520940408517x', 'f.swxcuwqd@ndixf.ae', '18152496782', '河北省 秦皇岛市 抚宁县', '1989363', 2, 1, '2023-02-22 14:39:58', 1, 2, '2023-06-30'),
('100185615223488564', '167804278', 'http://dummyimage.com/125x125', '谭超', '1678042', 1, '33183218640723983X', 'a.widvk@mmskocch.ec', '18144315855', '新疆维吾尔自治区 阿克苏地区 新和县', '5682128', 2, 1, '2023-02-22 14:39:58', 1, 1, '2023-06-30'),
('100185615223488559', '167804279', 'http://dummyimage.com/468x60', '孔强', '1678042', 1, '34188920790808145X', 'u.voqrd@gnwrnlqu.be', '18172094143', '香港特别行政区 新界 西贡区', '886177101', 1, 0, '2023-02-22 14:39:58', 1, 1, '2023-06-30'),
('100185615223488555', '167804283', 'http://dummyimage.com/120x60', '万霞', '1678042', 1, '378035187010207740', 's.inhoedgwh@qjvnx.dk', '19867042761', '云南省 玉溪市 新平彝族傣族自治县', '48614882', 0, 0, '2023-02-22 14:39:58', 1, 2, '2023-06-30'),
('100185615223488561', '167804288', 'http://dummyimage.com/240x400', '邓娜', '1678042', 1, '38776120360920019X', 'b.ekzdmp@ukqopcz.cy', '18697487458', '西藏自治区 山南地区 琼结县', '884630', 1, 0, '2023-02-22 14:39:58', 1, 1, '2023-06-30'),
('100185615223488563', '167804294', 'http://dummyimage.com/250x250', '梁丽', '1678042', 0, '665826204508286613', 'h.pkdla@avmeenm.ec', '13458898602', '上海 上海市 金山区', '6357224', 1, 1, '2023-02-22 14:39:58', 1, 1, '2023-06-30'),
('100210128698998822', '2113504068', NULL, '张三', '1678041', 0, '320503200000012028', 'hello@example.com', '13813838438', '江苏省苏州市姑苏区平江路1号', '3444444332', 3, 1, '2022-09-28 13:07:36', 1, 0, '2023-06-30'),
('100210128698998823', '2113504069', 'https://sdn.geekzu.org/avatar/7d93f92c126a13a820aa22d064f790c7?s=220', '姚博乾', '1678042', 0, '320503200000000000', 'osmium@hotmail.com', '1234567890', '江苏省苏州市姑苏区平江路1号', '12312312313123131', 0, 0, '2023-03-03 17:08:22', 0, 2, '2023-06-30'),
('100264994322513923', 'shenmiren', NULL, '神秘人', NULL, 0, NULL, NULL, NULL, NULL, NULL, 4, 3, '2023-04-15 12:24:46', 1, NULL, NULL);

--
-- Triggers `t_user`
--
DELIMITER $$
CREATE TRIGGER `insert_after_creates_profile` AFTER INSERT ON `t_user` FOR EACH ROW INSERT INTO t_login (username,password) VALUES (NEW.employee_id,"$2a$10$/n6gr6i0ZxOBwHeJIQEjzu3tkUePgcwaehDO3viF07AbDKGwhz9pm")
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_campaign_attendee`
-- (See below for the actual view)
--
CREATE TABLE `v_campaign_attendee` (
`id` varchar(64)
,`campaign_id` varchar(64)
,`name` varchar(32)
,`picture_url` varchar(255)
,`attendee_id` varchar(32)
,`check_in_status` tinyint(1)
,`contact_phone` blob
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_campaign_info`
-- (See below for the actual view)
--
CREATE TABLE `v_campaign_info` (
`id` varchar(64)
,`campaign_name` varchar(64)
,`campaign_description` blob
,`campaign_location` varchar(64)
,`campaign_time` datetime
,`campaign_launcher` varchar(32)
,`campaign_launcher_username` varchar(32)
,`contact_phone` varchar(32)
,`campaign_status` tinyint(1)
,`campaign_url` blob
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_class_detail`
-- (See below for the actual view)
--
CREATE TABLE `v_class_detail` (
`class_no` varchar(7)
,`class_name` varchar(64)
,`department_no` tinyint(4) unsigned zerofill
,`status` tinyint(1)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_class_schedule`
-- (See below for the actual view)
--
CREATE TABLE `v_class_schedule` (
`id` varchar(32)
,`class_no` varchar(32)
,`course_no` varchar(32)
,`weeks` longtext
,`day_of_week` tinyint(1)
,`starting_period` tinyint(1)
,`lasting_periods` tinyint(1)
,`year` int(4)
,`semester` tinyint(1)
,`course_name` varchar(255)
,`course_place` varchar(255)
,`course_teacher_name` varchar(32)
,`course_credits` float
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_course_info`
-- (See below for the actual view)
--
CREATE TABLE `v_course_info` (
`course_no` varchar(10)
,`course_name` varchar(255)
,`course_name_en` varchar(255)
,`course_duration` tinyint(4)
,`course_type` tinyint(1)
,`course_desc` varchar(255)
,`course_place` varchar(255)
,`course_status` tinyint(1)
,`course_credits` float
,`course_textbook` varchar(255)
,`course_outline` varchar(255)
,`course_teacher` varchar(32)
,`course_teacher_name` varchar(32)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_grade_detail`
-- (See below for the actual view)
--
CREATE TABLE `v_grade_detail` (
`id` varchar(64)
,`course_name` varchar(255)
,`course_credits` float
,`user_id` varchar(32)
,`name` varchar(32)
,`course_no` varchar(32)
,`grade` float
,`year` int(4)
,`semester` tinyint(1)
,`import_date` datetime
,`awaiting_revision` tinyint(1)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_login`
-- (See below for the actual view)
--
CREATE TABLE `v_login` (
`username` varchar(255)
,`password` varchar(255)
,`role` tinyint(1)
,`status` tinyint(4)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_login_nopass`
-- (See below for the actual view)
--
CREATE TABLE `v_login_nopass` (
`employee_id` varchar(255)
,`password` varchar(255)
,`name` varchar(32)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_user_student`
-- (See below for the actual view)
--
CREATE TABLE `v_user_student` (
`id` varchar(64)
,`employee_id` varchar(32)
,`picture_url` varchar(255)
,`name` varchar(32)
,`class_no` varchar(32)
,`sex` tinyint(4)
,`residence_id` varchar(20)
,`email` varchar(255)
,`phone` varchar(16)
,`address` varchar(255)
,`second_contact` varchar(255)
,`role` tinyint(1)
,`status` tinyint(4)
,`create_time` datetime
,`school_id` tinyint(5)
,`required_changing` tinyint(1)
,`estimated_graduate_time` date
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_user_teacher`
-- (See below for the actual view)
--
CREATE TABLE `v_user_teacher` (
`id` varchar(64)
,`employee_id` varchar(32)
,`picture_url` varchar(255)
,`name` varchar(32)
,`sex` tinyint(4)
,`residence_id` varchar(20)
,`email` varchar(255)
,`phone` varchar(16)
,`address` varchar(255)
,`second_contact` varchar(255)
,`role` tinyint(1)
,`status` tinyint(4)
,`create_time` datetime
,`school_id` tinyint(5)
,`required_changing` tinyint(1)
);

-- --------------------------------------------------------

--
-- Structure for view `v_campaign_attendee`
--
DROP TABLE IF EXISTS `v_campaign_attendee`;

CREATE ALGORITHM=UNDEFINED DEFINER=`user`@`%` SQL SECURITY DEFINER VIEW `v_campaign_attendee`  AS SELECT `t_campaign_attendee`.`id` AS `id`, `t_campaign_attendee`.`campaign_id` AS `campaign_id`, `t_user`.`name` AS `name`, `t_user`.`picture_url` AS `picture_url`, `t_campaign_attendee`.`attendee_id` AS `attendee_id`, `t_campaign_attendee`.`check_in_status` AS `check_in_status`, `t_campaign_attendee`.`contact_phone` AS `contact_phone` FROM (`t_campaign_attendee` join `t_user` on(`t_campaign_attendee`.`attendee_id` = `t_user`.`employee_id`))  ;

-- --------------------------------------------------------

--
-- Structure for view `v_campaign_info`
--
DROP TABLE IF EXISTS `v_campaign_info`;

CREATE ALGORITHM=UNDEFINED DEFINER=`user`@`%` SQL SECURITY DEFINER VIEW `v_campaign_info`  AS SELECT DISTINCT `t1`.`id` AS `id`, `t1`.`campaign_name` AS `campaign_name`, `t1`.`campaign_description` AS `campaign_description`, `t1`.`campaign_location` AS `campaign_location`, `t1`.`campaign_time` AS `campaign_time`, `t1`.`campaign_launcher` AS `campaign_launcher`, `t2`.`name` AS `campaign_launcher_username`, `t1`.`contact_phone` AS `contact_phone`, `t1`.`campaign_status` AS `campaign_status`, `t1`.`campaign_url` AS `campaign_url` FROM ((`t_campaign_info` `t1` left join `t_user` `t2` on(`t1`.`campaign_launcher` = `t2`.`employee_id`)) left join `t_campaign_info_pics` `t3` on(`t1`.`id` = `t3`.`campaign_id`))  ;

-- --------------------------------------------------------

--
-- Structure for view `v_class_detail`
--
DROP TABLE IF EXISTS `v_class_detail`;

CREATE ALGORITHM=UNDEFINED DEFINER=`user`@`%` SQL SECURITY DEFINER VIEW `v_class_detail`  AS SELECT `t_class`.`class_no` AS `class_no`, `t_class`.`class_name` AS `class_name`, `t_class`.`department_no` AS `department_no`, `t_class`.`status` AS `status` FROM `t_class``t_class`  ;

-- --------------------------------------------------------

--
-- Structure for view `v_class_schedule`
--
DROP TABLE IF EXISTS `v_class_schedule`;

CREATE ALGORITHM=UNDEFINED DEFINER=`user`@`%` SQL SECURITY DEFINER VIEW `v_class_schedule`  AS SELECT `t_class_schedule`.`id` AS `id`, `t_class_schedule`.`class_no` AS `class_no`, `t_class_schedule`.`course_no` AS `course_no`, `t_class_schedule`.`weeks` AS `weeks`, `t_class_schedule`.`day_of_week` AS `day_of_week`, `t_class_schedule`.`starting_period` AS `starting_period`, `t_class_schedule`.`lasting_periods` AS `lasting_periods`, `t_class_schedule`.`year` AS `year`, `t_class_schedule`.`semester` AS `semester`, `v_course_info`.`course_name` AS `course_name`, `v_course_info`.`course_place` AS `course_place`, `v_course_info`.`course_teacher_name` AS `course_teacher_name`, `v_course_info`.`course_credits` AS `course_credits` FROM (`t_class_schedule` join `v_course_info` on(`t_class_schedule`.`course_no` = `v_course_info`.`course_no`))  ;

-- --------------------------------------------------------

--
-- Structure for view `v_course_info`
--
DROP TABLE IF EXISTS `v_course_info`;

CREATE ALGORITHM=UNDEFINED DEFINER=`user`@`%` SQL SECURITY DEFINER VIEW `v_course_info`  AS SELECT `t_course`.`course_no` AS `course_no`, `t_course`.`course_name` AS `course_name`, `t_course`.`course_name_en` AS `course_name_en`, `t_course`.`course_duration` AS `course_duration`, `t_course`.`course_type` AS `course_type`, `t_course`.`course_desc` AS `course_desc`, `t_course`.`course_place` AS `course_place`, `t_course`.`course_status` AS `course_status`, `t_course`.`course_credits` AS `course_credits`, `t_course`.`course_textbook` AS `course_textbook`, `t_course`.`course_outline` AS `course_outline`, `t_course`.`course_teacher` AS `course_teacher`, `t_user`.`name` AS `course_teacher_name` FROM (`t_course` join `t_user` on(`t_course`.`course_teacher` = `t_user`.`employee_id`))  ;

-- --------------------------------------------------------

--
-- Structure for view `v_grade_detail`
--
DROP TABLE IF EXISTS `v_grade_detail`;

CREATE ALGORITHM=UNDEFINED DEFINER=`user`@`%` SQL SECURITY DEFINER VIEW `v_grade_detail`  AS SELECT `grade`.`id` AS `id`, `course_info`.`course_name` AS `course_name`, `course_info`.`course_credits` AS `course_credits`, `grade`.`user_id` AS `user_id`, `user`.`name` AS `name`, `grade`.`course_no` AS `course_no`, `grade`.`grade` AS `grade`, `grade`.`year` AS `year`, `grade`.`semester` AS `semester`, `grade`.`import_date` AS `import_date`, `grade`.`awaiting_revision` AS `awaiting_revision` FROM ((`t_grade` `grade` join `t_course` `course_info` on(`grade`.`course_no` = `course_info`.`course_no`)) join `t_user` `user` on(`grade`.`user_id` = `user`.`employee_id`))  ;

-- --------------------------------------------------------

--
-- Structure for view `v_login`
--
DROP TABLE IF EXISTS `v_login`;

CREATE ALGORITHM=UNDEFINED DEFINER=`user`@`%` SQL SECURITY DEFINER VIEW `v_login`  AS SELECT `t_login`.`username` AS `username`, `t_login`.`password` AS `password`, `t_user`.`role` AS `role`, `t_user`.`status` AS `status` FROM (`t_login` join `t_user` on(`t_login`.`username` = `t_user`.`employee_id`))  ;

-- --------------------------------------------------------

--
-- Structure for view `v_login_nopass`
--
DROP TABLE IF EXISTS `v_login_nopass`;

CREATE ALGORITHM=UNDEFINED DEFINER=`user`@`%` SQL SECURITY DEFINER VIEW `v_login_nopass`  AS SELECT `t_login`.`username` AS `employee_id`, `t_login`.`password` AS `password`, `tu`.`name` AS `name` FROM (`t_login` left join `t_user` `tu` on(`t_login`.`username` = `tu`.`employee_id`)) WHERE `t_login`.`password` is nullnull  ;

-- --------------------------------------------------------

--
-- Structure for view `v_user_student`
--
DROP TABLE IF EXISTS `v_user_student`;

CREATE ALGORITHM=UNDEFINED DEFINER=`user`@`%` SQL SECURITY DEFINER VIEW `v_user_student`  AS SELECT `t_user`.`id` AS `id`, `t_user`.`employee_id` AS `employee_id`, `t_user`.`picture_url` AS `picture_url`, `t_user`.`name` AS `name`, `t_user`.`class_no` AS `class_no`, `t_user`.`sex` AS `sex`, `t_user`.`residence_id` AS `residence_id`, `t_user`.`email` AS `email`, `t_user`.`phone` AS `phone`, `t_user`.`address` AS `address`, `t_user`.`second_contact` AS `second_contact`, `t_user`.`role` AS `role`, `t_user`.`status` AS `status`, `t_user`.`create_time` AS `create_time`, `t_user`.`school_id` AS `school_id`, `t_user`.`required_changing` AS `required_changing`, `t_user`.`estimated_graduate_time` AS `estimated_graduate_time` FROM `t_user` WHERE `t_user`.`role` = 33  ;

-- --------------------------------------------------------

--
-- Structure for view `v_user_teacher`
--
DROP TABLE IF EXISTS `v_user_teacher`;

CREATE ALGORITHM=UNDEFINED DEFINER=`user`@`%` SQL SECURITY DEFINER VIEW `v_user_teacher`  AS SELECT `t_user`.`id` AS `id`, `t_user`.`employee_id` AS `employee_id`, `t_user`.`picture_url` AS `picture_url`, `t_user`.`name` AS `name`, `t_user`.`sex` AS `sex`, `t_user`.`residence_id` AS `residence_id`, `t_user`.`email` AS `email`, `t_user`.`phone` AS `phone`, `t_user`.`address` AS `address`, `t_user`.`second_contact` AS `second_contact`, `t_user`.`role` AS `role`, `t_user`.`status` AS `status`, `t_user`.`create_time` AS `create_time`, `t_user`.`school_id` AS `school_id`, `t_user`.`required_changing` AS `required_changing` FROM `t_user` WHERE `t_user`.`role` = 22  ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `t_campaign_attendee`
--
ALTER TABLE `t_campaign_attendee`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `t_campaign_attendee_pk` (`campaign_id`,`attendee_id`),
  ADD UNIQUE KEY `t_campaign_attendee_pk2` (`attendee_id`,`campaign_id`,`check_in_status`);

--
-- Indexes for table `t_campaign_info`
--
ALTER TABLE `t_campaign_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `t_campaign_info_pk` (`campaign_name`,`campaign_description`,`campaign_location`,`campaign_time`,`campaign_launcher`,`contact_phone`,`campaign_status`,`campaign_url`) USING HASH,
  ADD KEY `t_campaign_info_t_user_employee_id_fk` (`campaign_launcher`);

--
-- Indexes for table `t_campaign_info_pics`
--
ALTER TABLE `t_campaign_info_pics`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `t_campaign_info_pics_pk2` (`campaign_id`,`picture_url`);

--
-- Indexes for table `t_campaign_subscription`
--
ALTER TABLE `t_campaign_subscription`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `t_class`
--
ALTER TABLE `t_class`
  ADD PRIMARY KEY (`class_no`),
  ADD KEY `t_class_t_department_department_no_fk` (`department_no`);

--
-- Indexes for table `t_class_manager_info`
--
ALTER TABLE `t_class_manager_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `t_class_manager_info_pk` (`class_no`,`employee_id`,`role`,`status`),
  ADD UNIQUE KEY `t_class_manager_info_pk2` (`class_no`,`employee_id`,`role`),
  ADD KEY `t_class_manager_info_t_employee_employee_id_fk` (`employee_id`);

--
-- Indexes for table `t_class_schedule`
--
ALTER TABLE `t_class_schedule`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `t_class_schedule_pk` (`course_no`,`day_of_week`,`starting_period`),
  ADD KEY `t_class_schedule_t_class_class_no_fk` (`class_no`);

--
-- Indexes for table `t_course`
--
ALTER TABLE `t_course`
  ADD PRIMARY KEY (`course_no`);

--
-- Indexes for table `t_department`
--
ALTER TABLE `t_department`
  ADD PRIMARY KEY (`department_no`);

--
-- Indexes for table `t_department_manager_info`
--
ALTER TABLE `t_department_manager_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `t_department_manager_info_pk` (`department_no`,`manager_no`,`status`),
  ADD UNIQUE KEY `t_department_manager_info_pk2` (`manager_no`,`department_no`);

--
-- Indexes for table `t_grade`
--
ALTER TABLE `t_grade`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `t_grade_pk` (`course_no`,`user_id`,`grade`,`year`,`semester`),
  ADD KEY `t_grade_t_user_employee_id_fk` (`user_id`);

--
-- Indexes for table `t_login`
--
ALTER TABLE `t_login`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `t_message_board`
--
ALTER TABLE `t_message_board`
  ADD PRIMARY KEY (`id`),
  ADD KEY `t_message_board_t_user_employee_id_fk` (`sender`);

--
-- Indexes for table `t_openid`
--
ALTER TABLE `t_openid`
  ADD PRIMARY KEY (`openid`);

--
-- Indexes for table `t_repair_data`
--
ALTER TABLE `t_repair_data`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `t_repair_data_pics`
--
ALTER TABLE `t_repair_data_pics`
  ADD PRIMARY KEY (`id`);

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
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `t_department`
--
ALTER TABLE `t_department`
  MODIFY `department_no` tinyint(4) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '部门编号', AUTO_INCREMENT=22;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `t_campaign_attendee`
--
ALTER TABLE `t_campaign_attendee`
  ADD CONSTRAINT `t_campaign_attendee_t_user_employee_id_fk` FOREIGN KEY (`attendee_id`) REFERENCES `t_user` (`employee_id`) ON UPDATE CASCADE;

--
-- Constraints for table `t_campaign_info`
--
ALTER TABLE `t_campaign_info`
  ADD CONSTRAINT `t_campaign_info_t_user_employee_id_fk` FOREIGN KEY (`campaign_launcher`) REFERENCES `t_user` (`employee_id`) ON UPDATE CASCADE;

--
-- Constraints for table `t_class`
--
ALTER TABLE `t_class`
  ADD CONSTRAINT `t_class_t_department_department_no_fk` FOREIGN KEY (`department_no`) REFERENCES `t_department` (`department_no`) ON UPDATE CASCADE;

--
-- Constraints for table `t_class_manager_info`
--
ALTER TABLE `t_class_manager_info`
  ADD CONSTRAINT `t_class_manager_info_t_class_class_no_fk` FOREIGN KEY (`class_no`) REFERENCES `t_class` (`class_no`) ON UPDATE CASCADE,
  ADD CONSTRAINT `t_class_manager_info_t_employee_employee_id_fk` FOREIGN KEY (`employee_id`) REFERENCES `t_user` (`employee_id`) ON UPDATE CASCADE;

--
-- Constraints for table `t_class_schedule`
--
ALTER TABLE `t_class_schedule`
  ADD CONSTRAINT `t_class_schedule_t_class_class_no_fk` FOREIGN KEY (`class_no`) REFERENCES `t_class` (`class_no`) ON UPDATE CASCADE,
  ADD CONSTRAINT `t_class_schedule_t_course_info_course_no_fk` FOREIGN KEY (`course_no`) REFERENCES `t_course` (`course_no`) ON UPDATE CASCADE;

--
-- Constraints for table `t_department_manager_info`
--
ALTER TABLE `t_department_manager_info`
  ADD CONSTRAINT `t_department_manager_info_t_department_department_no_fk` FOREIGN KEY (`department_no`) REFERENCES `t_department` (`department_no`) ON UPDATE CASCADE,
  ADD CONSTRAINT `t_department_manager_info_t_employee_employee_id_fk` FOREIGN KEY (`manager_no`) REFERENCES `t_user` (`employee_id`) ON UPDATE CASCADE;

--
-- Constraints for table `t_grade`
--
ALTER TABLE `t_grade`
  ADD CONSTRAINT `t_grade_t_course_info_course_no_fk` FOREIGN KEY (`course_no`) REFERENCES `t_course` (`course_no`) ON UPDATE CASCADE,
  ADD CONSTRAINT `t_grade_t_user_employee_id_fk` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`employee_id`) ON UPDATE CASCADE;

--
-- Constraints for table `t_login`
--
ALTER TABLE `t_login`
  ADD CONSTRAINT `t_login_t_user_employee_id_fk` FOREIGN KEY (`username`) REFERENCES `t_user` (`employee_id`) ON UPDATE CASCADE;

--
-- Constraints for table `t_message_board`
--
ALTER TABLE `t_message_board`
  ADD CONSTRAINT `t_message_board_t_user_employee_id_fk` FOREIGN KEY (`sender`) REFERENCES `t_user` (`employee_id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
