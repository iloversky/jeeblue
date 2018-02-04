package com.lovin.jeeblue.common.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by Lovin on 2018/1/10.
 */
public class SecurityUser extends SysUser implements UserDetails {
    private static final long serialVersionUID = 1L;

    public SecurityUser(SysUser suser) {
        if(suser != null) {
            this.setId(suser.getId());
            this.setUserName(suser.getUserName());
            this.setUserEmail(suser.getUserEmail());
            this.setUserPwd(suser.getUserPwd());
            this.setCreateTime(suser.getCreateTime());
            this.setSysRoles(suser.getSysRoles());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        Set<SysRole> userRoles = this.getSysRoles();

        if(userRoles != null) {
            for (SysRole role : userRoles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
                authorities.add(authority);
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return super.getUserPwd();
    }

    @Override
    public String getUsername() {
        return super.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}