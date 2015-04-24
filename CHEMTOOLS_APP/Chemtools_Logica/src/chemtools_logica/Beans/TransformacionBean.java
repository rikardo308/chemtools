package chemtools_logica.Beans;




import java.io.Serializable;

import java.util.Date;



public class TransformacionBean implements Serializable{
    
    private String comentario;
    private Date fecha_Tansformacion;
    private ProductoBean producto;
    private OrdenproduccionBean ordenproduccion;
    private InsumoBean insumo;
    private FormulaBean formula;
    private UsuarioBean usuario;

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setFecha_Tansformacion(Date fecha_Tansformacion) {
        this.fecha_Tansformacion = fecha_Tansformacion;
    }

    public Date getFecha_Tansformacion() {
        return fecha_Tansformacion;
    }

    public void setProducto(ProductoBean producto) {
        this.producto = producto;
    }

    public ProductoBean getProducto() {
        return producto;
    }

    public void setOrdenproduccion(OrdenproduccionBean ordenproduccion) {
        this.ordenproduccion = ordenproduccion;
    }

    public OrdenproduccionBean getOrdenproduccion() {
        return ordenproduccion;
    }

    public void setInsumo(InsumoBean insumo) {
        this.insumo = insumo;
    }

    public InsumoBean getInsumo() {
        return insumo;
    }

    public void setFormula(FormulaBean formula) {
        this.formula = formula;
    }

    public FormulaBean getFormula() {
        return formula;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }

    public UsuarioBean getUsuario() {
        return usuario;
    }
}
