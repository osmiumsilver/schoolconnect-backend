package com.osmium.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.osmium.schoolconnect.backend.entity.pojo.UninitializedUsers;
import com.osmium.schoolconnect.backend.mapper.UninitializedUsersMapper;
import com.osmium.schoolconnect.backend.service.IUnUsers;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

/**
 * @Author
 * @Date 2023/4/15
 * @Description
 */
@Validated
@Repository
public class UnUsersImpl extends ServiceImpl<UninitializedUsersMapper, UninitializedUsers> implements IUnUsers {
}
