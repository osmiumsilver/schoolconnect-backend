package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.Grade;
import com.osmium.schoolconnect.backend.entity.vo.GradeVO;
import com.osmium.schoolconnect.backend.mapper.GradeVOMapper;
import com.osmium.schoolconnect.backend.mapper.GradeMapper;
import com.osmium.schoolconnect.backend.service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade> implements IGradeService {
    private final GradeVOMapper gradeVOMapper;
    public GradeServiceImpl(GradeVOMapper gradeVOMapper) {
        this.gradeVOMapper = gradeVOMapper;
    }

    public List<GradeVO> listGradeByUserId(String userId, String year, String semester) {
        QueryWrapper<GradeVO> gradeQueryWrapper = new QueryWrapper<>();
        gradeQueryWrapper.eq("user_id", userId);
        gradeQueryWrapper.like("year", year);
        gradeQueryWrapper.like("semester", semester);
        return gradeVOMapper.selectList(gradeQueryWrapper);
    }

}

