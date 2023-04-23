package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.Login;
import com.osmium.schoolconnect.backend.mapper.LoginMapper;
import com.osmium.schoolconnect.backend.service.ILoginService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @Author
 * @Date 2023/4/5
 * @Description
 */

@Service
@Validated
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements ILoginService {

    @Override
    public Boolean updatePassword(String employeeId, String newEncodedPassword) {
        return baseMapper.updatePassword(employeeId, newEncodedPassword);
    }
}
