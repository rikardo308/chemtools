package chemtools_logica.BDL.IR;

import chemtools_logica.Entidades.Persona;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface BDL_SFPersonaRemote {
    Persona persistPersona(Persona persona);

    Persona mergePersona(Persona persona);

    void removePersona(Persona persona);

    List<Persona> getPersonaFindAll();
}
