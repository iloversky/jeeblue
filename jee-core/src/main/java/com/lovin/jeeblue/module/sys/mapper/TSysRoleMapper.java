package com.lovin.jeeblue.module.sys.mapper;

import com.lovin.jeeblue.common.mapper.BaseMapper;
import com.lovin.jeeblue.module.sys.entity.TSysRole;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface TSysRoleMapper extends BaseMapper {
    @Delete({
        "delete from t_sys_role",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_sys_role (ROLE_CODE, ROLE_NAME, ",
        "ROLE_STATUS, CREATE_TIME)",
        "values (#{roleCode,jdbcType=VARCHAR}, #{roleName,jdbcType=VARCHAR}, ",
        "#{roleStatus,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(TSysRole record);

    @Select({
        "select",
        "ID, ROLE_CODE, ROLE_NAME, ROLE_STATUS, CREATE_TIME",
        "from t_sys_role",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ROLE_CODE", property="roleCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE_NAME", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE_STATUS", property="roleStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    TSysRole selectByPrimaryKey(Long id);

    @Select({
        "select",
        "ID, ROLE_CODE, ROLE_NAME, ROLE_STATUS, CREATE_TIME",
        "from t_sys_role"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ROLE_CODE", property="roleCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE_NAME", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE_STATUS", property="roleStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TSysRole> selectAll();

    @Update({
        "update t_sys_role",
        "set ROLE_CODE = #{roleCode,jdbcType=VARCHAR},",
          "ROLE_NAME = #{roleName,jdbcType=VARCHAR},",
          "ROLE_STATUS = #{roleStatus,jdbcType=INTEGER},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TSysRole record);
}