package com.osmium.schoolconnect.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.osmium.schoolconnect.backend.entity.Clazz;
import com.osmium.schoolconnect.backend.entity.ClazzManagerInfo;
import com.osmium.schoolconnect.backend.entity.pojo.ClazzDetailsVO;

import java.util.List;


/**
 * @author
 * @date 2022/3/29
 * @apinote
 */

public interface IClazzService extends IService<Clazz> {
    List<Clazz> listClazzesManagedByManager(String userId);

    List<ClazzDetailsVO> listClazzDetailsById(List<Clazz> clazzes);

    List<ClazzManagerInfo> listClazzManagersByClazz(List<String> clazzId);
}


