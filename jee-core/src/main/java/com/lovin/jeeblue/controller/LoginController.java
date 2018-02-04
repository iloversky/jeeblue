package com.lovin.jeeblue.controller;

import com.lovin.jeeblue.common.util.PropertyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by Lovin on 2018/1/6.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    private final String CONTEXT_ADMIN = PropertyUtil.getValue("admin.path");

    private final String CONTEXT_USER = PropertyUtil.getValue("user.path");

    @Autowired
    private LocaleResolver localeResolver;

    @RequestMapping(value="", method=RequestMethod.GET)
    public String login(HttpServletRequest request) {
        Locale locale = localeResolver.resolveLocale(request);
        if(locale == null) {
            locale = LocaleContextHolder.getLocale();
        }
        // 国际化
        request.getSession().setAttribute("GLOBAL_LANG", locale.toString());
        // 管理员权限访问地址
        request.getSession().setAttribute("ctxA", CONTEXT_ADMIN);
        request.getSession().setAttribute("ctxU", CONTEXT_USER);

        return "login";
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public String login(HttpServletRequest request, String username, String password) {
        return "index";
    }
}
