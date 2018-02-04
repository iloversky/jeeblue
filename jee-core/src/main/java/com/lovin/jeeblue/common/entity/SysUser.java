package com.lovin.jeeblue.common.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lovin on 2018/1/10.
 */
public class SysUser implements Serializable {

    private Integer id;

    private String userName; //用户名

    private String userEmail;//用户邮箱

    private String userPwd;//用户密码

    private Date createTime;//时间

    private Set<SysRole> SysRoles = new HashSet<SysRole>(0);// 所对应的角色集合

    public SysUser() {
    }

    public SysUser(String userName, String userEmail, String userPwd, Date createTime, Set<SysRole> SysRoles) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPwd = userPwd;
        this.createTime = createTime;
        this.SysRoles = SysRoles;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPwd() {
        return this.userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }


    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Set<SysRole> getSysRoles() {
        return this.SysRoles;
    }

    public void setSysRoles(Set<SysRole> SysRoles) {
        this.SysRoles = SysRoles;
    }

    @Override
    public String toString() {
        return this.id + "|" + this.userName;
    }
}
