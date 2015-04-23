package chemtools_logica.BDL.IR;

import chemtools_logica.Entidades.Gasto;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface BDL_SFGastoRemote {
    Gasto persistGasto(Gasto gasto);

    Gasto mergeGasto(Gasto gasto);

    void removeGasto(Gasto gasto);

    List<Gasto> getGastoFindAll();
}
