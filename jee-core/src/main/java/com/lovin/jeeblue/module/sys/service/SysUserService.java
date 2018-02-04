package com.lovin.jeeblue.module.sys.service;

import com.github.pagehelper.PageInfo;
import com.lovin.jeeblue.module.sys.entity.TSysUser;
import com.sun.tools.javac.util.List;

/**
 * Created by Lovin on 2018/1/17.
 */
public interface SysUserService {

    PageInfo<TSysUser> find(int pageNum, int pageSize);
}
