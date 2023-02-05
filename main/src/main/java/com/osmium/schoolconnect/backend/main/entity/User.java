package com.osmium.schoolconnect.backend.main.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@TableName("t_user")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @TableId("employee_id")
    private String employeeId; //工号
    private String userId; //Generated ID
    private String pictureUrl; //照片URL
    private String name; //姓名
    private String classNo; //所在班级编号
    private Byte sex; //表示性别 0:男 1:女 2:其他 3:秘密
    private String residenceId; //身份证号码等证件号
    private String email; //邮箱
    private String phone; //手机号码
    private String address; //地址
    private String secondContact; //第二联系方式
    private Byte role;  // 0:本校 1:非本校
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime; //创建时间
    private LocalDateTime lastLoginTime; //最后登陆时间
    private String lastLoginIp; //最后登陆时间
    private String lastLoginLocation; //最后登陆地址
    private String avatar; //头像URL
}