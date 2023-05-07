package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.osmium.schoolconnect.backend.entity.Grade;
import com.osmium.schoolconnect.backend.entity.pojo.GradeRevisionDTO;
import com.osmium.schoolconnect.backend.entity.pojo.GradeVO;
import com.osmium.schoolconnect.backend.mapper.GradeDTOMapper;
import com.osmium.schoolconnect.backend.mapper.GradeMapper;
import com.osmium.schoolconnect.backend.mapper.GradeVOMapper;
import com.osmium.schoolconnect.backend.service.IGradeService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * <p>
 * 成绩表 服务实现类
 * </p>
 *
 * @author abel
 * @since 2023-01-12
 */
@Service
@Validated
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade> implements IGradeService {
    private final GradeVOMapper gradeVOMapper;
    private final GradeDTOMapper gradeDTOMapper;

    public GradeServiceImpl(GradeVOMapper gradeVOMapper, GradeDTOMapper gradeDTOMapper) {
        this.gradeVOMapper = gradeVOMapper;
        this.gradeDTOMapper = gradeDTOMapper;
    }


    @Override
    public List<GradeVO> listGradeByUserId(String userId, String year, String semester) {
        QueryWrapper<GradeVO> gradeQueryWrapper = new QueryWrapper<>();
        gradeQueryWrapper.eq("user_id", userId);
        gradeQueryWrapper.like("year", year);
        gradeQueryWrapper.like("semester", semester);
        return gradeVOMapper.selectList(gradeQueryWrapper);
    }

    @Override
    public List<GradeVO> listGradeWaitingForRevision(String userId) {

        return gradeVOMapper.selectGradeWaitingForRevision(userId);
    }

    @Override
    public List<GradeVO> listGradeByClazz(String courseId, String clazzId, String year, String semester) {
        return gradeVOMapper.selectGradeByClazz(courseId, clazzId, year, semester);
    }

    @Override
    public Boolean updateGradeAndRevision(GradeRevisionDTO gradeRevisionDTO) {

        return SqlHelper.retBool(gradeDTOMapper.updateGradeAndRevision(gradeRevisionDTO.getId(), gradeRevisionDTO.getGrade(), gradeRevisionDTO.getAwaitingRevision()));
    }

    //@Override
    //public List<GradeVO> listGradeByClazz(String clazzId, String year, String semester) {
    //    return gradeVOMapper.selectGradeByClazz(clazzId, year, semester);
    //}

}

