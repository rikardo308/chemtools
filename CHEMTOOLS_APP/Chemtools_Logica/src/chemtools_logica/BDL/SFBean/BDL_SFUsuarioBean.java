package chemtools_logica.BDL.SFBean;

import chemtools_logica.BDL.IL.BDL_SFUsuarioLocal;
import chemtools_logica.BDL.IR.BDL_SFUsuarioRemote;

import chemtools_logica.Entidades.Usuario;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "BDL_SFUsuario", mappedName = "map-BDL_SFUsuario")
public class BDL_SFUsuarioBean implements BDL_SFUsuarioRemote, BDL_SFUsuarioLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;

    public BDL_SFUsuarioBean() {
    }

    public Usuario persistUsuario(Usuario usuario) {
        em.persist(usuario);
        return usuario;
    }

    public Usuario mergeUsuario(Usuario usuario) {
        return em.merge(usuario);
    }

    public void removeUsuario(Usuario usuario) {
        usuario = em.find(Usuario.class, usuario.getIdUsuario());
        em.remove(usuario);
    }

    /** <code>select o from Usuario o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Usuario> getUsuarioFindAll() {
        return em.createNamedQuery("Usuario.findAll", Usuario.class).getResultList();
    }
    
    public Usuario loginUsuario(String usuario, String contrasena){
            Usuario user = null;
            
            String ejbQuery = "SELECT u FROM Usuario u " +
                              "WHERE u.nombre_Usuario = :usuario " +
                              "AND u.clave = :clave " +
                              "AND u.estado = 1";            
            try{
                Query query = em.createQuery(ejbQuery);
                query.setParameter("usuario",usuario);
                query.setParameter("clave",contrasena);
                user = (Usuario)query.getSingleResult();
            }catch(Exception e)
            {
                user = null;
            }

            return user;
        }
}
