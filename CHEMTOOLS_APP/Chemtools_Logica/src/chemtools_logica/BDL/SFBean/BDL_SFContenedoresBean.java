package chemtools_logica.BDL.SFBean;

import chemtools_logica.BDL.IL.BDL_SFContenedoresLocal;
import chemtools_logica.BDL.IR.BDL_SFContenedoresRemote;

import chemtools_logica.Entidades.Almacen;
import chemtools_logica.Entidades.Contenedores;

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

@Stateless(name = "BDL_SFContenedores", mappedName = "map-BDL_SFContenedores")
public class BDL_SFContenedoresBean implements BDL_SFContenedoresRemote, BDL_SFContenedoresLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;

    public BDL_SFContenedoresBean() {
    }

    public Contenedores persistContenedores(Contenedores contenedores) {
        em.persist(contenedores);
        return contenedores;
    }

    public Contenedores mergeContenedores(Contenedores contenedores) {
        return em.merge(contenedores);
    }

    public void removeContenedores(Contenedores contenedores) {
        contenedores = em.find(Contenedores.class, contenedores.getIdContenedores());
        em.remove(contenedores);
    }

    /** <code>select o from Contenedores o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Contenedores> getContenedoresFindAll() {
        return em.createNamedQuery("Contenedores.findAll", Contenedores.class).getResultList();
    }
    
    public List<Contenedores> allAlmacenesActivos(){
        List<Contenedores> contenedores = new ArrayList<Contenedores>();
        String ejbQuery = "SELECT u FROM Contenedores u " +
                          "WHERE u.estado = 1 ";
        
        try{
            Query query = em.createQuery(ejbQuery);
            contenedores = query.getResultList();
        }catch(Exception e)
        {
            contenedores = null;
        }
        
        return contenedores;
    }
}
