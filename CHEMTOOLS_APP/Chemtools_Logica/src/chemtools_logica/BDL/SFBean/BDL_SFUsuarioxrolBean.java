package chemtools_logica.BDL.SFBean;

import chemtools_logica.Entidades.Usuarioxrol;

import chemtools_logica.Entidades.UsuarioxrolPK;

import chemtools_logica.BDL.IL.BDL_SFUsuarioxrolLocal;
import chemtools_logica.BDL.IR.BDL_SFUsuarioxrolRemote;


import chemtools_logica.Entidades.Rol;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "BDL_SFUsuarioxrol", mappedName = "map-BDL_SFUsuarioxrol")
public class BDL_SFUsuarioxrolBean implements BDL_SFUsuarioxrolRemote, BDL_SFUsuarioxrolLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;

    public BDL_SFUsuarioxrolBean() {
    }

    public Usuarioxrol persistUsuarioxrol(Usuarioxrol usuarioxrol) {
        em.persist(usuarioxrol);
        return usuarioxrol;
    }

    public Usuarioxrol mergeUsuarioxrol(Usuarioxrol usuarioxrol) {
        return em.merge(usuarioxrol);
    }

    public void removeUsuarioxrol(Usuarioxrol usuarioxrol) {
        usuarioxrol =
            em.find(Usuarioxrol.class,
                    new UsuarioxrolPK(usuarioxrol.getUsuario().getIdUsuario(),
                                      usuarioxrol.getRol().getIdRol()));
        em.remove(usuarioxrol);
    }

    /** <code>select o from Usuarioxrol o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Usuarioxrol> getUsuarioxrolFindAll() {
        return em.createNamedQuery("Usuarioxrol.findAll", Usuarioxrol.class).getResultList();
    }
    
    public Rol getRolesByUsuario(int idUsuario){
        Rol rol = null;
        
        String ejbQuery = "SELECT u.rol FROM Usuarioxrol u " +
                          "WHERE u.usuario.idUsuario = :idUsuario ";
        
        try{
            Query query = em.createQuery(ejbQuery);
            query.setParameter("idUsuario",idUsuario);
            rol = (Rol)query.getSingleResult();
        }catch(Exception e)
        {
            rol = null;
        }

        return rol;
    }
}
