package com.lovin.jeeblue.module.sys.mapper;

import com.lovin.jeeblue.module.sys.entity.TSysUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TSysUserMapper {
    @Delete({
        "delete from t_sys_user",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_sys_user (USER_ID, USER_NAME, ",
        "USER_PWD, USER_EMAIL, ",
        "USER_MOBILE, USER_STATUS, ",
        "CREATE_TIME)",
        "values (#{userId,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
        "#{userPwd,jdbcType=VARCHAR}, #{userEmail,jdbcType=VARCHAR}, ",
        "#{userMobile,jdbcType=VARCHAR}, #{userStatus,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(TSysUser record);

    @Select({
        "select",
        "ID, USER_ID, USER_NAME, USER_PWD, USER_EMAIL, USER_MOBILE, USER_STATUS, CREATE_TIME",
        "from t_sys_user",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_NAME", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_PWD", property="userPwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_EMAIL", property="userEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_MOBILE", property="userMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_STATUS", property="userStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    TSysUser selectByPrimaryKey(Long id);

    @Select({
        "select",
        "ID, USER_ID, USER_NAME, USER_PWD, USER_EMAIL, USER_MOBILE, USER_STATUS, CREATE_TIME",
        "from t_sys_user"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_NAME", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_PWD", property="userPwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_EMAIL", property="userEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_MOBILE", property="userMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_STATUS", property="userStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TSysUser> selectAll();

    @Update({
        "update t_sys_user",
        "set USER_ID = #{userId,jdbcType=VARCHAR},",
          "USER_NAME = #{userName,jdbcType=VARCHAR},",
          "USER_PWD = #{userPwd,jdbcType=VARCHAR},",
          "USER_EMAIL = #{userEmail,jdbcType=VARCHAR},",
          "USER_MOBILE = #{userMobile,jdbcType=VARCHAR},",
          "USER_STATUS = #{userStatus,jdbcType=INTEGER},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TSysUser record);
}