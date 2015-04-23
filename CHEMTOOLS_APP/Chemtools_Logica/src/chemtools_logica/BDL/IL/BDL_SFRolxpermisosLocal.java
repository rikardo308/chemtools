package chemtools_logica.BDL.IL;

import chemtools_logica.Entidades.Rolxpermisos;

import java.util.List;

import javax.ejb.Local;

@Local
public interface BDL_SFRolxpermisosLocal {
    Rolxpermisos persistRoxpermisos(Rolxpermisos roxpermisos);

    Rolxpermisos mergeRoxpermisos(Rolxpermisos roxpermisos);

    void removeRoxpermisos(Rolxpermisos roxpermisos);

    List<Rolxpermisos> getRoxpermisosFindAll();
    
    List<Rolxpermisos> getPermisosbyRol(int idRol);
}
