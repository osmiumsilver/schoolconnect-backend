package com.osmium.schoolconnect.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.Clazz;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

public interface ClazzMapper extends BaseMapper<Clazz> {
@Select("select t_class.* from t_class WHERE class_no in (select t_class_manager_info.class_no from t_class_manager_info WHERE employee_id=#{employeeId})")
    List<Clazz> listClazzesManagedByManager(String employeeId);


@Select("select employee_id,name from v_user_student where class_no=#{clazzId}")
    List<HashMap<String, String>> selecyStudentUnderClass(String clazzId);
}