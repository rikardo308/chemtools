package chemtools_logica.Entidades;

import java.io.Serializable;

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
@NamedQueries({ @NamedQuery(name = "Usuario.findAll", query = "select o from Usuario o") })
@Table(name = "\"usuario\"")
public class Usuario implements Serializable {
    private static final long serialVersionUID = -3190514682852834676L;
    @Column(name = "Clave")
    private String clave;
    @Column(name = "Estado")
    private int estado;
    @Column(name = "Fecha_Registro")
    private String fecha_Registro;
    @Column(name = "Nombre_Usuario")
    private String nombre_Usuario;
    @Id
    @Column(name = "idUsuario", nullable = false)
    private int idUsuario;
    @OneToMany(mappedBy = "usuario", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Eventoxinsumo> eventoxinsumoList1;
    @OneToMany(mappedBy = "usuario", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Ordenproduccion> ordenproduccionList;
    @OneToMany(mappedBy = "usuario", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Eventoxusuario> eventoxusuarioList;
    @OneToMany(mappedBy = "usuario", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Usuarioxrol> usuarioxrolList;
    @OneToMany(mappedBy = "usuario", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Transformacion> transformacionList4;
    @OneToMany(mappedBy = "usuario", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Gasto> gastoList1;
    @ManyToOne
    @JoinColumn(name = "idPersona")
    private Persona persona;
    @OneToMany(mappedBy = "usuario", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Eventoxproducto> eventoxproductoList3;

    public Usuario() {
    }

    public Usuario(String clave, int estado, String fecha_Registro, Persona persona, int idUsuario,
                   String nombre_Usuario) {
        this.clave = clave;
        this.estado = estado;
        this.fecha_Registro = fecha_Registro;
        this.persona = persona;
        this.idUsuario = idUsuario;
        this.nombre_Usuario = nombre_Usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getFecha_Registro() {
        return fecha_Registro;
    }

    public void setFecha_Registro(String fecha_Registro) {
        this.fecha_Registro = fecha_Registro;
    }

    public String getNombre_Usuario() {
        return nombre_Usuario;
    }

    public void setNombre_Usuario(String nombre_Usuario) {
        this.nombre_Usuario = nombre_Usuario;
    }


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Eventoxinsumo> getEventoxinsumoList1() {
        return eventoxinsumoList1;
    }

    public void setEventoxinsumoList1(List<Eventoxinsumo> eventoxinsumoList1) {
        this.eventoxinsumoList1 = eventoxinsumoList1;
    }

    public Eventoxinsumo addEventoxinsumo(Eventoxinsumo eventoxinsumo) {
        getEventoxinsumoList1().add(eventoxinsumo);
        eventoxinsumo.setUsuario(this);
        return eventoxinsumo;
    }

    public Eventoxinsumo removeEventoxinsumo(Eventoxinsumo eventoxinsumo) {
        getEventoxinsumoList1().remove(eventoxinsumo);
        eventoxinsumo.setUsuario(null);
        return eventoxinsumo;
    }

    public List<Ordenproduccion> getOrdenproduccionList() {
        return ordenproduccionList;
    }

    public void setOrdenproduccionList(List<Ordenproduccion> ordenproduccionList) {
        this.ordenproduccionList = ordenproduccionList;
    }

    public Ordenproduccion addOrdenproduccion(Ordenproduccion ordenproduccion) {
        getOrdenproduccionList().add(ordenproduccion);
        ordenproduccion.setUsuario(this);
        return ordenproduccion;
    }

    public Ordenproduccion removeOrdenproduccion(Ordenproduccion ordenproduccion) {
        getOrdenproduccionList().remove(ordenproduccion);
        ordenproduccion.setUsuario(null);
        return ordenproduccion;
    }

    public List<Eventoxusuario> getEventoxusuarioList() {
        return eventoxusuarioList;
    }

    public void setEventoxusuarioList(List<Eventoxusuario> eventoxusuarioList) {
        this.eventoxusuarioList = eventoxusuarioList;
    }

    public Eventoxusuario addEventoxusuario(Eventoxusuario eventoxusuario) {
        getEventoxusuarioList().add(eventoxusuario);
        eventoxusuario.setUsuario(this);
        return eventoxusuario;
    }

    public Eventoxusuario removeEventoxusuario(Eventoxusuario eventoxusuario) {
        getEventoxusuarioList().remove(eventoxusuario);
        eventoxusuario.setUsuario(null);
        return eventoxusuario;
    }

    public List<Usuarioxrol> getUsuarioxrolList() {
        return usuarioxrolList;
    }

    public void setUsuarioxrolList(List<Usuarioxrol> usuarioxrolList) {
        this.usuarioxrolList = usuarioxrolList;
    }

    public Usuarioxrol addUsuarioxrol(Usuarioxrol usuarioxrol) {
        getUsuarioxrolList().add(usuarioxrol);
        usuarioxrol.setUsuario(this);
        return usuarioxrol;
    }

    public Usuarioxrol removeUsuarioxrol(Usuarioxrol usuarioxrol) {
        getUsuarioxrolList().remove(usuarioxrol);
        usuarioxrol.setUsuario(null);
        return usuarioxrol;
    }

    public List<Transformacion> getTransformacionList4() {
        return transformacionList4;
    }

    public void setTransformacionList4(List<Transformacion> transformacionList4) {
        this.transformacionList4 = transformacionList4;
    }

    public Transformacion addTransformacion(Transformacion transformacion) {
        getTransformacionList4().add(transformacion);
        transformacion.setUsuario(this);
        return transformacion;
    }

    public Transformacion removeTransformacion(Transformacion transformacion) {
        getTransformacionList4().remove(transformacion);
        transformacion.setUsuario(null);
        return transformacion;
    }

    public List<Gasto> getGastoList1() {
        return gastoList1;
    }

    public void setGastoList1(List<Gasto> gastoList1) {
        this.gastoList1 = gastoList1;
    }

    public Gasto addGasto(Gasto gasto) {
        getGastoList1().add(gasto);
        gasto.setUsuario(this);
        return gasto;
    }

    public Gasto removeGasto(Gasto gasto) {
        getGastoList1().remove(gasto);
        gasto.setUsuario(null);
        return gasto;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Eventoxproducto> getEventoxproductoList3() {
        return eventoxproductoList3;
    }

    public void setEventoxproductoList3(List<Eventoxproducto> eventoxproductoList3) {
        this.eventoxproductoList3 = eventoxproductoList3;
    }

    public Eventoxproducto addEventoxproducto(Eventoxproducto eventoxproducto) {
        getEventoxproductoList3().add(eventoxproducto);
        eventoxproducto.setUsuario(this);
        return eventoxproducto;
    }

    public Eventoxproducto removeEventoxproducto(Eventoxproducto eventoxproducto) {
        getEventoxproductoList3().remove(eventoxproducto);
        eventoxproducto.setUsuario(null);
        return eventoxproducto;
    }
}
