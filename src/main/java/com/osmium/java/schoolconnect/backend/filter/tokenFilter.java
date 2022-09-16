package com.osmium.java.schoolconnect.backend.filter;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.osmium.java.schoolconnect.backend.utils.JwtUitls;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
  *@Description token校验过滤器
  *@Author ZL
  *@Date Created in 2022/9/17 00:18
 **/
public class tokenFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String url = ((HttpServletRequest) servletRequest).getRequestURI();
        Map map = new HashMap();
        if (url != null) {
            //登录请求直接放行
            if ("/login".equals(url)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                //其他请求验证token
                String token = ((HttpServletRequest) servletRequest).getHeader("token");
                if (StringUtils.isNotBlank(token)) {
                    //token验证结果
                    int verify = JwtUitls.verify(token);
                    if (verify != 1) {
                        //验证失败
                        if (verify == 2) {
                            map.put("errorMsg", "token已过期");
                        } else if (verify == 0) {
                            map.put("errorMsg", "用户信息验证失败");

                        }
                    } else if (verify == 1) {
                        //验证成功，放行
                        filterChain.doFilter(servletRequest, servletResponse);
                    }
                } else {
                    //token为空的返回
                    map.put("errorMsg", "未携带token信息");
                }
            }

        }
    }
}
