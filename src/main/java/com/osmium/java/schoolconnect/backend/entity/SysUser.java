package com.osmium.java.schoolconnect.backend.entity;

import java.util.Date;
import lombok.Data;

@Data
public class SysUser {
    private String id;

    private String realname;

    private String nickname;

    private String username;

    private String password;

    private String email;

    private String phone;

    private Byte role;

    private Byte status;

    private Date createtime;

    private Date lastlogintime;

    private String lastloginip;

    private String lastloginlocation;

    private String avatar;
}