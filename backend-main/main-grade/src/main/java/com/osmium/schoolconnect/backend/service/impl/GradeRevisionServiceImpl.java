package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.pojo.GradeDTO;
import com.osmium.schoolconnect.backend.mapper.GradeDTOMapper;
import com.osmium.schoolconnect.backend.service.IGradeRevisionService;
import com.osmium.schoolconnect.backend.service.IGradeService;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

/**
 * @Author
 * @Date 2023/5/6
 * @Description
 */
@Validated
@Repository
public class GradeRevisionServiceImpl extends ServiceImpl<GradeDTOMapper, GradeDTO> implements IGradeRevisionService {
}
