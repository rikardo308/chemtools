package chemtools_logica.Entidades;

import java.io.Serializable;

public class EventoxproductoPK implements Serializable {
    public int almacen;
    public int evento;
    public String producto;
    public int usuario;

    public EventoxproductoPK() {
    }

    public EventoxproductoPK(int almacen, int evento, String producto, int usuario) {
        this.almacen = almacen;
        this.evento = evento;
        this.producto = producto;
        this.usuario = usuario;
    }

    public boolean equals(Object other) {
        if (other instanceof EventoxproductoPK) {
            final EventoxproductoPK otherEventoxproductoPK = (EventoxproductoPK) other;
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
