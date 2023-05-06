package com.osmium.schoolconnect.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.Clazz;
import com.osmium.schoolconnect.backend.entity.ClazzManagerInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author
 * @Date 2023/1/11
 * @Description
 */
public interface ClazzManagerInfoMapper extends BaseMapper<ClazzManagerInfo> {

    @Select("SELECT DISTINCT t_class.class_no,class_name from t_class JOIN t_class_manager_info ON t_class.class_no = t_class_manager_info.class_no WHERE employee_id=#{employeeId}")
    List<Clazz> getClazzManagedByStaff(String employeeId);
}
