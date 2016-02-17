/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marmar.ganaderia_fxml.entidades;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author manuelmartinez
 */
public class Vacunacion {

    private int id_vacunacion;
    private String tipo;
    private String medico;
    private String formula;
    private Date fecha_vacunacion;

    public Vacunacion() {
    }

    public Vacunacion(String tipo, String medico, String formula, Date fecha_vacunacion) {
        this.tipo = tipo;
        this.medico = medico;
        this.formula = formula;
        this.fecha_vacunacion = fecha_vacunacion;
    }

    public int getId_vacunacion() {
        return id_vacunacion;
    }

    public void setId_vacunacion(int id_vacunacion) {
        this.id_vacunacion = id_vacunacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public Date getFecha_vacunacion() {
        return fecha_vacunacion;
    }

    public void setFecha_vacunacion(Date fecha_vacunacion) {
        this.fecha_vacunacion = fecha_vacunacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id_vacunacion;
        hash = 53 * hash + Objects.hashCode(this.tipo);
        hash = 53 * hash + Objects.hashCode(this.medico);
        hash = 53 * hash + Objects.hashCode(this.formula);
        hash = 53 * hash + Objects.hashCode(this.fecha_vacunacion);
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
        final Vacunacion other = (Vacunacion) obj;
        if (this.id_vacunacion != other.id_vacunacion) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.medico, other.medico)) {
            return false;
        }
        if (!Objects.equals(this.formula, other.formula)) {
            return false;
        }
        if (!Objects.equals(this.fecha_vacunacion, other.fecha_vacunacion)) {
            return false;
        }
        return true;
    }


}
