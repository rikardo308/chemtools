package chemtools_logica.BDL.SFBean;

import chemtools_logica.Entidades.Eventoxproducto;

import chemtools_logica.Entidades.EventoxproductoPK;

import chemtools_logica.BDL.IL.BDL_SFEventoxproductoLocal;
import chemtools_logica.BDL.IR.BDL_SFEventoxproductoRemote;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "BDL_SFEventoxproducto", mappedName = "map-BDL_SFEventoxproducto")
public class BDL_SFEventoxproductoBean implements BDL_SFEventoxproductoRemote, BDL_SFEventoxproductoLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;

    public BDL_SFEventoxproductoBean() {
    }

    public Eventoxproducto persistEventoxproducto(Eventoxproducto eventoxproducto) {
        em.persist(eventoxproducto);
        return eventoxproducto;
    }

    public Eventoxproducto mergeEventoxproducto(Eventoxproducto eventoxproducto) {
        return em.merge(eventoxproducto);
    }

    public void removeEventoxproducto(Eventoxproducto eventoxproducto) {
        eventoxproducto =
            em.find(Eventoxproducto.class,
                    new EventoxproductoPK(eventoxproducto.getAlmacen().getIdAlmacen(),
                                          eventoxproducto.getEvento().getIdEvento(),
                                          eventoxproducto.getProducto().getIdProducto(),
                                          eventoxproducto.getUsuario().getIdUsuario()));
        em.remove(eventoxproducto);
    }

    /** <code>select o from Eventoxproducto o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Eventoxproducto> getEventoxproductoFindAll() {
        return em.createNamedQuery("Eventoxproducto.findAll", Eventoxproducto.class).getResultList();
    }
}
