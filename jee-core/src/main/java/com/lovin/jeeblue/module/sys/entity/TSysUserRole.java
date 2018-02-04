package com.lovin.jeeblue.module.sys.entity;

import com.lovin.jeeblue.common.entity.BaseEntity;

public class TSysUserRole extends BaseEntity {
    private Long id;

    private String userId;

    private String roleCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}