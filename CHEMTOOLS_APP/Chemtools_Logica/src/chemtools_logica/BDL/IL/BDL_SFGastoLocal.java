package chemtools_logica.BDL.IL;

import chemtools_logica.Entidades.Gasto;

import java.util.List;

import javax.ejb.Local;

@Local
public interface BDL_SFGastoLocal {
    Gasto persistGasto(Gasto gasto);

    Gasto mergeGasto(Gasto gasto);

    void removeGasto(Gasto gasto);

    List<Gasto> getGastoFindAll();
}
