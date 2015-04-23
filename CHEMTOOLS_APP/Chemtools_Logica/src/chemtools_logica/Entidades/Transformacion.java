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
@NamedQueries({ @NamedQuery(name = "Transformacion.findAll", query = "select o from Transformacion o") })
@Table(name = "\"transformacion\"")
@IdClass(TransformacionPK.class)
public class Transformacion implements Serializable {
    private static final long serialVersionUID = -5954487326819058573L;
    @Column(name = "Comentario")
    private String comentario;
    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha_Tansformacion")
    private Date fecha_Tansformacion;
    @ManyToOne
    @Id
    @JoinColumn(name = "idProducto")
    private Producto producto;
    @ManyToOne
    @Id
    @JoinColumn(name = "idOrdenProduccion")
    private Ordenproduccion ordenproduccion;
    @ManyToOne
    @Id
    @JoinColumn(name = "idInsumo")
    private Insumo insumo;
    @ManyToOne
    @Id
    @JoinColumn(name = "idFormula")
    private Formula formula;
    @ManyToOne
    @Id
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Transformacion() {
    }

    public Transformacion(String comentario, Date fecha_Tansformacion, Formula formula, Insumo insumo,
                          Ordenproduccion ordenproduccion, Producto producto, Usuario usuario) {
        this.comentario = comentario;
        this.fecha_Tansformacion = fecha_Tansformacion;
        this.formula = formula;
        this.insumo = insumo;
        this.ordenproduccion = ordenproduccion;
        this.producto = producto;
        this.usuario = usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha_Tansformacion() {
        return fecha_Tansformacion;
    }

    public void setFecha_Tansformacion(Date fecha_Tansformacion) {
        this.fecha_Tansformacion = fecha_Tansformacion;
    }

    public Ordenproduccion getOrdenproduccion() {
        return ordenproduccion;
    }

    public void setOrdenproduccion(Ordenproduccion ordenproduccion) {
        this.ordenproduccion = ordenproduccion;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setFormula(Formula formula) {
        this.formula = formula;
    }

    public Formula getFormula() {
        return formula;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
