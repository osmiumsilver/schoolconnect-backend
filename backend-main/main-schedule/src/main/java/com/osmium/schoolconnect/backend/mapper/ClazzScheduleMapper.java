package com.osmium.schoolconnect.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.ClazzSchedule;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/19
 * @Description
 */
public interface ClazzScheduleMapper extends BaseMapper<ClazzSchedule> {

    @Select("select t_class_schedule.id,class_no,weeks,lessons,year,semester from t_class_schedule JOIN t_course_teacher ON t_class_schedule.course_no = t_course_teacher.course_no WHERE teacher_id=#{userId} AND year=#{year} AND semester=#{semester}")
    List<ClazzSchedule> listScheduleByTeacher(String userId, String year, String semester);
}
