package chemtools_logica.Entidades;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "Insumo.findAll", query = "select o from Insumo o") })
@Table(name = "\"insumo\"")
public class Insumo implements Serializable {
    private static final long serialVersionUID = -7132475905656482383L;
    @Column(name = "Calidad")
    private int calidad;
    @Column(name = "Comentario")
    private String comentario;
    @Column(name = "Estado")
    private int estado;
    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha_Creacion")
    private Date fecha_Creacion;
    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha_Caducacion")
    private Date fecha_Caducacion;
    @Column(name = "Imagen")
    private String imagen;
    @Column(name = "Contenido")
    private BigDecimal contenido;
    @Id
    @Column(name = "idInsumo", nullable = false)
    private String idInsumo;
    @OneToMany(mappedBy = "insumo", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Eventoxinsumo> eventoxinsumoList;
    @ManyToOne
    @JoinColumn(name = "idTipoInsumo")
    private Tipoinsumo tipoinsumo;
    @OneToMany(mappedBy = "insumo", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Transformacion> transformacionList2;
    @ManyToOne
    @JoinColumn(name = "idEmpresa")
    private Empresa empresa;

    public Insumo() {
    }

    public Insumo(int calidad, String comentario, int estado, Date fecha_Creacion, Empresa empresa, String idInsumo,
                  Tipoinsumo tipoinsumo, Date fecha_Caducacion, String imagen) {
        this.calidad = calidad;
        this.comentario = comentario;
        this.estado = estado;
        this.fecha_Creacion = fecha_Creacion;
        this.empresa = empresa;
        this.idInsumo = idInsumo;
        this.tipoinsumo = tipoinsumo;
        this.fecha_Caducacion = fecha_Caducacion;
        this.imagen = imagen;
    }

    public int getCalidad() {
        return calidad;
    }

    public void setCalidad(int calidad) {
        this.calidad = calidad;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFecha_Creacion() {
        return fecha_Creacion;
    }

    public void setFecha_Creacion(Date fecha_Creacion) {
        this.fecha_Creacion = fecha_Creacion;
    }


    public String getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(String idInsumo) {
        this.idInsumo = idInsumo;
    }


    public List<Eventoxinsumo> getEventoxinsumoList() {
        return eventoxinsumoList;
    }

    public void setEventoxinsumoList(List<Eventoxinsumo> eventoxinsumoList) {
        this.eventoxinsumoList = eventoxinsumoList;
    }

    public Eventoxinsumo addEventoxinsumo(Eventoxinsumo eventoxinsumo) {
        getEventoxinsumoList().add(eventoxinsumo);
        eventoxinsumo.setInsumo(this);
        return eventoxinsumo;
    }

    public Eventoxinsumo removeEventoxinsumo(Eventoxinsumo eventoxinsumo) {
        getEventoxinsumoList().remove(eventoxinsumo);
        eventoxinsumo.setInsumo(null);
        return eventoxinsumo;
    }


    public void setTipoinsumo(Tipoinsumo tipoinsumo) {
        this.tipoinsumo = tipoinsumo;
    }

    public Tipoinsumo getTipoinsumo() {
        return tipoinsumo;
    }

    public List<Transformacion> getTransformacionList2() {
        return transformacionList2;
    }

    public void setTransformacionList2(List<Transformacion> transformacionList2) {
        this.transformacionList2 = transformacionList2;
    }

    public Transformacion addTransformacion(Transformacion transformacion) {
        getTransformacionList2().add(transformacion);
        transformacion.setInsumo(this);
        return transformacion;
    }

    public Transformacion removeTransformacion(Transformacion transformacion) {
        getTransformacionList2().remove(transformacion);
        transformacion.setInsumo(null);
        return transformacion;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Empresa getEmpresa() {
        return empresa;
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

    public void setContenido(BigDecimal contenido) {
        this.contenido = contenido;
    }

    public BigDecimal getContenido() {
        return contenido;
    }
}
