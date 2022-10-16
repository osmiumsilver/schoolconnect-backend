package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.Clazz;
import com.osmium.schoolconnect.backend.mapper.ClazzMapper;
import com.osmium.schoolconnect.backend.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @Author
 * @Date 2022/10/15
 * @Description
 */
@Service
public class ClazzServiceImpl extends ServiceImpl<ClazzMapper,Clazz> implements ClazzService {

@Autowired
private ClazzMapper clazzMapper;


    @Override
    public Clazz selectClassByClno(String clno) {
        return clazzMapper.selectClassByClno(clno);
    }

    @Override
    public List<Clazz> selectClassList(Clazz clazz) {
        return clazzMapper.selectClassList(clazz);
    }

    @Override
    public int insertClass(Clazz clazz) {
        return clazzMapper.insertClass(clazz);
    }

    @Override
    public int updateClass(Clazz clazz) {
        return clazzMapper.updateClass(clazz);
    }

    @Override
    public int deleteClassByClnos(String clnos) {
        return 0;
    }

    @Override
    public int deleteClassByClno(String clno) {
        return 0;
    }

    @Override
    public boolean saveBatch(Collection<Clazz> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Clazz> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Clazz> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Clazz entity) {
        return false;
    }

    @Override
    public Clazz getOne(Wrapper<Clazz> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<Clazz> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<Clazz> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public ClazzMapper getBaseMapper() {
        return null;
    }

    @Override
    public Class<Clazz> getEntityClass() {
        return null;
    }
}
