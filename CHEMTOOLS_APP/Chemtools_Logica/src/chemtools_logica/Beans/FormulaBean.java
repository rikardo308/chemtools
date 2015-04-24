package chemtools_logica.Beans;



import java.io.Serializable;

import java.util.Date;
import java.util.List;

public class FormulaBean implements Serializable{
    private String apellido_Creador;
    private String descripcion;
    private Date fecha_Creacion;
    private String nombre_Creador;
    private int estado;
    private int idFormula;
    private List<TransformacionBean> transformacionList3;
    private List<DetalleformulaBean> detalleformulaList2;

    public void setApellido_Creador(String apellido_Creador) {
        this.apellido_Creador = apellido_Creador;
    }

    public String getApellido_Creador() {
        return apellido_Creador;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setFecha_Creacion(Date fecha_Creacion) {
        this.fecha_Creacion = fecha_Creacion;
    }

    public Date getFecha_Creacion() {
        return fecha_Creacion;
    }

    public void setNombre_Creador(String nombre_Creador) {
        this.nombre_Creador = nombre_Creador;
    }

    public String getNombre_Creador() {
        return nombre_Creador;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setIdFormula(int idFormula) {
        this.idFormula = idFormula;
    }

    public int getIdFormula() {
        return idFormula;
    }

    public void setTransformacionList3(List<TransformacionBean> transformacionList3) {
        this.transformacionList3 = transformacionList3;
    }

    public List<TransformacionBean> getTransformacionList3() {
        return transformacionList3;
    }

    public void setDetalleformulaList2(List<DetalleformulaBean> detalleformulaList2) {
        this.detalleformulaList2 = detalleformulaList2;
    }

    public List<DetalleformulaBean> getDetalleformulaList2() {
        return detalleformulaList2;
    }
}
