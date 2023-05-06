package com.osmium.schoolconnect.backend.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author
 * @Date 2023/4/15
 * @Description
 */
@Data
@TableName("v_login_nopass")
public class UninitializedUsers {
    @TableId
    private String employeeId;
    private String name;
}
