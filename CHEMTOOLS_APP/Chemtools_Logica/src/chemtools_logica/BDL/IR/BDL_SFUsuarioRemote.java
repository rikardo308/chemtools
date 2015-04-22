package chemtools_logica.BDL.IR;

import chemtools_logica.Entidades.Usuario;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface BDL_SFUsuarioRemote {
    Usuario persistUsuario(Usuario usuario);

    Usuario mergeUsuario(Usuario usuario);

    void removeUsuario(Usuario usuario);

    List<Usuario> getUsuarioFindAll();
    
    Usuario loginUsuario(String usuario, String contraseña);
}
