package view.backing.seguridad;

import chemtools_logica.Beans.UsuarioBean;

import chemtools_logica.LN.IR.LN_SFUsuarioRemote;

import java.io.IOException;

import java.util.Hashtable;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import view.backing.Utils.Utils;

public class Frm_login {    
    private bSessionScopeBeanlogin sessionScopeBeanlogin;
    private LN_SFUsuarioRemote lN_SFUsuarioRemote;
    
    public Frm_login(){
        try {
            final Context context = getInitialContext();
            lN_SFUsuarioRemote = (LN_SFUsuarioRemote) context.lookup("map-LN_SFUsuario#chemtools_logica.LN.IR.LN_SFUsuarioRemote");    
        }catch(Exception e){}
    }
    
    public void login(ActionEvent event){
        UsuarioBean user = lN_SFUsuarioRemote.loginUsuario(sessionScopeBeanlogin.getUsuario(), sessionScopeBeanlogin.getContrasena());
        
        if(user == null){
                    sessionScopeBeanlogin.getContraInput().resetValue();
                    sessionScopeBeanlogin.setContrasena("");
                    Utils.addTarget(sessionScopeBeanlogin.getContraInput());
                }else{
            
                    sessionScopeBeanlogin.setPermisosMenu(user.getPermisos());
                    
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario",user);
                    try {
                        FacesContext.getCurrentInstance().getExternalContext().redirect("frm_inicio.jsf");
                    } catch (Exception ex) {}
                }
    }
    
    public void cerrarSession(ActionEvent event){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
                try {
                      FacesContext.getCurrentInstance().getExternalContext().redirect("frm_login.jsf");
                  } catch (IOException ex) {
                  }
    }
    
    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x/12.x connection details
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, "t3://127.0.0.1:7101");
        return new InitialContext(env);
    }

    public void setSessionScopeBeanlogin(bSessionScopeBeanlogin sessionScopeBeanlogin) {
        this.sessionScopeBeanlogin = sessionScopeBeanlogin;
    }

    public bSessionScopeBeanlogin getSessionScopeBeanlogin() {
        return sessionScopeBeanlogin;
    }
}
