/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marmar.ganaderia_fxml.hibernate;

import marmar.ganaderia_fxml.entidades.Venta;
import java.util.ArrayList;
import marmar.ganaderia_fxml.entidades.Bovino;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author manuelmartinez
 */
public class ConectorVenta {

    public Object saveNew(Venta r) {
        return HibernateConector.saveObject(r);
    }

    public void update(Venta r) {
        HibernateConector.updateObject(r);
    }

    public void delete(Venta r) {
        HibernateConector.deleteObject(r);
    }

    public ArrayList<Venta> getAll() {
        String hql = "From Venta";
        return (ArrayList<Venta>) HibernateConector.executeHQLQuery(hql);
    }
    
    public ArrayList<Bovino> getBovinosdeVenta(Venta v){
        ArrayList<Bovino> result = null;
        String hql = "From Bovino where id_venta="+v.getId_venta();
        Session session = HibernateConector.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery(hql);
            result = (ArrayList) query.list();

            for (Bovino b : result) {
                Hibernate.initialize(b.getRaza());
            }
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println(he.getMessage());
        } finally {
            session.close();
        }
        return result;
    }
}
