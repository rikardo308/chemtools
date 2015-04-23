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
@NamedQueries({ @NamedQuery(name = "Usuarioxrol.findAll", query = "select o from Usuarioxrol o") })
@Table(name = "\"usuarioxrol\"")
@IdClass(UsuarioxrolPK.class)
public class Usuarioxrol implements Serializable {
    private static final long serialVersionUID = -8446090936809719808L;
    @ManyToOne
    @Id
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    @ManyToOne
    @Id
    @JoinColumn(name = "idRol")
    private Rol rol;

    public Usuarioxrol() {
    }

    public Usuarioxrol(Rol rol, Usuario usuario) {
        this.rol = rol;
        this.usuario = usuario;
    }


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Rol getRol() {
        return rol;
    }
}
