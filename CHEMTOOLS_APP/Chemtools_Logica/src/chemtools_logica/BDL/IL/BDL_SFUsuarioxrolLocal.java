package chemtools_logica.BDL.IL;

import chemtools_logica.Entidades.Rol;
import chemtools_logica.Entidades.Usuarioxrol;

import java.util.List;

import javax.ejb.Local;

@Local
public interface BDL_SFUsuarioxrolLocal {
    Usuarioxrol persistUsuarioxrol(Usuarioxrol usuarioxrol);

    Usuarioxrol mergeUsuarioxrol(Usuarioxrol usuarioxrol);

    void removeUsuarioxrol(Usuarioxrol usuarioxrol);

    List<Usuarioxrol> getUsuarioxrolFindAll();
    
    Rol getRolesByUsuario(int idUsuario);
}
