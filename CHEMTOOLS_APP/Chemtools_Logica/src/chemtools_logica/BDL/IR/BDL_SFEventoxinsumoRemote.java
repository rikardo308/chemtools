package chemtools_logica.BDL.IR;

import chemtools_logica.Entidades.Eventoxinsumo;

import chemtools_logica.Entidades.Insumo;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface BDL_SFEventoxinsumoRemote {
    Eventoxinsumo persistEventoxinsumo(Eventoxinsumo eventoxinsumo);

    Eventoxinsumo mergeEventoxinsumo(Eventoxinsumo eventoxinsumo);

    void removeEventoxinsumo(Eventoxinsumo eventoxinsumo);

    List<Eventoxinsumo> getEventoxinsumoFindAll();
    
    List<Eventoxinsumo> getInsumosporAlmacenActivo(int nidAlmacen);
    
    List<Eventoxinsumo> getInsumosGenerales();
}
