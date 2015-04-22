package chemtools_logica.BDL.SFBean;

import chemtools_logica.Entidades.Detalleformula;

import chemtools_logica.Entidades.DetalleformulaPK;

import chemtools_logica.BDL.IL.BDL_SFDetalleformulaLocal;
import chemtools_logica.BDL.IR.BDL_SFDetalleformulaRemote;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "BDL_SFDetalleformula", mappedName = "map-BDL_SFDetalleformula")
public class BDL_SFDetalleformulaBean implements BDL_SFDetalleformulaRemote, BDL_SFDetalleformulaLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;

    public BDL_SFDetalleformulaBean() {
    }

    public Detalleformula persistDetalleformula(Detalleformula detalleformula) {
        em.persist(detalleformula);
        return detalleformula;
    }

    public Detalleformula mergeDetalleformula(Detalleformula detalleformula) {
        return em.merge(detalleformula);
    }

    public void removeDetalleformula(Detalleformula detalleformula) {
        detalleformula =
            em.find(Detalleformula.class,
                    new DetalleformulaPK(detalleformula.getFormula().getIdFormula(),
                                         detalleformula.getTipoinsumo().getIdTipoInsumo(),
                                         detalleformula.getTipoproducto().getIdTipoProducto()));
        em.remove(detalleformula);
    }

    /** <code>select o from Detalleformula o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Detalleformula> getDetalleformulaFindAll() {
        return em.createNamedQuery("Detalleformula.findAll", Detalleformula.class).getResultList();
    }
}
