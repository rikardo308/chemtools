package chemtools_logica.BDL.IL;

import chemtools_logica.Entidades.Persona;

import java.util.List;

import javax.ejb.Local;

@Local
public interface BDL_SFPersonaLocal {
    Persona persistPersona(Persona persona);

    Persona mergePersona(Persona persona);

    void removePersona(Persona persona);

    List<Persona> getPersonaFindAll();
}
