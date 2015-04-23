package chemtools_logica.LN.SFBean;

import chemtools_logica.BDL.IR.BDL_SFContenedoresRemote;
import chemtools_logica.BDL.IR.BDL_SFMedidaRemote;

import chemtools_logica.Beans.ContenedoresBean;

import chemtools_logica.Entidades.Contenedores;

import chemtools_logica.LN.IL.LN_SFContenedoresLocal;
import chemtools_logica.LN.IR.LN_SFContenedoresRemote;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "LN_SFContenedores", mappedName = "map-LN_SFContenedores")
public class LN_SFContenedoresBean implements LN_SFContenedoresRemote, LN_SFContenedoresLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;
    
    @EJB
    private BDL_SFContenedoresRemote bDL_SFContenedoresRemote;

    public List<ContenedoresBean> getContenedoresActivos(){
        List<Contenedores> contenedores = bDL_SFContenedoresRemote.allAlmacenesActivos();
        List<ContenedoresBean> contenedoresBean = new ArrayList<ContenedoresBean>();
        
        for(Contenedores entidad : contenedores){
            ContenedoresBean bean = new ContenedoresBean();
            
            bean.setDescripcion(entidad.getDescripcion());
            bean.setIdContenedores(entidad.getIdContenedores());
            
            contenedoresBean.add(bean);
        }
        
        return contenedoresBean;
    }
}
