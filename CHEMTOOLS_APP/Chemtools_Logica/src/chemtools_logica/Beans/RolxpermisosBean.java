package chemtools_logica.Beans;

import chemtools_logica.Entidades.Permisos;
import chemtools_logica.Entidades.Rol;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class RolxpermisosBean implements Serializable{
    
    private PermisosBean permisos;
    private RolBean rol;


    public void setPermisos(PermisosBean permisos) {
        this.permisos = permisos;
    }

    public PermisosBean getPermisos() {
        return permisos;
    }

    public void setRol(RolBean rol) {
        this.rol = rol;
    }

    public RolBean getRol() {
        return rol;
    }
}
