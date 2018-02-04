package com.lovin.jeeblue.module.sys.entity;

import com.lovin.jeeblue.common.entity.BaseEntity;

public class TSysResourceRole extends BaseEntity {
    private Long id;

    private String resourceUrl;

    private String roleCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}