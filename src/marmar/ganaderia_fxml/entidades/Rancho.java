/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marmar.ganaderia_fxml.entidades;

import java.util.Date;

/**
 *
 * @author manuelmartinez
 */
public class Rancho {

    private int id_rancho;
    private String nombre;
    private String rfc;
    private String fiero;
    private Date fecha_establecimiento;
    private String domicilio;

    public Rancho() {
    }

    public Rancho(String nombre, String rfc, String fiero, Date fecha_establecimiento, String domicilio) {
        this.nombre = nombre;
        this.rfc = rfc;
        this.fiero = fiero;
        this.fecha_establecimiento = fecha_establecimiento;
        this.domicilio = domicilio;
    }

    public int getId_rancho() {
        return id_rancho;
    }

    public void setId_rancho(int id_rancho) {
        this.id_rancho = id_rancho;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getFiero() {
        return fiero;
    }

    public void setFiero(String fiero) {
        this.fiero = fiero;
    }

    public Date getFecha_establecimiento() {
        return fecha_establecimiento;
    }

    public void setFecha_establecimiento(Date fecha_establecimiento) {
        this.fecha_establecimiento = fecha_establecimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }


}
