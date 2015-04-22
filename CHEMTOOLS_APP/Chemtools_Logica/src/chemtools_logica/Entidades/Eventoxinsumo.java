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
@NamedQueries({ @NamedQuery(name = "Eventoxinsumo.findAll", query = "select o from Eventoxinsumo o") })
@Table(name = "\"eventoxinsumo\"")
@IdClass(EventoxinsumoPK.class)
public class Eventoxinsumo implements Serializable {
    private static final long serialVersionUID = 2006544766982758346L;
    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha_Evento")
    private Date fecha_Evento;
    @ManyToOne
    @Id
    @JoinColumn(name = "idInsumo")
    private Insumo insumo;
    @ManyToOne
    @Id
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    @ManyToOne
    @Id
    @JoinColumn(name = "idEvento")
    private Evento evento;
    @ManyToOne
    @Id
    @JoinColumn(name = "idAlmacen")
    private Almacen almacen;

    public Eventoxinsumo() {
    }

    public Eventoxinsumo(Date fecha_Evento, Almacen almacen, Evento evento, Insumo insumo,
                         Usuario usuario) {
        this.fecha_Evento = fecha_Evento;
        this.almacen = almacen;
        this.evento = evento;
        this.insumo = insumo;
        this.usuario = usuario;
    }

    public Date getFecha_Evento() {
        return fecha_Evento;
    }

    public void setFecha_Evento(Date fecha_Evento) {
        this.fecha_Evento = fecha_Evento;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Almacen getAlmacen() {
        return almacen;
    }
}
