package com.osmium.java.schoolconnect.backend.entity;

import lombok.Data;

@Data
public class User {
    private Integer userNo; // 用户编号
    private String username; //
    private String userSex;
    private byte sAge;
    private String phone;
    private String address;
    private String id; //独一无二ID
    private byte role;
    private byte status;
}