package chemtools_logica.BDL.IL;

import chemtools_logica.Entidades.Eventoxinsumo;

import chemtools_logica.Entidades.Insumo;

import java.util.List;

import javax.ejb.Local;

@Local
public interface BDL_SFEventoxinsumoLocal {
    Eventoxinsumo persistEventoxinsumo(Eventoxinsumo eventoxinsumo);

    Eventoxinsumo mergeEventoxinsumo(Eventoxinsumo eventoxinsumo);

    void removeEventoxinsumo(Eventoxinsumo eventoxinsumo);

    List<Eventoxinsumo> getEventoxinsumoFindAll();
    
    List<Eventoxinsumo> getInsumosporAlmacenActivo(int nidAlmacen);
}
