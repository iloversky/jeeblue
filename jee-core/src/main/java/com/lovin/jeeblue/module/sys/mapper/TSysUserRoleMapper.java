package com.lovin.jeeblue.module.sys.mapper;

import com.lovin.jeeblue.common.mapper.BaseMapper;
import com.lovin.jeeblue.module.sys.entity.TSysUserRole;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface TSysUserRoleMapper extends BaseMapper {
    @Delete({
        "delete from t_sys_user_role",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_sys_user_role (USER_ID, ROLE_CODE)",
        "values (#{userId,jdbcType=VARCHAR}, #{roleCode,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(TSysUserRole record);

    @Select({
        "select",
        "ID, USER_ID, ROLE_CODE",
        "from t_sys_user_role",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE_CODE", property="roleCode", jdbcType=JdbcType.VARCHAR)
    })
    TSysUserRole selectByPrimaryKey(Long id);

    @Select({
        "select",
        "ID, USER_ID, ROLE_CODE",
        "from t_sys_user_role"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE_CODE", property="roleCode", jdbcType=JdbcType.VARCHAR)
    })
    List<TSysUserRole> selectAll();

    @Update({
        "update t_sys_user_role",
        "set USER_ID = #{userId,jdbcType=VARCHAR},",
          "ROLE_CODE = #{roleCode,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TSysUserRole record);
}