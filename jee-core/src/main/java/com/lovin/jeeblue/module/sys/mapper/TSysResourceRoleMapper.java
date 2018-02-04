package com.lovin.jeeblue.module.sys.mapper;

import com.lovin.jeeblue.common.mapper.BaseMapper;
import com.lovin.jeeblue.module.sys.entity.TSysResourceRole;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface TSysResourceRoleMapper extends BaseMapper {
    @Delete({
        "delete from t_sys_resource_role",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_sys_resource_role (RESOURCE_URL, ROLE_CODE)",
        "values (#{resourceUrl,jdbcType=VARCHAR}, #{roleCode,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(TSysResourceRole record);

    @Select({
        "select",
        "ID, RESOURCE_URL, ROLE_CODE",
        "from t_sys_resource_role",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="RESOURCE_URL", property="resourceUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE_CODE", property="roleCode", jdbcType=JdbcType.VARCHAR)
    })
    TSysResourceRole selectByPrimaryKey(Long id);

    @Select({
        "select",
        "ID, RESOURCE_URL, ROLE_CODE",
        "from t_sys_resource_role"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="RESOURCE_URL", property="resourceUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE_CODE", property="roleCode", jdbcType=JdbcType.VARCHAR)
    })
    List<TSysResourceRole> selectAll();

    @Update({
        "update t_sys_resource_role",
        "set RESOURCE_URL = #{resourceUrl,jdbcType=VARCHAR},",
          "ROLE_CODE = #{roleCode,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TSysResourceRole record);
}