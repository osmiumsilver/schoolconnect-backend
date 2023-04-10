package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.Login;
import com.osmium.schoolconnect.backend.entity.User;
import com.osmium.schoolconnect.backend.mapper.LoginMapper;
import com.osmium.schoolconnect.backend.mapper.UserMapper;
import com.osmium.schoolconnect.backend.service.ILoginService;
import com.osmium.schoolconnect.backend.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Author
 * @Date 2023/4/5
 * @Description
 */

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements ILoginService {

    @Override
    public Boolean updatePassword(String employeeId, String newEncodedPassword) {
        return baseMapper.updatePassword(employeeId, newEncodedPassword);
    }
}
