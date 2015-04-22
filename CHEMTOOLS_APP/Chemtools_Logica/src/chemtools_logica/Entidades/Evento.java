package chemtools_logica.Entidades;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Evento.findAll", query = "select o from Evento o") })
@Table(name = "\"evento\"")
public class Evento implements Serializable {
    private static final long serialVersionUID = -8640064129347356394L;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Estado")
    private int estado;
    @Id
    @Column(name = "idEvento", nullable = false)
    private int idEvento;
    @OneToMany(mappedBy = "evento", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Eventoxproducto> eventoxproductoList;
    @OneToMany(mappedBy = "evento", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Eventoxinsumo> eventoxinsumoList2;
    @OneToMany(mappedBy = "evento", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Eventoxusuario> eventoxusuarioList1;

    public Evento() {
    }

    public Evento(String descripcion, int estado, int idEvento) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.idEvento = idEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public List<Eventoxproducto> getEventoxproductoList() {
        return eventoxproductoList;
    }

    public void setEventoxproductoList(List<Eventoxproducto> eventoxproductoList) {
        this.eventoxproductoList = eventoxproductoList;
    }

    public Eventoxproducto addEventoxproducto(Eventoxproducto eventoxproducto) {
        getEventoxproductoList().add(eventoxproducto);
        eventoxproducto.setEvento(this);
        return eventoxproducto;
    }

    public Eventoxproducto removeEventoxproducto(Eventoxproducto eventoxproducto) {
        getEventoxproductoList().remove(eventoxproducto);
        eventoxproducto.setEvento(null);
        return eventoxproducto;
    }

    public List<Eventoxinsumo> getEventoxinsumoList2() {
        return eventoxinsumoList2;
    }

    public void setEventoxinsumoList2(List<Eventoxinsumo> eventoxinsumoList2) {
        this.eventoxinsumoList2 = eventoxinsumoList2;
    }

    public Eventoxinsumo addEventoxinsumo(Eventoxinsumo eventoxinsumo) {
        getEventoxinsumoList2().add(eventoxinsumo);
        eventoxinsumo.setEvento(this);
        return eventoxinsumo;
    }

    public Eventoxinsumo removeEventoxinsumo(Eventoxinsumo eventoxinsumo) {
        getEventoxinsumoList2().remove(eventoxinsumo);
        eventoxinsumo.setEvento(null);
        return eventoxinsumo;
    }

    public List<Eventoxusuario> getEventoxusuarioList1() {
        return eventoxusuarioList1;
    }

    public void setEventoxusuarioList1(List<Eventoxusuario> eventoxusuarioList1) {
        this.eventoxusuarioList1 = eventoxusuarioList1;
    }

    public Eventoxusuario addEventoxusuario(Eventoxusuario eventoxusuario) {
        getEventoxusuarioList1().add(eventoxusuario);
        eventoxusuario.setEvento(this);
        return eventoxusuario;
    }

    public Eventoxusuario removeEventoxusuario(Eventoxusuario eventoxusuario) {
        getEventoxusuarioList1().remove(eventoxusuario);
        eventoxusuario.setEvento(null);
        return eventoxusuario;
    }
}
