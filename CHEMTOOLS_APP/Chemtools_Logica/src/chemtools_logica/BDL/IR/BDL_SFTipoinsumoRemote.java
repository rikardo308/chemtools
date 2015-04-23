package chemtools_logica.BDL.IR;

import chemtools_logica.Entidades.Tipoinsumo;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface BDL_SFTipoinsumoRemote {
    Tipoinsumo persistTipoinsumo(Tipoinsumo tipoinsumo);

    Tipoinsumo mergeTipoinsumo(Tipoinsumo tipoinsumo);

    void removeTipoinsumo(Tipoinsumo tipoinsumo);

    List<Tipoinsumo> getTipoinsumoFindAll();
    
    List<Tipoinsumo> getTipoinsumosActivos();
}
