package chemtools_logica.Beans;




import java.io.Serializable;

import java.util.Date;

import java.util.List;




public class OrdenproduccionBean implements Serializable{
    private String comentario;
    private Date fechaRegistro;
    private String imagen;
    private int estado;
    private int idOrdenProduccion;
    private UsuarioBean usuario;
    private List<TransformacionBean> transformacionList1;
    private LaboratorioBean laboratorio;
    
    //EXTRAS
    private Date fechaInicial;
    private Date fechaFinal;

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setIdOrdenProduccion(int idOrdenProduccion) {
        this.idOrdenProduccion = idOrdenProduccion;
    }

    public int getIdOrdenProduccion() {
        return idOrdenProduccion;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }

    public UsuarioBean getUsuario() {
        return usuario;
    }

    public void setTransformacionList1(List<TransformacionBean> transformacionList1) {
        this.transformacionList1 = transformacionList1;
    }

    public List<TransformacionBean> getTransformacionList1() {
        return transformacionList1;
    }

    public void setLaboratorio(LaboratorioBean laboratorio) {
        this.laboratorio = laboratorio;
    }

    public LaboratorioBean getLaboratorio() {
        return laboratorio;
    }
}
