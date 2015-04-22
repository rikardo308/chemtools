package chemtools_logica.Beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class MedidaBean implements Serializable{
    private String descripcion;
    private int estado;
    private int idMedida;


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

    public void setIdMedida(int idMedida) {
        this.idMedida = idMedida;
    }

    public int getIdMedida() {
        return idMedida;
    }
}
