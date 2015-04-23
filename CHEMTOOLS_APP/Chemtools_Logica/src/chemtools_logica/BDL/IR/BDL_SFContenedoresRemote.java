package chemtools_logica.BDL.IR;

import chemtools_logica.Entidades.Contenedores;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface BDL_SFContenedoresRemote {
    Contenedores persistContenedores(Contenedores contenedores);

    Contenedores mergeContenedores(Contenedores contenedores);

    void removeContenedores(Contenedores contenedores);

    List<Contenedores> getContenedoresFindAll();
    
    List<Contenedores> allAlmacenesActivos();
}
