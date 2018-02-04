package com.lovin.jeeblue.module.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lovin.jeeblue.module.sys.entity.TSysUser;
import com.lovin.jeeblue.module.sys.mapper.TSysUserMapper;
import com.lovin.jeeblue.module.sys.service.SysUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lovin on 2018/1/17.
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private TSysUserMapper sysUserMapper;

    public PageInfo<TSysUser> find(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TSysUser> list = sysUserMapper.selectAll();
        PageInfo<TSysUser> pageInfo = new PageInfo(list);

        return pageInfo;
    }
}
