package chemtools_logica.BDL.IR;

import chemtools_logica.Beans.InsumoBean;

import chemtools_logica.Entidades.Insumo;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface BDL_SFIsumoRemote {
    Insumo persistInsumo(Insumo insumo);

    Insumo mergeInsumo(Insumo insumo);

    void removeInsumo(Insumo insumo);

    List<Insumo> getInsumoFindAll();
    
    List<Insumo> busquedaInsumo(InsumoBean bean);

    String updateInsumo(Insumo insumo);
    
    boolean existeCodigoInsump(String codigo);
}
