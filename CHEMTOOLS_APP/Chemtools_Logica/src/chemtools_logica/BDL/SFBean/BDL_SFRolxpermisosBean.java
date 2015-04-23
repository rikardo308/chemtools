package chemtools_logica.BDL.SFBean;

import chemtools_logica.Entidades.Rolxpermisos;

import chemtools_logica.Entidades.RolxpermisosPK;

import chemtools_logica.BDL.IL.BDL_SFRolxpermisosLocal;
import chemtools_logica.BDL.IR.BDL_SFRolxpermisosRemote;

import chemtools_logica.Entidades.Usuario;

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

@Stateless(name = "BDL_SFRolxpermisos", mappedName = "map-BDL_SFRolxpermisos")
public class BDL_SFRolxpermisosBean implements BDL_SFRolxpermisosRemote, BDL_SFRolxpermisosLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;

    public BDL_SFRolxpermisosBean() {
    }

    public Rolxpermisos persistRoxpermisos(Rolxpermisos roxpermisos) {
        em.persist(roxpermisos);
        return roxpermisos;
    }

    public Rolxpermisos mergeRoxpermisos(Rolxpermisos roxpermisos) {
        return em.merge(roxpermisos);
    }

    public void removeRoxpermisos(Rolxpermisos roxpermisos) {
        roxpermisos =
            em.find(Rolxpermisos.class,
                    new RolxpermisosPK(roxpermisos.getPermisos().getIdPermisos(), roxpermisos.getRol().getIdRol()));
        em.remove(roxpermisos);
    }

    /** <code>select o from Roxpermisos o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Rolxpermisos> getRoxpermisosFindAll() {
        return em.createNamedQuery("Roxpermisos.findAll", Rolxpermisos.class).getResultList();
    }
    
    public List<Rolxpermisos> getPermisosbyRol(int idRol){
        List<Rolxpermisos> Roluser = new ArrayList<Rolxpermisos>();
        
        String ejbQuery = "SELECT u FROM Rolxpermisos u " +
                          "WHERE u.rol.idRol = :idRol " +
                          "AND u.permisos.estado = 1";
        
        try{
            Query query = em.createQuery(ejbQuery);
            query.setParameter("idRol",idRol);
            Roluser = query.getResultList();
        }catch(Exception e)
        {
            Roluser = null;
        }

        return Roluser;
    }
}
