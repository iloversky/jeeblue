package com.lovin.jeeblue.common.security;

import com.lovin.jeeblue.common.entity.SecurityUser;
import com.lovin.jeeblue.common.entity.SysRole;
import com.lovin.jeeblue.common.entity.SysUser;
import com.lovin.jeeblue.common.i18n.LocaleMessageService;
import com.lovin.jeeblue.common.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lovin on 2018/1/10.
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private static Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    // 业务服务类
    @Autowired
    private UserService userService;

    @Autowired
    private LocaleMessageService localeMessageService;

    /**
     * 自定义验证方式
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        logger.info("provider authenticate: {} ", username);

        SysUser sysUser = userService.findByUserName(username);

        if(sysUser == null) {
            throw new UsernameNotFoundException(MessageFormat.format(localeMessageService.getMessage("err_login_user_not_found"), username));
        }

        // 加密过程在这里体现
        if(!password.equals(sysUser.getUserPwd())) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            request.getSession().setAttribute("username", username);
            throw new BadCredentialsException(localeMessageService.getMessage("err_login_pwd_wrong"));
        }

        // 获取用户权限
        Set<SysRole> roles = new HashSet<>(userService.findRolesByUid(username));
        sysUser.setSysRoles(roles);

        // SecurityUser实现UserDetails并将SysUser的name映射为username
        SecurityUser user = new SecurityUser(sysUser);

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }

}
