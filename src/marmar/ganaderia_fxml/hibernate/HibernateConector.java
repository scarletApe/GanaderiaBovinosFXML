/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marmar.ganaderia_fxml.hibernate;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author manuelmartinez
 */
public class HibernateConector {

    public static final SessionFactory factory;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml)
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }

    public static Object saveObject(Object object) {
        Session session = factory.openSession();
        Transaction tx = null;
        Object objectId = 0;
        try {
            tx = session.beginTransaction();
            objectId = session.save(object);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println(he.getMessage());
            he.printStackTrace();
        } finally {
            session.close();
        }
        return objectId;
    }

    public static void updateObject(Object object) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(object);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println(he.getMessage());
            he.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void deleteObject(Object object) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(object);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println(he.getMessage());
            he.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List executeHQLQuery(String hql) {
        List result = null;
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery(hql);
            result = query.list();
            tx.commit();

        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println(he.getMessage());
            he.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
