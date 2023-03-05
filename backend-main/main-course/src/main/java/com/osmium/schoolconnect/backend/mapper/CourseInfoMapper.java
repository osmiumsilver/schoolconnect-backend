package com.osmium.schoolconnect.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.CourseInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author
 * @Date 2023/1/11
 * @Description
 */
public interface CourseInfoMapper extends BaseMapper<CourseInfo> {
    @Select("select * from t_course_info JOIN t_course_teacher ON t_course_teacher.course_no = t_course_info.course_no WHERE teacher_id=${userId}")
    List<CourseInfo> getCoursesByTeacher(String userId);
}
