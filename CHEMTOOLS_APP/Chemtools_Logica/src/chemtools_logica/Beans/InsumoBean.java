package chemtools_logica.Beans;

import chemtools_logica.Entidades.Eventoxinsumo;
import chemtools_logica.Entidades.Tipoinsumo;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class InsumoBean implements Serializable{
    private int calidad;
    private String comentario;
    private int estado;
    private Date fecha_Creacion;
    private Date fecha_Caducacion;
    private String idInsumo;
    private String imagen;
    private TipoinsumoBean tipoinsumo1;
    //EXTRAS
    private String unidadMedida;
    private String contenedor;
    private String tipoInsumo;
    private String razonSocialEmpresa;
    
    private int idunidadMeidad;
    private int idcontenedor;
    private int idtipoInsumo;
    private int idEmpresa;

    private String styleEstado;
    
    private String calidadText;
    
    private Date fechaCaducidadMin;
    private Date fechaCaducidadMax;
    private Date fechaCreaciondMin;
    private Date fechaCreaciondMax;
    
    private int idAlmacen;

    public void setCalidad(int calidad) {
        this.calidad = calidad;
    }

    public int getCalidad() {
        return calidad;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setFecha_Creacion(Date fecha_Creacion) {
        this.fecha_Creacion = fecha_Creacion;
    }

    public Date getFecha_Creacion() {
        return fecha_Creacion;
    }

    public void setIdInsumo(String idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getIdInsumo() {
        return idInsumo;
    }

    public void setTipoinsumo1(TipoinsumoBean tipoinsumo1) {
        this.tipoinsumo1 = tipoinsumo1;
    }

    public TipoinsumoBean getTipoinsumo1() {
        return tipoinsumo1;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setContenedor(String contenedor) {
        this.contenedor = contenedor;
    }

    public String getContenedor() {
        return contenedor;
    }

    public void setTipoInsumo(String tipoInsumo) {
        this.tipoInsumo = tipoInsumo;
    }

    public String getTipoInsumo() {
        return tipoInsumo;
    }

    public void setIdunidadMeidad(int idunidadMeidad) {
        this.idunidadMeidad = idunidadMeidad;
    }

    public int getIdunidadMeidad() {
        return idunidadMeidad;
    }

    public void setIdcontenedor(int idcontenedor) {
        this.idcontenedor = idcontenedor;
    }

    public int getIdcontenedor() {
        return idcontenedor;
    }

    public void setIdtipoInsumo(int idtipoInsumo) {
        this.idtipoInsumo = idtipoInsumo;
    }

    public int getIdtipoInsumo() {
        return idtipoInsumo;
    }

    public void setRazonSocialEmpresa(String razonSocialEmpresa) {
        this.razonSocialEmpresa = razonSocialEmpresa;
    }

    public String getRazonSocialEmpresa() {
        return razonSocialEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setStyleEstado(String styleEstado) {
        this.styleEstado = styleEstado;
    }

    public String getStyleEstado() {
        return styleEstado;
    }

    public void setCalidadText(String calidadText) {
        this.calidadText = calidadText;
    }

    public String getCalidadText() {
        return calidadText;
    }

    public void setFecha_Caducacion(Date fecha_Caducacion) {
        this.fecha_Caducacion = fecha_Caducacion;
    }

    public Date getFecha_Caducacion() {
        return fecha_Caducacion;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setFechaCaducidadMin(Date fechaCaducidadMin) {
        this.fechaCaducidadMin = fechaCaducidadMin;
    }

    public Date getFechaCaducidadMin() {
        return fechaCaducidadMin;
    }

    public void setFechaCaducidadMax(Date fechaCaducidadMax) {
        this.fechaCaducidadMax = fechaCaducidadMax;
    }

    public Date getFechaCaducidadMax() {
        return fechaCaducidadMax;
    }

    public void setFechaCreaciondMin(Date fechaCreaciondMin) {
        this.fechaCreaciondMin = fechaCreaciondMin;
    }

    public Date getFechaCreaciondMin() {
        return fechaCreaciondMin;
    }

    public void setFechaCreaciondMax(Date fechaCreaciondMax) {
        this.fechaCreaciondMax = fechaCreaciondMax;
    }

    public Date getFechaCreaciondMax() {
        return fechaCreaciondMax;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public int getIdAlmacen() {
        return idAlmacen;
    }
}
