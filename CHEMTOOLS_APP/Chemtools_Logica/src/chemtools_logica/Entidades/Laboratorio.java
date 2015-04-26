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
@NamedQueries({ @NamedQuery(name = "Laboratorio.findAll", query = "select o from Laboratorio o") })
@Table(name = "\"laboratorio\"")
public class Laboratorio implements Serializable {
    private static final long serialVersionUID = -8018658372005938288L;
    @Column(name = "Direccion")
    private String direccion;
    @Column(name = "Estado")
    private int estado;
    @Column(name = "Nombre_Encargado")
    private String nombre_Encargado;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "idDepartamento")
    private int idDepartamento;
    @Column(name = "idDistrito")
    private int idDistrito;
    @Id
    @Column(name = "idLaboratorio", nullable = false)
    private int idLaboratorio;
    @Column(name = "idProvicia")
    private int idProvicia;
    @OneToMany(mappedBy = "laboratorio", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Ordenproduccion> ordenproduccionList1;

    public Laboratorio() {
    }

    public Laboratorio(String direccion, int estado, int idDepartamento, int idDistrito, int idLaboratorio,
                       int idProvicia, String nombre_Encargado, String nombre) {
        this.direccion = direccion;
        this.estado = estado;
        this.idDepartamento = idDepartamento;
        this.idDistrito = idDistrito;
        this.idLaboratorio = idLaboratorio;
        this.idProvicia = idProvicia;
        this.nombre_Encargado = nombre_Encargado;
        this.nombre = nombre;
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

    public String getNombre_Encargado() {
        return nombre_Encargado;
    }

    public void setNombre_Encargado(String nombre_Encargado) {
        this.nombre_Encargado = nombre_Encargado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
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

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public int getIdProvicia() {
        return idProvicia;
    }

    public void setIdProvicia(int idProvicia) {
        this.idProvicia = idProvicia;
    }

    public List<Ordenproduccion> getOrdenproduccionList1() {
        return ordenproduccionList1;
    }

    public void setOrdenproduccionList1(List<Ordenproduccion> ordenproduccionList1) {
        this.ordenproduccionList1 = ordenproduccionList1;
    }

    public Ordenproduccion addOrdenproduccion(Ordenproduccion ordenproduccion) {
        getOrdenproduccionList1().add(ordenproduccion);
        ordenproduccion.setLaboratorio(this);
        return ordenproduccion;
    }

    public Ordenproduccion removeOrdenproduccion(Ordenproduccion ordenproduccion) {
        getOrdenproduccionList1().remove(ordenproduccion);
        ordenproduccion.setLaboratorio(null);
        return ordenproduccion;
    }
}
