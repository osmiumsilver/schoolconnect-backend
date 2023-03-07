package com.osmium.schoolconnect.backend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.Clazz;
import com.osmium.schoolconnect.backend.entity.pojo.ClazzDetailsVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClazzMapper extends BaseMapper<Clazz> {
@Select("select t_class.* from t_class WHERE class_no in (select t_class_manager_info.class_no from t_class_manager_info WHERE employee_id=#{employeeId})")
    List<Clazz> listClazzesManagedByManager(String employeeId);


}