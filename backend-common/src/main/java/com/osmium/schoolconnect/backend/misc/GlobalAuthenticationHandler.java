package com.osmium.schoolconnect.backend.misc;

import cn.hutool.json.JSONUtil;
import com.osmium.schoolconnect.backend.misc.Result;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author
 * @Date 2023/2/19
 * @Description
 */
//@Configuration
@Component
public class GlobalAuthenticationHandler {
    private GlobalAuthenticationHandler() {
    }

    public static class CustomizedAccessDeniedHandler implements AccessDeniedHandler {

        @Override
        public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
            response.setContentType("application/json;charset=UTF-8");
            response.setHeader("WWW-Authenticate", "NO-AUTH"); //这条非常重要 可以防治
            response.setStatus(401);
            //按照系统自定义结构返回授权失败
            response.getWriter().write(JSONUtil.toJsonStr(Result.error(ResultCode.AUTH_UNAUTHORIZED)));
        }
    }

    public static class CustomizedAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
        /**
         * Used to make customizable error messages and codes when login fails
         */
        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response,
                             AuthenticationException authException) throws IOException {
            response.setContentType("application/json;charset=UTF-8");
            response.setHeader("WWW-Authenticate", "NO-AUTH"); //这条非常重要 可以防治
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            //按照系统自定义结构返回授权失败
            response.getWriter().write(JSONUtil.toJsonStr(Result.error(ResultCode.AUTH_UNAUTHORIZED)));
        }



        @Override
        public void afterPropertiesSet() {
            setRealmName("norealm");
            super.afterPropertiesSet();
        }
    }
}
