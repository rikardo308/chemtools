package chemtools_logica.LN.SFBean;

import chemtools_logica.BDL.IR.BDL_SFEventoxinsumoRemote;
import chemtools_logica.BDL.IR.BDL_SFIsumoRemote;

import chemtools_logica.Beans.EventoxinsumoBean;
import chemtools_logica.Beans.InsumoBean;

import chemtools_logica.Entidades.Almacen;
import chemtools_logica.Entidades.Contenedores;
import chemtools_logica.Entidades.Empresa;
import chemtools_logica.Entidades.Evento;
import chemtools_logica.Entidades.Eventoxinsumo;
import chemtools_logica.Entidades.Insumo;

import chemtools_logica.Entidades.Medida;
import chemtools_logica.Entidades.Tipoinsumo;

import chemtools_logica.Entidades.Usuario;

import chemtools_logica.LN.IL.LN_SFInsumoLocal;
import chemtools_logica.LN.IR.LN_SFInsumoRemote;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import chemtools_logica.util_formato.Fecha.FechaUtiles;

import java.util.Date;

@Stateless(name = "LN_SFInsumo", mappedName = "map-LN_SFInsumo")
public class LN_SFInsumoBean implements LN_SFInsumoRemote, LN_SFInsumoLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;
    
    @EJB
    BDL_SFEventoxinsumoRemote bDL_SFEventoxinsumoRemote;
    @EJB
    BDL_SFIsumoRemote bDL_SFInsumoRemote;
    
    public List<InsumoBean> getInsumosbyAlmacen(int nidAlmacen){
        List<Insumo> insumos = new ArrayList<Insumo>();
        
        List<Eventoxinsumo> ev = bDL_SFEventoxinsumoRemote.getInsumosporAlmacenActivo(nidAlmacen);
        
        List<InsumoBean> insumosBean = new ArrayList<InsumoBean>();
        
        for(Eventoxinsumo entidad : ev){
            InsumoBean beanInsumo = new InsumoBean();
            
            beanInsumo = convertEntityToBeanInsumo(entidad.getInsumo(),nidAlmacen);
            
            insumosBean.add(beanInsumo);
        }
        
        return insumosBean;
    }
    
    public List<InsumoBean> getAllinsumos(){
        List<Insumo> insumos = bDL_SFInsumoRemote.getInsumoFindAll();
        List<InsumoBean> insumosBean = new ArrayList<InsumoBean>();
        
        for(Insumo entidad : insumos){
            InsumoBean beanInsumo = new InsumoBean();
            
            beanInsumo = convertEntityToBeanInsumo(entidad,0);
            
            insumosBean.add(beanInsumo);
        }
        
        return insumosBean;
    }
    
    public List<InsumoBean> getBusquedaInsumos(InsumoBean bean){
        List<Insumo> insumos = bDL_SFInsumoRemote.busquedaInsumo(bean);
        List<InsumoBean> insumosBean = new ArrayList<InsumoBean>();
        
        for(Insumo entidad : insumos){
            InsumoBean beanInsumo = new InsumoBean();
            
            beanInsumo = convertEntityToBeanInsumo(entidad,0);
            
            insumosBean.add(beanInsumo);
        }
        
        return insumosBean;
    }
    
    public String updateInsumo(InsumoBean insumo){
        
        Insumo insumoEntidad = new Insumo();
        insumoEntidad = convertBeanToEntityInsumo(insumo,0);
        bDL_SFInsumoRemote.mergeInsumo(insumoEntidad);
        
        return "";
    }
    
    public void cambioInsumoAlmacen(EventoxinsumoBean eventoxinsumo){
        Eventoxinsumo eInsumo = new Eventoxinsumo();
        
        eInsumo = this.convertEntityToBeanEventoxinsumo(eventoxinsumo);
        
        bDL_SFEventoxinsumoRemote.mergeEventoxinsumo(eInsumo);
    }
    
    public void insertarInsumo(EventoxinsumoBean eventoxinsumo){
        Eventoxinsumo eInsumo = new Eventoxinsumo();
        
        eInsumo = this.convertEntityToBeanEventoxinsumo(eventoxinsumo);
        
        bDL_SFEventoxinsumoRemote.mergeEventoxinsumo(eInsumo);
    }
    
    public boolean verificarCodigoDupl(String codigo){
        boolean exi = bDL_SFInsumoRemote.existeCodigoInsump(codigo);
        return exi;
    }
    
    //0 = update, 1 = insert
    public Insumo convertBeanToEntityInsumo(InsumoBean insumo, int opc){
        Insumo insumoEntidad = new Insumo();
        Tipoinsumo tipoInsumo = new Tipoinsumo();
        Contenedores contenedor = new Contenedores();
        Medida medida = new Medida();
        Empresa empresa = new Empresa();
        
        insumoEntidad.setCalidad(insumo.getCalidad());
        insumoEntidad.setComentario(insumo.getComentario());
        insumoEntidad.setEstado(insumo.getEstado());
        insumoEntidad.setContenido(insumo.getContenido());
        
        Date fechaCreacion = FechaUtiles.fechaActual();
        
        insumoEntidad.setFecha_Creacion(fechaCreacion);
        insumoEntidad.setIdInsumo(insumo.getIdInsumo());
        insumoEntidad.setFecha_Caducacion(insumo.getFecha_Caducacion());
        insumoEntidad.setImagen(insumo.getImagen());
        
        tipoInsumo.setIdTipoInsumo(insumo.getIdtipoInsumo());
        
        if(opc == 0){
            contenedor.setIdContenedores(insumo.getIdcontenedor());
            tipoInsumo.setContenedores(contenedor);
            medida.setIdMedida(insumo.getIdunidadMeidad());
            tipoInsumo.setMedida(medida);
        } 
            
        insumoEntidad.setTipoinsumo(tipoInsumo);
        
        empresa.setIdEmpresa(insumo.getIdEmpresa());
        insumoEntidad.setEmpresa(empresa);

        return insumoEntidad;
    }
    
    public Eventoxinsumo convertEntityToBeanEventoxinsumo(EventoxinsumoBean eventoxinsumo){
        
        Eventoxinsumo eInsumo = new Eventoxinsumo();
        Insumo insumoEntidad = new Insumo();
        Evento evento = new Evento();
        Usuario user = new Usuario();
        Almacen almacen = new Almacen();
        
        insumoEntidad = convertBeanToEntityInsumo(eventoxinsumo.getInsumo(),1);

        eInsumo.setInsumo(insumoEntidad);
        
            evento.setIdEvento(eventoxinsumo.getIdEvento());
            eInsumo.setEvento(evento);
        
        eInsumo.setFecha_Evento(new Date());
            
            user.setIdUsuario(eventoxinsumo.getIdUsuario());
            eInsumo.setUsuario(user);
            
        
            almacen.setIdAlmacen(eventoxinsumo.getIdAlmacen());
            eInsumo.setAlmacen(almacen);
            
        return eInsumo;
    }
    
    public InsumoBean convertEntityToBeanInsumo(Insumo insumo,int Almacen){
        InsumoBean insumoBean = new InsumoBean();
        
        insumoBean.setCalidad(insumo.getCalidad());
        insumoBean.setComentario(insumo.getComentario());
        insumoBean.setEstado(insumo.getEstado());
        insumoBean.setContenido(insumo.getContenido());
        
        if(insumo.getEstado() == 1){
            insumoBean.setCalidadText("PESIMO");
        }
        else if(insumo.getEstado() == 2){
            insumoBean.setCalidadText("MASOMENOS");
        }
        else if(insumo.getEstado() == 3){
            insumoBean.setCalidadText("BIEN");
        }
        
        insumoBean.setFecha_Creacion(insumo.getFecha_Creacion());
        insumoBean.setIdInsumo(insumo.getIdInsumo());
        insumoBean.setImagen(insumo.getImagen());
        insumoBean.setFecha_Caducacion(insumo.getFecha_Caducacion());
        
        if(insumo.getEstado() == 0){
            insumoBean.setStyleEstado("background-color:Red;color:White;");
        }else{
            insumoBean.setStyleEstado("background-color:Green;color:White;");
        }
        
        insumoBean.setIdtipoInsumo(insumo.getTipoinsumo().getIdTipoInsumo());
        insumoBean.setIdEmpresa(insumo.getEmpresa().getIdEmpresa());
        insumoBean.setIdcontenedor(insumo.getTipoinsumo().getContenedores().getIdContenedores());
        insumoBean.setIdunidadMeidad(insumo.getTipoinsumo().getMedida().getIdMedida());
        
        insumoBean.setTipoInsumo(insumo.getTipoinsumo().getDescripcion());
        insumoBean.setContenedor(insumo.getTipoinsumo().getContenedores().getDescripcion());
        insumoBean.setUnidadMedida(insumo.getTipoinsumo().getMedida().getDescripcion());
        insumoBean.setRazonSocialEmpresa(insumo.getEmpresa().getRazonSocial());
        
        insumoBean.setIdAlmacen(Almacen);
        
        return insumoBean;
    }
}
