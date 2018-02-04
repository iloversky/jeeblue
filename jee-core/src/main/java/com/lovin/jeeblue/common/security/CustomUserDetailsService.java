package com.lovin.jeeblue.common.security;

import com.lovin.jeeblue.common.entity.SecurityUser;
import com.lovin.jeeblue.common.entity.SysUser;
import com.lovin.jeeblue.common.i18n.LocaleMessageService;
import com.lovin.jeeblue.common.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by Lovin on 2018/1/10.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    // 业务服务类
    @Autowired
    private UserService userService;

    @Autowired
    private LocaleMessageService localeMessageService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        logger.info("CustomUserDetailsService find user: {} ", userName);

        // SysUser对应数据库中的用户表，是最终存储用户和密码的表，可自定义
        // 本例使用SysUser中的 name作为用户名:
        SysUser user = userService.findByUserName(userName);

        // SecurityUser实现UserDetails并将SysUser的name映射为username
        SecurityUser seu = null;
        if (user != null) {
            seu = new SecurityUser(user);
        }

        return  seu;
    }
}
