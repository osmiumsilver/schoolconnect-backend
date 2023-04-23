package com.osmium.schoolconnect.backend.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@TableName("t_user LEFT JOIN t_class ON t_user.class_no = t_class.class_no")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @TableId("employee_id")
    @Excel(name = "工号")
    private String employeeId; //工号
    private String id; //Generated ID

    @Excel(name = "照片URL")
    private String pictureUrl; //照片URL

    @Excel(name = "姓名")
    private String name; //姓名

    @TableField("t_user.class_no")
    @Excel(name = "班级编号")
    private String classNo; //所在班级编号

    @Excel(name = "班级名称")
    private String className; //所在班级名称

    @Excel(name = "性别", replace = {"男_0", "女_1 "})
    private Byte sex; //表示性别 0:男 1:女

    @Excel(name = "身份证号码")
    private String residenceId; //身份证号码等证件号

    @Excel(name = "邮箱")
    private String email; //邮箱

    @Excel(name = "手机号")
    private String phone; //手机号码

    @Excel(name = "地址")
    private String address; //地址

    @Excel(name = "第二联系方式")
    private String secondContact; //第二联系方式

    @Excel(name="角色")
    private Byte role;  // 0:本校 1:非本校


    @TableField("t_user.status")
    @Excel(name="状态")
    private Byte status; //状态

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime createTime; //创建时间


    private int schoolId;//所在学校ID


    @TableField("required_changing")
    private Byte requiredChanging;//是否需要修改 0为不需要 1为需要 2为审核中

    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField("estimated_graduate_time")
    @Excel(name="预计毕业时间")
    private LocalDate estimatedGraduateTime;

}