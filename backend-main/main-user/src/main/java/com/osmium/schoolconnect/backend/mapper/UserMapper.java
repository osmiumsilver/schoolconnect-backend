package com.osmium.schoolconnect.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.User;


public interface UserMapper extends BaseMapper<User> {



//    @Select("Select * from t_user JOIN t_class_manager_info ON t_class_manager_info.class_no = t_user.class_no WHERE employee_id=#{employeeId} AND role = 2")
//List<User> getStudentsManagedByManager(String employeeId);

}