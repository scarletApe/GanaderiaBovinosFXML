/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marmar.ganaderia_fxml.entidades;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author manuelmartinez
 */
public class Bovino {

    private int id_bovino;
    private String num_arete;
    private String sexo;
    private String pelaje;
    private String melona;
    private String apodo;
    private String comentario;
    private Date fecha_nacimiento;
    private Date fecha_muerte;
    private Raza raza;
    private Venta venta;
    private Set vacunas;
    private int edad;

    public Bovino() {

    }

    public Bovino(String sexo, String pelaje, Date fecha_nacimiento, Raza raza) {
        this.sexo = sexo;
        this.pelaje = pelaje;
        this.fecha_nacimiento = fecha_nacimiento;
        this.raza = raza;
    }

    public int getId_bovino() {
        return id_bovino;
    }

    public void setId_bovino(int id_bovino) {
        this.id_bovino = id_bovino;
    }

    public String getNum_arete() {
        return num_arete;
    }

    public void setNum_arete(String num_arete) {
        this.num_arete = num_arete;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPelaje() {
        return pelaje;
    }

    public void setPelaje(String pelaje) {
        this.pelaje = pelaje;
    }

    public String getMelona() {
        return melona;
    }

    public void setMelona(String melona) {
        this.melona = melona;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Date getFecha_muerte() {
        return fecha_muerte;
    }

    public void setFecha_muerte(Date fecha_muerte) {
        this.fecha_muerte = fecha_muerte;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Set getVacunas() {
        return vacunas;
    }

    public void setVacunas(Set vacunas) {
        this.vacunas = vacunas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getEdad() {
        if (fecha_muerte != null) {
            Date actual = fecha_muerte;

            int actual_months = (actual.getMonth() + 1) + (actual.getYear() * 12);
            int d_months = (fecha_nacimiento.getMonth() + 1) + (fecha_nacimiento.getYear() * 12);

            return actual_months - d_months;
        }
        //no esta muerto
        Date actual = new Date();

        int actual_months = (actual.getMonth() + 1) + (actual.getYear() * 12);
        int d_months = (fecha_nacimiento.getMonth() + 1) + (fecha_nacimiento.getYear() * 12);

        return actual_months - d_months;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id_bovino;
        hash = 41 * hash + Objects.hashCode(this.pelaje);
        hash = 41 * hash + Objects.hashCode(this.fecha_nacimiento);
        hash = 41 * hash + Objects.hashCode(this.raza);
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
        final Bovino other = (Bovino) obj;
        if (this.id_bovino != other.id_bovino) {
            return false;
        }
        if (!this.sexo.equals(other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.pelaje, other.pelaje)) {
            return false;
        }
        if (!Objects.equals(this.fecha_nacimiento, other.fecha_nacimiento)) {
            return false;
        }
        if (!Objects.equals(this.raza, other.raza)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (num_arete != null && !num_arete.isEmpty()) {
            sb.append(num_arete).append(", ");
        }
        if (apodo != null && !apodo.isEmpty()) {
            sb.append(apodo).append(", ");
        }
        sb.append(sexo).append(", ").append(pelaje).append(", ").append(raza)
                .append(", ").append(fecha_nacimiento);
        return sb.toString();
    }

}
