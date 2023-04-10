package com.osmium.schoolconnect.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.osmium.schoolconnect.backend.entity.Login;
import org.apache.ibatis.annotations.Update;

/**
 * @Author
 * @Date 2023/4/5
 * @Description
 */
public interface LoginMapper extends BaseMapper<Login> {
    @Update("UPDATE schoolconnect.t_login t SET t.password = #{newEncodedPassword} WHERE t.username LIKE #{employeeId} ESCAPE '#';")
    Boolean updatePassword(String employeeId, String newEncodedPassword);
}
