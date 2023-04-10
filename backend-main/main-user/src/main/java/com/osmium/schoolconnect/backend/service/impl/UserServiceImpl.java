package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.User;
import com.osmium.schoolconnect.backend.mapper.UserMapper;
import com.osmium.schoolconnect.backend.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author abel
 * @since 2023-01-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public List<User> getEmployeesWaitingToBeReviewedByManagerID(String employeeId) {
        return baseMapper.getEmployeesWaitingToBeReviewedByManagerID(employeeId);
    }


}
