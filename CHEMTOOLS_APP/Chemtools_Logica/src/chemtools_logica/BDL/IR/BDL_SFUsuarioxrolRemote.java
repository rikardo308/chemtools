package chemtools_logica.BDL.IR;

import chemtools_logica.Entidades.Rol;
import chemtools_logica.Entidades.Usuarioxrol;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface BDL_SFUsuarioxrolRemote {
    Usuarioxrol persistUsuarioxrol(Usuarioxrol usuarioxrol);

    Usuarioxrol mergeUsuarioxrol(Usuarioxrol usuarioxrol);

    void removeUsuarioxrol(Usuarioxrol usuarioxrol);

    List<Usuarioxrol> getUsuarioxrolFindAll();
    
    Rol getRolesByUsuario(int idUsuario);
}
