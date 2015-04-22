package chemtools_logica.LN.IL;

import chemtools_logica.Beans.UsuarioBean;

import java.util.List;

import javax.ejb.Local;

@Local
public interface LN_SFUsuarioLocal {
    
    List<UsuarioBean> allUsuarios();
    
    UsuarioBean loginUsuario(String usuario, String contraseña);
}
