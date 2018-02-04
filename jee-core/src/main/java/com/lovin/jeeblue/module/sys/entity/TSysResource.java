package com.lovin.jeeblue.module.sys.entity;

import com.lovin.jeeblue.common.entity.BaseEntity;

public class TSysResource extends BaseEntity {
    private Long id;

    private String resourceName;

    private String resourceUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }
}