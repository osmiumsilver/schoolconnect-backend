package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

import java.util.Date;


@Data
@TableName("t_sys_user")
public class User {
    @TableId("user_id")
    private String userId; //Generated ID
    private @Id long employeeId; //员工、学生编号
    private String realname; //姓名
    private String nickname; //昵称
    private Byte sex; //表示性别 0:男 1:女 2:其他 3:秘密
    private String residenceId; //身份证号码等证件号
    private String email; //邮箱
    private String phone; //手机号码
    private String address; //地址
    private Byte role;  // 0:本校 1:非本校
    private Date createTime; //创建时间
    private Date lastLoginTime; //最后登陆时间
    private String lastLoginIp; //最后登陆时间
    private String lastLoginLocation; //最后登陆地址
    private String avatar; //头像URL
}