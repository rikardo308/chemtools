package chemtools_logica.Beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class ContenedoresBean implements Serializable{
    private String descripcion;
    private int estado;
    private int idContenedores;


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setIdContenedores(int idContenedores) {
        this.idContenedores = idContenedores;
    }

    public int getIdContenedores() {
        return idContenedores;
    }
}
