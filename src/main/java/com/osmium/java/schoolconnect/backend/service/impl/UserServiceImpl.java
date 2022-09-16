package com.osmium.java.schoolconnect.backend.service.impl;

import com.github.yulichang.base.MPJBaseServiceImpl;
import com.osmium.java.schoolconnect.backend.entity.User;
import com.osmium.java.schoolconnect.backend.mapper.UserMapper;
import com.osmium.java.schoolconnect.backend.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends MPJBaseServiceImpl<UserMapper, User> implements UserService {

}
