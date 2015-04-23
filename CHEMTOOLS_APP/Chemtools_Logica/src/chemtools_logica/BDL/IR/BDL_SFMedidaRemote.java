package chemtools_logica.BDL.IR;

import chemtools_logica.Entidades.Medida;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface BDL_SFMedidaRemote {
    Medida persistMedida(Medida medida);

    Medida mergeMedida(Medida medida);

    void removeMedida(Medida medida);

    List<Medida> getMedidaFindAll();
    
    List<Medida> getMedidasActivas();
}
