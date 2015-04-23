package chemtools_logica.LN.SFBean;

import chemtools_logica.BDL.IR.BDL_SFMedidaRemote;

import chemtools_logica.Beans.MedidaBean;

import chemtools_logica.Entidades.Medida;

import chemtools_logica.LN.IL.LN_SFMedidaLocal;
import chemtools_logica.LN.IR.LN_SFMedidaRemote;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "LN_SFMedida", mappedName = "map-LN_SFMedida")
public class LN_SFMedidaBean implements LN_SFMedidaRemote, LN_SFMedidaLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;
    
    @EJB
    private BDL_SFMedidaRemote bDL_SFMedidaRemote;

    public List<MedidaBean> allMedidas(){
        List<Medida> medidas = bDL_SFMedidaRemote.getMedidasActivas();
        List<MedidaBean> medidasBean = new ArrayList<MedidaBean>();
        
        for(Medida entidad : medidas){
            MedidaBean bean = new MedidaBean();
            bean.setIdMedida(entidad.getIdMedida());
            bean.setDescripcion(entidad.getDescripcion());
            
            medidasBean.add(bean);
        }
        
        return medidasBean;
    }
}
