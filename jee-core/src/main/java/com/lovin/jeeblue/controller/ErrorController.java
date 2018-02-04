package com.lovin.jeeblue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Lovin on 2018/1/6.
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping(value="/403", method=RequestMethod.GET)
    public String error403(HttpServletRequest request) {
        return "/error/403";
    }
}
