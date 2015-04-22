package chemtools_logica.LN.SFBean;

import chemtools_logica.Entidades.Rolxpermisos;

import chemtools_logica.BDL.IR.BDL_SFRolxpermisosRemote;

import chemtools_logica.Beans.PermisosBean;
import chemtools_logica.Beans.RolBean;
import chemtools_logica.Beans.RolxpermisosBean;

import chemtools_logica.LN.IL.LN_SFRolxpermisosLocal;
import chemtools_logica.LN.IR.LN_SFRolxpermisosRemote;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "LN_SFRolxpermisos", mappedName = "map-LN_SFRolxpermisos")
public class LN_SFRolxpermisosBean implements LN_SFRolxpermisosRemote, LN_SFRolxpermisosLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;
    
    @EJB
    BDL_SFRolxpermisosRemote bDL_SFRolxpermisosRemote;

    public List<RolxpermisosBean>allRolxpermisos(){
        List<Rolxpermisos> lista = bDL_SFRolxpermisosRemote.getRoxpermisosFindAll();
        List<RolxpermisosBean> lista1 = new ArrayList<RolxpermisosBean>();
        
        for(Rolxpermisos entidad : lista){
            RolxpermisosBean bean = new RolxpermisosBean();
            PermisosBean permiso = new PermisosBean();
            RolBean rol = new RolBean();
            
            permiso.setIdPermisos(entidad.getPermisos().getIdPermisos());
            rol.setIdRol(entidad.getRol().getIdRol());
            
            bean.setPermisos(permiso);
            bean.setRol(rol);
            
            lista1.add(bean);
        }
        
        return lista1;
        
    }
    
    
}
