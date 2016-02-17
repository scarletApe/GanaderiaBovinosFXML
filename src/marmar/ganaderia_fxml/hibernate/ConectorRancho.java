/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marmar.ganaderia_fxml.hibernate;

import marmar.ganaderia_fxml.entidades.Rancho;
import java.util.ArrayList;

/**
 *
 * @author manuelmartinez
 */
public class ConectorRancho {

    public Object saveNew(Rancho r) {
        return HibernateConector.saveObject(r);
    }

    public void update(Rancho r) {
        HibernateConector.updateObject(r);
    }

    public void delete(Rancho r) {
        HibernateConector.deleteObject(r);
    }

    public ArrayList<Rancho> getAll() {
        String hql = "From Rancho";
        return (ArrayList<Rancho>) HibernateConector.executeHQLQuery(hql);
    }
}
