package com.osmium.schoolconnect.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.osmium.schoolconnect.backend.entity.User;
import com.osmium.schoolconnect.backend.entity.pojo.StudentInfoVO;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author abel
 * @since 2023-01-12
 */
public interface IUserService extends IService<User> {

List<StudentInfoVO> listStudentInfoByIds(Collection<? extends Serializable> idList);
    List<StudentInfoVO> listStudentInfoByClazzId(String clazzId);
    List<StudentInfoVO> getEmployeesWaitingToBeReviewedByManagerID(String employeeId);


    StudentInfoVO selectStudentById(String userId);

    List<User> listUserByStatus(String status);
}
