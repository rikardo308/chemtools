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
@NamedQueries({ @NamedQuery(name = "Almacen.findAll", query = "select o from Almacen o") })
@Table(name = "\"almacen\"")
public class Almacen implements Serializable {
    private static final long serialVersionUID = 8708846059692104443L;
    @Column(name = "Capacidad")
    private int capacidad;
    @Column(name = "Direccion")
    private String direccion;
    @Column(name = "Estado")
    private int estado;
    @Column(name = "TipoAlmacen")
    private int tipoAlmacen;
    @Id
    @Column(name = "idAlmacen", nullable = false)
    private int idAlmacen;
    @Column(name = "idDepartamento")
    private int idDepartamento;
    @Column(name = "idDistrito")
    private int idDistrito;
    @Column(name = "idProvicia")
    private int idProvicia;
    @Column(name = "Nombre")
    private String nombre;
    @OneToMany(mappedBy = "almacen", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Eventoxproducto> eventoxproductoList2;
    @OneToMany(mappedBy = "almacen", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Eventoxinsumo> eventoxinsumoList3;

    public Almacen() {
    }

    public Almacen(int capacidad, String direccion, int estado, int idAlmacen, int idDepartamento, int idDistrito,
                   int idProvicia, String nombre) {
        this.capacidad = capacidad;
        this.direccion = direccion;
        this.estado = estado;
        this.idAlmacen = idAlmacen;
        this.idDepartamento = idDepartamento;
        this.idDistrito = idDistrito;
        this.idProvicia = idProvicia;
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public int getIdProvicia() {
        return idProvicia;
    }

    public void setIdProvicia(int idProvicia) {
        this.idProvicia = idProvicia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Eventoxproducto> getEventoxproductoList2() {
        return eventoxproductoList2;
    }

    public void setEventoxproductoList2(List<Eventoxproducto> eventoxproductoList2) {
        this.eventoxproductoList2 = eventoxproductoList2;
    }

    public Eventoxproducto addEventoxproducto(Eventoxproducto eventoxproducto) {
        getEventoxproductoList2().add(eventoxproducto);
        eventoxproducto.setAlmacen(this);
        return eventoxproducto;
    }

    public Eventoxproducto removeEventoxproducto(Eventoxproducto eventoxproducto) {
        getEventoxproductoList2().remove(eventoxproducto);
        eventoxproducto.setAlmacen(null);
        return eventoxproducto;
    }

    public List<Eventoxinsumo> getEventoxinsumoList3() {
        return eventoxinsumoList3;
    }

    public void setEventoxinsumoList3(List<Eventoxinsumo> eventoxinsumoList3) {
        this.eventoxinsumoList3 = eventoxinsumoList3;
    }

    public Eventoxinsumo addEventoxinsumo(Eventoxinsumo eventoxinsumo) {
        getEventoxinsumoList3().add(eventoxinsumo);
        eventoxinsumo.setAlmacen(this);
        return eventoxinsumo;
    }

    public Eventoxinsumo removeEventoxinsumo(Eventoxinsumo eventoxinsumo) {
        getEventoxinsumoList3().remove(eventoxinsumo);
        eventoxinsumo.setAlmacen(null);
        return eventoxinsumo;
    }

    public void setTipoAlmacen(int tipoAlmacen) {
        this.tipoAlmacen = tipoAlmacen;
    }

    public int getTipoAlmacen() {
        return tipoAlmacen;
    }
}
