package com.lovin.jeeblue.module.sys.controller;

import com.github.pagehelper.PageInfo;
import com.lovin.jeeblue.module.sys.entity.TSysUser;
import com.lovin.jeeblue.module.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * manage user controller
 * Created by Lovin on 2018/1/16.
 */
@Controller
@RequestMapping("${admin.path}/user")
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value="/index", method= RequestMethod.GET)
    public String index() {
        return "module/sys/user/list";
    }

    @RequestMapping(value="/list", method= RequestMethod.GET)
    @ResponseBody
    public PageInfo<TSysUser> list(@RequestParam(required=false, defaultValue="1") int pageNum,
                                   @RequestParam(required=false, defaultValue="3") int pageSize) {
        return sysUserService.find(pageNum, pageSize);
    }
}
