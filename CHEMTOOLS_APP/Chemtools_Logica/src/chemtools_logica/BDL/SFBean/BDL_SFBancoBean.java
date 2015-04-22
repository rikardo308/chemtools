package chemtools_logica.BDL.SFBean;

import chemtools_logica.BDL.IL.BDL_SFBancoLocal;
import chemtools_logica.BDL.IR.BDL_SFBancoRemote;

import chemtools_logica.Entidades.Banco;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "BDL_SFBanco", mappedName = "map-BDL_SFBanco")
public class BDL_SFBancoBean implements BDL_SFBancoRemote, BDL_SFBancoLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;

    public BDL_SFBancoBean() {
    }

    public Banco persistBanco(Banco banco) {
        em.persist(banco);
        return banco;
    }

    public Banco mergeBanco(Banco banco) {
        return em.merge(banco);
    }

    public void removeBanco(Banco banco) {
        banco = em.find(Banco.class, banco.getIdBanco());
        em.remove(banco);
    }

    /** <code>select o from Banco o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Banco> getBancoFindAll() {
        return em.createNamedQuery("Banco.findAll", Banco.class).getResultList();
    }
}
