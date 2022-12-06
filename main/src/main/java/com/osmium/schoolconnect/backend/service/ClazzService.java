package com.osmium.schoolconnect.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.osmium.schoolconnect.backend.entity.Clazz;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author
 * @date 2022/3/29
 * @apinote
 */

public interface ClazzService extends IService<Clazz> {
    @Override
    boolean saveOrUpdate(Clazz entity);
}


