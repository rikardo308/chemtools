package view.backing.Transformaciones;

import java.io.Serializable;

import java.util.Date;

public class TransformacionesFiltro implements Serializable{
    private String nombreLab = "";
    private Date fecIni;
    private Date fecFin;
    private int estado;




    public void setNombreLab(String nombreLab) {
        this.nombreLab = nombreLab;
    }

    public String getNombreLab() {
        return nombreLab;
    }

    public void setFecIni(Date fecIni) {
        this.fecIni = fecIni;
    }

    public Date getFecIni() {
        return fecIni;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

}
