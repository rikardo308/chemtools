package chemtools_logica.Beans;

import chemtools_logica.Entidades.Almacen;
import chemtools_logica.Entidades.Evento;
import chemtools_logica.Entidades.Insumo;
import chemtools_logica.Entidades.Usuario;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class EventoxinsumoBean implements Serializable{
    private Date fecha_Evento;
    private InsumoBean insumo;
    private UsuarioBean usuario;
    private EventoBean evento;
    private AlmacenBean almacen;
    
    //EXTRAS
    private int idUsuario;
    private int idEvento;
    private int idAlmacen;


    public void setFecha_Evento(Date fecha_Evento) {
        this.fecha_Evento = fecha_Evento;
    }

    public Date getFecha_Evento() {
        return fecha_Evento;
    }

    public void setInsumo(InsumoBean insumo) {
        this.insumo = insumo;
    }

    public InsumoBean getInsumo() {
        return insumo;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }

    public UsuarioBean getUsuario() {
        return usuario;
    }

    public void setEvento(EventoBean evento) {
        this.evento = evento;
    }

    public EventoBean getEvento() {
        return evento;
    }

    public void setAlmacen(AlmacenBean almacen) {
        this.almacen = almacen;
    }

    public AlmacenBean getAlmacen() {
        return almacen;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public int getIdAlmacen() {
        return idAlmacen;
    }
}
