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
@NamedQueries({ @NamedQuery(name = "Eventoxusuario.findAll", query = "select o from Eventoxusuario o") })
@Table(name = "\"eventoxusuario\"")
@IdClass(EventoxusuarioPK.class)
public class Eventoxusuario implements Serializable {
    private static final long serialVersionUID = -4477277682518251378L;
    @Column(name = "Comentario")
    private String comentario;
    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha")
    private Date fecha;
    @ManyToOne
    @Id
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    @ManyToOne
    @Id
    @JoinColumn(name = "idEvento")
    private Evento evento;

    public Eventoxusuario() {
    }

    public Eventoxusuario(String comentario, Date fecha, Evento evento, Usuario usuario) {
        this.comentario = comentario;
        this.fecha = fecha;
        this.evento = evento;
        this.usuario = usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
}
