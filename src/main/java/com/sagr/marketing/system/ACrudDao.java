package com.sagr.marketing.system;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AGrintsov
 */
public abstract class ACrudDao<T> {
    protected SessionFactory sessionFactory;
    protected Class<T> entityClass;

    protected ACrudDao(SessionFactory sessionFactory, Class<T> entityClass) {
        this.sessionFactory = sessionFactory;
        this.entityClass = entityClass;
    }

    public void add(T entity) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void update(T entity) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public T getById(Integer id) {
        Session session = null;
        T entity = null;
        try {
            session = sessionFactory.openSession();
            entity = (T)session.load(entityClass, id);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return entity;
    }

    public List<T> getAll() {
        Session session = null;
        List<T> entities = new ArrayList<T>();
        try {
            session = sessionFactory.openSession();
            entities = session.createCriteria(entityClass).list();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return entities;
    }

    public void remove(T entity) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<T> find(CriteriaMaker criteriaMaker) {
        Session session = null;
        List<T> entities;
        try {
            session = sessionFactory.openSession();
            Criteria criteria = criteriaMaker.make(session);
            entities = criteria.list();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return entities;
    }

    protected interface CriteriaMaker {
        Criteria make(Session session);
    }
}
