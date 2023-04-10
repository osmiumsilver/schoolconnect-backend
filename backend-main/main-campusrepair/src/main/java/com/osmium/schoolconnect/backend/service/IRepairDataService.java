package com.osmium.schoolconnect.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.osmium.schoolconnect.backend.entity.RepairData;

import java.util.List;

/**
 * @Author
 * @Date 2023/3/10
 * @Description
 */
public interface IRepairDataService extends IService<RepairData> {
    List<RepairData> listRepairData(String status);
    List<RepairData> listRepairData(String status,String userId);

}
