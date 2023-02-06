package com.osmium.schoolconnect.backend.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.osmium.schoolconnect.backend.auth.entity.Login;
import com.osmium.schoolconnect.backend.auth.entity.UsernamePassword;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @Author
 * @Date 2022/12/7
 * @Description
 */

public interface ILoginService extends IService<Login> {
    UsernamePassword login(String username, String password);

Login getUserById(String username);
    UserDetails loadUserByUsername(String username);
}
