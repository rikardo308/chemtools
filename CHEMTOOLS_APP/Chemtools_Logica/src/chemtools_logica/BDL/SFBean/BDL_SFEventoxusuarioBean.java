package chemtools_logica.BDL.SFBean;

import chemtools_logica.Entidades.Eventoxusuario;

import chemtools_logica.Entidades.EventoxusuarioPK;

import chemtools_logica.BDL.IL.BDL_SFEventoxusuarioLocal;
import chemtools_logica.BDL.IR.BDL_SFEventoxusuarioRemote;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "BDL_SFEventoxusuario", mappedName = "map-BDL_SFEventoxusuario")
public class BDL_SFEventoxusuarioBean implements BDL_SFEventoxusuarioRemote, BDL_SFEventoxusuarioLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;

    public BDL_SFEventoxusuarioBean() {
    }

    public Eventoxusuario persistEventoxusuario(Eventoxusuario eventoxusuario) {
        em.persist(eventoxusuario);
        return eventoxusuario;
    }

    public Eventoxusuario mergeEventoxusuario(Eventoxusuario eventoxusuario) {
        return em.merge(eventoxusuario);
    }

    public void removeEventoxusuario(Eventoxusuario eventoxusuario) {
        eventoxusuario =
            em.find(Eventoxusuario.class,
                    new EventoxusuarioPK(eventoxusuario.getEvento().getIdEvento(),
                                         eventoxusuario.getUsuario().getIdUsuario()));
        em.remove(eventoxusuario);
    }

    /** <code>select o from Eventoxusuario o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Eventoxusuario> getEventoxusuarioFindAll() {
        return em.createNamedQuery("Eventoxusuario.findAll", Eventoxusuario.class).getResultList();
    }
}
