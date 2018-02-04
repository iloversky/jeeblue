package com.lovin.jeeblue.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by Lovin on 2018/1/11.
 */
@Controller
@RequestMapping("/lang")
public class LangController {

    private static Logger logger = LoggerFactory.getLogger(LangController.class);

    @Autowired
    private LocaleResolver localeResolver;

    @RequestMapping(value="/{lang}", method=RequestMethod.GET)
    public String zh(HttpServletRequest request, HttpServletResponse response,
                             @PathVariable String lang,
                             @RequestParam(defaultValue="/") String url) {
        logger.info("change language to {}", lang);
        if("zh".equals(lang)) {
            localeResolver.setLocale(request, response, new Locale(lang, "CN"));
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("zh", "CN"));
        } else if("en".equals(lang)) {
            localeResolver.setLocale(request, response, new Locale(lang, "US"));
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("en", "US"));
        }
        request.getSession().setAttribute("GLOBAL_LANG", localeResolver.resolveLocale(request).toString());
        logger.info("changed language {}",
                request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME));

        return "redirect:" + url;
    }
}
