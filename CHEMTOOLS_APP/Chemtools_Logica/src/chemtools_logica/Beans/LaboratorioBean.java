package chemtools_logica.Beans;



import java.io.Serializable;

import java.util.List;



public class LaboratorioBean implements Serializable{
    private String direccion;
    private int estado;
    private String nombre_Encargado;
    private String nombre;
    private int idDepartamento;
    private int idDistrito;
    private int idLaboratorio;
    private int idProvicia;
    private List<OrdenproduccionBean> ordenproduccionList1;


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setNombre_Encargado(String nombre_Encargado) {
        this.nombre_Encargado = nombre_Encargado;
    }

    public String getNombre_Encargado() {
        return nombre_Encargado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdProvicia(int idProvicia) {
        this.idProvicia = idProvicia;
    }

    public int getIdProvicia() {
        return idProvicia;
    }

    public void setOrdenproduccionList1(List<OrdenproduccionBean> ordenproduccionList1) {
        this.ordenproduccionList1 = ordenproduccionList1;
    }

    public List<OrdenproduccionBean> getOrdenproduccionList1() {
        return ordenproduccionList1;
    }
}
