package com.osmium.java.schoolconnect.backend.mapper;

import com.osmium.java.schoolconnect.backend.entity.SysUser;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface SysuserMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Delete({
        "delete from sysuser",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Insert({
        "insert into sysuser (realname, nickname, ",
        "username, `password`, ",
        "email, phone, `role`, ",
        "`status`, createtime, ",
        "lastlogintime, lastloginip, ",
        "lastloginlocation, avatar)",
        "values (#{realname,jdbcType=VARCHAR}, #{nickname,jdbcType=VARCHAR}, ",
        "#{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, #{role,jdbcType=TINYINT}, ",
        "#{status,jdbcType=TINYINT}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{lastlogintime,jdbcType=TIMESTAMP}, #{lastloginip,jdbcType=VARCHAR}, ",
        "#{lastloginlocation,jdbcType=VARCHAR}, #{avatar,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(SysUser row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Select({
        "select",
        "id, realname, nickname, username, `password`, email, phone, `role`, `status`, ",
        "createtime, lastlogintime, lastloginip, lastloginlocation, avatar",
        "from sysuser",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="role", property="role", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastlogintime", property="lastlogintime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastloginip", property="lastloginip", jdbcType=JdbcType.VARCHAR),
        @Result(column="lastloginlocation", property="lastloginlocation", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR)
    })
    SysUser selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Select({
        "select",
        "id, realname, nickname, username, `password`, email, phone, `role`, `status`, ",
        "createtime, lastlogintime, lastloginip, lastloginlocation, avatar",
        "from sysuser"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="role", property="role", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastlogintime", property="lastlogintime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastloginip", property="lastloginip", jdbcType=JdbcType.VARCHAR),
        @Result(column="lastloginlocation", property="lastloginlocation", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR)
    })
    List<SysUser> selectAll();

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Update({
        "update sysuser",
        "set realname = #{realname,jdbcType=VARCHAR},",
          "nickname = #{nickname,jdbcType=VARCHAR},",
          "username = #{username,jdbcType=VARCHAR},",
          "`password` = #{password,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "`role` = #{role,jdbcType=TINYINT},",
          "`status` = #{status,jdbcType=TINYINT},",
          "createtime = #{createtime,jdbcType=TIMESTAMP},",
          "lastlogintime = #{lastlogintime,jdbcType=TIMESTAMP},",
          "lastloginip = #{lastloginip,jdbcType=VARCHAR},",
          "lastloginlocation = #{lastloginlocation,jdbcType=VARCHAR},",
          "avatar = #{avatar,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysUser row);
}