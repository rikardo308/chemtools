package view.backing.Transformaciones;

import chemtools_logica.Beans.InsumoBean;
import chemtools_logica.Beans.LaboratorioBean;
import chemtools_logica.Beans.OrdenproduccionBean;
import chemtools_logica.Beans.UsuarioBean;

import chemtools_logica.Entidades.Ordenproduccion;

import chemtools_logica.LN.IR.LN_SFAlmacenRemote;
import chemtools_logica.LN.IR.LN_SFContenedoresRemote;
import chemtools_logica.LN.IR.LN_SFEmpresaRemote;
import chemtools_logica.LN.IR.LN_SFInsumoRemote;
import chemtools_logica.LN.IR.LN_SFMedidaRemote;
import chemtools_logica.LN.IR.LN_SFTipoinsumoRemote;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import javax.annotation.PostConstruct;

import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.naming.Context;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.nav.RichButton;

import view.backing.Utils.Utils;

public class Frm_transformaciones {
    private bSessionScopeBeanTransformaciones sessionScopeBeanTransformaciones = new bSessionScopeBeanTransformaciones();
    private RichInputText nombreLabInputBusqueda;
    private RichInputDate fecIniInputDateBusqueda;
    private RichInputDate fecFinInputDateBusqueda;
    private RichSelectOneChoice estadoSelectOneChoiceBusqueda;
    private RichForm formTransformaciones;
    private RichTable tableOrdenesResultado;


    public Frm_transformaciones(){
    }
    
    @PostConstruct
    public void methodInvokeOncedOnPageLoad() {
        try {
            final Context context = getInitialContext();
        } catch (Exception e){
        
        }
        HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        UsuarioBean usuario = (UsuarioBean) sesion.getAttribute("usuario");
        
    }
    
    public void busquedaOrdenesProduccion(ActionEvent event){
        OrdenproduccionBean bean = new OrdenproduccionBean();
        LaboratorioBean lab = new LaboratorioBean();
        //lab.setRazon_Social(sessionScopeBeanTransformaciones.getFiltro().getNombreLab());
        bean.setLaboratorio(lab);
        bean.setEstado(sessionScopeBeanTransformaciones.getFiltro().getEstado());
        bean.setFechaInicial(sessionScopeBeanTransformaciones.getFiltro().getFecIni());
        bean.setFechaFinal(sessionScopeBeanTransformaciones.getFiltro().getFecFin());
        
        OrdenproduccionBean resultado = new OrdenproduccionBean();
        resultado.setIdOrdenProduccion(1);
        resultado.setComentario("Para Interfaz");
        resultado.setFechaRegistro(new Date());
        resultado.setEstado(1);
        UsuarioBean usu = new UsuarioBean();
        usu.setNombre_Usuario("El gran Chespe");
        resultado.setUsuario(usu);
        sessionScopeBeanTransformaciones.getOrdenesMostradas().add(resultado);
        
        Utils.addTarget(getTableOrdenesResultado());
        
    }
    
    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x/12.x connection details
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, "t3://127.0.0.1:7101");
        return new InitialContext(env);
    }

    public void setNombreLabInputBusqueda(RichInputText nombreLabInputBusqueda) {
        this.nombreLabInputBusqueda = nombreLabInputBusqueda;
    }

    public RichInputText getNombreLabInputBusqueda() {
        return nombreLabInputBusqueda;
    }
    
    public void setSessionScopeBeanTransformaciones(bSessionScopeBeanTransformaciones sessionScopeBeanTransformaciones) {
        this.sessionScopeBeanTransformaciones = sessionScopeBeanTransformaciones;
    }

    public bSessionScopeBeanTransformaciones getSessionScopeBeanTransformaciones() {
        return sessionScopeBeanTransformaciones;
    }

    public void setFecIniInputDateBusqueda(RichInputDate fecIniInputDateBusqueda) {
        this.fecIniInputDateBusqueda = fecIniInputDateBusqueda;
    }

    public RichInputDate getFecIniInputDateBusqueda() {
        return fecIniInputDateBusqueda;
    }

    public void setFecFinInputDateBusqueda(RichInputDate fecFinInputDateBusqueda) {
        this.fecFinInputDateBusqueda = fecFinInputDateBusqueda;
    }

    public RichInputDate getFecFinInputDateBusqueda() {
        return fecFinInputDateBusqueda;
    }

    public void setEstadoSelectOneChoiceBusqueda(RichSelectOneChoice estadoSelectOneChoiceBusqueda) {
        this.estadoSelectOneChoiceBusqueda = estadoSelectOneChoiceBusqueda;
    }

    public RichSelectOneChoice getEstadoSelectOneChoiceBusqueda() {
        return estadoSelectOneChoiceBusqueda;
    }

    public void setFormTransformaciones(RichForm formTransformaciones) {
        this.formTransformaciones = formTransformaciones;
    }

    public RichForm getFormTransformaciones() {
        return formTransformaciones;
    }

    public void setTableOrdenesResultado(RichTable tableOrdenesResultado) {
        this.tableOrdenesResultado = tableOrdenesResultado;
    }

    public RichTable getTableOrdenesResultado() {
        return tableOrdenesResultado;
    }
}
