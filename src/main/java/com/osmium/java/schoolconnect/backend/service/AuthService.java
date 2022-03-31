package com.osmium.java.schoolconnect.backend.service;

import com.osmium.java.schoolconnect.backend.entity.SysUser;

import javax.servlet.http.HttpSession;

/**
 * @author
 * @date 2022/3/29
 * @apinote
 */
public interface AuthService {
    void register(Integer ,String name, String password);
    SysUser login(HttpSession session);;
}
