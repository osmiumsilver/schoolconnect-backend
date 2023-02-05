package com.osmium.schoolconnect.backend.main.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.main.entity.School;
import com.osmium.schoolconnect.backend.main.mapper.SchoolMapper;
import com.osmium.schoolconnect.backend.main.service.ISchoolService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学校表 服务实现类
 * </p>
 *
 * @author abel
 * @since 2023-01-12
 */
@Service
public class SchoolServiceImpl extends ServiceImpl<SchoolMapper, School> implements ISchoolService {

}
