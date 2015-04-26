package view.backing.insumos;

import chemtools_logica.Beans.AlmacenBean;
import chemtools_logica.Beans.EmpresaBean;
import chemtools_logica.Beans.InsumoBean;

import chemtools_logica.Beans.UsuarioBean;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.nav.RichButton;

public class bSessionScopeBeaninsumo implements Serializable{
    @SuppressWarnings("compatibility:-5645476594390090689")
    private static final long serialVersionUID = 1L;

    private int exec = 0;
    UsuarioBean usuario = new UsuarioBean();
    private Date fechaMinima = new Date();
    private String directorio = "INSUMOS GENERALES";
    
    
    
    private boolean almacenEsc = false;

    //LISTAS
    private List<AlmacenBean> almacenesActios = new ArrayList<AlmacenBean>();
    private List<InsumoBean> insumos = new ArrayList<InsumoBean>();
    
    private List<EmpresaBean> empresas = new ArrayList<EmpresaBean>();
    
    //COMBOBOX
    private ArrayList listaMedida = new ArrayList();
    private ArrayList listaTipoinsumo = new ArrayList();
    private ArrayList listaContenedores = new ArrayList();
    private ArrayList listaEstados = new ArrayList();
    private ArrayList listaCalidad = new ArrayList();
    private ArrayList listaEmpresa = new ArrayList();
    private ArrayList listaAlmacen = new ArrayList();
    
    //BUSQUEDA ALMACEN
    private String nombreBusquedaAlmacen;
    
    private String nidAlmacen;
    
    //BUSQUEDA
    private String codigoBusqueda;
    private String nombreBusqueda;
    private int medidabusqueda;
    private int tinsumobusqueda;
    private int contenedorbusqueda;
    private int empresaBusqueda;
    private int nidAlmacenSelecc = 0;
    
    private Date fechaCaducidadMin;
    private Date fechaCaducidadMax;
    private Date fechaCreaciondMin;
    private Date fechaCreaciondMax;
    private int estadobusqueda;
    private int calidadbusqueda;
    
    
    private String imageRuta;
    
    
    private AlmacenBean almacenSeleccionado;
    
    //EDIT
    private String codigoEdit;
    private String nombreEdit;
    private String razonSocialEdit;
    private int tinsumoedit;
    private int estadoedit;
    private int calidadedit;
    private int almacenedit;
    private InsumoBean insumoSelecc;
    private boolean cambioHecho = false;
    private boolean cambioAlmacen = false;
    private int empresaEdit;
    
    //NUEVO
    private String codigoNuevo;
    private String comentarioNuevo;
    private int calidadnuevo;
    private int tinsumoNuevo;
    private int empresaNuevo;
    private int estadoNuevo;
    private Date fCaducacionNuevo;
    private String contenidoNuevo;
    
    //NUEVO T.INSUMO
    private String descripcionNuevotInsumo;
    private String comentarioNuevotInsumo;
    private String tMinimaNuevotInsumo;
    private String tMaximaNuevotInsumo;
    private String tExpiracionNuevotInsumo;
    private int contenedorNuevotInsumo;
    private int uMedidaNuevotInsumo;
    
    //NUEVO CONTENEDO Y MEDIDA
    private String descripcionNuevoContenedor;
    private String descripcionNuevaMedida;

    public void setAlmacenesActios(List<AlmacenBean> almacenesActios) {
        this.almacenesActios = almacenesActios;
    }

    public List<AlmacenBean> getAlmacenesActios() {
        return almacenesActios;
    }

    public void setInsumos(List<InsumoBean> insumos) {
        this.insumos = insumos;
    }

    public List<InsumoBean> getInsumos() {
        return insumos;
    }

    public void setListaMedida(ArrayList listaMedida) {
        this.listaMedida = listaMedida;
    }

    public ArrayList getListaMedida() {
        return listaMedida;
    }

    public void setListaTipoinsumo(ArrayList listaTipoinsumo) {
        this.listaTipoinsumo = listaTipoinsumo;
    }

    public ArrayList getListaTipoinsumo() {
        return listaTipoinsumo;
    }

    public void setListaContenedores(ArrayList listaContenedores) {
        this.listaContenedores = listaContenedores;
    }

    public ArrayList getListaContenedores() {
        return listaContenedores;
    }

    public void setCodigoBusqueda(String codigoBusqueda) {
        this.codigoBusqueda = codigoBusqueda;
    }

    public String getCodigoBusqueda() {
        return codigoBusqueda;
    }

    public void setNombreBusqueda(String nombreBusqueda) {
        this.nombreBusqueda = nombreBusqueda;
    }

    public String getNombreBusqueda() {
        return nombreBusqueda;
    }

    public void setMedidabusqueda(int medidabusqueda) {
        this.medidabusqueda = medidabusqueda;
    }

    public int getMedidabusqueda() {
        return medidabusqueda;
    }

    public void setTinsumobusqueda(int tinsumobusqueda) {
        this.tinsumobusqueda = tinsumobusqueda;
    }

    public int getTinsumobusqueda() {
        return tinsumobusqueda;
    }

    public void setContenedorbusqueda(int contenedorbusqueda) {
        this.contenedorbusqueda = contenedorbusqueda;
    }

    public int getContenedorbusqueda() {
        return contenedorbusqueda;
    }

    public void setNidAlmacenSelecc(int nidAlmacenSelecc) {
        this.nidAlmacenSelecc = nidAlmacenSelecc;
    }

    public int getNidAlmacenSelecc() {
        return nidAlmacenSelecc;
    }

    public void setAlmacenSeleccionado(AlmacenBean almacenSeleccionado) {
        this.almacenSeleccionado = almacenSeleccionado;
    }

    public AlmacenBean getAlmacenSeleccionado() {
        return almacenSeleccionado;
    }

    public void setInsumoSelecc(InsumoBean insumoSelecc) {
        this.insumoSelecc = insumoSelecc;
    }

    public InsumoBean getInsumoSelecc() {
        return insumoSelecc;
    }

    public void setCodigoEdit(String codigoEdit) {
        this.codigoEdit = codigoEdit;
    }

    public String getCodigoEdit() {
        return codigoEdit;
    }

    public void setNombreEdit(String nombreEdit) {
        this.nombreEdit = nombreEdit;
    }

    public String getNombreEdit() {
        return nombreEdit;
    }

    public void setTinsumoedit(int tinsumoedit) {
        this.tinsumoedit = tinsumoedit;
    }

    public int getTinsumoedit() {
        return tinsumoedit;
    }

    public void setCambioHecho(boolean cambioHecho) {
        this.cambioHecho = cambioHecho;
    }

    public boolean isCambioHecho() {
        return cambioHecho;
    }


    public void setCodigoNuevo(String codigoNuevo) {
        this.codigoNuevo = codigoNuevo;
    }

    public String getCodigoNuevo() {
        return codigoNuevo;
    }

    public void setComentarioNuevo(String comentarioNuevo) {
        this.comentarioNuevo = comentarioNuevo;
    }

    public String getComentarioNuevo() {
        return comentarioNuevo;
    }

    public void setTinsumoNuevo(int tinsumoNuevo) {
        this.tinsumoNuevo = tinsumoNuevo;
    }

    public int getTinsumoNuevo() {
        return tinsumoNuevo;
    }

    public void setEmpresaNuevo(int empresaNuevo) {
        this.empresaNuevo = empresaNuevo;
    }

    public int getEmpresaNuevo() {
        return empresaNuevo;
    }

    public void setEstadoNuevo(int estadoNuevo) {
        this.estadoNuevo = estadoNuevo;
    }

    public int getEstadoNuevo() {
        return estadoNuevo;
    }

    public void setEstadoedit(int estadoedit) {
        this.estadoedit = estadoedit;
    }

    public int getEstadoedit() {
        return estadoedit;
    }

    public void setListaEstados(ArrayList listaEstados) {
        this.listaEstados = listaEstados;
    }

    public ArrayList getListaEstados() {
        return listaEstados;
    }


    public void setListaCalidad(ArrayList listaCalidad) {
        this.listaCalidad = listaCalidad;
    }

    public ArrayList getListaCalidad() {
        return listaCalidad;
    }

    public void setCalidadedit(int calidadedit) {
        this.calidadedit = calidadedit;
    }

    public int getCalidadedit() {
        return calidadedit;
    }

    public void setEmpresas(List<EmpresaBean> empresas) {
        this.empresas = empresas;
    }

    public List<EmpresaBean> getEmpresas() {
        return empresas;
    }

    public void setRazonSocialEdit(String razonSocialEdit) {
        this.razonSocialEdit = razonSocialEdit;
    }

    public String getRazonSocialEdit() {
        return razonSocialEdit;
    }

    public void setListaEmpresa(ArrayList listaEmpresa) {
        this.listaEmpresa = listaEmpresa;
    }

    public ArrayList getListaEmpresa() {
        return listaEmpresa;
    }

    public void setEmpresaBusqueda(int empresaBusqueda) {
        this.empresaBusqueda = empresaBusqueda;
    }

    public int getEmpresaBusqueda() {
        return empresaBusqueda;
    }

    public void setCalidadnuevo(int calidadnuevo) {
        this.calidadnuevo = calidadnuevo;
    }

    public int getCalidadnuevo() {
        return calidadnuevo;
    }

    public void setNombreBusquedaAlmacen(String nombreBusquedaAlmacen) {
        this.nombreBusquedaAlmacen = nombreBusquedaAlmacen;
    }

    public String getNombreBusquedaAlmacen() {
        return nombreBusquedaAlmacen;
    }

    public void setImageRuta(String imageRuta) {
        this.imageRuta = imageRuta;
    }

    public String getImageRuta() {
        return imageRuta;
    }

    public void setFechaCaducidadMin(Date fechaCaducidadMin) {
        this.fechaCaducidadMin = fechaCaducidadMin;
    }

    public Date getFechaCaducidadMin() {
        return fechaCaducidadMin;
    }

    public void setFechaCaducidadMax(Date fechaCaducidadMax) {
        this.fechaCaducidadMax = fechaCaducidadMax;
    }

    public Date getFechaCaducidadMax() {
        return fechaCaducidadMax;
    }

    public void setFechaCreaciondMin(Date fechaCreaciondMin) {
        this.fechaCreaciondMin = fechaCreaciondMin;
    }

    public Date getFechaCreaciondMin() {
        return fechaCreaciondMin;
    }

    public void setFechaCreaciondMax(Date fechaCreaciondMax) {
        this.fechaCreaciondMax = fechaCreaciondMax;
    }

    public Date getFechaCreaciondMax() {
        return fechaCreaciondMax;
    }

    public void setFCaducacionNuevo(Date fCaducacionNuevo) {
        this.fCaducacionNuevo = fCaducacionNuevo;
    }

    public Date getFCaducacionNuevo() {
        return fCaducacionNuevo;
    }

    public void setEstadobusqueda(int estadobusqueda) {
        this.estadobusqueda = estadobusqueda;
    }

    public int getEstadobusqueda() {
        return estadobusqueda;
    }

    public void setCalidadbusqueda(int calidadbusqueda) {
        this.calidadbusqueda = calidadbusqueda;
    }

    public int getCalidadbusqueda() {
        return calidadbusqueda;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }

    public UsuarioBean getUsuario() {
        return usuario;
    }

    public void setNidAlmacen(String nidAlmacen) {
        this.nidAlmacen = nidAlmacen;
    }

    public String getNidAlmacen() {
        return nidAlmacen;
    }

    public void setExec(int exec) {
        this.exec = exec;
    }

    public int getExec() {
        return exec;
    }

    public void setDirectorio(String directorio) {
        this.directorio = directorio;
    }

    public String getDirectorio() {
        return directorio;
    }

    public void setFechaMinima(Date fechaMinima) {
        this.fechaMinima = fechaMinima;
    }

    public Date getFechaMinima() {
        return fechaMinima;
    }

    public void setContenidoNuevo(String contenidoNuevo) {
        this.contenidoNuevo = contenidoNuevo;
    }

    public String getContenidoNuevo() {
        return contenidoNuevo;
    }

    public void setListaAlmacen(ArrayList listaAlmacen) {
        this.listaAlmacen = listaAlmacen;
    }

    public ArrayList getListaAlmacen() {
        return listaAlmacen;
    }

    public void setAlmacenedit(int almacenedit) {
        this.almacenedit = almacenedit;
    }

    public int getAlmacenedit() {
        return almacenedit;
    }

    public void setCambioAlmacen(boolean cambioAlmacen) {
        this.cambioAlmacen = cambioAlmacen;
    }

    public boolean isCambioAlmacen() {
        return cambioAlmacen;
    }

    public void setEmpresaEdit(int empresaEdit) {
        this.empresaEdit = empresaEdit;
    }

    public int getEmpresaEdit() {
        return empresaEdit;
    }

    public void setDescripcionNuevotInsumo(String descripcionNuevotInsumo) {
        this.descripcionNuevotInsumo = descripcionNuevotInsumo;
    }

    public String getDescripcionNuevotInsumo() {
        return descripcionNuevotInsumo;
    }

    public void setComentarioNuevotInsumo(String comentarioNuevotInsumo) {
        this.comentarioNuevotInsumo = comentarioNuevotInsumo;
    }

    public String getComentarioNuevotInsumo() {
        return comentarioNuevotInsumo;
    }

    public void setTMinimaNuevotInsumo(String tMinimaNuevotInsumo) {
        this.tMinimaNuevotInsumo = tMinimaNuevotInsumo;
    }

    public String getTMinimaNuevotInsumo() {
        return tMinimaNuevotInsumo;
    }

    public void setTMaximaNuevotInsumo(String tMaximaNuevotInsumo) {
        this.tMaximaNuevotInsumo = tMaximaNuevotInsumo;
    }

    public String getTMaximaNuevotInsumo() {
        return tMaximaNuevotInsumo;
    }

    public void setTExpiracionNuevotInsumo(String tExpiracionNuevotInsumo) {
        this.tExpiracionNuevotInsumo = tExpiracionNuevotInsumo;
    }

    public String getTExpiracionNuevotInsumo() {
        return tExpiracionNuevotInsumo;
    }

    public void setContenedorNuevotInsumo(int contenedorNuevotInsumo) {
        this.contenedorNuevotInsumo = contenedorNuevotInsumo;
    }

    public int getContenedorNuevotInsumo() {
        return contenedorNuevotInsumo;
    }

    public void setUMedidaNuevotInsumo(int uMedidaNuevotInsumo) {
        this.uMedidaNuevotInsumo = uMedidaNuevotInsumo;
    }

    public int getUMedidaNuevotInsumo() {
        return uMedidaNuevotInsumo;
    }

    public void setAlmacenEsc(boolean almacenEsc) {
        this.almacenEsc = almacenEsc;
    }

    public boolean isAlmacenEsc() {
        return almacenEsc;
    }

    public void setDescripcionNuevoContenedor(String descripcionNuevoContenedor) {
        this.descripcionNuevoContenedor = descripcionNuevoContenedor;
    }

    public String getDescripcionNuevoContenedor() {
        return descripcionNuevoContenedor;
    }

    public void setDescripcionNuevaMedida(String descripcionNuevaMedida) {
        this.descripcionNuevaMedida = descripcionNuevaMedida;
    }

    public String getDescripcionNuevaMedida() {
        return descripcionNuevaMedida;
    }
}
