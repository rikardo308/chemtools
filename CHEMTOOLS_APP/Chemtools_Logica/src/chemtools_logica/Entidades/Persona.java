package chemtools_logica.Entidades;

import java.io.Serializable;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "Persona.findAll", query = "select o from Persona o") })
@Table(name = "\"persona\"")
public class Persona implements Serializable {
    private static final long serialVersionUID = -8099798910647062263L;
    @Column(name = "Apellido")
    private String apellido;
    private int dni;
    @Column(name = "Direccion")
    private String direccion;
    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha_Nacimiento")
    private Date fecha_Nacimiento;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "idDepartamento")
    private int idDepartamento;
    @Column(name = "idDistrito")
    private int idDistrito;
    @Id
    @Column(name = "idPersona", nullable = false)
    private int idPersona;
    @Column(name = "idProvicia")
    private int idProvicia;
    @OneToMany(mappedBy = "persona", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Usuario> eventoxusuarioList;

    public Persona() {
    }

    public Persona(String apellido, String direccion, int dni, Date fecha_Nacimiento, int idDepartamento,
                   int idDistrito, int idPersona, int idProvicia, String nombre) {
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.fecha_Nacimiento = fecha_Nacimiento;
        this.idDepartamento = idDepartamento;
        this.idDistrito = idDistrito;
        this.idPersona = idPersona;
        this.idProvicia = idProvicia;
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha_Nacimiento() {
        return fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(Date fecha_Nacimiento) {
        this.fecha_Nacimiento = fecha_Nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdProvicia() {
        return idProvicia;
    }

    public void setIdProvicia(int idProvicia) {
        this.idProvicia = idProvicia;
    }

    public List<Usuario> getEventoxusuarioList() {
        return eventoxusuarioList;
    }

    public void setEventoxusuarioList(List<Usuario> eventoxusuarioList) {
        this.eventoxusuarioList = eventoxusuarioList;
    }

    public Usuario addUsuario(Usuario usuario) {
        getEventoxusuarioList().add(usuario);
        usuario.setPersona(this);
        return usuario;
    }

    public Usuario removeUsuario(Usuario usuario) {
        getEventoxusuarioList().remove(usuario);
        usuario.setPersona(null);
        return usuario;
    }
}
