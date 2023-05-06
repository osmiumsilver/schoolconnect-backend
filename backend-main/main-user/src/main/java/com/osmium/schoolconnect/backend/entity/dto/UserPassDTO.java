package com.osmium.schoolconnect.backend.entity.dto;

import lombok.Data;

/**
 * @Author
 * @Date 2023/4/5
 * @Description
 */
@Data
public class UserPassDTO {
    private String employeeId; //工号
    private String oldPass;
    private String newPass;
}
