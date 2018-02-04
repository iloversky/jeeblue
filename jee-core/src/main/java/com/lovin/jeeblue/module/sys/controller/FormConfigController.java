package com.lovin.jeeblue.module.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 表单动态设置
 * Created by Lovin on 2018/1/18.
 */
@Controller
@RequestMapping("${admin.path}/form/config")
public class FormConfigController {

    @RequestMapping(value="/index", method= RequestMethod.GET)
    public String index() {
        return "module/sys/config/index";
    }
}
