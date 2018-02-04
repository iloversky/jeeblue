package com.lovin.jeeblue.common.mapper;

import com.lovin.jeeblue.common.entity.BaseEntity;

import java.util.List;

/**
 * Created by Lovin on 2018/1/13.
 */
public interface BaseMapper<T extends BaseEntity> {

    List<T> selectAll();

    int delete(String id);

    T select(String id);

    int insert(T record);

    int update(T record);
}
