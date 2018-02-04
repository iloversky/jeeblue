package com.lovin.jeeblue.common.service.impl;

import com.lovin.jeeblue.common.service.BaseService;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Lovin on 2018/1/13.
 */
public class BaseServiceImpl<T, K> implements BaseService<T, K> {

    private Class<T> modelClass;    // 当前泛型真实类型的Class

    public BaseServiceImpl() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public void save(T entity) {

    }

    @Override
    public void save(List<T> entities) {

    }

    @Override
    public void delete(K id) {

    }

    @Override
    public void delete(List<K> ids) {

    }

    @Override
    public void update(T entity) {

    }

    @Override
    public T findById(K id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }
}
