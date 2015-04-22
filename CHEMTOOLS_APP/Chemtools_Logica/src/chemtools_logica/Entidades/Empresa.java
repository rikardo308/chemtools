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
@NamedQueries({ @NamedQuery(name = "Empresa.findAll", query = "select o from Empresa o") })
@Table(name = "\"empresa\"")
public class Empresa implements Serializable {
    private static final long serialVersionUID = -7784789651638885284L;
    @Column(name = "Direccion")
    private String direccion;
    @Column(name = "Estado")
    private int estado;
    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;
    private String ruc;
    @Column(name = "Tipo")
    private int tipo;
    @Column(name = "idDepartamento")
    private int idDepartamento;
    @Column(name = "idDistrito")
    private int idDistrito;
    @Column(name = "PaginaWeb")
    private String paginaWeb;
    @Column(name = "NombreEncargado")
    private String nombreEncargado;
    @Id
    @Column(name = "idEmpresa", nullable = false)
    private int idEmpresa;
    @Column(name = "idProvicia")
    private int idProvicia;
    @OneToMany(mappedBy = "empresa", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Producto> eventoxproductoList1;
    @OneToMany(mappedBy = "empresa", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Insumo> eventoxinsumoList1;

    public Empresa() {
    }

    public Empresa(String direccion, int estado, int idDepartamento, int idDistrito, int idEmpresa,
                   int idProvicia, String razonSocial, String ruc, int tipo) {
        this.direccion = direccion;
        this.estado = estado;
        this.idDepartamento = idDepartamento;
        this.idDistrito = idDistrito;
        this.idEmpresa = idEmpresa;
        this.idProvicia = idProvicia;
        this.razonSocial = razonSocial;
        this.ruc = ruc;
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
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

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdProvicia() {
        return idProvicia;
    }

    public void setIdProvicia(int idProvicia) {
        this.idProvicia = idProvicia;
    }

    public List<Producto> getEventoxproductoList1() {
        return eventoxproductoList1;
    }

    public void setEventoxproductoList1(List<Producto> eventoxproductoList1) {
        this.eventoxproductoList1 = eventoxproductoList1;
    }

    public Producto addProducto(Producto producto) {
        getEventoxproductoList1().add(producto);
        producto.setEmpresa(this);
        return producto;
    }

    public Producto removeProducto(Producto producto) {
        getEventoxproductoList1().remove(producto);
        producto.setEmpresa(null);
        return producto;
    }

    public List<Insumo> getEventoxinsumoList1() {
        return eventoxinsumoList1;
    }

    public void setEventoxinsumoList1(List<Insumo> eventoxinsumoList1) {
        this.eventoxinsumoList1 = eventoxinsumoList1;
    }

    public Insumo addInsumo(Insumo insumo) {
        getEventoxinsumoList1().add(insumo);
        insumo.setEmpresa(this);
        return insumo;
    }

    public Insumo removeInsumo(Insumo insumo) {
        getEventoxinsumoList1().remove(insumo);
        insumo.setEmpresa(null);
        return insumo;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setNombreEncargado(String nombreEncargado) {
        this.nombreEncargado = nombreEncargado;
    }

    public String getNombreEncargado() {
        return nombreEncargado;
    }
}
