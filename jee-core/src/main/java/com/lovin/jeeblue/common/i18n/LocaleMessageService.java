package com.lovin.jeeblue.common.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by Lovin on 2018/1/11.
 */
@Component
public class LocaleMessageService {

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String key) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Locale locale = (Locale) request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        return messageSource.getMessage(key , null, locale);
    }

    public String getMessage(String key, String defaultValue) {
        String value = getMessage(key);
        if(StringUtils.isEmpty(value)) {
            value = defaultValue;
        }
        return value;
    }
}
