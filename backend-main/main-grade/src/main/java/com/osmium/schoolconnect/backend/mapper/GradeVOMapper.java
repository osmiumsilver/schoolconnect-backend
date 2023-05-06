package com.osmium.schoolconnect.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.pojo.GradeVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author
 * @Date 2023/2/20
 * @Description
 */
public interface GradeVOMapper extends BaseMapper<GradeVO> {
    @Select("select DISTINCT v_grade_detail.* from v_grade_detail,(select employee_id,class_no from v_user_student WHERE class_no IN (select DISTINCT class_no from t_class_manager_info where employee_id=#{userId})) as cc WHERE awaiting_revision=1 AND cc.employee_id = user_id")
    List<GradeVO> selectGradeWaitingForRevision(String userId);

    //@Select("select DISTINCT * from v_grade_detail WHERE user_id   IN (select employee_id from v_user_student JOIN t_class tc on v_user_student.class_no = tc.class_no WHERE tc.class_no = #{clazzId}) AND year LIKE #{year} AND semester LIKE #{semester}")
    //List<GradeVO> selectGradeByClazz(String clazzId, String year, String semester);
    @Select("select DISTINCT * from v_grade_detail WHERE user_id   IN (select employee_id from v_user_student JOIN t_class tc on v_user_student.class_no = tc.class_no WHERE tc.class_no = #{clazzId}) AND year LIKE #{year} AND semester LIKE #{semester} AND course_no LIKE #{courseId}")
    List<GradeVO> selectGradeByClazz(String courseId, String clazzId, String year, String semester);
}
