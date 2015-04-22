package chemtools_logica.Entidades;

import java.io.Serializable;

public class EventoxusuarioPK implements Serializable {
    public int evento;
    public int usuario;

    public EventoxusuarioPK() {
    }

    public EventoxusuarioPK(int evento, int usuario) {
        this.evento = evento;
        this.usuario = usuario;
    }

    public boolean equals(Object other) {
        if (other instanceof EventoxusuarioPK) {
            final EventoxusuarioPK otherEventoxusuarioPK = (EventoxusuarioPK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void setEvento(int evento) {
        this.evento = evento;
    }

    public int getEvento() {
        return evento;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getUsuario() {
        return usuario;
    }
}
