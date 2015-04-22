package chemtools_logica.BDL.IL;

import chemtools_logica.Entidades.Eventoxusuario;

import java.util.List;

import javax.ejb.Local;

@Local
public interface BDL_SFEventoxusuarioLocal {
    Eventoxusuario persistEventoxusuario(Eventoxusuario eventoxusuario);

    Eventoxusuario mergeEventoxusuario(Eventoxusuario eventoxusuario);

    void removeEventoxusuario(Eventoxusuario eventoxusuario);

    List<Eventoxusuario> getEventoxusuarioFindAll();
}
