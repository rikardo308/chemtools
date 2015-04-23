package chemtools_logica.BDL.IL;

import chemtools_logica.Entidades.Usuario;

import java.util.List;

import javax.ejb.Local;

@Local
public interface BDL_SFUsuarioLocal {
    Usuario persistUsuario(Usuario usuario);

    Usuario mergeUsuario(Usuario usuario);

    void removeUsuario(Usuario usuario);

    List<Usuario> getUsuarioFindAll();
    
    Usuario loginUsuario(String usuario, String contraseña);
}
