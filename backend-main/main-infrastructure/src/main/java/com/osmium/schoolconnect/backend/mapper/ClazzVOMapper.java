package com.osmium.schoolconnect.backend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.pojo.ClazzDetailsVO;

import java.util.List;

/**
 * @Author
 * @Date 2023/3/7
 * @Description
 */
public interface ClazzVOMapper extends BaseMapper<ClazzDetailsVO> {
    List<ClazzDetailsVO> selectList(QueryWrapper<ClazzDetailsVO> gradeQueryWrapper);
}
