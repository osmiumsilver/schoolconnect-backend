-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 172.17.0.1
-- Generation Time: Mar 06, 2023 at 03:53 PM
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
  `campaign_id` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'campaign ID',
  `attendee_id` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `check_in_status` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `t_campaign_info`
--

CREATE TABLE `t_campaign_info` (
  `id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT uuid_short() COMMENT 'GENERATED ID',
  `campaign_name` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动名称',
  `campaign_description` blob DEFAULT NULL COMMENT '活动介绍',
  `campaign_location` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '活动位置',
  `campaign_time` datetime DEFAULT NULL COMMENT '时间',
  `campaign_launcher` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发起人',
  `campaign_status` tinyint(1) DEFAULT NULL COMMENT '状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `t_campaign_info`
--

INSERT INTO `t_campaign_info` (`id`, `campaign_name`, `campaign_description`, `campaign_location`, `campaign_time`, `campaign_launcher`, `campaign_status`) VALUES
('1630836060600786945', '此革产', 0x76656e69616d207175692063756c706120696e6369646964756e7420636f6d6d6f646f, 'magna dolor', '1981-02-14 15:20:35', '2200004002', 0),
('1630836100157267970', '么只物新自', 0x766f6c757074617465206164697069736963696e6720696e, 'ipsum', '1985-07-17 08:56:06', '2113504069', 0),
('1630836100169850882', '府农记', 0x726570726568656e6465726974206164206c61626f72697320646f20657374, 'non anim adipisicing', '1976-07-21 12:45:58', '2113504069', 0),
('1630836100169850883', '比干她导', 0x706172696174757220696e206d61676e61206465736572756e74, 'consectetur deserunt laboris do', '1998-06-04 23:00:35', '2113504069', 0),
('1630836112845037570', '用形广育天题流', 0x6d61676e6120646f20696e2073696e74, 'irure', '2016-05-14 04:52:31', '2113504069', 0),
('1630836112878592002', '究型门里节律', 0x717569, 'consequat aliquip eiusmod esse', '2017-08-15 08:31:11', '2113504069', 0),
('1630836112882786306', '千任群林深光', 0x657865726369746174696f6e20616c6971756120766f6c757074617465204c6f72656d20717569, 'cillum dolore ea aliquip', '2008-09-01 19:38:04', '2113504069', 0),
('1630836119564312578', '条天持米明', 0x696e2063756c7061, 'amet', '1977-03-12 12:46:20', '2113504069', 0),
('1630836119581089793', '流满拉无在', 0x6561, 'culpa', '1995-08-29 22:01:05', '2113504069', 0),
('1630836126216478722', '约大空说号没县', 0x646f6c6f722073696e7420637570696461746174, 'consequat et', '2010-09-30 14:44:51', '2113504069', 0);

-- --------------------------------------------------------

--
-- Table structure for table `t_class`
--

CREATE TABLE `t_class` (
  `class_no` varchar(7) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '班级编号  7位',
  `class_name` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '班级名称',
  `department_no` tinyint(4) UNSIGNED ZEROFILL DEFAULT NULL COMMENT '所在部门编号 4位',
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
('1678041', '测试班级1', 0002, 0),
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
('100185615223488534', '1678042', '000000000004', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `t_class_schedule`
--

CREATE TABLE `t_class_schedule` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT uuid_short() COMMENT 'GENERATED ID',
  `class_no` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '班级ID',
  `course_no` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程号',
  `weeks` tinyint(1) DEFAULT NULL COMMENT '星期',
  `lessons` tinyint(1) DEFAULT NULL COMMENT '节次',
  `year` int(4) NOT NULL,
  `semester` tinyint(1) DEFAULT NULL
) ;

--
-- Dumping data for table `t_class_schedule`
--

INSERT INTO `t_class_schedule` (`id`, `class_no`, `course_no`, `weeks`, `lessons`, `year`, `semester`) VALUES
('100185615223488537', '1678004', '9002602020', 1, 7, 2023, 1),
('100185615223488538', '1678004', '9002602021', 2, 2, 2023, 1);

-- --------------------------------------------------------

--
-- Table structure for table `t_course_attendee`
--

CREATE TABLE `t_course_attendee` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT uuid_short() COMMENT 'GENERATED ID',
  `attendee_id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学生ID',
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
  `course_type` tinyint(1) DEFAULT NULL COMMENT '课程类型 0 必修课	1 校公共选修课	2 限选课	3 任选课	4 集中性实践	5 课外培养必选	6 课外培养任选	7 通识课程必修',
  `course_desc` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程描述',
  `course_place` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '课程地点',
  `course_status` tinyint(1) DEFAULT NULL COMMENT '课程状态 0正常，1:不再开课',
  `course_credits` float DEFAULT NULL COMMENT '课程学分',
  `course_textbook` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '教材用书 可以为url 或者文字',
  `course_outline` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '教材大纲'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='课程表';

--
-- Dumping data for table `t_course_info`
--

INSERT INTO `t_course_info` (`course_no`, `course_name`, `course_name_en`, `course_duration`, `course_type`, `course_desc`, `course_place`, `course_status`, `course_credits`, `course_textbook`, `course_outline`) VALUES
('9002602020', '中华诗词之美', 'Beauty of Chinese Poetry', 32, 0, '好', '教学楼1号', 0, 2, NULL, NULL),
('9002602021', '课程2', '', 3, 0, '好', '教学楼12号', 0, 2, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `t_course_teacher`
--

CREATE TABLE `t_course_teacher` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT uuid_short() COMMENT 'GENERATED ID',
  `teacher_id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `course_no` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='参与课程的教师表';

--
-- Dumping data for table `t_course_teacher`
--

INSERT INTO `t_course_teacher` (`id`, `teacher_id`, `course_no`) VALUES
('100185615223488529', '000000000005', '9002602020'),
('100185615223488603', '000000000004', '9002602021'),
('100185615223488604', '000000000005', '9002602021');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='部门负责人信息';

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
('100185615223488518', '2113504069', '9002602021', 100, 2023, 1, '2023-02-22 00:00:00', 0),
('100185615223488523', '2200004002', '9002602021', 100, 2023, 1, '2023-02-22 00:00:00', 0),
('100185615223488525', '2200004002', '9002602020', 100, 2023, 2, '2023-02-22 00:00:00', 0);

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
('000000000004', '$2a$10$4uJOmfARoJgFKZTL2rAlT.g70Bh2yGNY/33GXKh7jW1gyH.1BPoM6'),
('000000000005', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('000000000006', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy'),
('2113504069', '$2a$10$4uJOmfARoJgFKZTL2rAlT.g70Bh2yGNY/33GXKh7jW1gyH.1BPoM6'),
('2200004002', '$2a$10$Nu62XKUcdbK.5s.fyQymZeg4Ex4lf1jKEi.aeSgiEeNUH8af.UYvy');

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
  `submitted_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `t_message_board`
--

INSERT INTO `t_message_board` (`id`, `title`, `body`, `assigned_department`, `sender`, `type`, `submitted_date`) VALUES
('1630966059559288834', '次响日自性', 0x616e696d20646f6c6f72206561, 'ipsum est', '2113504069', 1, '2019-03-25 23:50:58'),
('1630966059714478082', '况种方土国许真', 0x696e6369646964756e7420616420757420717569, 'elit sunt', '2113504069', 1, '2015-01-26 13:37:47'),
('1630966059714478083', '满育标造加格现', 0x7574207369742065752073696e7420657865726369746174696f6e, 'aute ea velit', '2113504069', 2, '2014-12-14 08:07:38');

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
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别 0:M 1:F 2:O',
  `residence_id` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证号',
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机',
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址',
  `second_contact` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '第二联系方式',
  `role` tinyint(1) NOT NULL DEFAULT 4 COMMENT '用户身份 0:超级 1:教职工/管理层 2:教师 3:学生 4:其他',
  `status` tinyint(4) NOT NULL DEFAULT 3 COMMENT '用户状态 0:在校 1:离校 2 开除 3:其他',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `school_id` tinyint(5) NOT NULL,
  `required_changing` tinyint(1) DEFAULT NULL COMMENT '是否需要修改 0为不需要 1为需要 2为审核中'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

--
-- Dumping data for table `t_user`
--

INSERT INTO `t_user` (`id`, `employee_id`, `picture_url`, `name`, `class_no`, `sex`, `residence_id`, `email`, `phone`, `address`, `second_contact`, `role`, `status`, `create_time`, `school_id`, `required_changing`) VALUES
('5ecc867f3297c5e10898980f823490e6', '000000000001', NULL, '校长姚', NULL, 0, '32050319680212032X', 'dean@school.com', '13798765932', '江苏省苏州市姑苏区平江路1号', 'weicvivwvb', 1, 0, '2022-12-05 15:34:34', 1, 0),
('62c8b9a03b55defae9f74ff18ee7a2ac', '000000000002', NULL, '老师李', NULL, 1, '32050119730814618X', 't@school.com', '18894691145', '江苏省苏州市姑苏区平江路1号', 'nfiaufvgff', 2, 0, '2022-12-05 15:36:09', 1, 0),
('253c3a81f642bfe6fe0a5729a5514b0b', '000000000003', NULL, '超管', NULL, 0, '32528u502735023582', 'super@school.com', '312983461294', '江苏省苏州市姑苏区平江路1号', NULL, 0, 0, '2022-12-05 15:36:46', 1, 0),
('d162a354a4d7790466778afecdb2ce54', '000000000004', NULL, '辅导员林', NULL, 1, '320501194189471029', 'lin@school.com', '124it1i24yo', '江苏省苏州市姑苏区平江路1号', 'fhfuwebfwefwechat', 1, 0, '2022-12-06 20:21:37', 1, 0),
('4d8e37166077fbe7ceaf48015cdc30e6', '000000000005', NULL, 'A老师', NULL, 0, NULL, NULL, NULL, NULL, NULL, 4, 3, '2023-02-22 17:07:40', 1, 0),
('4aa4bf2f9a07d9f326bb9e856172aa5e', '000000000006', NULL, 'B老师', NULL, 1, NULL, NULL, NULL, NULL, NULL, 4, 3, '2023-02-22 17:07:41', 1, 0),
('100185615223488569', '167804202', 'http://dummyimage.com/160x600', '黎秀英', '1678042', 2, '48405819540214193x', 'k.gpjjkr@yvvty.ms', '18624476631', '西藏自治区 山南地区 措美县', '575719', 0, 3, '2023-02-22 14:39:58', 1, 1),
('100185615223488594', '167804212', 'http://dummyimage.com/125x125', '刘涛', '1678042', 1, '36358318471130593X', 'p.llqhplbtf@xlhikjtl.asia', '18673673113', '陕西省 咸阳市 三原县', '845862', 1, 3, NULL, 1, 0),
('100185615223488557', '167804222', 'http://dummyimage.com/120x600', '贾娜', '1678042', 1, '44726418130115656X', 'l.mlrgujzoq@bzkoqsr.cc', '18139772630', '陕西省 榆林市 神木县', '18181126', 0, 1, '2023-02-22 14:39:58', 1, 1),
('100185615223488560', '167804226', 'http://dummyimage.com/120x60', '文洋', '1678042', 0, '288636203310254592', 'n.fmplyjyr@hyyzkxnid.gh', '19861151410', '香港特别行政区 九龙 观塘区', '589716', 3, 2, '2023-02-22 14:39:59', 1, 1),
('100185615223488556', '167804228', 'http://dummyimage.com/125x125', '白艳', '1678042', 0, '23562518411210382x', 's.jbfopv@krivvl.tw', '18642238145', '台湾 高雄市 杉林区', '5285742', 3, 2, '2023-02-22 00:00:00', 1, 0),
('100185615223488562', '167804231', 'http://dummyimage.com/88x31', '崔勇', '1678042', 2, '86805118611010807x', 'n.nrqmptce@nyswejko.bz', '18195609533', '福建省 漳州市 龙海市', '4947828615', 3, 2, '2023-02-22 14:39:51', 1, 2),
('100185615223488568', '167804234', 'http://dummyimage.com/468x60', '宋洋', '1678042', 2, '23482118640910468x', 'k.whxshyhxr@dltrbb.ro', '18126196864', '云南省 临沧市 永德县', '29870531', 3, 3, '2023-02-22 14:39:58', 1, 2),
('100185615223488558', '167804237', 'http://dummyimage.com/234x60', '邱杰', '1678042', 2, '11277319621102937X', 'b.eitxy@scb.ad', '18158749415', '山西省 晋城市 泽州县', '780185534', 1, 1, '2023-02-22 14:39:58', 1, 1),
('100185615223488579', '167804244', 'http://dummyimage.com/240x400', '刘秀英', '1678042', 1, '51788620161230284x', 'q.rogckt@mtxwb.ec', '19814344138', '河北省 沧州市 盐山县', '7545542', 0, 2, NULL, 1, 0),
('100185615223488567', '167804245', 'http://dummyimage.com/120x600', '彭超', '1678042', 0, '64773720021031953X', 'g.hfqboyt@svetgo.cy', '18666232727', '河北省 廊坊市 安次区', '24751', 2, 3, '2023-02-22 14:39:58', 1, 2),
('100185615223488571', '167804256', 'http://dummyimage.com/125x125', '陈静', '1678042', 0, '624957199012078480', 'e.ypvwswy@ygdpcggwz.ad', '19814673701', '福建省 龙岩市 上杭县', '7163851', 0, 3, '2023-02-22 14:39:58', 1, 2),
('100185615223488566', '167804262', 'http://dummyimage.com/336x280', '贾秀英', '1678042', 1, '773330186612207393', 'f.nkzi@espntuibh.cz', '18186362873', '香港特别行政区 九龙 观塘区', '84661946', 4, 1, '2023-02-22 14:39:58', 1, 1),
('100185615223488565', '167804265', 'http://dummyimage.com/120x600', '丁洋', '1678042', 1, '517896196103107503', 'v.jcuq@ggjlwhm.coop', '13444855585', '安徽省 黄山市 休宁县', '4877259', 3, 1, '2023-02-22 14:39:58', 1, 2),
('100185615223488595', '167804272', 'http://dummyimage.com/120x600', '任娟', '1678042', 1, '44821818020410360x', 'h.oslg@qytw.jm', '19824422824', '内蒙古自治区 乌海市 乌达区', '77696228', 3, 1, NULL, 1, 2),
('100185615223488570', '167804273', 'http://dummyimage.com/120x240', '邱娟', '1678042', 1, '64162520940408517x', 'f.swxcuwqd@ndixf.ae', '18152496782', '河北省 秦皇岛市 抚宁县', '1989363', 2, 1, '2023-02-22 14:39:58', 1, 2),
('100185615223488564', '167804278', 'http://dummyimage.com/125x125', '谭超', '1678042', 1, '33183218640723983X', 'a.widvk@mmskocch.ec', '18144315855', '新疆维吾尔自治区 阿克苏地区 新和县', '5682128', 2, 1, '2023-02-22 14:39:58', 1, 1),
('100185615223488559', '167804279', 'http://dummyimage.com/468x60', '孔强', '1678042', 1, '34188920790808145X', 'u.voqrd@gnwrnlqu.be', '18172094143', '香港特别行政区 新界 西贡区', '886177101', 1, 0, '2023-02-22 14:39:58', 1, 1),
('100185615223488555', '167804283', 'http://dummyimage.com/120x60', '万霞', '1678042', 1, '378035187010207740', 's.inhoedgwh@qjvnx.dk', '19867042761', '云南省 玉溪市 新平彝族傣族自治县', '48614882', 0, 0, '2023-02-22 14:39:58', 1, 2),
('100185615223488561', '167804288', 'http://dummyimage.com/240x400', '邓娜', '1678042', 1, '38776120360920019X', 'b.ekzdmp@ukqopcz.cy', '18697487458', '西藏自治区 山南地区 琼结县', '884630', 1, 0, '2023-02-22 14:39:58', 1, 1),
('100185615223488563', '167804294', 'http://dummyimage.com/250x250', '梁丽', '1678042', 0, '665826204508286613', 'h.pkdla@avmeenm.ec', '13458898602', '上海 上海市 金山区', '6357224', 1, 1, '2023-02-22 14:39:58', 1, 1),
('100210128698998823', '2113504069', NULL, '姚博乾', '1678042', 0, '320503200000000000', 'osmium@hotmail.com', '1234567890', '江苏省苏州市姑苏区平江路1号', '12312312313123131', 0, 0, '2023-03-03 17:08:22', 0, 0),
('100210128698998822', '2200004002', NULL, '张三', '1678042', 0, '320503200000012028', 'hello@example.com', '13813838438', '江苏省苏州市姑苏区平江路1号', '3444444332', 1, 1, '2022-09-28 13:07:36', 1, 0);

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
,`course_no` varchar(32)
,`grade` float
,`year` int(4)
,`semester` tinyint(1)
,`import_date` datetime
);

-- --------------------------------------------------------

--
-- Structure for view `v_grade_detail`
--
DROP TABLE IF EXISTS `v_grade_detail`;

CREATE ALGORITHM=UNDEFINED DEFINER=`user`@`%` SQL SECURITY DEFINER VIEW `v_grade_detail`  AS SELECT `grade`.`id` AS `id`, `course_info`.`course_name` AS `course_name`, `course_info`.`course_credits` AS `course_credits`, `grade`.`user_id` AS `user_id`, `grade`.`course_no` AS `course_no`, `grade`.`grade` AS `grade`, `grade`.`year` AS `year`, `grade`.`semester` AS `semester`, `grade`.`import_date` AS `import_date` FROM (`t_grade` `grade` join `t_course_info` `course_info` on(`grade`.`course_no` = `course_info`.`course_no`))  ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `t_campaign_attendee`
--
ALTER TABLE `t_campaign_attendee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `t_campaign_attendee_t_user_employee_id_fk` (`attendee_id`);

--
-- Indexes for table `t_campaign_info`
--
ALTER TABLE `t_campaign_info`
  ADD PRIMARY KEY (`id`),
  ADD KEY `t_campaign_info_t_user_employee_id_fk` (`campaign_launcher`);

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
  ADD KEY `t_class_schedule_t_class_class_no_fk` (`class_no`),
  ADD KEY `t_class_schedule_t_course_info_course_no_fk` (`course_no`);

--
-- Indexes for table `t_course_attendee`
--
ALTER TABLE `t_course_attendee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `t_course_attendee_t_user_employee_id_fk` (`attendee_id`);

--
-- Indexes for table `t_course_info`
--
ALTER TABLE `t_course_info`
  ADD PRIMARY KEY (`course_no`);

--
-- Indexes for table `t_course_teacher`
--
ALTER TABLE `t_course_teacher`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `t_course_teacher_pk` (`course_no`,`teacher_id`),
  ADD UNIQUE KEY `t_course_teacher_pk2` (`teacher_id`,`course_no`);

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
  ADD CONSTRAINT `t_class_schedule_t_course_info_course_no_fk` FOREIGN KEY (`course_no`) REFERENCES `t_course_info` (`course_no`) ON UPDATE CASCADE;

--
-- Constraints for table `t_course_attendee`
--
ALTER TABLE `t_course_attendee`
  ADD CONSTRAINT `t_course_attendee_t_user_employee_id_fk` FOREIGN KEY (`attendee_id`) REFERENCES `t_user` (`employee_id`);

--
-- Constraints for table `t_course_teacher`
--
ALTER TABLE `t_course_teacher`
  ADD CONSTRAINT `t_course_teacher_t_course_info_course_no_fk` FOREIGN KEY (`course_no`) REFERENCES `t_course_info` (`course_no`),
  ADD CONSTRAINT `t_course_teacher_t_user_employee_id_fk` FOREIGN KEY (`teacher_id`) REFERENCES `t_user` (`employee_id`) ON UPDATE CASCADE;

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
  ADD CONSTRAINT `t_grade_t_course_info_course_no_fk` FOREIGN KEY (`course_no`) REFERENCES `t_course_info` (`course_no`) ON UPDATE CASCADE,
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
