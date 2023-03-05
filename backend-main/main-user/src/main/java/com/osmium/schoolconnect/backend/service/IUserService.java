package com.osmium.schoolconnect.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.osmium.schoolconnect.backend.entity.User;
import com.osmium.schoolconnect.backend.entity.vo.UserInfoRevisionVO;

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

    List<User> getEmployeesWaitingToBeReviewedByManagerID(String employeeId);



}
