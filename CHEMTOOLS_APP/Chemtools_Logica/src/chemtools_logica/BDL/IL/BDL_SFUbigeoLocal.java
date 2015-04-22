package chemtools_logica.BDL.IL;

import chemtools_logica.Entidades.Ubigeo;

import java.util.List;

import javax.ejb.Local;

@Local
public interface BDL_SFUbigeoLocal {
    Ubigeo persistUbigeo(Ubigeo ubigeo);

    Ubigeo mergeUbigeo(Ubigeo ubigeo);

    void removeUbigeo(Ubigeo ubigeo);

    List<Ubigeo> getUbigeoFindAll();
}
