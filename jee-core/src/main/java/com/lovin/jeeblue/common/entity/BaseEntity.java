package com.lovin.jeeblue.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Lovin on 2018/1/14.
 */
public class BaseEntity implements Serializable {

    /**
     * ID
     */
    private Long id;
    /**
     * 创建时间
     */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
