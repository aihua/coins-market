package com.app.coins.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

/**
 * Implementation of generic DAO class for simple crud operations
 */
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

    private Class<T> type;
    private SessionFactory sessionFactory;
    private Session session;

    protected GenericDaoImpl(Class<T> type) {
        this.type = type;
    }

    @Override
    public PK persist(T newInstance) {
        PK id = (PK) getSession().save(newInstance);
        getSession().flush();
        return id;
    }

    @Override
    public T find(PK id) {
        T object = (T) getSession().get(type, id);
        getSession().flush();
        return object;
    }

    @Override
    public void update(T transientObject) {
        getSession().update(transientObject);
        getSession().flush();
    }

    @Override
    public void delete(T persistentObject) {
        getSession().delete(persistentObject);
        getSession().flush();
    }

    @Override
    public List<T> findAll() {
        List<T> list = getSession().createCriteria(type).list();
        getSession().flush();
        return list;
    }

    private Session getSession() {
        if (session == null) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}