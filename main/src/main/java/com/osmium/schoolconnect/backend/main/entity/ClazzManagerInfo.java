package com.osmium.schoolconnect.backend.main.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author
 * @Date 2023/1/8
 * @Description
 */
@Data
@TableName("t_class_manager_info")
public class ClazzManagerInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String classNo; //班级编号
    private String employeeId; //管理人员编号
    private byte role; //0 班主任 1 辅导员
    private byte status; //0 正常 1 离开
}
