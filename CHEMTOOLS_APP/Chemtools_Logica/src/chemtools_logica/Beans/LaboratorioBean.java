package chemtools_logica.Beans;



import java.io.Serializable;

import java.util.List;



public class LaboratorioBean implements Serializable{
    private String direccion;
    private int estado;
    private String nombre_Encargado;
    private String ruc;
    private String razon_Social;
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

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRazon_Social(String razon_Social) {
        this.razon_Social = razon_Social;
    }

    public String getRazon_Social() {
        return razon_Social;
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
