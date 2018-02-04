package com.lovin.jeeblue.module.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * manage user controller
 * Created by Lovin on 2018/1/16.
 */
@Controller
@RequestMapping("${admin.path}/role")
public class RoleController {

    @RequestMapping(value="/list", method= RequestMethod.GET)
    public String list() {

        return "module/sys/role/list";
    }
}
