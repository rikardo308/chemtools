package view.backing.insumos;


import chemtools_logica.Beans.AlmacenBean;
import chemtools_logica.Beans.ContenedoresBean;
import chemtools_logica.Beans.EmpresaBean;
import chemtools_logica.Beans.EventoxinsumoBean;
import chemtools_logica.Beans.InsumoBean;
import chemtools_logica.Beans.MedidaBean;
import chemtools_logica.Beans.TipoinsumoBean;
import chemtools_logica.Beans.UsuarioBean;

import chemtools_logica.LN.IR.LN_SFAlmacenRemote;
import chemtools_logica.LN.IR.LN_SFContenedoresRemote;
import chemtools_logica.LN.IR.LN_SFEmpresaRemote;
import chemtools_logica.LN.IR.LN_SFInsumoRemote;
import chemtools_logica.LN.IR.LN_SFMedidaRemote;
import chemtools_logica.LN.IR.LN_SFTipoinsumoRemote;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.output.RichImage;
import oracle.adf.view.rich.render.ClientEvent;

import org.apache.myfaces.trinidad.event.SelectionEvent;

import view.backing.Utils.Utils;

public class Frm_insumos {
    
    //COMPONENTES
    private RichForm form;
    private RichTable tbInsumos;
    private RichInputText codigoInputBusqueda;
    private RichInputText nombreInputBusqueda;
    private RichSelectOneChoice umedidaInputBusqueda;
    private RichSelectOneChoice tinsumoInputBusqueda;
    private RichSelectOneChoice empresaInputBusqueda;
    private RichSelectOneChoice contenedorInputBusqueda;
    private RichButton btnEditar;
    private RichPopup popEdit;
    private RichButton btnAgregar;
    private RichPopup popAgregar;
    private RichPopup popVerImagen;
    
    private RichInputText codigoInputEdit;
    private RichInputText codigoInputNuevo;
    private RichInputText comentarioInputNuevo;
    private RichSelectOneChoice calidadInputNuevo;
    private RichSelectOneChoice tinsumoInputNuevo;
    private RichSelectOneChoice empresaInputNuevo;
    
    //CONEXCIONES
    private LN_SFAlmacenRemote lN_SFAlmacenRemote;
    private LN_SFInsumoRemote lN_SFInsumoRemote;
    private LN_SFMedidaRemote lN_SFMedidaRemote;
    private LN_SFTipoinsumoRemote lN_SFTipoinsumoRemote;
    private LN_SFContenedoresRemote lN_SFContenedoresRemote;
    private LN_SFEmpresaRemote lN_SFEmpresaRemote;
    
    private bSessionScopeBeaninsumo sessionScopeBeaninsumo = new bSessionScopeBeaninsumo();
    private RichPanelGroupLayout tbAlmacenes;
    private RichButton btnVerImagen;
    private RichImage imagenInsumo;
    private RichInputDate dt_fCreacionMin;
    private RichInputDate dt_fCreacionMax;
    private RichInputDate dt_fCaducacionMin;
    private RichInputDate dt_fCaducacionMax;
    private RichSelectOneChoice estadoInputBusqueda;
    private RichSelectOneChoice calidadInputBusqueda;
    private RichPanelGridLayout pl_Busqueda;
    private RichInputText nombreAlmacenBusqueda;

    public Frm_insumos(){    
    }
    
    @PostConstruct
    public void methodInvokeOncedOnPageLoad() {
        try {
            final Context context = getInitialContext();
            lN_SFAlmacenRemote = (LN_SFAlmacenRemote) context.lookup("map-LN_SFAlmacen#chemtools_logica.LN.IR.LN_SFAlmacenRemote");  
            lN_SFInsumoRemote = (LN_SFInsumoRemote) context.lookup("map-LN_SFInsumo#chemtools_logica.LN.IR.LN_SFInsumoRemote");  
            lN_SFMedidaRemote = (LN_SFMedidaRemote) context.lookup("map-LN_SFMedida#chemtools_logica.LN.IR.LN_SFMedidaRemote");
            lN_SFTipoinsumoRemote = (LN_SFTipoinsumoRemote) context.lookup("map-LN_SFTipoinsumo#chemtools_logica.LN.IR.LN_SFTipoinsumoRemote");
            lN_SFContenedoresRemote = (LN_SFContenedoresRemote) context.lookup("map-LN_SFContenedores#chemtools_logica.LN.IR.LN_SFContenedoresRemote");
            lN_SFEmpresaRemote = (LN_SFEmpresaRemote) context.lookup("map-LN_SFEmpresa#chemtools_logica.LN.IR.LN_SFEmpresaRemote");
        }catch(Exception e){}

        HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        UsuarioBean usuario = (UsuarioBean) sesion.getAttribute("usuario");
        sessionScopeBeaninsumo.setUsuario(usuario);
        
        if(sessionScopeBeaninsumo.getExec() == 0){
            sessionScopeBeaninsumo.setAlmacenesActios(lN_SFAlmacenRemote.getAllAlmacenes());
            sessionScopeBeaninsumo.setInsumos(lN_SFInsumoRemote.getAllinsumos());
            sessionScopeBeaninsumo.setExec(1);
        }
        
        sessionScopeBeaninsumo.setListaMedida(this.llenarmedidaComno());
        sessionScopeBeaninsumo.setListaTipoinsumo(this.llenartipoInsumoComno());
        sessionScopeBeaninsumo.setListaContenedores(this.llenarcontenedoresComno());
        sessionScopeBeaninsumo.setListaEstados(this.llenarEstados());
        sessionScopeBeaninsumo.setListaCalidad(this.llenarCalidad());
        sessionScopeBeaninsumo.setListaEmpresa(this.llenaEmpresa());
    }
    
    public void busquedaAlmacen(ActionEvent event){
        
        sessionScopeBeaninsumo.setEmpresaSeleccionada(null);
        
        String nombre = sessionScopeBeaninsumo.getNombreBusquedaAlmacen();
        
        sessionScopeBeaninsumo.setAlmacenesActios(new ArrayList<AlmacenBean>());
        
        sessionScopeBeaninsumo.setAlmacenesActios(lN_SFAlmacenRemote.getAllAlmacenesBusqeuda(nombre));
        
        sessionScopeBeaninsumo.setNombreBusquedaAlmacen("");
        Utils.addTarget(getNombreAlmacenBusqueda());

        Utils.addTarget(getTbAlmacenes()); 
        
        getBtnAgregar().setDisabled(true);
        getBtnEditar().setDisabled(true);
        getBtnVerImagen().setDisabled(true);
        Utils.addTarget(getBtnAgregar());
        Utils.addTarget(getBtnEditar());
        Utils.addTarget(getBtnVerImagen()); 
    }
    
    public void traeInsumos(ActionEvent event){
        
        int nidAlmacen = sessionScopeBeaninsumo.getEmpresaSeleccionada().getIdAlmacen();
        
        System.out.println("NID: "+nidAlmacen);
        
        sessionScopeBeaninsumo.setInsumos(lN_SFInsumoRemote.getInsumosbyAlmacen(nidAlmacen));
        getTbInsumos().setValue(sessionScopeBeaninsumo.getInsumos());
        Utils.addTarget(getTbInsumos());
        sessionScopeBeaninsumo.setNidAlmacenSelecc(nidAlmacen);
        
        getBtnAgregar().setDisabled(false);
        Utils.addTarget(getBtnAgregar());
        getBtnEditar().setDisabled(false);
        Utils.addTarget(getBtnEditar());
        getBtnVerImagen().setDisabled(false);
        Utils.addTarget(getBtnVerImagen()); 
    }
    
    public void selectInsumo(SelectionEvent se){
        RichTable t = (RichTable)se.getSource();
        InsumoBean beanInsumo = (InsumoBean) t.getSelectedRowData();
        sessionScopeBeaninsumo.setInsumoSelecc(beanInsumo);
        getBtnEditar().setDisabled(false);
        getBtnVerImagen().setDisabled(false);
        Utils.addTarget(getBtnEditar());
        Utils.addTarget(getBtnVerImagen());
    }
    
    public void limpiaryRefrescar(ActionEvent event){
        getCodigoInputBusqueda().setValue(null);
        sessionScopeBeaninsumo.setCodigoBusqueda("");
        getNombreInputBusqueda().setValue(null);
        sessionScopeBeaninsumo.setNombreBusqueda("");
        getUmedidaInputBusqueda().setValue(0);
        getEmpresaInputBusqueda().setValue(0);
        getTinsumoInputBusqueda().setValue(0);
        getContenedorInputBusqueda().setValue(0);
        getCalidadInputBusqueda().setValue(0);
        getDt_fCreacionMin().setValue("");
        getDt_fCreacionMax().setValue("");
        getDt_fCaducacionMin().setValue("");
        getDt_fCaducacionMax().setValue("");
        sessionScopeBeaninsumo.setInsumos(lN_SFInsumoRemote.getAllinsumos());
        getTbInsumos().setValue(sessionScopeBeaninsumo.getInsumos());
        getBtnAgregar().setDisabled(true);
        getBtnEditar().setDisabled(true);
        getBtnVerImagen().setDisabled(true);
        Utils.addTarget(getTbInsumos());
        Utils.addTarget(getCodigoInputBusqueda());
        Utils.addTarget(getCalidadInputBusqueda());
        Utils.addTarget(getNombreInputBusqueda());
        Utils.addTarget(getUmedidaInputBusqueda());
        Utils.addTarget(getEmpresaInputBusqueda());
        Utils.addTarget(getTinsumoInputBusqueda());
        Utils.addTarget(getContenedorInputBusqueda());
        
        Utils.addTarget(getDt_fCreacionMin());
        Utils.addTarget(getDt_fCreacionMax());
        Utils.addTarget(getDt_fCaducacionMin());
        Utils.addTarget(getDt_fCaducacionMax());
        
        Utils.addTarget(getBtnAgregar());
        Utils.addTarget(getBtnEditar());
        Utils.addTarget(getBtnVerImagen());
        
        sessionScopeBeaninsumo.setNidAlmacenSelecc(0);
    }
    
    public void busquedaInsumo(ActionEvent event){
        InsumoBean bean = new InsumoBean();
        
        bean.setIdInsumo(sessionScopeBeaninsumo.getCodigoBusqueda());
        bean.setComentario(sessionScopeBeaninsumo.getNombreBusqueda());
        bean.setIdunidadMeidad(sessionScopeBeaninsumo.getMedidabusqueda());
        bean.setIdtipoInsumo(sessionScopeBeaninsumo.getTinsumobusqueda());
        bean.setIdcontenedor(sessionScopeBeaninsumo.getContenedorbusqueda());
        bean.setIdAlmacen(sessionScopeBeaninsumo.getNidAlmacenSelecc());
        bean.setIdEmpresa(sessionScopeBeaninsumo.getEmpresaBusqueda());
        bean.setFechaCreaciondMin(sessionScopeBeaninsumo.getFechaCreaciondMin());
        bean.setFechaCreaciondMax(sessionScopeBeaninsumo.getFechaCreaciondMax());
        bean.setFechaCaducidadMin(sessionScopeBeaninsumo.getFechaCaducidadMin());
        bean.setFechaCaducidadMax(sessionScopeBeaninsumo.getFechaCaducidadMax());
        bean.setEstado(sessionScopeBeaninsumo.getEstadobusqueda());
        bean.setCalidad(sessionScopeBeaninsumo.getCalidadbusqueda());
        
            sessionScopeBeaninsumo.setInsumos(lN_SFInsumoRemote.getBusquedaInsumos(bean));
            getTbInsumos().setValue(sessionScopeBeaninsumo.getInsumos());
            Utils.addTarget(getTbInsumos()); 
        
        getBtnAgregar().setDisabled(true);
        getBtnEditar().setDisabled(true);
        getBtnVerImagen().setDisabled(true);
        Utils.addTarget(getBtnAgregar());
        Utils.addTarget(getBtnEditar());
        Utils.addTarget(getBtnVerImagen());
    }
    
    public void mostrarpopEdit(ActionEvent event){
        InsumoBean beanInsumo = sessionScopeBeaninsumo.getInsumoSelecc();
        sessionScopeBeaninsumo.setCodigoEdit(beanInsumo.getIdInsumo()+"");
        sessionScopeBeaninsumo.setNombreEdit(beanInsumo.getComentario());
        sessionScopeBeaninsumo.setRazonSocialEdit(beanInsumo.getRazonSocialEmpresa());
        sessionScopeBeaninsumo.setTinsumoedit(beanInsumo.getIdtipoInsumo());
        sessionScopeBeaninsumo.setEstadoedit(beanInsumo.getEstado());
        sessionScopeBeaninsumo.setCalidadedit(beanInsumo.getCalidad());

        Utils.showPopUpMIDDLE(getPopEdit());
    }
    
    public void mostrarpopAgregar(ActionEvent event){
        sessionScopeBeaninsumo.setCodigoNuevo("");
        sessionScopeBeaninsumo.setComentarioNuevo("");
        sessionScopeBeaninsumo.setCalidadnuevo(0);
        sessionScopeBeaninsumo.setTinsumoNuevo(0);
        sessionScopeBeaninsumo.setEmpresaNuevo(0);
        sessionScopeBeaninsumo.setFCaducacionNuevo(null);
        Utils.showPopUpMIDDLE(getPopAgregar());
    }
    
    public void mostrarpopVerImagen(ActionEvent event){
        InsumoBean beanInsumo = sessionScopeBeaninsumo.getInsumoSelecc();
        sessionScopeBeaninsumo.setImageRuta(beanInsumo.getImagen());
        Utils.showPopUpMIDDLE(getPopVerImagen());
    }
    
    public void nuevoInsumo(ActionEvent event){
        String comentario = sessionScopeBeaninsumo.getComentarioNuevo();
        String codigo = sessionScopeBeaninsumo.getCodigoNuevo();
        int calidad = sessionScopeBeaninsumo.getCalidadnuevo();
        int tInsumo = sessionScopeBeaninsumo.getTinsumoNuevo();
        int empresa = sessionScopeBeaninsumo.getEmpresaNuevo();
        Date fCaducacion = sessionScopeBeaninsumo.getFCaducacionNuevo();
        
        int almacen = sessionScopeBeaninsumo.getNidAlmacenSelecc(); 
        int usuario = sessionScopeBeaninsumo.getUsuario().getIdUsuario();
        
        InsumoBean beanInsumo = new InsumoBean();
        EventoxinsumoBean eventoxinsumo = new EventoxinsumoBean();
        
        beanInsumo.setIdInsumo(codigo);
        beanInsumo.setCalidad(calidad);
        beanInsumo.setComentario(comentario);
        beanInsumo.setEstado(1);
        beanInsumo.setIdEmpresa(empresa);
        beanInsumo.setIdtipoInsumo(tInsumo);
        beanInsumo.setImagen("");
        beanInsumo.setFecha_Caducacion(fCaducacion);
        
        eventoxinsumo.setInsumo(beanInsumo);
        eventoxinsumo.setIdEvento(1);
        eventoxinsumo.setIdAlmacen(almacen);
        eventoxinsumo.setIdUsuario(usuario);
        
        lN_SFInsumoRemote.insertarInsumo(eventoxinsumo);
        
        getPopAgregar().hide();
        
        sessionScopeBeaninsumo.setInsumos(lN_SFInsumoRemote.getAllinsumos());
        getTbInsumos().setValue(sessionScopeBeaninsumo.getInsumos());
        Utils.addTarget(getTbInsumos());
    }
    
    public void cerrarPopNuevoInsumo(ActionEvent event){
        sessionScopeBeaninsumo.setComentarioNuevo("");
        sessionScopeBeaninsumo.setCalidadnuevo(0);
        sessionScopeBeaninsumo.setTinsumoNuevo(0);
        sessionScopeBeaninsumo.setEmpresaNuevo(0);
    }
            
    
    public void editarInsumo(ClientEvent ce){
        if(sessionScopeBeaninsumo.isCambioHecho()){
            InsumoBean beanInsumo = sessionScopeBeaninsumo.getInsumoSelecc();
            
            beanInsumo.setEstado(sessionScopeBeaninsumo.getEstadoedit());
            beanInsumo.setCalidad(sessionScopeBeaninsumo.getCalidadedit());
            int cal = sessionScopeBeaninsumo.getCalidadedit();
            if(cal == 1){
                beanInsumo.setCalidadText("PESIMO");
            }
            if(cal == 2){
                beanInsumo.setCalidadText("MASOMENOS");
            }
            if(cal == 3){
                beanInsumo.setCalidadText("BIEN");
            }
            lN_SFInsumoRemote.updateInsumo(beanInsumo);
            
            sessionScopeBeaninsumo.setInsumos(lN_SFInsumoRemote.getAllinsumos());
            getTbInsumos().setValue(sessionScopeBeaninsumo.getInsumos());
            Utils.addTarget(getTbInsumos());
            
            sessionScopeBeaninsumo.setCambioHecho(false);  
            
            getPopEdit().hide();
        }
    }
    
    public void verificarCambiosEditTinsumo(ValueChangeEvent vce){
        sessionScopeBeaninsumo.setCambioHecho(true);
        int tInsumo = Integer.parseInt(vce.getNewValue().toString());
        sessionScopeBeaninsumo.setTinsumoedit(tInsumo);
    }
    
    public ArrayList llenarmedidaComno() {
        ArrayList medida = new ArrayList();
        List<MedidaBean> medidaBean = lN_SFMedidaRemote.allMedidas();
        for (MedidaBean m : medidaBean) {
            medida.add(new SelectItem(m.getIdMedida(),m.getDescripcion()));
        }
        
        return medida;
    }
    
    public ArrayList llenartipoInsumoComno() {
        ArrayList tipoInsumos = new ArrayList();
        List<TipoinsumoBean> tipoInsumoBean = lN_SFTipoinsumoRemote.getAlltipoInsumos();
        for (TipoinsumoBean ti : tipoInsumoBean) {
            tipoInsumos.add(new SelectItem(ti.getIdTipoInsumo(),ti.getDescripcion()));
        }
        
        return tipoInsumos;
    }
    
    public ArrayList llenarcontenedoresComno() {
        ArrayList contenedores = new ArrayList();
        List<ContenedoresBean> contenedorBean = lN_SFContenedoresRemote.getContenedoresActivos();
        for (ContenedoresBean c : contenedorBean) {
            contenedores.add(new SelectItem(c.getIdContenedores(),c.getDescripcion()));
        }
        
        return contenedores;
    }
    
    public ArrayList llenarEstados() {
        ArrayList estados = new ArrayList();
        estados.add(new SelectItem(0,"Inactivo"));
        estados.add(new SelectItem(1,"Activo"));
        
        return estados;
    }
    
    public ArrayList llenarCalidad() {
        ArrayList calidad = new ArrayList();
        calidad.add(new SelectItem(1,"Pesimo"));
        calidad.add(new SelectItem(2,"Masomenos"));
        calidad.add(new SelectItem(3,"Bien"));
        
        return calidad;
    }
    
    public ArrayList llenaEmpresa() {
        ArrayList empresas = new ArrayList();
        List<EmpresaBean> EmpresaBean = lN_SFEmpresaRemote.getAllEmpresas();
        for (EmpresaBean e : EmpresaBean) {
            empresas.add(new SelectItem(e.getIdEmpresa(),e.getRazonSocial()));
        }
        
        return empresas;
    }
    
    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x/12.x connection details
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, "t3://127.0.0.1:7101");
        return new InitialContext(env);
    }

    public void setSessionScopeBeaninsumo(bSessionScopeBeaninsumo sessionScopeBeaninsumo) {
        this.sessionScopeBeaninsumo = sessionScopeBeaninsumo;
    }

    public bSessionScopeBeaninsumo getSessionScopeBeaninsumo() {
        return sessionScopeBeaninsumo;
    }

    public void setForm(RichForm form) {
        this.form = form;
    }

    public RichForm getForm() {
        return form;
    }

    public void setTbInsumos(RichTable tbInsumos) {
        this.tbInsumos = tbInsumos;
    }

    public RichTable getTbInsumos() {
        return tbInsumos;
    }

    public void setCodigoInputBusqueda(RichInputText codigoInputBusqueda) {
        this.codigoInputBusqueda = codigoInputBusqueda;
    }

    public RichInputText getCodigoInputBusqueda() {
        return codigoInputBusqueda;
    }

    public void setNombreInputBusqueda(RichInputText nombreInputBusqueda) {
        this.nombreInputBusqueda = nombreInputBusqueda;
    }

    public RichInputText getNombreInputBusqueda() {
        return nombreInputBusqueda;
    }

    public void setUmedidaInputBusqueda(RichSelectOneChoice umedidaInputBusqueda) {
        this.umedidaInputBusqueda = umedidaInputBusqueda;
    }

    public RichSelectOneChoice getUmedidaInputBusqueda() {
        return umedidaInputBusqueda;
    }

    public void setTinsumoInputBusqueda(RichSelectOneChoice tinsumoInputBusqueda) {
        this.tinsumoInputBusqueda = tinsumoInputBusqueda;
    }

    public RichSelectOneChoice getTinsumoInputBusqueda() {
        return tinsumoInputBusqueda;
    }

    public void setContenedorInputBusqueda(RichSelectOneChoice contenedorInputBusqueda) {
        this.contenedorInputBusqueda = contenedorInputBusqueda;
    }

    public RichSelectOneChoice getContenedorInputBusqueda() {
        return contenedorInputBusqueda;
    }

    public void setBtnEditar(RichButton btnEditar) {
        this.btnEditar = btnEditar;
    }

    public RichButton getBtnEditar() {
        return btnEditar;
    }

    public void setPopEdit(RichPopup popEdit) {
        this.popEdit = popEdit;
    }

    public RichPopup getPopEdit() {
        return popEdit;
    }

    public void setCodigoInputEdit(RichInputText codigoInputEdit) {
        this.codigoInputEdit = codigoInputEdit;
    }

    public RichInputText getCodigoInputEdit() {
        return codigoInputEdit;
    }

    public void setBtnAgregar(RichButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public RichButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setPopAgregar(RichPopup popAgregar) {
        this.popAgregar = popAgregar;
    }

    public RichPopup getPopAgregar() {
        return popAgregar;
    }

    public void setCodigoInputNuevo(RichInputText codigoInputNuevo) {
        this.codigoInputNuevo = codigoInputNuevo;
    }

    public RichInputText getCodigoInputNuevo() {
        return codigoInputNuevo;
    }


    public void setEmpresaInputBusqueda(RichSelectOneChoice empresaInputBusqueda) {
        this.empresaInputBusqueda = empresaInputBusqueda;
    }

    public RichSelectOneChoice getEmpresaInputBusqueda() {
        return empresaInputBusqueda;
    }

    public void setComentarioInputNuevo(RichInputText comentarioInputNuevo) {
        this.comentarioInputNuevo = comentarioInputNuevo;
    }

    public RichInputText getComentarioInputNuevo() {
        return comentarioInputNuevo;
    }

    public void setCalidadInputNuevo(RichSelectOneChoice calidadInputNuevo) {
        this.calidadInputNuevo = calidadInputNuevo;
    }

    public RichSelectOneChoice getCalidadInputNuevo() {
        return calidadInputNuevo;
    }

    public void setTinsumoInputNuevo(RichSelectOneChoice tinsumoInputNuevo) {
        this.tinsumoInputNuevo = tinsumoInputNuevo;
    }

    public RichSelectOneChoice getTinsumoInputNuevo() {
        return tinsumoInputNuevo;
    }

    public void setEmpresaInputNuevo(RichSelectOneChoice empresaInputNuevo) {
        this.empresaInputNuevo = empresaInputNuevo;
    }

    public RichSelectOneChoice getEmpresaInputNuevo() {
        return empresaInputNuevo;
    }

    public void setTbAlmacenes(RichPanelGroupLayout tbAlmacenes) {
        this.tbAlmacenes = tbAlmacenes;
    }

    public RichPanelGroupLayout getTbAlmacenes() {
        return tbAlmacenes;
    }

    public void setBtnVerImagen(RichButton btnVerImagen) {
        this.btnVerImagen = btnVerImagen;
    }

    public RichButton getBtnVerImagen() {
        return btnVerImagen;
    }

    public void setPopVerImagen(RichPopup popVerImagen) {
        this.popVerImagen = popVerImagen;
    }

    public RichPopup getPopVerImagen() {
        return popVerImagen;
    }

    public void setImagenInsumo(RichImage imagenInsumo) {
        this.imagenInsumo = imagenInsumo;
    }

    public RichImage getImagenInsumo() {
        return imagenInsumo;
    }

    public void setDt_fCreacionMin(RichInputDate dt_fCreacionMin) {
        this.dt_fCreacionMin = dt_fCreacionMin;
    }

    public RichInputDate getDt_fCreacionMin() {
        return dt_fCreacionMin;
    }

    public void setDt_fCreacionMax(RichInputDate dt_fCreacionMax) {
        this.dt_fCreacionMax = dt_fCreacionMax;
    }

    public RichInputDate getDt_fCreacionMax() {
        return dt_fCreacionMax;
    }

    public void setDt_fCaducacionMin(RichInputDate dt_fCaducacionMin) {
        this.dt_fCaducacionMin = dt_fCaducacionMin;
    }

    public RichInputDate getDt_fCaducacionMin() {
        return dt_fCaducacionMin;
    }

    public void setDt_fCaducacionMax(RichInputDate dt_fCaducacionMax) {
        this.dt_fCaducacionMax = dt_fCaducacionMax;
    }

    public RichInputDate getDt_fCaducacionMax() {
        return dt_fCaducacionMax;
    }

    public void setEstadoInputBusqueda(RichSelectOneChoice estadoInputBusqueda) {
        this.estadoInputBusqueda = estadoInputBusqueda;
    }

    public RichSelectOneChoice getEstadoInputBusqueda() {
        return estadoInputBusqueda;
    }

    public void setCalidadInputBusqueda(RichSelectOneChoice calidadInputBusqueda) {
        this.calidadInputBusqueda = calidadInputBusqueda;
    }

    public RichSelectOneChoice getCalidadInputBusqueda() {
        return calidadInputBusqueda;
    }

    public void setPl_Busqueda(RichPanelGridLayout pl_Busqueda) {
        this.pl_Busqueda = pl_Busqueda;
    }

    public RichPanelGridLayout getPl_Busqueda() {
        return pl_Busqueda;
    }

    public void setNombreAlmacenBusqueda(RichInputText nombreAlmacenBusqueda) {
        this.nombreAlmacenBusqueda = nombreAlmacenBusqueda;
    }

    public RichInputText getNombreAlmacenBusqueda() {
        return nombreAlmacenBusqueda;
    }
}
