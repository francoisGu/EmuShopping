package com.litaos.mapper;

import com.litaos.factory.MySessionFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by litaoshen on 10/09/2015.
 */
public class ObjectMapper implements ObjectRepository {
    @Override
    public int create(Object object) {

        if(object == null){
            return 0;
        }

        // get session & transaction
        Session session = MySessionFactory.getSession();
        Transaction transaction = null;

        // id
        int _id = 0;

        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return _id;
    }

    @Override
    public boolean update(Object object) {

        if(object == null){
            return false;
        }

        // check if update successfully
        boolean success = true;

        // get session & transaction
        Session session = MySessionFactory.getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
//            session.merge(object);
            session.saveOrUpdate(object);
            transaction.commit();
        } catch (HibernateException e) {

            // fail to update
            success = false;

            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return success;
    }

    @Override
    public boolean delete(Object object) {

        if(object == null){
            return false;
        }

        // check if update successfully
        boolean success = true;

        // get session & transaction
        Session session = MySessionFactory.getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        } catch (HibernateException e) {

            // fail to delete
            success = false;

            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return success;
    }

    @Override
    public List<Object> findByKey(Class objectClass, String key, Object value) {

        List<Object> objectList = null;

        // get session & transaction
        Session session = MySessionFactory.getSession();
        Transaction transaction = null;

        if (key == null || value == null) {
            return objectList;
        }

        try {
            // Criteria
            Criteria criteria = session.createCriteria(objectClass);

            transaction = session.beginTransaction();

            criteria.add(Restrictions.eq(key, value));
            List results = criteria.list();

            if(results.size() > 0) {
                objectList = results;
            }

            transaction.commit();
        } catch (HibernateException e) {

            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return objectList;
    }



    @Override
    public List listAll(Class objectClass) {

        if (objectClass == null) {
            return null;
        }

        List<Object> objects = null;

        // get session & transaction
        Session session = MySessionFactory.getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Criteria criteria = session.createCriteria(objectClass);

            objects = criteria.list();

            transaction.commit();

        } catch (HibernateException e) {

            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return objects;
    }
}
