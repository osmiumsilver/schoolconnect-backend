package com.osmium.schoolconnect.backend.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.auth.entity.OpenID;
import com.osmium.schoolconnect.backend.auth.mapper.OpenIDMapper;
import com.osmium.schoolconnect.backend.auth.service.IOpenIDService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author abel
 * @since 2023-01-12
 */
@Service
public class OpenIDServiceImpl extends ServiceImpl<OpenIDMapper, OpenID> implements IOpenIDService {

}
