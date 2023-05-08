package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.User;
import com.osmium.schoolconnect.backend.entity.pojo.StudentInfoVO;
import com.osmium.schoolconnect.backend.mapper.StudentInfoVOMapper;
import com.osmium.schoolconnect.backend.mapper.UserMapper;
import com.osmium.schoolconnect.backend.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.Collection;
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

    private final StudentInfoVOMapper studentInfoVOMapper;

    public UserServiceImpl(StudentInfoVOMapper studentInfoVOMapper) {
        this.studentInfoVOMapper = studentInfoVOMapper;
    }

    //@Override
    //public List<StudentInfoVO> listStudentInfo() {
    //    return studentInfoVOMapper.selectList();
    //}

    @Override
    public List<StudentInfoVO> listStudentInfoByClazzId(String clazzId) {
        return studentInfoVOMapper.getStudentInfoByClazzId(clazzId);
    }

    @Override
    public StudentInfoVO selectStudentById(String userId) {
        return studentInfoVOMapper.selectById(userId);

    }

    @Override
    public List<User> listUserByStatus(String status) {
        QueryWrapper<User> q =new QueryWrapper();
        q.eq("status",status);
        return baseMapper.selectList(q);
    }

    @Override
    public List<StudentInfoVO> listStudentInfoByIds(Collection<? extends Serializable> idList) {
        return studentInfoVOMapper.selectBatchIds(idList);
    }

    @Override
    public List<StudentInfoVO> getEmployeesWaitingToBeReviewedByManagerID(String employeeId) {
        return studentInfoVOMapper.getEmployeesWaitingToBeReviewedByManagerID(employeeId);
    }



}
