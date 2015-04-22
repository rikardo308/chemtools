package chemtools_logica.LN.SFBean;

import chemtools_logica.BDL.IR.BDL_SFAlmacenRemote;

import chemtools_logica.BDL.IR.BDL_SFTipoinsumoRemote;

import chemtools_logica.Beans.TipoinsumoBean;

import chemtools_logica.Entidades.Tipoinsumo;

import chemtools_logica.LN.IL.LN_SFTipoinsumoLocal;
import chemtools_logica.LN.IR.LN_SFTipoinsumoRemote;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "LN_SFTipoinsumo", mappedName = "map-LN_SFTipoinsumo")
public class LN_SFTipoinsumoBean implements LN_SFTipoinsumoRemote, LN_SFTipoinsumoLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;
    
    @EJB
    BDL_SFTipoinsumoRemote bDL_SFTipoinsumoRemote;
    

    public List<TipoinsumoBean> getAlltipoInsumos(){
        List<Tipoinsumo> tipoInsumos = bDL_SFTipoinsumoRemote.getTipoinsumosActivos();
        List<TipoinsumoBean> tipoInsumosBean = new ArrayList<TipoinsumoBean>();
        
        for(Tipoinsumo entidad : tipoInsumos){
            TipoinsumoBean bean = new TipoinsumoBean();
            
            bean.setDescripcion(entidad.getDescripcion());
            bean.setIdTipoInsumo(entidad.getIdTipoInsumo());
            
            tipoInsumosBean.add(bean);
        }
        
        return tipoInsumosBean;
    }
}
