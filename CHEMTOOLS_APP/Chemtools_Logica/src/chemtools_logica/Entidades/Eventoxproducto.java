package chemtools_logica.Entidades;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "Eventoxproducto.findAll", query = "select o from Eventoxproducto o") })
@Table(name = "\"eventoxproducto\"")
@IdClass(EventoxproductoPK.class)
public class Eventoxproducto implements Serializable {
    private static final long serialVersionUID = -4310611589102195170L;
    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha_Evento")
    private Date fecha_Evento;
    @ManyToOne
    @Id
    @JoinColumn(name = "idEvento")
    private Evento evento;
    @ManyToOne
    @Id
    @JoinColumn(name = "idProducto")
    private Producto producto;
    @ManyToOne
    @Id
    @JoinColumn(name = "idAlmacen")
    private Almacen almacen;
    @ManyToOne
    @Id
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Eventoxproducto() {
    }

    public Eventoxproducto(Date fecha_Evento, Almacen almacen, Evento evento, Producto producto,
                           Usuario usuario) {
        this.fecha_Evento = fecha_Evento;
        this.almacen = almacen;
        this.evento = evento;
        this.producto = producto;
        this.usuario = usuario;
    }

    public Date getFecha_Evento() {
        return fecha_Evento;
    }

    public void setFecha_Evento(Date fecha_Evento) {
        this.fecha_Evento = fecha_Evento;
    }


    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
