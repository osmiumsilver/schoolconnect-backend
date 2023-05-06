package com.osmium.schoolconnect.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.pojo.StudentInfoVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author
 * @Date 2023/4/30
 * @Description
 */
public interface StudentInfoVOMapper extends BaseMapper<StudentInfoVO> {
    @Select("SELECT * from v_user_student JOIN t_class_manager_info ON t_class_manager_info.class_no = v_user_student.class_no WHERE t_class_manager_info.employee_id=#{employeeId} AND required_changing=2")
    List<StudentInfoVO> getEmployeesWaitingToBeReviewedByManagerID(String employeeId);

    @Select("SELECT * from v_user_student WHERE class_no=#{clazzId}")
    List<StudentInfoVO> getStudentInfoByClazzId(String clazzId);
}
