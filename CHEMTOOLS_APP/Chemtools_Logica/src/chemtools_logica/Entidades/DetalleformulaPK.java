package chemtools_logica.Entidades;

import java.io.Serializable;

public class DetalleformulaPK implements Serializable {
    public int formula;
    public int tipoproducto;
    public int tipoinsumo;

    public DetalleformulaPK() {
    }

    public DetalleformulaPK(int formula, int tipoinsumo, int tipoproducto) {
        this.formula = formula;
        this.tipoinsumo = tipoinsumo;
        this.tipoproducto = tipoproducto;
    }

    public boolean equals(Object other) {
        if (other instanceof DetalleformulaPK) {
            final DetalleformulaPK otherDetalleformulaPK = (DetalleformulaPK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void setFormula(int formula) {
        this.formula = formula;
    }

    public int getFormula() {
        return formula;
    }

    public void setTipoproducto(int tipoproducto) {
        this.tipoproducto = tipoproducto;
    }

    public int getTipoproducto() {
        return tipoproducto;
    }

    public void setTipoinsumo(int tipoinsumo) {
        this.tipoinsumo = tipoinsumo;
    }

    public int getTipoinsumo() {
        return tipoinsumo;
    }
}

