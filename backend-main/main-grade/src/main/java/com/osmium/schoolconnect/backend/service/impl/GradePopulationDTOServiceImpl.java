package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.pojo.GradePopulationDTO;
import com.osmium.schoolconnect.backend.mapper.GradePopulationDTOMapper;
import com.osmium.schoolconnect.backend.service.IGradePopulationService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @Author
 * @Date 2023/5/7
 * @Description
 */
@Service
@Validated
public class GradePopulationDTOServiceImpl extends ServiceImpl<GradePopulationDTOMapper, GradePopulationDTO> implements IGradePopulationService {
}
