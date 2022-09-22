package com.osmium.java.schoolconnect.backend.controller;


import com.osmium.java.schoolconnect.backend.entity.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController{

    /*-------------------------------- 用户 -----------------------------------*/
    @Resource
    @RequestMapping (value="addUser", method = RequestMethod.POST)
    //插入用户
    protected void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    //删除用户
    protected void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    //修改用户
    protected void alterUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    /*-------------------------------- 院系-----------------------------------*/
    protected void addDepartment(HttpServletResponse response)
            throws IOException {
    }

    // 插入院系
    protected void insert_department(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

    }

    // 删除院系
    protected void delete_department(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
    }

    // 修改院系
    protected void alter_department(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

    }

    /*-------------------------------- 班级-----------------------------------*/
    // 查询所有班级
    protected void query_all_class(HttpServletResponse response)
            throws IOException {

    }

    // 插入班级
    protected void insert_class(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

    }

    // 删除班级
    protected void delete_class(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

    }

    // 修改班级
    protected void alter_class(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

    }

    /*-------------------------------- 学生-----------------------------------*/

    // 插入学生
    protected void insert_student(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
    }

    // 删除学生
    protected void delete_student(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

    }

    // 修改学生信息
    protected void alter_student(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

    }

    /*-------------------------------- 课程 -----------------------------------*/
    //查询课程平均分
    protected void course_avg(HttpServletResponse response) throws IOException {

    }

    //查询课程不及格率
    protected void fail_rate(HttpServletResponse response) throws IOException {
    }

    // 查询课程排名
    protected void course_ranking(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    //查询所有课程
    protected void query_all_course(HttpServletResponse response) throws IOException {

    }

    //插入课程
    protected void insert_course(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    //删除课程
    protected void delete_course(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    //修改课程信息
    protected void alter_course(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

    }

    /*-------------------------------- 成绩-----------------------------------*/
    // 查询所有成绩表
    protected void query_all_sc(HttpServletResponse response)
            throws IOException {

    }

    // 插入一条成绩记录
    protected void insert_sc(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

    }

    // 删除成绩记录
    protected void delete_sc(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

    }

    // 修改成绩信息
    protected void alter_sc(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

    }

}
