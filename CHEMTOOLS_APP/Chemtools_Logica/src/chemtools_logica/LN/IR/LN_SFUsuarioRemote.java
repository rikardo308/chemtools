package chemtools_logica.LN.IR;

import chemtools_logica.Beans.UsuarioBean;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface LN_SFUsuarioRemote {
    
    List<UsuarioBean> allUsuarios();
    
    UsuarioBean loginUsuario(String usuario, String contraseña);
}
