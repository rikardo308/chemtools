package chemtools_logica.Beans;


import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;

import javax.persistence.Column;


public class TipoproductoBean implements Serializable {
    private String comentario;
    private String descripcion;
    private int estado;
    private BigDecimal tiempo_Expiracion;
    private String temperatura_Maxima;
    private String temperatura_Minima;
    private int idTipoProducto;
    private List<DetalleformulaBean> detalleformulaList;
    private List<ProductoBean> eventoxproductoList;
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

    public void setTiempo_Expiracion(BigDecimal tiempo_Expiracion) {
        this.tiempo_Expiracion = tiempo_Expiracion;
    }

    public BigDecimal getTiempo_Expiracion() {
        return tiempo_Expiracion;
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

    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public int getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setDetalleformulaList(List<DetalleformulaBean> detalleformulaList) {
        this.detalleformulaList = detalleformulaList;
    }

    public List<DetalleformulaBean> getDetalleformulaList() {
        return detalleformulaList;
    }

    public void setEventoxproductoList(List<ProductoBean> eventoxproductoList) {
        this.eventoxproductoList = eventoxproductoList;
    }

    public List<ProductoBean> getEventoxproductoList() {
        return eventoxproductoList;
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
