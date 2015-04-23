package chemtools_logica.BDL.SFBean;

import chemtools_logica.BDL.IL.BDL_SFTipoinsumoLocal;
import chemtools_logica.BDL.IR.BDL_SFTipoinsumoRemote;

import chemtools_logica.Entidades.Medida;
import chemtools_logica.Entidades.Tipoinsumo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "BDL_SFTipoinsumo", mappedName = "map-BDL_SFTipoinsumo")
public class BDL_SFTipoinsumoBean implements BDL_SFTipoinsumoRemote, BDL_SFTipoinsumoLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;

    public BDL_SFTipoinsumoBean() {
    }

    public Tipoinsumo persistTipoinsumo(Tipoinsumo tipoinsumo) {
        em.persist(tipoinsumo);
        return tipoinsumo;
    }

    public Tipoinsumo mergeTipoinsumo(Tipoinsumo tipoinsumo) {
        return em.merge(tipoinsumo);
    }

    public void removeTipoinsumo(Tipoinsumo tipoinsumo) {
        tipoinsumo = em.find(Tipoinsumo.class, tipoinsumo.getIdTipoInsumo());
        em.remove(tipoinsumo);
    }

    /** <code>select o from Tipoinsumo o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Tipoinsumo> getTipoinsumoFindAll() {
        return em.createNamedQuery("Tipoinsumo.findAll", Tipoinsumo.class).getResultList();
    }
    
    public List<Tipoinsumo> getTipoinsumosActivos(){
        List<Tipoinsumo> tipoInsumos = new ArrayList<Tipoinsumo>();
        
        String ejbQuery = "SELECT u FROM Tipoinsumo u " +
                          "WHERE u.estado = 1 ";
        
        try{
            Query query = em.createQuery(ejbQuery);
            tipoInsumos = query.getResultList();
        }catch(Exception e)
        {
            tipoInsumos = null;
        }

        return tipoInsumos;
    }
}
