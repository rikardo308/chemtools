package chemtools_logica.LN.SFBean;

import chemtools_logica.BDL.IR.BDL_SFAlmacenRemote;
import chemtools_logica.BDL.IR.BDL_SFEmpresaRemote;

import chemtools_logica.Beans.AlmacenBean;

import chemtools_logica.Entidades.Almacen;

import chemtools_logica.LN.IL.LN_SFAlmacenLocal;
import chemtools_logica.LN.IR.LN_SFAlmacenRemote;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "LN_SFAlmacen", mappedName = "map-LN_SFAlmacen")
public class LN_SFAlmacenBean implements LN_SFAlmacenRemote, LN_SFAlmacenLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;

    @EJB
    BDL_SFAlmacenRemote bDL_SFAlmacenRemote;
    
    public List<AlmacenBean> getAllAlmacenes(){
        List<Almacen>almacenes = bDL_SFAlmacenRemote.allAlmacenesActivos();
        List<AlmacenBean>beanAlmacenes = new ArrayList<AlmacenBean>();
        
        for(Almacen entidad : almacenes){
            AlmacenBean bean = new AlmacenBean();
            
            bean.setIdAlmacen(entidad.getIdAlmacen());
            bean.setNombre(entidad.getNombre());
            bean.setCapacidad(entidad.getCapacidad());
            
            beanAlmacenes.add(bean);
        }
        
        return beanAlmacenes;
    }
    
    public List<AlmacenBean> getAllAlmacenesBusqeuda(String nombre){
        List<Almacen>almacenes = bDL_SFAlmacenRemote.getAlmacenBusqueda(nombre);
        List<AlmacenBean>beanAlmacenes = new ArrayList<AlmacenBean>();
        
        for(Almacen entidad : almacenes){
            AlmacenBean bean = new AlmacenBean();
            
            bean.setIdAlmacen(entidad.getIdAlmacen());
            bean.setNombre(entidad.getNombre());
            bean.setCapacidad(entidad.getCapacidad());
            
            beanAlmacenes.add(bean);
        }
        
        return beanAlmacenes;
    } 
}
