package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String id; //Generated ID
    private String pictureUrl; //照片URL
    private String name; //姓名
    private String classNo; //所在班级编号
    private Byte sex; //表示性别 0:男 1:女 2:其他 3:秘密
    private String residenceId; //身份证号码等证件号
    private String email; //邮箱
    private String phone; //手机号码
    private String address; //地址
    private String secondContact; //第二联系方式
    private byte role;  // 0:本校 1:非本校

    private byte status; //状态
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime createTime; //创建时间


    private int schoolId;//所在学校ID
    @TableField("required_changing")
    private byte requiredChanging;//是否需要修改 0为不需要 1为需要 2为审核中

}