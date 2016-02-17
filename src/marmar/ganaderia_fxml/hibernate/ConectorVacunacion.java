/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marmar.ganaderia_fxml.hibernate;

import marmar.ganaderia_fxml.entidades.Vacunacion;
import java.util.ArrayList;
import marmar.ganaderia_fxml.entidades.Bovino;
import marmar.ganaderia_fxml.entidades.Venta;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author manuelmartinez
 */
public class ConectorVacunacion {

    public Object saveNew(Vacunacion r) {
        return HibernateConector.saveObject(r);
    }

    public void update(Vacunacion r) {
        HibernateConector.updateObject(r);
    }

    public void delete(Vacunacion r) {
        HibernateConector.deleteObject(r);
    }

    public ArrayList<Vacunacion> getAll() {
        String hql = "From Vacunacion";
        return (ArrayList<Vacunacion>) HibernateConector.executeHQLQuery(hql);
    }
    
    public ArrayList<Bovino> getBovinosdeVacunacion(Vacunacion v){
        ArrayList<Bovino> result = null;
        /*
        SELECT * FROM DONORS
WHERE RELIGION_CODE <> (SELECT RELIGION_CODE FROM RELIGIONS
                            WHERE UPPER(RELIGION_NAME) LIKE 'PASTAFARISMO');
        */
        String hql = "From Bovino where id_bovino in "
                + "(select id_bovino from Bov_Vac where id_vacunacion="+v.getId_vacunacion()+")";
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
