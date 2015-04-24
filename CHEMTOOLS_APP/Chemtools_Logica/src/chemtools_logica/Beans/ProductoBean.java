package chemtools_logica.Beans;




import java.io.Serializable;

import java.util.Date;
import java.util.List;



public class ProductoBean implements Serializable {
    private int calidad;
    private String comentario;
    private int estado;
    private Date fecha_Creacion;
    private Date tiempo_Caducacion;
    private byte[] imagen;
    private String idProducto;
    private List<TransformacionBean> transformacionList;
    private TipoproductoBean tipoproducto;
    private EmpresaBean empresa;
    private List<EventoxproductoBean> eventoxproductoList1;


    public void setCalidad(int calidad) {
        this.calidad = calidad;
    }

    public int getCalidad() {
        return calidad;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setFecha_Creacion(Date fecha_Creacion) {
        this.fecha_Creacion = fecha_Creacion;
    }

    public Date getFecha_Creacion() {
        return fecha_Creacion;
    }

    public void setTiempo_Caducacion(Date tiempo_Caducacion) {
        this.tiempo_Caducacion = tiempo_Caducacion;
    }

    public Date getTiempo_Caducacion() {
        return tiempo_Caducacion;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setTransformacionList(List<TransformacionBean> transformacionList) {
        this.transformacionList = transformacionList;
    }

    public List<TransformacionBean> getTransformacionList() {
        return transformacionList;
    }

    public void setTipoproducto(TipoproductoBean tipoproducto) {
        this.tipoproducto = tipoproducto;
    }

    public TipoproductoBean getTipoproducto() {
        return tipoproducto;
    }

    public void setEmpresa(EmpresaBean empresa) {
        this.empresa = empresa;
    }

    public EmpresaBean getEmpresa() {
        return empresa;
    }

    public void setEventoxproductoList1(List<EventoxproductoBean> eventoxproductoList1) {
        this.eventoxproductoList1 = eventoxproductoList1;
    }

    public List<EventoxproductoBean> getEventoxproductoList1() {
        return eventoxproductoList1;
    }
}

