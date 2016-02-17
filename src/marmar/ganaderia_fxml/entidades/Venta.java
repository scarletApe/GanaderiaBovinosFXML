/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marmar.ganaderia_fxml.entidades;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author manuelmartinez
 */
public class Venta {

    private int id_venta;
    private String comprador;
    private Date fecha_venta;
    private BigDecimal monto;

    public Venta() {
    }

    public Venta(String comprador, Date fecha_venta, BigDecimal monto) {
        this.comprador = comprador;
        this.fecha_venta = fecha_venta;
        this.monto = monto;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id_venta;
        hash = 53 * hash + Objects.hashCode(this.comprador);
        hash = 53 * hash + Objects.hashCode(this.fecha_venta);
        hash = 53 * hash + Objects.hashCode(this.monto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venta other = (Venta) obj;
        if (this.id_venta != other.id_venta) {
            return false;
        }
        if (!Objects.equals(this.comprador, other.comprador)) {
            return false;
        }
        if (!Objects.equals(this.fecha_venta, other.fecha_venta)) {
            return false;
        }
        if (!Objects.equals(this.monto, other.monto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return comprador + " " + fecha_venta;
    }

}
