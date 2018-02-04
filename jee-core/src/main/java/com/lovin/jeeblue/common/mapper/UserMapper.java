package com.lovin.jeeblue.common.mapper;

import com.lovin.jeeblue.common.entity.SysRole;
import com.lovin.jeeblue.common.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Lovin on 2018/1/13.
 */
@Repository
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM T_SYS_USER WHERE USER_ID=#{username}")
    SysUser findByUserName(String username);

    @Select("SELECT * FROM T_SYS_USER_ROLE WHERE USER_ID=#{uid}")
    @Results({
            @Result(property="name", column="ROLE_CODE")
    })
    List<SysRole> findRolesByUid(String uid);
}
