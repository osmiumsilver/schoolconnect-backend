package com.osmium.schoolconnect.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.pojo.ClazzScheduleVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author
 * @Date 2023/4/19
 * @Description
 */
public interface ClazzScheduleVOMapper extends BaseMapper<ClazzScheduleVO> {
    @Select("select v_class_schedule.* from v_class_schedule JOIN t_course ON v_class_schedule.course_no = t_course.course_no WHERE course_teacher=#{userId} AND year=#{year} AND semester=#{semester}")
    List<ClazzScheduleVO> listScheduleByTeacher(String userId, String year, String semester);
    @Select("select t_class_schedule.*,course_name,course_place,course_credits,(SELECT name from t_user WHERE employee_id=course_teacher)as course_teacher from t_class_schedule JOIN t_course ON t_class_schedule.course_no = t_course.course_no  WHERE (class_no=#{classNo} AND semester like #{semester} AND year like #{year})")
    List<ClazzScheduleVO> selectScheduleDetailsByClazz(String classNo, String semester, String year);
}
