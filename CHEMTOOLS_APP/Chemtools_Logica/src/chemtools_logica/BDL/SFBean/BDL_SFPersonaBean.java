package chemtools_logica.BDL.SFBean;

import chemtools_logica.BDL.IL.BDL_SFPersonaLocal;
import chemtools_logica.BDL.IR.BDL_SFPersonaRemote;

import chemtools_logica.Entidades.Persona;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "BDL_SFPersona", mappedName = "map-BDL_SFPersona")
public class BDL_SFPersonaBean implements BDL_SFPersonaRemote, BDL_SFPersonaLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;

    public BDL_SFPersonaBean() {
    }

    public Persona persistPersona(Persona persona) {
        em.persist(persona);
        return persona;
    }

    public Persona mergePersona(Persona persona) {
        return em.merge(persona);
    }

    public void removePersona(Persona persona) {
        persona = em.find(Persona.class, persona.getIdPersona());
        em.remove(persona);
    }

    /** <code>select o from Persona o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Persona> getPersonaFindAll() {
        return em.createNamedQuery("Persona.findAll", Persona.class).getResultList();
    }
}
