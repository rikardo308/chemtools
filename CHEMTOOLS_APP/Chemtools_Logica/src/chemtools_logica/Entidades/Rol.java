package chemtools_logica.Entidades;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Rol.findAll", query = "select o from Rol o") })
@Table(name = "\"rol\"")
public class Rol implements Serializable {
    private static final long serialVersionUID = 4282854884973701395L;
    @Column(name = "Estado")
    private int estado;
    @Column(name = "Nombre")
    private String nombre;
    @Id
    @Column(name = "idRol", nullable = false)
    private int idRol;
    @OneToMany(mappedBy = "rol", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Rolxpermisos> rolxpermisosList1;
    @OneToMany(mappedBy = "rol", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Usuarioxrol> usuarioxrolList1;

    public Rol() {
    }

    public Rol(int estado, int idRol, String nombre) {
        this.estado = estado;
        this.idRol = idRol;
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public List<Rolxpermisos> getRolxpermisosList1() {
        return rolxpermisosList1;
    }

    public void setRolxpermisosList1(List<Rolxpermisos> rolxpermisosList1) {
        this.rolxpermisosList1 = rolxpermisosList1;
    }

    public Rolxpermisos addRolxpermisos(Rolxpermisos rolxpermisos) {
        getRolxpermisosList1().add(rolxpermisos);
        rolxpermisos.setRol(this);
        return rolxpermisos;
    }

    public Rolxpermisos removeRolxpermisos(Rolxpermisos rolxpermisos) {
        getRolxpermisosList1().remove(rolxpermisos);
        rolxpermisos.setRol(null);
        return rolxpermisos;
    }

    public List<Usuarioxrol> getUsuarioxrolList1() {
        return usuarioxrolList1;
    }

    public void setUsuarioxrolList1(List<Usuarioxrol> usuarioxrolList1) {
        this.usuarioxrolList1 = usuarioxrolList1;
    }

    public Usuarioxrol addUsuarioxrol(Usuarioxrol usuarioxrol) {
        getUsuarioxrolList1().add(usuarioxrol);
        usuarioxrol.setRol(this);
        return usuarioxrol;
    }

    public Usuarioxrol removeUsuarioxrol(Usuarioxrol usuarioxrol) {
        getUsuarioxrolList1().remove(usuarioxrol);
        usuarioxrol.setRol(null);
        return usuarioxrol;
    }
}
