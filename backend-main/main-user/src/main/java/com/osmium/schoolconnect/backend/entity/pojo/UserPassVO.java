package com.osmium.schoolconnect.backend.entity.pojo;

import lombok.Data;

/**
 * @Author
 * @Date 2023/4/5
 * @Description
 */
@Data
public class UserPassVO {
    private String employeeId; //工号
    private String oldPass;
    private String newPass;
}
