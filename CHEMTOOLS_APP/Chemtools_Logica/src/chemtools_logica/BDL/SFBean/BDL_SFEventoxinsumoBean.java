package chemtools_logica.BDL.SFBean;

import chemtools_logica.Entidades.Eventoxinsumo;

import chemtools_logica.Entidades.EventoxinsumoPK;

import chemtools_logica.BDL.IL.BDL_SFEventoxinsumoLocal;
import chemtools_logica.BDL.IR.BDL_SFEventoxinsumoRemote;

import chemtools_logica.Entidades.Insumo;

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

@Stateless(name = "BDL_SFEventoxinsumo", mappedName = "map-BDL_SFEventoxinsumo")
public class BDL_SFEventoxinsumoBean implements BDL_SFEventoxinsumoRemote, BDL_SFEventoxinsumoLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;

    public BDL_SFEventoxinsumoBean() {
    }

    public Eventoxinsumo persistEventoxinsumo(Eventoxinsumo eventoxinsumo) {
        em.persist(eventoxinsumo);
        return eventoxinsumo;
    }

    public Eventoxinsumo mergeEventoxinsumo(Eventoxinsumo eventoxinsumo) {
        Eventoxinsumo ei = em.merge(eventoxinsumo);
        return ei;
    }
    
    public void removeEventoxinsumo(Eventoxinsumo eventoxinsumo) {
        eventoxinsumo =
            em.find(Eventoxinsumo.class,
                    new EventoxinsumoPK(eventoxinsumo.getAlmacen().getIdAlmacen(),
                                        eventoxinsumo.getEvento().getIdEvento(),
                                        eventoxinsumo.getInsumo().getIdInsumo(),
                                        eventoxinsumo.getUsuario().getIdUsuario()));
        em.remove(eventoxinsumo);
    }

    /** <code>select o from Eventoxinsumo o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Eventoxinsumo> getEventoxinsumoFindAll() {
        return em.createNamedQuery("Eventoxinsumo.findAll", Eventoxinsumo.class).getResultList();
    }
    
    public List<Eventoxinsumo> getInsumosporAlmacenActivo(int nidAlmacen){
        List<Eventoxinsumo> eventoXInsumos = new ArrayList<Eventoxinsumo>();
        
        String ejbQuery ="SELECT t1.* "+
                            "FROM eventoxinsumo t1 " +
                            "INNER JOIN insumo AS ins ON t1.idInsumo = ins.idInsumo " +
                            "INNER JOIN almacen AS alm ON t1.idUsuario = alm.idAlmacen "+
                            "INNER JOIN "+
                            "( "+
                              "SELECT MAX(Fecha_Evento) maxdate, idInsumo,idUsuario "+
                              "FROM eventoxinsumo "+
                              "GROUP BY idInsumo "+
                            ") t2 "+
                              "ON t1.idInsumo = t2.idInsumo "+
                              "AND t1.Fecha_Evento = t2.maxdate "+
                            "AND t1.idAlmacen = "+nidAlmacen;
        
        try{
            Query query = em.createNativeQuery(ejbQuery, Eventoxinsumo.class);
            eventoXInsumos = query.getResultList();
        }catch(Exception e)
        {
            eventoXInsumos = null;
        }
        
        return eventoXInsumos;
        
    }
}
