package chemtools_logica.Beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class EmpresaBean implements Serializable{
    
    private String direccion;
    private String empresacol;
    private int estado;
    private String razonSocial;
    private String ruc;
    private int tipo;
    private int idDepartamento;
    private int idDistrito;
    private int idEmpresa;
    private int idProvicia;


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setEmpresacol(String empresacol) {
        this.empresacol = empresacol;
    }

    public String getEmpresacol() {
        return empresacol;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRuc() {
        return ruc;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
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

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdProvicia(int idProvicia) {
        this.idProvicia = idProvicia;
    }

    public int getIdProvicia() {
        return idProvicia;
    }
}
