package chemtools_logica.BDL.IL;

import chemtools_logica.Entidades.Tipoinsumo;

import java.util.List;

import javax.ejb.Local;

@Local
public interface BDL_SFTipoinsumoLocal {
    Tipoinsumo persistTipoinsumo(Tipoinsumo tipoinsumo);

    Tipoinsumo mergeTipoinsumo(Tipoinsumo tipoinsumo);

    void removeTipoinsumo(Tipoinsumo tipoinsumo);

    List<Tipoinsumo> getTipoinsumoFindAll();
    
    List<Tipoinsumo> getTipoinsumosActivos();
}
