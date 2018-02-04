package com.lovin.jeeblue.common.service.impl;

import com.lovin.jeeblue.common.mapper.UserMapper;
import com.lovin.jeeblue.common.entity.SysRole;
import com.lovin.jeeblue.common.entity.SysUser;
import com.lovin.jeeblue.common.service.UserService;
import com.lovin.jeeblue.common.util.PropertyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Lovin on 2018/1/13.
 */
@Service
public class UserServiceImpl implements UserService {

    private final String DEFAULT_SUPER_ADMIN = PropertyUtil.getValue("super.admin", "superAdmin");

    private final String DEFAULT_SUPER_ADMIN_PWD = PropertyUtil.getValue("super.admin.password", "0");

    @Autowired
    private UserMapper userDao;

    @Override
    public SysUser findByUserName(String username) {
        SysUser user = null;
        if(DEFAULT_SUPER_ADMIN.equals(username)) {
            user = new SysUser();
            user.setUserName("超级管理员");
            user.setUserPwd(DEFAULT_SUPER_ADMIN_PWD);

            Set<SysRole> roles = new HashSet<>();
            SysRole role = new SysRole();
            role.setName("ROLE_" + DEFAULT_SUPER_ADMIN);
            roles.add(role);
            user.setSysRoles(roles);

            return user;
        }

        return userDao.findByUserName(username);
    }

    @Override
    public List<SysRole> findRolesByUid(String uid) {
        return userDao.findRolesByUid(uid);
    }
}
