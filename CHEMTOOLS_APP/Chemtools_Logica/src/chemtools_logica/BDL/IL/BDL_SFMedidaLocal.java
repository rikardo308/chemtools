package chemtools_logica.BDL.IL;

import chemtools_logica.Entidades.Medida;

import java.util.List;

import javax.ejb.Local;

@Local
public interface BDL_SFMedidaLocal {
    Medida persistMedida(Medida medida);

    Medida mergeMedida(Medida medida);

    void removeMedida(Medida medida);

    List<Medida> getMedidaFindAll();
    
    List<Medida> getMedidasActivas();
}
