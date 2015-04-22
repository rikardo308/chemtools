package chemtools_logica.Entidades;

import java.io.Serializable;

public class UsuarioxrolPK implements Serializable {
    public int rol;
    public int usuario;

    public UsuarioxrolPK() {
    }

    public UsuarioxrolPK(int rol, int usuario) {
        this.rol = rol;
        this.usuario = usuario;
    }

    public boolean equals(Object other) {
        if (other instanceof UsuarioxrolPK) {
            final UsuarioxrolPK otherUsuarioxrolPK = (UsuarioxrolPK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getRol() {
        return rol;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getUsuario() {
        return usuario;
    }
}
