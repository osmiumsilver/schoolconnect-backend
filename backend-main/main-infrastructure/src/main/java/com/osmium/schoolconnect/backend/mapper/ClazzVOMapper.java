package com.osmium.schoolconnect.backend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.pojo.ClazzVO;

import java.util.List;

/**
 * @Author
 * @Date 2023/3/7
 * @Description
 */
public interface ClazzVOMapper extends BaseMapper<ClazzVO> {
    List<ClazzVO> selectList(QueryWrapper<ClazzVO> gradeQueryWrapper);
}
