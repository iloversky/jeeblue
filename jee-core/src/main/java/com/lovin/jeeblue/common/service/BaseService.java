package com.lovin.jeeblue.common.service;

import java.io.Serializable;
import java.util.List;

/**
 * service 基础层
 * Created by Lovin on 2018/1/13.
 */
public interface BaseService<T, K> {

    void save(T entity);

    void save(List<T> entities);

    void delete(K id);

    void delete(List<K> ids);

    void update(T entity);

    T findById(K id);

    List<T> findAll();
}
