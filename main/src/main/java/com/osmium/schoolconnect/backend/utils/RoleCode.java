package com.osmium.schoolconnect.backend.utils;

/**
 * @Author Abel
 * @Date 2022/9/20
 * @Description 角色代码
 */
public enum RoleCode {
    TEACHER("1", "教师"),
    STUDENT("2", "学生"),
    ADMINISTRATIVE("3", "超级管理员");

    private final String code;
    private final String role;
    RoleCode(String code, String role) {
        this.code = code;
        this.role = role;
    }
}
