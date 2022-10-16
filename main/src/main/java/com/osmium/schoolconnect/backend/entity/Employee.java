package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

import java.util.Date;

/**
 * @Author
 * @Date 2022/10/16
 * @Description
 */
@Data
@TableName("employee")
public class Employee {
    private @Id long employeeId; //员工、学生编号
    private String name; //姓名
    private String classNo; // 所在班级编号
    private Byte sex; //表示性别 0:男 1:女 2:其他 3:秘密
    private String residenceId; //身份证号码等证件号
    private String email; //邮箱
    private String phone; //手机号码
    private String address; //地址
    private String secondContact; //QQ号码 微信号等第二联系方式
    private Byte role;  //身份表示 （教师 学生 来宾等）用户身份 0:超级 1:教师/教职工 2:学生 3：家长 4:其他 5:来宾
    private Byte status; //状态表示（在校，离校等）0:在校 1:离校 2开除 3:注销 4:其他
    private Date createTime; //创建时间
}
