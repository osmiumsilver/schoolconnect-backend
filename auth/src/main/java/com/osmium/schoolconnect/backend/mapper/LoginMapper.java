package com.osmium.schoolconnect.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.Login;
import org.apache.ibatis.annotations.Select;

/**
 * @Author
 * @Date 2022/12/7
 * @Description
 */
public interface LoginMapper extends BaseMapper<Login>{


    //Login findByUsername(@Param("username") String username);
    @Select("select * from t_login where username=#{username} and password=#{passwd}")
    Login login(String username,String password);
}
