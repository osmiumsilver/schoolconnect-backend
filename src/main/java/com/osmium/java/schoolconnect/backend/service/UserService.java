package com.osmium.java.schoolconnect.backend.service;

import com.osmium.java.schoolconnect.backend.entity.User;
import com.github.yulichang.base.MPJBaseService;

import java.io.Serializable;

/**
 * @author
 * @date 2022/3/29
 * @apinote
 */
public interface UserService extends MPJBaseService<User> {
    @Override
   default User getByIdDeep(Serializable id) {
        return MPJBaseService.super.getByIdDeep(id);
    }
}
