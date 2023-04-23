package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.User;
import com.osmium.schoolconnect.backend.mapper.UserMapper;
import com.osmium.schoolconnect.backend.service.IUserService;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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
@Validated
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public List<User> getEmployeesWaitingToBeReviewedByManagerID(String employeeId) {
        return baseMapper.getEmployeesWaitingToBeReviewedByManagerID(employeeId);
    }



}
