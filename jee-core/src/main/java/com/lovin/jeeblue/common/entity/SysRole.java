package com.lovin.jeeblue.common.entity;

/**
 * Created by Lovin on 2018/1/10.
 */
public class SysRole {

    private int id;

    private SysUser SUser;// 角色对应的用户实体

    private String name;// 角色名称

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public SysUser getSUser() {
        return SUser;
    }
    public void setSUser(SysUser sUser) {
        SUser = sUser;
    }
}
