package chemtools_logica.BDL.IL;

import chemtools_logica.Beans.InsumoBean;

import chemtools_logica.Entidades.Insumo;

import java.util.List;

import javax.ejb.Local;

@Local
public interface BDL_SFIsumoLocal {
    Insumo persistInsumo(Insumo insumo);

    Insumo mergeInsumo(Insumo insumo);

    void removeInsumo(Insumo insumo);

    List<Insumo> getInsumoFindAll();
    
    List<Insumo> busquedaInsumo(InsumoBean bean);
    
    String updateInsumo(Insumo insumo);
}
