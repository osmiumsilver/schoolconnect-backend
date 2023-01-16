package com.osmium.schoolconnect.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.Login;

/**
 * @Author
 * @Date 2022/12/7
 * @Description
 */
public interface LoginMapper extends BaseMapper<Login>{
    //@Select("select * from t_login where username=#{username}")
    //Login findByUsername(@Param("username") String username);

}
