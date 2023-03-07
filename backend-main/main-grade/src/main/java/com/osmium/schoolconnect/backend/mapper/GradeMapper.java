package com.osmium.schoolconnect.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.Grade;
import com.osmium.schoolconnect.backend.entity.pojo.GradeVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GradeMapper extends BaseMapper<Grade> {

   @Select("select DISTINCT t_grade.* from t_grade,(select employee_id,class_no from t_user WHERE class_no IN (select DISTINCT class_no from t_class_manager_info where employee_id=#{userId})) as cc WHERE awaiting_revision=1 AND cc.employee_id = user_id")
    List<Grade> selectGradeWaitingForRevision(String userId);

   @Select("")
    List<GradeVO> selectGradeByClazz(String clazzId, String year, String semester);
}