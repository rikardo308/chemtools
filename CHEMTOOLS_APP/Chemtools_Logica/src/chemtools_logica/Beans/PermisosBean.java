package chemtools_logica.Beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class PermisosBean implements Serializable{
    private int estado;
    private String icono;
    private String nombre;
    private String url;
    private int idPermisos;


    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getIcono() {
        return icono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setIdPermisos(int idPermisos) {
        this.idPermisos = idPermisos;
    }

    public int getIdPermisos() {
        return idPermisos;
    }
}
