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
    //@Select("select * from t_login where username=#{username} and password=#{password}")
    //UsernamePassword login(String username, String password);
    //
    //@Select("SELECT role FROM t_user WHERE user_id=#{username}")
    //String findRole(String username);

    @Select("SELECT username, password, t_user.role,t_user.status FROM t_login JOIN t_user ON t_login.username = t_user.employee_id where t_login.username=#{username}")
    Login getUserById(String username);
}
