package com.osmium.schoolconnect.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.osmium.schoolconnect.backend.entity.Login;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @Author
 * @Date 2022/12/7
 * @Description
 */

public interface ILoginService extends IService<Login> {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
