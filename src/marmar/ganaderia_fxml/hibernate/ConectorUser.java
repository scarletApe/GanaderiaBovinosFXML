/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marmar.ganaderia_fxml.hibernate;

import marmar.ganaderia_fxml.entidades.User;
import java.util.ArrayList;

/**
 *
 * @author manuelmartinez
 */
public class ConectorUser {

    public Object saveNew(User r) {
        return HibernateConector.saveObject(r);
    }

    public void update(User r) {
        HibernateConector.updateObject(r);
    }

    public void delete(User r) {
        HibernateConector.deleteObject(r);
    }

    public ArrayList<User> getAll() {
        String hql = "From User";
        return (ArrayList<User>) HibernateConector.executeHQLQuery(hql);
    }
}
