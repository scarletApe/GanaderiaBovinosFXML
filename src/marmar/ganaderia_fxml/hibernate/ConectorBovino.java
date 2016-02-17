/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marmar.ganaderia_fxml.hibernate;

import marmar.ganaderia_fxml.entidades.Bovino;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import marmar.ganaderia_fxml.entidades.Raza;
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
public class ConectorBovino {

    public Object saveNew(Bovino r) {
        return HibernateConector.saveObject(r);
    }

    public void update(Bovino r) {
        HibernateConector.updateObject(r);
    }

    public void delete(Bovino r) {
        HibernateConector.deleteObject(r);
    }

    public ArrayList<Bovino> getAll() {
        String hql = "From Bovino";
        ArrayList<Bovino> result = null;
        Session session = HibernateConector.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery(hql);
            result = (ArrayList) query.list();

            for (Bovino b : result) {
                Hibernate.initialize(b.getRaza());
                Hibernate.initialize(b.getVenta());
                Hibernate.initialize(b.getVacunas());
                b.getVacunas().size();
            }
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

    /**
     * This method returns a list of bovines that are not dead and that havent
     * been sold. Also it inizializes their Raze, Sale and Vacination objects.
     *
     * @return
     */
    public ArrayList<Bovino> getVivosyNoVendidos() {
        ArrayList<Bovino> result = null;
        Session session = HibernateConector.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Criteria cr = session.createCriteria(Bovino.class);

            // To check if the given property is null 
            Criterion fm = Restrictions.isNull("fecha_muerte");
            Criterion v = Restrictions.isNull("venta");
            LogicalExpression andexp = Restrictions.and(fm, v);
            cr.add(andexp);

            result = (ArrayList) cr.list();

            for (Bovino b : result) {
                Hibernate.initialize(b.getRaza());
                Hibernate.initialize(b.getVenta());
                Hibernate.initialize(b.getVacunas());
                b.getVacunas().size();
            }
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

    /**
     * This method figures out the months between the current date and the date
     * given.
     *
     * @param d The given date.
     * @return Months between the two dates.
     */
    private int getMonthsOld(Date d) {
        Date actual = new Date();

        int actual_months = (actual.getMonth() + 1) + (actual.getYear() * 12);
        int d_months = (d.getMonth() + 1) + (d.getYear() * 12);

        return actual_months - d_months;
    }

    public ArrayList<Bovino> getBovinosFiltrados(
            String sexo, String estado,
            String arete, Raza raza,
            String edad, int meses) {

        ArrayList<Bovino> result = null;
        Session session = HibernateConector.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Criteria cr = session.createCriteria(Bovino.class);

            //filtrar el sexo
            if (sexo.charAt(0) == 'A') {
            } else {
                Criterion c = Restrictions.ilike("sexo", sexo);
                cr.add(c);
            }

            //filtrar el estado del animal
            if (estado.equalsIgnoreCase("Todo Estado")) {
            } else if (estado.equalsIgnoreCase("Vendidas")) {
                Criterion fm = Restrictions.isNull("fecha_muerte");
                Criterion v = Restrictions.isNotNull("venta");
                cr.add(fm);
                cr.add(v);
            } else if (estado.equalsIgnoreCase("Muertas")) {
                Criterion fm = Restrictions.isNotNull("fecha_muerte");
                Criterion v = Restrictions.isNull("venta");
                cr.add(fm);
                cr.add(v);
            } else {
                //vivas
                Criterion fm = Restrictions.isNull("fecha_muerte");
                Criterion v = Restrictions.isNull("venta");
                cr.add(fm);
                cr.add(v);
            }

            //filtro para los aretes
            if (arete.equalsIgnoreCase("Todas")) {
            } else if (arete.equalsIgnoreCase("Con Arete")) {
                Criterion c = Restrictions.isNotNull("num_arete");
                cr.add(c);
            } else {
                Criterion c = Restrictions.isNull("num_arete");
                cr.add(c);
            }

            result = (ArrayList) cr.list();

            for (Bovino b : result) {
                Hibernate.initialize(b.getRaza());
                Hibernate.initialize(b.getVenta());
                Hibernate.initialize(b.getVacunas());
                b.getVacunas().size();
            }
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

        if (result != null) {
            ArrayList<Bovino> filtrados = new ArrayList<>(result.size());
            if (edad.equalsIgnoreCase("Toda Edad")) {
                return result;
            } else if (edad.equalsIgnoreCase("Mayor o Igual Que")) {

                for (Bovino b : result) {
                    if (b.getEdad() >= meses) {
                        filtrados.add(b);
                    }
                }
            } else {
                for (Bovino b : result) {
                    if (b.getEdad() <= meses) {
                        filtrados.add(b);
                    }
                }

            }
            return filtrados;
        }
        return result;
    }
}
