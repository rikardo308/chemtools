package chemtools_logica.Beans;

import chemtools_logica.Entidades.Contenedores;
import chemtools_logica.Entidades.Detalleformula;
import chemtools_logica.Entidades.Insumo;
import chemtools_logica.Entidades.Medida;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class TipoinsumoBean implements Serializable{
    private String comentario;
    private String descripcion;
    private int estado;
    private String temperatura_Maxima;
    private String temperatura_Minima;
    private int idTipoInsumo;
    private MedidaBean medida;
    private ContenedoresBean contenedores;


    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getComentario() {
        return comentario;
    }

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

    public void setTemperatura_Maxima(String temperatura_Maxima) {
        this.temperatura_Maxima = temperatura_Maxima;
    }

    public String getTemperatura_Maxima() {
        return temperatura_Maxima;
    }

    public void setTemperatura_Minima(String temperatura_Minima) {
        this.temperatura_Minima = temperatura_Minima;
    }

    public String getTemperatura_Minima() {
        return temperatura_Minima;
    }

    public void setIdTipoInsumo(int idTipoInsumo) {
        this.idTipoInsumo = idTipoInsumo;
    }

    public int getIdTipoInsumo() {
        return idTipoInsumo;
    }

    public void setMedida(MedidaBean medida) {
        this.medida = medida;
    }

    public MedidaBean getMedida() {
        return medida;
    }

    public void setContenedores(ContenedoresBean contenedores) {
        this.contenedores = contenedores;
    }

    public ContenedoresBean getContenedores() {
        return contenedores;
    }
}
