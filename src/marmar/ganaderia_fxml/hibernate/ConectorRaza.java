/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marmar.ganaderia_fxml.hibernate;

import marmar.ganaderia_fxml.entidades.Raza;
import java.util.ArrayList;

/**
 *
 * @author manuelmartinez
 */
public class ConectorRaza {

    public Object saveNew(Raza r) {
        return HibernateConector.saveObject(r);
    }

    public void update(Raza r) {
        HibernateConector.updateObject(r);
    }

    public void delete(Raza r) {
        HibernateConector.deleteObject(r);
    }

    public ArrayList<Raza> getAll() {
        String hql = "From Raza";
        return (ArrayList<Raza>) HibernateConector.executeHQLQuery(hql);
    }
}
