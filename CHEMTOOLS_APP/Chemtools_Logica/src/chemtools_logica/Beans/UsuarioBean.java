package chemtools_logica.Beans;

import chemtools_logica.Entidades.Persona;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;

public class UsuarioBean implements Serializable{
    private String clave;
    private int estado;
    private String fecha_Registro;
    private String nombre_Usuario;
    private int idUsuario;
    private PersonaBean persona;
    
    private RolBean rol;
    
    private  List<PermisosBean> permisos = new ArrayList<PermisosBean>();

    public void setRol(RolBean rol) {
        this.rol = rol;
    }

    public RolBean getRol() {
        return rol;
    }

    public void setPermisos(List<PermisosBean> permisos) {
        this.permisos = permisos;
    }

    public List<PermisosBean> getPermisos() {
        return permisos;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setFecha_Registro(String fecha_Registro) {
        this.fecha_Registro = fecha_Registro;
    }

    public String getFecha_Registro() {
        return fecha_Registro;
    }

    public void setNombre_Usuario(String nombre_Usuario) {
        this.nombre_Usuario = nombre_Usuario;
    }

    public String getNombre_Usuario() {
        return nombre_Usuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setPersona(PersonaBean persona) {
        this.persona = persona;
    }

    public PersonaBean getPersona() {
        return persona;
    }
}
