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
@NamedQueries({ @NamedQuery(name = "Permisos.findAll", query = "select o from Permisos o") })
@Table(name = "\"permisos\"")
public class Permisos implements Serializable {
    private static final long serialVersionUID = -3390566163085525792L;
    @Column(name = "Estado")
    private int estado;
    @Column(name = "Icono")
    private String icono;
    @Column(name = "Nombre")
    private String nombre;
    private String url;
    @Id
    @Column(name = "idPermisos", nullable = false)
    private int idPermisos;
    @OneToMany(mappedBy = "permisos", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Rolxpermisos> rolxpermisosList;

    public Permisos() {
    }

    public Permisos(int estado, String icono, int idPermisos, String nombre, String url) {
        this.estado = estado;
        this.icono = icono;
        this.idPermisos = idPermisos;
        this.nombre = nombre;
        this.url = url;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIdPermisos() {
        return idPermisos;
    }

    public void setIdPermisos(int idPermisos) {
        this.idPermisos = idPermisos;
    }

    public List<Rolxpermisos> getRolxpermisosList() {
        return rolxpermisosList;
    }

    public void setRolxpermisosList(List<Rolxpermisos> rolxpermisosList) {
        this.rolxpermisosList = rolxpermisosList;
    }

    public Rolxpermisos addRolxpermisos(Rolxpermisos rolxpermisos) {
        getRolxpermisosList().add(rolxpermisos);
        rolxpermisos.setPermisos(this);
        return rolxpermisos;
    }

    public Rolxpermisos removeRolxpermisos(Rolxpermisos rolxpermisos) {
        getRolxpermisosList().remove(rolxpermisos);
        rolxpermisos.setPermisos(null);
        return rolxpermisos;
    }
}
