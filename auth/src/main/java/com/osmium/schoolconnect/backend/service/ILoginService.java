package com.osmium.schoolconnect.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.osmium.schoolconnect.backend.entity.Login;

/**
 * @Author
 * @Date 2022/12/7
 * @Description
 */

public interface ILoginService extends IService<Login> {
    Login login(String username, String password);
}