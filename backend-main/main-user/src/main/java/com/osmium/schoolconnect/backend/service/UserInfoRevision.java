package com.osmium.schoolconnect.backend.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.pojo.UserInfoRevisionDTO;
import com.osmium.schoolconnect.backend.mapper.UserInfoRevisionVOMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @Author
 * @Date 2023/2/28
 * @Description
 */
@Service
@Validated
public class UserInfoRevision extends ServiceImpl<UserInfoRevisionVOMapper, UserInfoRevisionDTO> {

}
