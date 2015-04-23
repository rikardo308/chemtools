package chemtools_logica.Entidades;

import java.io.Serializable;

public class RolxpermisosPK implements Serializable {
    public int permisos;
    public int rol;

    public RolxpermisosPK() {
    }

    public RolxpermisosPK(int permisos, int rol) {
        this.permisos = permisos;
        this.rol = rol;
    }

    public boolean equals(Object other) {
        if (other instanceof RolxpermisosPK) {
            final RolxpermisosPK otherRolxpermisosPK = (RolxpermisosPK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void setPermisos(int permisos) {
        this.permisos = permisos;
    }

    public int getPermisos() {
        return permisos;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getRol() {
        return rol;
    }
}
