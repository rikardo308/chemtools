package chemtools_logica.BDL.SFBean;

import chemtools_logica.BDL.IL.BDL_SFMedidaLocal;
import chemtools_logica.BDL.IR.BDL_SFMedidaRemote;

import chemtools_logica.Entidades.Medida;

import chemtools_logica.Entidades.Rolxpermisos;

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

@Stateless(name = "BDL_SFMedida", mappedName = "map-BDL_SFMedida")
public class BDL_SFMedidaBean implements BDL_SFMedidaRemote, BDL_SFMedidaLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;

    public BDL_SFMedidaBean() {
    }

    public Medida persistMedida(Medida medida) {
        em.persist(medida);
        return medida;
    }

    public Medida mergeMedida(Medida medida) {
        return em.merge(medida);
    }

    public void removeMedida(Medida medida) {
        medida = em.find(Medida.class, medida.getIdMedida());
        em.remove(medida);
    }

    /** <code>select o from Medida o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Medida> getMedidaFindAll() {
        return em.createNamedQuery("Medida.findAll", Medida.class).getResultList();
    }
    
    public List<Medida> getMedidasActivas(){
        List<Medida> medidas = new ArrayList<Medida>();
        
        String ejbQuery = "SELECT u FROM Medida u " +
                          "WHERE u.estado = 1 ";
        
        try{
            Query query = em.createQuery(ejbQuery);
            medidas = query.getResultList();
        }catch(Exception e)
        {
            medidas = null;
        }

        return medidas;
    }
}
