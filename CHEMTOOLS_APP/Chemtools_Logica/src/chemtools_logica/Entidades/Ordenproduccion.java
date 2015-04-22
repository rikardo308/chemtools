package chemtools_logica.Entidades;

import java.io.Serializable;

import java.sql.Timestamp;

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

@Entity
@NamedQueries({ @NamedQuery(name = "Ordenproduccion.findAll", query = "select o from Ordenproduccion o") })
@Table(name = "\"ordenproduccion\"")
public class Ordenproduccion implements Serializable {
    private static final long serialVersionUID = -135451856376923174L;
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "fechaRegistro")
    private Timestamp fechaRegistro;
    @Column(name = "Imagen")
    private byte[] imagen;
    @Column(name = "Estado")
    private int estado;
    @Id
    @Column(name = "idOrdenProduccion", nullable = false)
    private int idOrdenProduccion;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    @OneToMany(mappedBy = "ordenproduccion", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Transformacion> transformacionList1;
    @ManyToOne
    @JoinColumn(name = "idLaboratorio")
    private Laboratorio laboratorio;

    public Ordenproduccion() {
    }

    public Ordenproduccion(String comentario, Timestamp fechaRegistro, Laboratorio laboratorio, int idOrdenProduccion,
                           Usuario usuario) {
        this.comentario = comentario;
        this.fechaRegistro = fechaRegistro;
        this.laboratorio = laboratorio;
        this.idOrdenProduccion = idOrdenProduccion;
        this.usuario = usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }


    public int getIdOrdenProduccion() {
        return idOrdenProduccion;
    }

    public void setIdOrdenProduccion(int idOrdenProduccion) {
        this.idOrdenProduccion = idOrdenProduccion;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Transformacion> getTransformacionList1() {
        return transformacionList1;
    }

    public void setTransformacionList1(List<Transformacion> transformacionList1) {
        this.transformacionList1 = transformacionList1;
    }

    public Transformacion addTransformacion(Transformacion transformacion) {
        getTransformacionList1().add(transformacion);
        transformacion.setOrdenproduccion(this);
        return transformacion;
    }

    public Transformacion removeTransformacion(Transformacion transformacion) {
        getTransformacionList1().remove(transformacion);
        transformacion.setOrdenproduccion(null);
        return transformacion;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }
}
