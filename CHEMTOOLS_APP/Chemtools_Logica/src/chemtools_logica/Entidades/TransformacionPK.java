package chemtools_logica.Entidades;

import java.io.Serializable;

public class TransformacionPK implements Serializable {
    public int formula;
    public String insumo;
    public int ordenproduccion;
    public String producto;
    public int usuario;

    public TransformacionPK() {
    }

    public TransformacionPK(int formula, String insumo, int ordenproduccion, String producto, int usuario) {
        this.formula = formula;
        this.insumo = insumo;
        this.ordenproduccion = ordenproduccion;
        this.producto = producto;
        this.usuario = usuario;
    }

    public boolean equals(Object other) {
        if (other instanceof TransformacionPK) {
            final TransformacionPK otherTransformacionPK = (TransformacionPK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void setOrdenproduccion(int ordenproduccion) {
        this.ordenproduccion = ordenproduccion;
    }

    public int getOrdenproduccion() {
        return ordenproduccion;
    }

    public void setFormula(int formula) {
        this.formula = formula;
    }

    public int getFormula() {
        return formula;
    }

    public void setInsumo(String insumo) {
        this.insumo = insumo;
    }

    public String getInsumo() {
        return insumo;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getProducto() {
        return producto;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getUsuario() {
        return usuario;
    }
}
