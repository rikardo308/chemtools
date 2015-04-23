package chemtools_logica.LN.SFBean;

import chemtools_logica.BDL.IR.BDL_SFRolxpermisosRemote;
import chemtools_logica.BDL.IR.BDL_SFUsuarioRemote;
import chemtools_logica.BDL.IR.BDL_SFUsuarioxrolRemote;
import chemtools_logica.BDL.SFBean.BDL_SFRolxpermisosBean;
import chemtools_logica.BDL.SFBean.BDL_SFUsuarioBean;

import chemtools_logica.Beans.PermisosBean;
import chemtools_logica.Beans.PersonaBean;
import chemtools_logica.Beans.RolBean;
import chemtools_logica.Beans.RolxpermisosBean;
import chemtools_logica.Beans.UsuarioBean;

import chemtools_logica.Entidades.Persona;
import chemtools_logica.Entidades.Rol;
import chemtools_logica.Entidades.Rolxpermisos;
import chemtools_logica.Entidades.Usuario;

import chemtools_logica.Entidades.Usuarioxrol;

import chemtools_logica.LN.IL.LN_SFUsuarioLocal;
import chemtools_logica.LN.IR.LN_SFUsuarioRemote;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "LN_SFUsuario", mappedName = "map-LN_SFUsuario")
public class LN_SFUsuarioBean implements LN_SFUsuarioRemote, LN_SFUsuarioLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;

    @EJB
    BDL_SFUsuarioRemote bDL_SFUsuarioRemote;
    @EJB
    BDL_SFRolxpermisosRemote bDL_SFRolxpermisosRemote;
    @EJB
    BDL_SFUsuarioxrolRemote bDL_SFUsuarioxrolRemote;
   
   public List<UsuarioBean> allUsuarios(){
       List<Usuario>usuarios = bDL_SFUsuarioRemote.getUsuarioFindAll();
       List<UsuarioBean> usuas = new ArrayList<UsuarioBean>();
       
       for(Usuario entidad : usuarios){
           UsuarioBean bean = new UsuarioBean();
           PersonaBean persona = new PersonaBean();
           
           persona.setIdPersona(entidad.getPersona().getIdPersona());
           bean.setPersona(persona);
           bean.setIdUsuario(entidad.getIdUsuario());
           
           usuas.add(bean);
       }
       
       return usuas;
   }
   
    public UsuarioBean loginUsuario(String usuario, String contraseña){
        Usuario usuarioEnt = bDL_SFUsuarioRemote.loginUsuario(usuario, contraseña);
        
        UsuarioBean beanUsuario = new UsuarioBean();
        if(usuarioEnt != null){
            beanUsuario.setIdUsuario(usuarioEnt.getIdUsuario());
            beanUsuario.setNombre_Usuario(usuarioEnt.getNombre_Usuario());
            
            Rol rolEnt = bDL_SFUsuarioxrolRemote.getRolesByUsuario(usuarioEnt.getIdUsuario());
            RolBean beanRol = new RolBean();
            beanRol.setIdRol(rolEnt.getIdRol());
            beanRol.setNombre(rolEnt.getNombre());
            
            beanUsuario.setRol(beanRol);
            
            List<Rolxpermisos> rolPermisosEnt = bDL_SFRolxpermisosRemote.getPermisosbyRol(rolEnt.getIdRol());
            List<PermisosBean> rolPermisosList = new ArrayList<PermisosBean>();
            
            for(Rolxpermisos entidad : rolPermisosEnt){
                PermisosBean beanPermisos = new PermisosBean();
                beanPermisos.setNombre(entidad.getPermisos().getNombre());
                beanPermisos.setUrl(entidad.getPermisos().getUrl());
                beanPermisos.setIcono(entidad.getPermisos().getIcono());
                
                rolPermisosList.add(beanPermisos);
            }
            
            beanUsuario.setPermisos(rolPermisosList);

        }else{
            beanUsuario = null; 
        }
        return beanUsuario;
    }
} 
