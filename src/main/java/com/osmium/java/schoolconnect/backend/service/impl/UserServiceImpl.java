
package com.osmium.java.schoolconnect.backend.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.osmium.java.schoolconnect.backend.entity.User;
import com.osmium.java.schoolconnect.backend.mapper.UserMapper;
import com.osmium.java.schoolconnect.backend.service.UserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends MPJBaseServiceImpl<UserMapper,User> implements UserService {
    @Override
    public User getByIdDeep(Serializable id) {
        return super.getByIdDeep(id);
    }
}