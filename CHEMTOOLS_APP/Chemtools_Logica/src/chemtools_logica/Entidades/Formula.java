package chemtools_logica.Entidades;

import java.io.Serializable;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "Formula.findAll", query = "select o from Formula o") })
@Table(name = "\"formula\"")
public class Formula implements Serializable {
    private static final long serialVersionUID = 4826405012718587598L;
    @Column(name = "Apellido_Creador")
    private String apellido_Creador;
    @Column(name = "Descripcion")
    private String descripcion;
    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha_Creacion")
    private Date fecha_Creacion;
    @Column(name = "Nombre_Creador")
    private String nombre_Creador;
    @Column(name = "Estado")
    private int estado;
    @Id
    @Column(name = "idFormula", nullable = false)
    private int idFormula;
    @OneToMany(mappedBy = "formula", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Transformacion> transformacionList3;
    @OneToMany(mappedBy = "formula", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Detalleformula> detalleformulaList2;

    public Formula() {
    }

    public Formula(String apellido_Creador, String descripcion, Date fecha_Creacion, int idFormula,
                   String nombre_Creador) {
        this.apellido_Creador = apellido_Creador;
        this.descripcion = descripcion;
        this.fecha_Creacion = fecha_Creacion;
        this.idFormula = idFormula;
        this.nombre_Creador = nombre_Creador;
    }

    public String getApellido_Creador() {
        return apellido_Creador;
    }

    public void setApellido_Creador(String apellido_Creador) {
        this.apellido_Creador = apellido_Creador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_Creacion() {
        return fecha_Creacion;
    }

    public void setFecha_Creacion(Date fecha_Creacion) {
        this.fecha_Creacion = fecha_Creacion;
    }

    public String getNombre_Creador() {
        return nombre_Creador;
    }

    public void setNombre_Creador(String nombre_Creador) {
        this.nombre_Creador = nombre_Creador;
    }

    public int getIdFormula() {
        return idFormula;
    }

    public void setIdFormula(int idFormula) {
        this.idFormula = idFormula;
    }

    public List<Transformacion> getTransformacionList3() {
        return transformacionList3;
    }

    public void setTransformacionList3(List<Transformacion> transformacionList3) {
        this.transformacionList3 = transformacionList3;
    }

    public Transformacion addTransformacion(Transformacion transformacion) {
        getTransformacionList3().add(transformacion);
        transformacion.setFormula(this);
        return transformacion;
    }

    public Transformacion removeTransformacion(Transformacion transformacion) {
        getTransformacionList3().remove(transformacion);
        transformacion.setFormula(null);
        return transformacion;
    }

    public List<Detalleformula> getDetalleformulaList2() {
        return detalleformulaList2;
    }

    public void setDetalleformulaList2(List<Detalleformula> detalleformulaList2) {
        this.detalleformulaList2 = detalleformulaList2;
    }

    public Detalleformula addDetalleformula(Detalleformula detalleformula) {
        getDetalleformulaList2().add(detalleformula);
        detalleformula.setFormula(this);
        return detalleformula;
    }

    public Detalleformula removeDetalleformula(Detalleformula detalleformula) {
        getDetalleformulaList2().remove(detalleformula);
        detalleformula.setFormula(null);
        return detalleformula;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }
}
