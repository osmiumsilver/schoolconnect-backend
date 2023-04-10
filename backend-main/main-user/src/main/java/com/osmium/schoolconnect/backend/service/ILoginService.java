package com.osmium.schoolconnect.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.osmium.schoolconnect.backend.entity.Login;

/**
 * @Author
 * @Date 2023/4/5
 * @Description
 */
public interface ILoginService extends IService<Login> {
    Boolean updatePassword(String employeeId, String newEncodedPassword);
}