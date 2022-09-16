package com.osmium.java.schoolconnect.backend.service.impl;

import com.github.yulichang.base.MPJBaseServiceImpl;
import com.osmium.java.schoolconnect.backend.entity.SysUser;
import com.osmium.java.schoolconnect.backend.entity.User;
import com.osmium.java.schoolconnect.backend.mapper.UserMapper;
import com.osmium.java.schoolconnect.backend.service.UserService;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Service
public class UserServiceImpl extends MPJBaseServiceImpl<UserMapper, User> implements UserService {

}
