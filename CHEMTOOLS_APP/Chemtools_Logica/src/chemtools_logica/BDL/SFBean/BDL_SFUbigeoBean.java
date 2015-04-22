package chemtools_logica.BDL.SFBean;

import chemtools_logica.Entidades.Ubigeo;

import chemtools_logica.BDL.IL.BDL_SFUbigeoLocal;
import chemtools_logica.BDL.IR.BDL_SFUbigeoRemote;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "BDL_SFUbigeo", mappedName = "map-BDL_SFUbigeo")
public class BDL_SFUbigeoBean implements BDL_SFUbigeoRemote, BDL_SFUbigeoLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;

    public BDL_SFUbigeoBean() {
    }

    public Ubigeo persistUbigeo(Ubigeo ubigeo) {
        em.persist(ubigeo);
        return ubigeo;
    }

    public Ubigeo mergeUbigeo(Ubigeo ubigeo) {
        return em.merge(ubigeo);
    }

    public void removeUbigeo(Ubigeo ubigeo) {
        ubigeo = em.find(Ubigeo.class, ubigeo.getIdUbigeo());
        em.remove(ubigeo);
    }

    /** <code>select o from Ubigeo o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Ubigeo> getUbigeoFindAll() {
        return em.createNamedQuery("Ubigeo.findAll", Ubigeo.class).getResultList();
    }
}
