package com.osmium.schoolconnect.backend.mapper;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.User;
import com.osmium.schoolconnect.backend.entity.vo.UserInfoRevisionVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT * from t_user JOIN t_class_manager_info ON t_class_manager_info.class_no = t_user.class_no WHERE t_class_manager_info.employee_id=#{employeeId} AND required_changing=2")
    List<User> getEmployeesWaitingToBeReviewedByManagerID(String employeeId);


}