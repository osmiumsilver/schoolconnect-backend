package com.osmium.schoolconnect.backend.main.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.main.entity.Grade;
import com.osmium.schoolconnect.backend.main.mapper.GradeMapper;
import com.osmium.schoolconnect.backend.main.service.IGradeService;
import org.springframework.stereotype.Service;

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

}
