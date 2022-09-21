package com.osmium.java.schoolconnect.backend.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author
 * @date 2022/3/29
 * @apinote
 */
@Service
public class AuthServiceImpl {
    @Resource
    private SysUserMapper sysUserMapper;

    @Transactional
    @Override
    public Action login(HttpSession session){

    }
}
