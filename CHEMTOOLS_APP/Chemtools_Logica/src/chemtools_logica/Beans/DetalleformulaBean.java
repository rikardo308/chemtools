package chemtools_logica.Beans;

import chemtools_logica.Entidades.Formula;
import chemtools_logica.Entidades.Tipoinsumo;
import chemtools_logica.Entidades.Tipoproducto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class DetalleformulaBean implements Serializable {
    
    private int cantidad_Insumo;
    private int cantidad_Producto;
    private TipoproductoBean tipoproducto;
    private TipoinsumoBean tipoinsumo;
    private FormulaBean formula;


    public void setCantidad_Insumo(int cantidad_Insumo) {
        this.cantidad_Insumo = cantidad_Insumo;
    }

    public int getCantidad_Insumo() {
        return cantidad_Insumo;
    }

    public void setCantidad_Producto(int cantidad_Producto) {
        this.cantidad_Producto = cantidad_Producto;
    }

    public int getCantidad_Producto() {
        return cantidad_Producto;
    }

    public void setTipoproducto(TipoproductoBean tipoproducto) {
        this.tipoproducto = tipoproducto;
    }

    public TipoproductoBean getTipoproducto() {
        return tipoproducto;
    }

    public void setTipoinsumo(TipoinsumoBean tipoinsumo) {
        this.tipoinsumo = tipoinsumo;
    }

    public TipoinsumoBean getTipoinsumo() {
        return tipoinsumo;
    }

    public void setFormula(FormulaBean formula) {
        this.formula = formula;
    }

    public FormulaBean getFormula() {
        return formula;
    }
}
