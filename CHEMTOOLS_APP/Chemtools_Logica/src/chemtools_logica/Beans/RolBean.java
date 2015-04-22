package chemtools_logica.Beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class RolBean implements Serializable{
    private int estado;
    private String nombre;
    private int idRol;

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getIdRol() {
        return idRol;
    }
}
