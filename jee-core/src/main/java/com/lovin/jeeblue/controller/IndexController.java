package com.lovin.jeeblue.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Lovin on 2018/1/6.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(value="", method=RequestMethod.GET)
    public String index(HttpServletRequest request) {
        return "index";
    }

    @RequestMapping(value="/user/index", method=RequestMethod.GET)
    public String index(HttpServletRequest request, String name) {
        request.setAttribute("key", "hello " + name);
        return "index";
    }

    @RequestMapping(value="/admin/index", method=RequestMethod.GET)
    public String admin(HttpServletRequest request, String name) {
        request.setAttribute("key", "hello " + name);
        return "index";
    }

    @RequestMapping(value="/super/index", method=RequestMethod.GET)
    @PreAuthorize("hasAnyRole('superAdmin')")
    public String supe(HttpServletRequest request) {
        return "index";
    }
}
