package chemtools_logica.BDL.IL;

import chemtools_logica.Entidades.Contenedores;

import java.util.List;

import javax.ejb.Local;

@Local
public interface BDL_SFContenedoresLocal {
    Contenedores persistContenedores(Contenedores contenedores);

    Contenedores mergeContenedores(Contenedores contenedores);

    void removeContenedores(Contenedores contenedores);

    List<Contenedores> getContenedoresFindAll();
    
    List<Contenedores> allAlmacenesActivos();
}
