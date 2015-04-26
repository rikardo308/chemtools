package view.backing.insumos;


import chemtools_logica.Beans.AlmacenBean;
import chemtools_logica.Beans.ContenedoresBean;
import chemtools_logica.Beans.EmpresaBean;
import chemtools_logica.Beans.EventoxinsumoBean;
import chemtools_logica.Beans.InsumoBean;
import chemtools_logica.Beans.MedidaBean;
import chemtools_logica.Beans.TipoinsumoBean;
import chemtools_logica.Beans.UsuarioBean;

import chemtools_logica.Entidades.Eventoxinsumo;

import chemtools_logica.LN.IR.LN_SFAlmacenRemote;
import chemtools_logica.LN.IR.LN_SFContenedoresRemote;
import chemtools_logica.LN.IR.LN_SFEmpresaRemote;
import chemtools_logica.LN.IR.LN_SFInsumoRemote;
import chemtools_logica.LN.IR.LN_SFMedidaRemote;
import chemtools_logica.LN.IR.LN_SFTipoinsumoRemote;

import java.io.InputStream;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import javax.faces.validator.ValidatorException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.output.RichImage;
import oracle.adf.view.rich.component.rich.output.RichMessage;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.render.ClientEvent;

import org.apache.myfaces.trinidad.change.RowKeySetAttributeChange;
import org.apache.myfaces.trinidad.context.RequestContext;
import org.apache.myfaces.trinidad.event.SelectionEvent;

import org.apache.myfaces.trinidad.model.RowKeySetImpl;
import org.apache.myfaces.trinidad.model.UploadedFile;

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
    private RichOutputLabel directorio;
    private RichOutputLabel cantInsumos;
    private RichSelectOneChoice almacenEdit;
    private RichPanelFormLayout plPpopnuevoTInsumo;
    private RichPopup popNuevoTInsumo;
    private RichButton btnNuevotInsumo;
    private RichPopup popNuevoContenedor;
    private RichButton btnNuevoContenedor;
    private RichPopup popnuevaMedida;
    private RichButton btnNuevaMedida;
    private RichSelectOneChoice inputnuevoTInsumoContenedor;
    private RichSelectOneChoice inputnuevoTInsumoMedida;
    private RichPopup popCambioAlmacen;
    private RichButton btnCambioAlmacen;

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
        sessionScopeBeaninsumo.setListaAlmacen(this.llenarAlmacen());
    }
    
    public void busquedaAlmacen(ActionEvent event){
        
        sessionScopeBeaninsumo.setAlmacenSeleccionado(null);
        
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
        
        Utils.addTarget(getTbInsumos());
    }
    
    public void traeInsumos(ActionEvent event){
        
        int nidAlmacen = sessionScopeBeaninsumo.getAlmacenSeleccionado().getIdAlmacen();
        
        String nombre =sessionScopeBeaninsumo.getAlmacenSeleccionado().getNombre();
        
        sessionScopeBeaninsumo.setDirectorio("INSUMOS DE "+nombre);
        
        sessionScopeBeaninsumo.setInsumos(lN_SFInsumoRemote.getInsumosbyAlmacen(nidAlmacen));
        getTbInsumos().setValue(sessionScopeBeaninsumo.getInsumos());
        Utils.addTarget(getTbInsumos());
        sessionScopeBeaninsumo.setNidAlmacenSelecc(nidAlmacen);
        sessionScopeBeaninsumo.setAlmacenedit(nidAlmacen);
       
        getBtnAgregar().setDisabled(false);
        Utils.addTarget(getBtnAgregar());
        getBtnEditar().setDisabled(true);
        Utils.addTarget(getBtnEditar());
        getBtnVerImagen().setDisabled(true);
        getBtnCambioAlmacen().setDisabled(true);
        Utils.addTarget(getBtnCambioAlmacen());
        Utils.addTarget(getBtnVerImagen()); 
        Utils.addTarget(getDirectorio());
        Utils.addTarget(getCantInsumos());
        
        Utils.clearRowSelection(getTbInsumos());
    }
    
    public void selectInsumo(SelectionEvent se){
        RichTable t = (RichTable)se.getSource();
        InsumoBean beanInsumo = (InsumoBean) t.getSelectedRowData();
        sessionScopeBeaninsumo.setInsumoSelecc(beanInsumo);
        getBtnEditar().setDisabled(false);
        getBtnVerImagen().setDisabled(false);
        
        Utils.addTarget(getBtnEditar());
        Utils.addTarget(getBtnVerImagen());
        
        if(sessionScopeBeaninsumo.getAlmacenedit() != 0){
            getBtnCambioAlmacen().setDisabled(false);
            Utils.addTarget(getBtnCambioAlmacen());
        }
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
        sessionScopeBeaninsumo.setDirectorio("INSUMOS GENERALES");
        getBtnAgregar().setDisabled(true);
        getBtnEditar().setDisabled(true);
        getBtnVerImagen().setDisabled(true);
        Utils.addTarget(getBtnVerImagen());
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
        
        Utils.addTarget(getCantInsumos());
        Utils.addTarget(getDirectorio());
        
        getBtnCambioAlmacen().setDisabled(true);
        Utils.addTarget(getBtnCambioAlmacen());
        
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
        
        sessionScopeBeaninsumo.setInsumos(new ArrayList<InsumoBean>());
        
            sessionScopeBeaninsumo.setInsumos(lN_SFInsumoRemote.getBusquedaInsumos(bean));
            getTbInsumos().setValue(sessionScopeBeaninsumo.getInsumos());
            Utils.addTarget(getTbInsumos()); 
        
        getBtnAgregar().setDisabled(true);
        getBtnEditar().setDisabled(true);
        getBtnVerImagen().setDisabled(true);
        Utils.addTarget(getBtnAgregar());
        Utils.addTarget(getBtnEditar());
        Utils.addTarget(getBtnVerImagen());
        Utils.addTarget(getCantInsumos());
    }
    
    public void mostrarpopEdit(ActionEvent event){
        InsumoBean beanInsumo = sessionScopeBeaninsumo.getInsumoSelecc();
        sessionScopeBeaninsumo.setCodigoEdit(beanInsumo.getIdInsumo()+"");
        sessionScopeBeaninsumo.setNombreEdit(beanInsumo.getComentario());
        sessionScopeBeaninsumo.setRazonSocialEdit(beanInsumo.getRazonSocialEmpresa());
        sessionScopeBeaninsumo.setTinsumoedit(beanInsumo.getIdtipoInsumo());
        sessionScopeBeaninsumo.setEstadoedit(beanInsumo.getEstado());
        sessionScopeBeaninsumo.setCalidadedit(beanInsumo.getCalidad());
        sessionScopeBeaninsumo.setAlmacenedit(beanInsumo.getIdAlmacen());
        sessionScopeBeaninsumo.setEmpresaEdit(beanInsumo.getIdEmpresa());

        Utils.showPopUpMIDDLE(getPopEdit());
    }
    
    public void mostrarpopAgregar(ActionEvent event){
        sessionScopeBeaninsumo.setCodigoNuevo("");
        sessionScopeBeaninsumo.setComentarioNuevo("");
        sessionScopeBeaninsumo.setCalidadnuevo(0);
        sessionScopeBeaninsumo.setTinsumoNuevo(0);
        sessionScopeBeaninsumo.setEmpresaNuevo(0);
        sessionScopeBeaninsumo.setFCaducacionNuevo(null);
        sessionScopeBeaninsumo.setContenidoNuevo("");
        Utils.showPopUpMIDDLE(getPopAgregar());
    }
    
    public void mostrarpopAgregarTInsumo(ActionEvent event){
        this.limpiarPOPNuevotInsumo();
        
        Utils.showPopUpAFTER_START(getPopNuevoTInsumo(), getBtnNuevotInsumo());
    }
    
    public void mostrarpopVerImagen(ActionEvent event){
        InsumoBean beanInsumo = sessionScopeBeaninsumo.getInsumoSelecc();
        sessionScopeBeaninsumo.setImageRuta(beanInsumo.getImagen());
        Utils.showPopUpMIDDLE(getPopVerImagen());
    }
    
    public void mostrarpopNuevoContenedor(ActionEvent event){
        sessionScopeBeaninsumo.setDescripcionNuevoContenedor("");
        Utils.showPopUpAFTER_START(getPopNuevoContenedor(), getBtnNuevoContenedor());
    }
    
    public void mostrarpopNuevaMedida(ActionEvent event){
        sessionScopeBeaninsumo.setDescripcionNuevaMedida("");
        Utils.showPopUpAFTER_START(getPopnuevaMedida(), getBtnNuevaMedida());
    }
    
    public void mostrarpopCambioAlmacen(ActionEvent event){
        Utils.showPopUpAFTER_START(getPopCambioAlmacen(), getBtnCambioAlmacen());
    }
    
    public void insertarContenedor(ActionEvent event){
        ContenedoresBean bean = new ContenedoresBean();
        
        bean.setDescripcion(sessionScopeBeaninsumo.getDescripcionNuevoContenedor());
        
        lN_SFContenedoresRemote.insertContenedor(bean);
        
        sessionScopeBeaninsumo.setListaContenedores(this.llenarcontenedoresComno());
        
        Utils.addTargetMany(getContenedorInputBusqueda(),getInputnuevoTInsumoContenedor());
        
        getPopNuevoContenedor().hide();
    }
    
    public void insertarMedida(ActionEvent event){
        MedidaBean bean = new MedidaBean();
        
        bean.setDescripcion(sessionScopeBeaninsumo.getDescripcionNuevaMedida());
        
        lN_SFMedidaRemote.insertMedida(bean);
        
        sessionScopeBeaninsumo.setListaMedida(this.llenarmedidaComno());
        
        Utils.addTargetMany(getUmedidaInputBusqueda(),getInputnuevoTInsumoMedida());
        
        getPopnuevaMedida().hide();
    }
    
    public void imageUpload(ValueChangeEvent valueChangeEvent) {
        try{
            UploadedFile file = (UploadedFile) valueChangeEvent.getNewValue();
            InputStream inputStream1 = file.getInputStream();
            long fileSize = file.getLength() / (1024 * 1024);
            
            System.out.println(fileSize);
            
            if(file.getLength() > 1602864){//no mas de 1.5mb
                FacesMessage fm = new FacesMessage("Imagen no puede pesar mas de 1.5 MB");
                throw new ValidatorException(fm);
            }
            
            if(Utils.validarExtensionImg(file.getFilename())){
                System.out.println(file.getFilename());
            }else{
                FacesMessage fm = new FacesMessage("Imagen ingresada no es .png .jpg .jpeg");
                throw new ValidatorException(fm);
            }
        }catch(Exception e){}
    }
    
    public void nuevoInsumo(ActionEvent event){
        String comentario = sessionScopeBeaninsumo.getComentarioNuevo();
        String codigo = sessionScopeBeaninsumo.getCodigoNuevo();
        int calidad = sessionScopeBeaninsumo.getCalidadnuevo();
        int tInsumo = sessionScopeBeaninsumo.getTinsumoNuevo();
        int empresa = sessionScopeBeaninsumo.getEmpresaNuevo();
        Date fCaducacion = sessionScopeBeaninsumo.getFCaducacionNuevo();
        String contenido = sessionScopeBeaninsumo.getContenidoNuevo();
        
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
        
        BigDecimal cont = new BigDecimal(contenido);
        
        beanInsumo.setContenido(cont);
        
        eventoxinsumo.setInsumo(beanInsumo);
        eventoxinsumo.setIdEvento(1);
        eventoxinsumo.setIdAlmacen(almacen);
        eventoxinsumo.setIdUsuario(usuario);
        
        lN_SFInsumoRemote.insertarInsumo(eventoxinsumo);
        
        getPopAgregar().hide();
        
        sessionScopeBeaninsumo.setInsumos(lN_SFInsumoRemote.getAllinsumos());
        getTbInsumos().setValue(sessionScopeBeaninsumo.getInsumos());
        Utils.addTarget(getTbInsumos());
        Utils.addTarget(getCantInsumos());
        
        Utils.showMessage("Se Ingreso un nuevo Insumo", null, 2);
        
    }
    
    public void cerrarPopNuevoInsumo(ActionEvent event){
        sessionScopeBeaninsumo.setComentarioNuevo("");
        sessionScopeBeaninsumo.setCalidadnuevo(0);
        sessionScopeBeaninsumo.setTinsumoNuevo(0);
        sessionScopeBeaninsumo.setEmpresaNuevo(0);
    }
    
    public void verificarCambioAlmacenInsumo(ValueChangeEvent vce){
        sessionScopeBeaninsumo.setCambioAlmacen(true);
    }
    
    
    
    public void cambiarAlmacen(ActionEvent event){
        InsumoBean beanInsumo = sessionScopeBeaninsumo.getInsumoSelecc();  
        if(sessionScopeBeaninsumo.isCambioAlmacen() && sessionScopeBeaninsumo.getAlmacenedit() != 0 && beanInsumo.getEstado() == 1){
            
            int usuario = sessionScopeBeaninsumo.getUsuario().getIdUsuario();
            int almacenEntrada = sessionScopeBeaninsumo.getAlmacenedit();
            int almacenSalida = sessionScopeBeaninsumo.getAlmacenSeleccionado().getIdAlmacen();
            
            Date fechaSalida  = new Date();
            Date fechaEntrada = Utils.addTimeBySecondsDemo(fechaSalida, 2);
            
            
            EventoxinsumoBean eInsumoSalida = new EventoxinsumoBean();
                eInsumoSalida.setFecha_Evento(fechaSalida);
                eInsumoSalida.setIdEvento(4);
                eInsumoSalida.setIdUsuario(usuario);
                eInsumoSalida.setIdAlmacen(almacenSalida);
                eInsumoSalida.setInsumo(beanInsumo);
            
            EventoxinsumoBean eInsumoEntrada = new EventoxinsumoBean();
                eInsumoEntrada.setFecha_Evento(fechaEntrada);
                eInsumoEntrada.setIdEvento(3);
                eInsumoEntrada.setIdUsuario(usuario);
                eInsumoEntrada.setIdAlmacen(almacenEntrada);
                eInsumoEntrada.setInsumo(beanInsumo);
                
            List<EventoxinsumoBean> listaEvento = new ArrayList<EventoxinsumoBean>();
                listaEvento.add(eInsumoSalida);
                listaEvento.add(eInsumoEntrada);          
            
            lN_SFInsumoRemote.cambioInsumoAlmacen(listaEvento);  
            

            sessionScopeBeaninsumo.setCambioAlmacen(false);
            
            sessionScopeBeaninsumo.setInsumos(lN_SFInsumoRemote.getAllinsumos());
            getTbInsumos().setValue(sessionScopeBeaninsumo.getInsumos());
            Utils.addTarget(getTbInsumos());
            
            sessionScopeBeaninsumo.setAlmacenedit(0);
            
            getPopCambioAlmacen().hide();
        }else if(beanInsumo.getEstado() != 1){
            getPopCambioAlmacen().hide();
            
            Utils.showMessage("Seleccione un insumo Activo para el cambio de almacen",null,1);
            
            sessionScopeBeaninsumo.setCambioAlmacen(false);
            
            sessionScopeBeaninsumo.setAlmacenedit(sessionScopeBeaninsumo.getAlmacenSeleccionado().getIdAlmacen());
        }
    }
            
    
    public void editarInsumo(ClientEvent ce){
        
        InsumoBean beanInsumo = sessionScopeBeaninsumo.getInsumoSelecc();        
        if(sessionScopeBeaninsumo.isCambioHecho()){
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
            
            getPopEdit().hide();
        }
        else{
            getPopEdit().hide();
            getBtnAgregar().setDisabled(true);
            getBtnEditar().setDisabled(true);
            getBtnVerImagen().setDisabled(true);
            Utils.addTarget(getBtnAgregar());
            Utils.addTarget(getBtnEditar());
            Utils.addTarget(getBtnVerImagen());
        }
    }
    
    public void verificarCambiosEditTinsumo(ValueChangeEvent vce){
        sessionScopeBeaninsumo.setCambioHecho(true);
    }
    
    public void agregarTInsumo(ActionEvent event){
        String descripcion = sessionScopeBeaninsumo.getDescripcionNuevotInsumo();
        String comentario = sessionScopeBeaninsumo.getComentarioNuevotInsumo();
        String tMinimo = sessionScopeBeaninsumo.getTMinimaNuevotInsumo();
        String tMaximo = sessionScopeBeaninsumo.getTMaximaNuevotInsumo();
        String tExpiracion = sessionScopeBeaninsumo.getTExpiracionNuevotInsumo();
        int contenedor = sessionScopeBeaninsumo.getContenedorNuevotInsumo();
        int uMedida = sessionScopeBeaninsumo.getUMedidaNuevotInsumo();
        
        TipoinsumoBean bean = new TipoinsumoBean();
        bean.setDescripcion(descripcion);
        bean.setComentario(comentario);
        bean.setTemperatura_Minima(tMinimo);
        bean.setTemperatura_Maxima(tMaximo);
        
        BigDecimal tExp = new BigDecimal(tExpiracion);
        bean.setTiempo_Expiracion(tExp);
        
        bean.setIdContenedor(contenedor);
        bean.setIdUMedida(uMedida);
        
        lN_SFTipoinsumoRemote.inserttInsumo(bean);
        
        this.limpiarPOPNuevotInsumo();
        
        sessionScopeBeaninsumo.setListaTipoinsumo(this.llenartipoInsumoComno());
        
        Utils.addTargetMany(getTinsumoInputBusqueda());
        
        getPopNuevoTInsumo().hide();
        
        Utils.showMessage("Se Ingreso un nuevo Tipo de Insumo", null, 2);
        
        
    }
    
    public void limpiarPOPNuevotInsumo(){
        sessionScopeBeaninsumo.setDescripcionNuevotInsumo("");
        sessionScopeBeaninsumo.setComentarioNuevotInsumo("");
        sessionScopeBeaninsumo.setTMinimaNuevotInsumo("");
        sessionScopeBeaninsumo.setTMaximaNuevotInsumo("");
        sessionScopeBeaninsumo.setTExpiracionNuevotInsumo("");
        sessionScopeBeaninsumo.setContenedorNuevotInsumo(0);
        sessionScopeBeaninsumo.setUMedidaNuevotInsumo(0);
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
    
    public ArrayList llenarAlmacen(){
        ArrayList almacenes = new ArrayList();
        List<AlmacenBean> EmpresaBean = lN_SFAlmacenRemote.getAllAlmacenes();
        for (AlmacenBean e : EmpresaBean) {
            almacenes.add(new SelectItem(e.getIdAlmacen(),e.getNombre()));
        } 
        return almacenes;
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

    public void setDirectorio(RichOutputLabel directorio) {
        this.directorio = directorio;
    }

    public RichOutputLabel getDirectorio() {
        return directorio;
    }

    public void setCantInsumos(RichOutputLabel cantInsumos) {
        this.cantInsumos = cantInsumos;
    }

    public RichOutputLabel getCantInsumos() {
        return cantInsumos;
    }

    public void setAlmacenEdit(RichSelectOneChoice almacenEdit) {
        this.almacenEdit = almacenEdit;
    }

    public RichSelectOneChoice getAlmacenEdit() {
        return almacenEdit;
    }

    public void setPlPpopnuevoTInsumo(RichPanelFormLayout plPpopnuevoTInsumo) {
        this.plPpopnuevoTInsumo = plPpopnuevoTInsumo;
    }

    public RichPanelFormLayout getPlPpopnuevoTInsumo() {
        return plPpopnuevoTInsumo;
    }

    public void setPopNuevoTInsumo(RichPopup popNuevoTInsumo) {
        this.popNuevoTInsumo = popNuevoTInsumo;
    }

    public RichPopup getPopNuevoTInsumo() {
        return popNuevoTInsumo;
    }

    public void setBtnNuevotInsumo(RichButton btnNuevotInsumo) {
        this.btnNuevotInsumo = btnNuevotInsumo;
    }

    public RichButton getBtnNuevotInsumo() {
        return btnNuevotInsumo;
    }

    public void setPopNuevoContenedor(RichPopup popNuevoContenedor) {
        this.popNuevoContenedor = popNuevoContenedor;
    }

    public RichPopup getPopNuevoContenedor() {
        return popNuevoContenedor;
    }

    public void setBtnNuevoContenedor(RichButton btnNuevoContenedor) {
        this.btnNuevoContenedor = btnNuevoContenedor;
    }

    public RichButton getBtnNuevoContenedor() {
        return btnNuevoContenedor;
    }

    public void setPopnuevaMedida(RichPopup popnuevaMedida) {
        this.popnuevaMedida = popnuevaMedida;
    }

    public RichPopup getPopnuevaMedida() {
        return popnuevaMedida;
    }

    public void setBtnNuevaMedida(RichButton btnNuevaMedida) {
        this.btnNuevaMedida = btnNuevaMedida;
    }

    public RichButton getBtnNuevaMedida() {
        return btnNuevaMedida;
    }

    public void setInputnuevoTInsumoContenedor(RichSelectOneChoice inputnuevoTInsumoContenedor) {
        this.inputnuevoTInsumoContenedor = inputnuevoTInsumoContenedor;
    }

    public RichSelectOneChoice getInputnuevoTInsumoContenedor() {
        return inputnuevoTInsumoContenedor;
    }

    public void setInputnuevoTInsumoMedida(RichSelectOneChoice inputnuevoTInsumoMedida) {
        this.inputnuevoTInsumoMedida = inputnuevoTInsumoMedida;
    }

    public RichSelectOneChoice getInputnuevoTInsumoMedida() {
        return inputnuevoTInsumoMedida;
    }

    public void setPopCambioAlmacen(RichPopup popCambioAlmacen) {
        this.popCambioAlmacen = popCambioAlmacen;
    }

    public RichPopup getPopCambioAlmacen() {
        return popCambioAlmacen;
    }

    public void setBtnCambioAlmacen(RichButton btnCambioAlmacen) {
        this.btnCambioAlmacen = btnCambioAlmacen;
    }

    public RichButton getBtnCambioAlmacen() {
        return btnCambioAlmacen;
    }
}
