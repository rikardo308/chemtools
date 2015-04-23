package chemtools_logica.Entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Detalleformula.findAll", query = "select o from Detalleformula o") })
@Table(name = "\"detalleformula\"")
@IdClass(DetalleformulaPK.class)
public class Detalleformula implements Serializable {
    private static final long serialVersionUID = 6580263110786084767L;
    @Column(name = "Cantidad_Insumo")
    private int cantidad_Insumo;
    @Column(name = "Cantidad_Producto")
    private int cantidad_Producto;
    @ManyToOne
    @Id
    @JoinColumn(name = "idTipoProducto")
    private Tipoproducto tipoproducto;
    @ManyToOne
    @Id
    @JoinColumn(name = "idTipoInsumo")
    private Tipoinsumo tipoinsumo;
    @ManyToOne
    @Id
    @JoinColumn(name = "idFormula")
    private Formula formula;

    public Detalleformula() {
    }

    public Detalleformula(int cantidad_Insumo, int cantidad_Producto, Formula formula, Tipoinsumo tipoinsumo,
                          Tipoproducto tipoproducto) {
        this.cantidad_Insumo = cantidad_Insumo;
        this.cantidad_Producto = cantidad_Producto;
        this.formula = formula;
        this.tipoinsumo = tipoinsumo;
        this.tipoproducto = tipoproducto;
    }

    public int getCantidad_Insumo() {
        return cantidad_Insumo;
    }

    public void setCantidad_Insumo(int cantidad_Insumo) {
        this.cantidad_Insumo = cantidad_Insumo;
    }

    public int getCantidad_Producto() {
        return cantidad_Producto;
    }

    public void setCantidad_Producto(int cantidad_Producto) {
        this.cantidad_Producto = cantidad_Producto;
    }


    public Tipoproducto getTipoproducto() {
        return tipoproducto;
    }

    public void setTipoproducto(Tipoproducto tipoproducto) {
        this.tipoproducto = tipoproducto;
    }

    public Tipoinsumo getTipoinsumo() {
        return tipoinsumo;
    }

    public void setTipoinsumo(Tipoinsumo tipoinsumo) {
        this.tipoinsumo = tipoinsumo;
    }

    public void setFormula(Formula formula) {
        this.formula = formula;
    }

    public Formula getFormula() {
        return formula;
    }
}
