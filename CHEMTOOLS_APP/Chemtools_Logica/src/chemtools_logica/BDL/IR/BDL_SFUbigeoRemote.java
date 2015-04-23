package chemtools_logica.BDL.IR;

import chemtools_logica.Entidades.Ubigeo;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface BDL_SFUbigeoRemote {
    Ubigeo persistUbigeo(Ubigeo ubigeo);

    Ubigeo mergeUbigeo(Ubigeo ubigeo);

    void removeUbigeo(Ubigeo ubigeo);

    List<Ubigeo> getUbigeoFindAll();
}
