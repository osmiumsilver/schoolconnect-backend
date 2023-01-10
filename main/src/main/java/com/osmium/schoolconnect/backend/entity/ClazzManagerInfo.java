package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author
 * @Date 2023/1/8
 * @Description
 */
@Data
@TableName("t_class_manager_info")
public class ClazzManagerInfo {
    private String classNo; //班级编号
    private String employeeId; //管理人员编号
    private byte role; //0 班主任 1 辅导员
    private byte status; //0 正常 1 离开
}
