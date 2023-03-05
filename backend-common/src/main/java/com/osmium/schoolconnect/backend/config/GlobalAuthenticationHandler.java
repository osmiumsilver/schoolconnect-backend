package com.osmium.schoolconnect.backend.config;

import cn.hutool.json.JSONUtil;
import com.osmium.schoolconnect.backend.misc.Result;
import com.osmium.schoolconnect.backend.misc.ResultCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

/**
 * @Author
 * @Date 2023/2/19
 * @Description
 */
@Configuration

public class GlobalAuthenticationHandler {
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomizedAccessDeniedHandler();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new CustomizedAuthenticationEntryPoint();
    }

    public static class CustomizedAccessDeniedHandler implements AccessDeniedHandler {

        @Override
        public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(401);
            //按照系统自定义结构返回授权失败
            response.getWriter().write(JSONUtil.toJsonStr(Result.error(ResultCode.AUTH_UNAUTHORIZED)));
        }
    }

    static class CustomizedAuthenticationEntryPoint implements AuthenticationEntryPoint {

        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response,
                             AuthenticationException authException) throws IOException {
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(401);
            //按照系统自定义结构返回授权失败
            response.getWriter().write(JSONUtil.toJsonStr(Result.error(ResultCode.AUTH_UNAUTHORIZED)));
        }
    }
}
