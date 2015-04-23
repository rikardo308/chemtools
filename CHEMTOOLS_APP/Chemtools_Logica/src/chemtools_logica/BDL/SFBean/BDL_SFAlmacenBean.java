package chemtools_logica.BDL.SFBean;

import chemtools_logica.BDL.IL.BDL_SFAlmacenLocal;
import chemtools_logica.BDL.IR.BDL_SFAlmacenRemote;

import chemtools_logica.Entidades.Almacen;

import chemtools_logica.Entidades.Empresa;
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

@Stateless(name = "BDL_SFAlmacen", mappedName = "-BDL_SFAlmacen")
public class BDL_SFAlmacenBean implements BDL_SFAlmacenRemote, BDL_SFAlmacenLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;

    public BDL_SFAlmacenBean() {
    }

    public Almacen persistAlmacen(Almacen almacen) {
        em.persist(almacen);
        return almacen;
    }

    public Almacen mergeAlmacen(Almacen almacen) {
        return em.merge(almacen);
    }

    public void removeAlmacen(Almacen almacen) {
        almacen = em.find(Almacen.class, almacen.getIdAlmacen());
        em.remove(almacen);
    }

    /** <code>select o from Almacen o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Almacen> getAlmacenFindAll() {
        return em.createNamedQuery("Almacen.findAll", Almacen.class).getResultList();
    }
    
    public List<Almacen> allAlmacenesActivos(){
        List<Almacen> listaAlmacen = new ArrayList<Almacen>();
        String ejbQuery = "SELECT u FROM Almacen u " +
                          "WHERE u.estado = 1 ";
        
        try{
            Query query = em.createQuery(ejbQuery);
            listaAlmacen = query.getResultList();
        }catch(Exception e)
        {
            listaAlmacen = null;
        }
        
        return listaAlmacen;
    }
    
    public List<Almacen>getAlmacenBusqueda(String nombreAlmacen){
        List<Almacen> almacenes = new ArrayList<Almacen>();
        String ejbQuery = "SELECT u FROM Almacen u " +
                          "WHERE 1 = 1 ";
        if(nombreAlmacen != null){
            ejbQuery +="AND u.nombre like :nombreAlmacen ";
        }
            ejbQuery += "AND u.estado = 1";

        try{
            Query query = em.createQuery(ejbQuery);
            if(nombreAlmacen != null){
                query.setParameter("nombreAlmacen", "%"+nombreAlmacen.toUpperCase()+"%");   
            }
            almacenes = query.getResultList();
        }catch(Exception e)
        {
            almacenes = null;
        }
        
        return almacenes;
    }
}
