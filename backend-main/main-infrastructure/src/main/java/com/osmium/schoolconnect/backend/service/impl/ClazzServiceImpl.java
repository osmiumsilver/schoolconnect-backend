package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.Clazz;
import com.osmium.schoolconnect.backend.entity.ClazzManagerInfo;
import com.osmium.schoolconnect.backend.entity.pojo.ClazzDetailsVO;
import com.osmium.schoolconnect.backend.mapper.ClazzManagerInfoMapper;
import com.osmium.schoolconnect.backend.mapper.ClazzMapper;
import com.osmium.schoolconnect.backend.mapper.ClazzVOMapper;
import com.osmium.schoolconnect.backend.service.IClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author
 * @Date 2022/10/15
 * @Description
 */
@Service
public class ClazzServiceImpl extends ServiceImpl<ClazzMapper, Clazz> implements IClazzService {
    private final ClazzVOMapper clazzVOMapper;
    private final ClazzManagerInfoMapper clazzManagerInfoMapper;

    @Autowired
    public ClazzServiceImpl(ClazzVOMapper clazzVOMapper, ClazzManagerInfoMapper clazzManagerInfoMapper) {
        this.clazzVOMapper = clazzVOMapper;
        this.clazzManagerInfoMapper = clazzManagerInfoMapper;
    }

    @Override
    public List<Clazz> listClazzesManagedByManager(String userId) {
        return baseMapper.listClazzesManagedByManager(userId);
    }

    @Override
    public List<ClazzDetailsVO> listClazzDetailsById(List<Clazz> clazzes) {
        QueryWrapper<ClazzDetailsVO> gradeQueryWrapper = new QueryWrapper<>();
        gradeQueryWrapper.eq("class_no", clazzes);
        return clazzVOMapper.selectList(gradeQueryWrapper);
    }

    @Override
    public List<ClazzManagerInfo> listClazzManagersByClazz(List<String> clazzId) {
       return null;//TODO
    }
}
