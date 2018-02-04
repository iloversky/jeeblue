package com.lovin.jeeblue.common.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

/**
 * Created by Lovin on 2018/1/9.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private static Logger logger = LoggerFactory.getLogger(SpringSecurityConfig.class);

    @Autowired
    private CustomAuthenticationProvider provider;//自定义验证

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    // roles admin allow to access /admin/**
    // roles user allow to access /user/**
    // custom 403 access denied handler
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("SpringSecurityConfig configure....");

        http.csrf().disable()
            .authorizeRequests()
            // 无需登录认证权限
            .antMatchers("/login", "/lang/**", "/ignore/**").permitAll()
            // url http://host:port/*/user/** 需要 USER权限
            .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
            // url http://host:port/*/admin/** 需要 ADMIN权限 (hasAuthority("ADMIN"))
            .antMatchers("/admin/**").hasAnyRole("ADMIN")
            // 其他所有资源都需要认证，登陆后访问
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login") // 指定登录页面
            .failureUrl("/login?error=true")
            .successHandler(loginSuccessHandler()) // 登录成功后可使用 loginSuccessHandler()存储用户信息
            .defaultSuccessUrl("/")
            .permitAll()
            .and()
            .logout()
            .permitAll()
            .and()
            .exceptionHandling().accessDeniedHandler(accessDeniedHandler);

        // session管理
        // session失效后跳转
        http.sessionManagement().invalidSessionUrl("/login");
        // 只允许一个用户登录,如果同一个账户两次登录,那么第一个账户将被踢下线,跳转到登录页面
        http.sessionManagement().maximumSessions(1).expiredUrl("/login");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        logger.info("SpringSecurityConfig configureGlobal....");
        //将验证过程交给自定义验证工具
        auth.authenticationProvider(provider);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }

    @Bean
    public LoginSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler();
    }

    @Bean(name="localeResolver")
    public CookieLocaleResolver localeResolver() {
        return new CookieLocaleResolver();
    }
}