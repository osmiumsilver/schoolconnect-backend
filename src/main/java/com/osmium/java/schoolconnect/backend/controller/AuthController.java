package com.osmium.java.schoolconnect.backend.controller;

import com.osmium.java.schoolconnect.backend.service.impl.UserDao;
import com.osmium.java.schoolconnect.backend.entity.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/api/auth")

public class AuthController{
    @Resource
    UserService service;



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String level;
        //实例化UserDao对象

        SysUser sysUser = new UserDao().login(username, Encryptor.MD5Encrypt(password));
        //判断是否登录成功
        if (sysUser != null) {//成功
            level = sysUser.getLevel();
            if (level.equals("用户")) {
                request.getSession().setAttribute("user", sysUser);//将用户对象放到session中
                //转发到user.jsp中
                response.sendRedirect(request.getContextPath() + "/user.jsp");

                //  request.getRequestDispatcher("user.jsp").forward(request, response);
            } else {
                request.getSession().setAttribute("admin", sysUser);//将管理员对象放到session中
                //转发到admin.jsp中
                //  request.getRequestDispatcher("admin.jsp").forward(request, response);

                response.sendRedirect(request.getContextPath() + "/admin.jsp");
            }
        } else {//失败
            response.setCharacterEncoding("gb2312");
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<script charset=\"gb2312\" type=\"text/javascript\">");
            out.println("alert(' 错误:用户名或密码错误！');");
            out.println("window.location.href = \"index.html\";");
            out.println("</script>");

        }
    }

}
