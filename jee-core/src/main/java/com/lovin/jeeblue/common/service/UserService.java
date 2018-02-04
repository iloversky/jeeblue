package com.lovin.jeeblue.common.service;

import com.lovin.jeeblue.common.entity.SysRole;
import com.lovin.jeeblue.common.entity.SysUser;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Date;

/**
 * Created by Lovin on 2018/1/10.
 */
public interface UserService {

    SysUser findByUserName(String username);

    List<SysRole> findRolesByUid(String uid);
}
