package chemtools_logica.Entidades;

import java.io.Serializable;

public class EventoxinsumoPK implements Serializable {
    public int almacen;
    public int evento;
    public String insumo;
    public int usuario;

    public EventoxinsumoPK() {
    }

    public EventoxinsumoPK(int almacen, int evento, String insumo, int usuario) {
        this.almacen = almacen;
        this.evento = evento;
        this.insumo = insumo;
        this.usuario = usuario;
    }

    public boolean equals(Object other) {
        if (other instanceof EventoxinsumoPK) {
            final EventoxinsumoPK otherEventoxinsumoPK = (EventoxinsumoPK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void setAlmacen(int almacen) {
        this.almacen = almacen;
    }

    public int getAlmacen() {
        return almacen;
    }

    public void setEvento(int evento) {
        this.evento = evento;
    }

    public int getEvento() {
        return evento;
    }

    public void setInsumo(String insumo) {
        this.insumo = insumo;
    }

    public String getInsumo() {
        return insumo;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getUsuario() {
        return usuario;
    }
}
