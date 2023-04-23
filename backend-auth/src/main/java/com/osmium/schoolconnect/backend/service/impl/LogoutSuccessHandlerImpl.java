package com.osmium.schoolconnect.backend.service.impl;


import com.alibaba.fastjson.JSON;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.ServletUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;



/**
 * @Author
 * @Date 2023/4/15
 * @Description
 */
@Service
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        ServletUtils.renderString((javax.servlet.http.HttpServletResponse) response, JSON.toJSONString(AjaxResult.success("退出成功")));
    }
}
