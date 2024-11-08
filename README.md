# Welcome to SchoolConnect

## 用现代的技术栈 编写一个学校信息管理系统

Java 17 + Spring Boot 3.0.6 + Spring Security 6.0.3 w/ OAuth2 Resource Server + Jwt EasyAuth™️ (by Nimbus JOSE + JWT)

Undertow Servlet + MyBatis-Plus 3.5.3.1 + HikariCP 5.0.1 + Hutool+Ruoyi-common包

WebSocket + GraphQL (学习中)


数据持久化 MariaDB + Redis

开发本项目的过程中尝试使用最新的技术与最新的语法，写最少的代码的同时能完成更多工作。

This project is to try to adopt the latest technology and the syntax brought by Java 17 and
Spring Boot 3.x by learning along during the development, reduce boilerplate code and complexity as much as possible.

**Write less, do more.**

本系统的主要模块包括：

1. 身份绑定：该小程序获取用户微信名称与头像等相关信息 在初次登录时，通过将微信账户与教工或学生在系统中的身份账户直接绑定，微信直接打开小程序则自动登录，立即使用小程序的各类功能。
2. 个人信息管理模块：用户可在个人信息页面设置和修改个人的信息，如姓名、电话、地址等。
3. 学籍管理：该功能可以实现学生查看自己并维护的学籍信息，方便教师以及教务员对学生信息的收集与整理。
4. 成绩管理：学生可以在此查看在校所获得的绩点，分数，专业计划完成情况等。教师可以在此修改，导入学生的成绩情况。
5. 课程管理：该功能可以实现学生查看自己当前以及过去所有学期的课表，方便学生安排时间。可以设定课前提醒，不再错过上课。同时教务员可以安排教务进程，安排课程。
6. 活动管理：该功能可以实现对于大学生各类活动的技术支持，包括信息发布、报名信息收集，活动状态等。
7. 公共区域：师生可在此模块中查看各个系部所发布的重要公告。此功能与微信推送服务相整合，不错过重要信息。
8. 公众服务：在这里提供全校师生以及来宾用户都可以使用的生活服务，如寄收快递、打印服务、外卖送货等。
