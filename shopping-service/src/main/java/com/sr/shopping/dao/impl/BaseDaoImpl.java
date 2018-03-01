package com.sr.shopping.dao.impl;

import com.sr.shopping.dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import static com.sun.tools.attach.VirtualMachine.list;

@Transactional
public class BaseDaoImpl<T> implements BaseDao<T> {

    @Resource private SessionFactory sessionFactory;

    private Class<T> aClass;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Class<T> getaClass() {

        if (aClass == null) {
            aClass = (Class<T>) ((ParameterizedType) this.getClass()
                    .getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return aClass;
    }

    public Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    /**
     * 保存 insert
     *
     * @param o
     */
    @Override
    public Serializable save(T o) {
        return this.getCurrentSession().save(o);
    }

    /**
     * 删除delete 按id
     *
     * @param id
     */
    @Override
    public void delete(Serializable id) {
        T t = this.get(id);
        this.delete(t);
    }

    /**
     * 删除delete 按class
     *
     * @param o
     */
    @Override
    public void delete(T o) {
        this.getCurrentSession().delete(o);
    }

    /**
     * 修改
     *
     * @param o
     */
    @Override
    public void update(T o) {
        this.getCurrentSession().update(o);
    }

    /**
     * saveOrUpdate
     *
     * @param o
     */
    @Override
    public void saveOrUpdate(T o) {
        this.getCurrentSession().saveOrUpdate(o);
    }

    /**
     * 获取单个对象
     *
     * @param id
     */
    @Override
    public T get(Serializable id) {
        return this.getCurrentSession().get(this.getaClass(), id);
    }

    /**
     * 获取数组
     *
     * @param hql
     */
    @Override
    public List<T> find(String hql) {
        Query query = this.getCurrentSession().createQuery(hql);
        return query.list();
    }

    /**
     * 获取数组
     *
     * @param hql
     * @param params
     */
    @Override
    public List<T> find(String hql, Map<String, Object> params) {
        Query query = this.getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
        }
        return query.list();
    }

    /**
     * 获取数组分页
     *
     * @param hql
     * @param page
     * @param rows
     */
    @Override
    public List<T> find(String hql, int page, int rows) {
        Query query = this.getCurrentSession().createQuery(hql);
        query.setFirstResult((page - 1) * rows).setMaxResults(rows);
        return query.list();
    }

    /**
     * 获取数组分页
     *
     * @param hql
     * @param params
     * @param page
     * @param rows
     */
    @Override
    public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
        Query query = this.getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
        }
        query.setFirstResult((page - 1) * rows).setMaxResults(rows);
        return query.list();
    }

    /**
     * 获取记录数量
     *
     * @param hql
     */
    @Override
    public Integer count(String hql) {
        Query query = this.getCurrentSession().createQuery(hql);
        Long l = (Long) query.uniqueResult();
        return l.intValue();
    }

    /**
     * 获取记录数量
     *
     * @param hql
     * @param id
     */
    @Override
    public Integer count(String hql, Integer id) {
        Query query = this.getCurrentSession().createQuery(hql);
        query.setInteger(0, id);
        Long l = (Long) query.uniqueResult();
        return l.intValue();
    }

    /**
     * 获取记录数量
     *
     * @param hql
     * @param params
     */
    @Override
    public Integer count(String hql, Map<String, Object> params) {
        Query query = this.getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
        }
        Long l = (Long) query.uniqueResult();
        return l.intValue();
    }

    /**
     * 一些特殊的DML，如特殊的修改
     *
     * @param hql
     */
    @Override
    public int executeHql(String hql) {
        Query query = this.getCurrentSession().createQuery(hql);
        return query.executeUpdate();
    }

    /**
     * 一些特殊的DML，如特殊的修改
     *
     * @param hql
     * @param params
     */
    @Override
    public int executeHql(String hql, Map<String, Object> params) {
        Query query = this.getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
        }
        return query.executeUpdate();
    }
}
