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
@NamedQueries({ @NamedQuery(name = "Rolxpermisos.findAll", query = "select o from Rolxpermisos o") })
@Table(name = "\"rolxpermisos\"")
@IdClass(RolxpermisosPK.class)
public class Rolxpermisos implements Serializable {
    private static final long serialVersionUID = 8792481378012633808L;
    @ManyToOne
    @Id
    @JoinColumn(name = "idPermisos")
    private Permisos permisos;
    @ManyToOne
    @Id
    @JoinColumn(name = "idRol")
    private Rol rol;

    public Rolxpermisos() {
    }

    public Rolxpermisos(Permisos permisos, Rol rol) {
        this.permisos = permisos;
        this.rol = rol;
    }


    public Permisos getPermisos() {
        return permisos;
    }

    public void setPermisos(Permisos permisos) {
        this.permisos = permisos;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
