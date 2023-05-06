package com.osmium.schoolconnect.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.Clazz;
import com.osmium.schoolconnect.backend.entity.DepartmentInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DepartmentInfoMapper extends BaseMapper<DepartmentInfo> {

    @Select("select * from t_class where department_no =#{departmentId}")
    List<Clazz> listClazzesByDepartment(String departmentId);
}