package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.RepairData;
import com.osmium.schoolconnect.backend.mapper.RepairDataMapper;
import com.osmium.schoolconnect.backend.service.IRepairDataService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author
 * @Date 2023/3/10
 * @Description
 */
@Service
public class RepairDataServiceImpl extends ServiceImpl<RepairDataMapper, RepairData> implements IRepairDataService {
    @Override
    public List<RepairData> listRepairData(String status, String userId) {
        QueryWrapper<RepairData> q = new QueryWrapper<>();
        q.eq("status",status);
        q.eq("initiator",userId);
        q.orderByDesc("create_time");
        return baseMapper.selectList(q);
    }

    @Override
    public List<RepairData> listRepairData(String status) {
        QueryWrapper<RepairData> q = new QueryWrapper<>();
        q.eq("status",status);
        q.orderByDesc("create_time");
        return baseMapper.selectList(q);
    }
}
