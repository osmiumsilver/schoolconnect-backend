package com.osmium.java.schoolconnect.backend.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Entity
@Data
@TableName("user")
public class User {
    private @Id @GeneratedValue long id; //系统唯一id
    private long employeeId; //员工 学生编号
    private String name; //姓名
    private String nickname; //昵称
    private Integer password;
    private Byte sex; //表示性别
    private String residenceId; //身份证号码等证件号
    private String email; //邮箱
    private String phone; //手机号码
    private String address; //地址
    private String secondContact; //QQ号码 微信号等第二联系方式
    private Byte role;  //身份表示 （教师 学生 来宾等）
    private Byte status; //状态表示（在校，离校等）
    private Date createTime; //创建时间
    private Date lastLoginTime; //最后登陆时间
    private String lastLoginIP; //最后登陆时间
    private String lastLoginLocation; //最后登陆地址
    private String avatar; //头像URL
}