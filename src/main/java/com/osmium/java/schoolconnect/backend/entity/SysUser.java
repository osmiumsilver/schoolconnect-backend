package com.osmium.java.schoolconnect.backend.entity;

import lombok.Data;


@Data
public class SysUser {
    private String id; //独一无二ID
    private String nickname; //昵称
    private String username; // 用户名
    private String password; // 密码
    private String email; //邮箱
    private String phone; // 手机号
    private byte role; //0:系统管理员 1:教师/教职工 2：学生 3：家长 4：其他
    private byte status; //0：正常 1:异常 2：已经结束任期 2：已经注销
    private String createTime; //创建时间
    private String lastLoginTime; //最后登录时间
    private String lastLoginIp; //最后登录IP
    private String lastLoginLocation; //最后登录地点
    private String avatar; //头像

}