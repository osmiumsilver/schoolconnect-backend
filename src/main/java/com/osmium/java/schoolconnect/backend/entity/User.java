package com.osmium.java.schoolconnect.backend.entity;

import java.util.Date;
import lombok.Data;

@Data
public class User {
    private String id;

    private Integer userno;

    private Integer clno;

    private Byte sex;

    private String idnumber;

    private String realname;

    private String email;

    private String phone;

    private String address;

    private String qq;

    private Byte role;

    private Byte status;

    private Date createtime;
}