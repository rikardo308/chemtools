package chemtools_logica.Entidades;

import java.io.Serializable;

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
@NamedQueries({ @NamedQuery(name = "Producto.findAll", query = "select o from Producto o") })
@Table(name = "\"producto\"")
public class Producto implements Serializable {
    private static final long serialVersionUID = 4181431240011881881L;
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
    @Column(name = "Tiempo_Caducacion")
    private Date tiempo_Caducacion;
    @Column(name = "Imagen")
    private byte[] imagen;
    @Id
    @Column(name = "idProducto", nullable = false)
    private String idProducto;
    @OneToMany(mappedBy = "producto", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Transformacion> transformacionList;
    @ManyToOne
    @JoinColumn(name = "idTipoProducto")
    private Tipoproducto tipoproducto;
    @ManyToOne
    @JoinColumn(name = "idEmpresa")
    private Empresa empresa;
    @OneToMany(mappedBy = "producto", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Eventoxproducto> eventoxproductoList1;

    public Producto() {
    }

    public Producto(int calidad, String comentario, int estado, Date fecha_Creacion, Empresa empresa, String idProducto,
                    Tipoproducto tipoproducto) {
        this.calidad = calidad;
        this.comentario = comentario;
        this.estado = estado;
        this.fecha_Creacion = fecha_Creacion;
        this.empresa = empresa;
        this.idProducto = idProducto;
        this.tipoproducto = tipoproducto;
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


    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }


    public List<Transformacion> getTransformacionList() {
        return transformacionList;
    }

    public void setTransformacionList(List<Transformacion> transformacionList) {
        this.transformacionList = transformacionList;
    }

    public Transformacion addTransformacion(Transformacion transformacion) {
        getTransformacionList().add(transformacion);
        transformacion.setProducto(this);
        return transformacion;
    }

    public Transformacion removeTransformacion(Transformacion transformacion) {
        getTransformacionList().remove(transformacion);
        transformacion.setProducto(null);
        return transformacion;
    }

    public void setTipoproducto(Tipoproducto tipoproducto) {
        this.tipoproducto = tipoproducto;
    }

    public Tipoproducto getTipoproducto() {
        return tipoproducto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Eventoxproducto> getEventoxproductoList1() {
        return eventoxproductoList1;
    }

    public void setEventoxproductoList1(List<Eventoxproducto> eventoxproductoList1) {
        this.eventoxproductoList1 = eventoxproductoList1;
    }

    public Eventoxproducto addEventoxproducto(Eventoxproducto eventoxproducto) {
        getEventoxproductoList1().add(eventoxproducto);
        eventoxproducto.setProducto(this);
        return eventoxproducto;
    }

    public Eventoxproducto removeEventoxproducto(Eventoxproducto eventoxproducto) {
        getEventoxproductoList1().remove(eventoxproducto);
        eventoxproducto.setProducto(null);
        return eventoxproducto;
    }

    public void setTiempo_Caducacion(Date tiempo_Caducacion) {
        this.tiempo_Caducacion = tiempo_Caducacion;
    }

    public Date getTiempo_Caducacion() {
        return tiempo_Caducacion;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public byte[] getImagen() {
        return imagen;
    }
}
