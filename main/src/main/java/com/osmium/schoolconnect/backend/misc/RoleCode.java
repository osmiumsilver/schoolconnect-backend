package com.osmium.schoolconnect.backend.misc;

/**
 * @Author Abel
 * @Date 2022/9/20
 * @Description 角色代码
 */
public enum RoleCode {
    SUPER("0","超级管理员"),
    ADMINISTRATIVE("1", "教职工"),
    TEACHER("2", "教师"),
    STUDENT("3", "学生"),
    OTHER("4","其他"),
    GUEST("5","来宾");

    RoleCode(String code, String role) {
    }
}
