package chemtools_logica.BDL.IR;

import chemtools_logica.Entidades.Eventoxusuario;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface BDL_SFEventoxusuarioRemote {
    Eventoxusuario persistEventoxusuario(Eventoxusuario eventoxusuario);

    Eventoxusuario mergeEventoxusuario(Eventoxusuario eventoxusuario);

    void removeEventoxusuario(Eventoxusuario eventoxusuario);

    List<Eventoxusuario> getEventoxusuarioFindAll();
}
