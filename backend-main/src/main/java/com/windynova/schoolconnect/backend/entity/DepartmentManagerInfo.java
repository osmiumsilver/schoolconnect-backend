package com.osmium.schoolconnect.backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("t_department_manager_info")

public class DepartmentManagerInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @TableId()
    private Long id;
    private String departmentNo;
    private String managerNo; //部门负责人编号
    private byte status; //状态
}
