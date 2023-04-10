package com.osmium.schoolconnect.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.Course;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author
 * @Date 2023/1/11
 * @Description
 */
public interface CourseMapper extends BaseMapper<Course> {
    @Select("select class_no from t_class_schedule JOIN t_course ON t_class_schedule.course_no = t_course.course_no where t_course.course_teacher = #{name}")
    List<String> selectClazzesTaughtByTeacher(String name);
}
