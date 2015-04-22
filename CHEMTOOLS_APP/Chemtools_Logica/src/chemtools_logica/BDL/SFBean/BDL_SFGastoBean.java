package chemtools_logica.BDL.SFBean;

import chemtools_logica.Entidades.Gasto;

import chemtools_logica.BDL.IL.BDL_SFGastoLocal;
import chemtools_logica.BDL.IR.BDL_SFGastoRemote;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "BDL_SFGasto", mappedName = "map-BDL_SFGasto")
public class BDL_SFGastoBean implements BDL_SFGastoRemote, BDL_SFGastoLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;

    public BDL_SFGastoBean() {
    }

    public Gasto persistGasto(Gasto gasto) {
        em.persist(gasto);
        return gasto;
    }

    public Gasto mergeGasto(Gasto gasto) {
        return em.merge(gasto);
    }

    public void removeGasto(Gasto gasto) {
        gasto = em.find(Gasto.class, gasto.getIdGastos());
        em.remove(gasto);
    }

    /** <code>select o from Gasto o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Gasto> getGastoFindAll() {
        return em.createNamedQuery("Gasto.findAll", Gasto.class).getResultList();
    }
}
