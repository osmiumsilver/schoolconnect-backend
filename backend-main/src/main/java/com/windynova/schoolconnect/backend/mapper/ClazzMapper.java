package com.osmium.schoolconnect.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.Clazz;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClazzMapper extends BaseMapper<Clazz>  {
@Select("SELECT t_class.class_no,class_name from t_class JOIN t_class_manager_info WHERE employee_id=#{employeeId} AND t_class_manager_info.role=#{classManagerRole};")
    List<Clazz> getClazzManagedByStaff(String employeeId,int classManagerRole);

}