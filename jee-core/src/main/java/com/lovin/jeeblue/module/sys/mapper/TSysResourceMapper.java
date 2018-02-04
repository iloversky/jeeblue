package com.lovin.jeeblue.module.sys.mapper;

import com.lovin.jeeblue.common.mapper.BaseMapper;
import com.lovin.jeeblue.module.sys.entity.TSysResource;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface TSysResourceMapper extends BaseMapper {
    @Delete({
        "delete from t_sys_resource",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_sys_resource (RESOURCE_NAME, RESOURCE_URL)",
        "values (#{resourceName,jdbcType=VARCHAR}, #{resourceUrl,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(TSysResource record);

    @Select({
        "select",
        "ID, RESOURCE_NAME, RESOURCE_URL",
        "from t_sys_resource",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="RESOURCE_NAME", property="resourceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="RESOURCE_URL", property="resourceUrl", jdbcType=JdbcType.VARCHAR)
    })
    TSysResource selectByPrimaryKey(Long id);

    @Select({
        "select",
        "ID, RESOURCE_NAME, RESOURCE_URL",
        "from t_sys_resource"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="RESOURCE_NAME", property="resourceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="RESOURCE_URL", property="resourceUrl", jdbcType=JdbcType.VARCHAR)
    })
    List<TSysResource> selectAll();

    @Update({
        "update t_sys_resource",
        "set RESOURCE_NAME = #{resourceName,jdbcType=VARCHAR},",
          "RESOURCE_URL = #{resourceUrl,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TSysResource record);
}