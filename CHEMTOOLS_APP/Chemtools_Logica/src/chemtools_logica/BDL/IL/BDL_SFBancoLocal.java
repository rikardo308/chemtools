package chemtools_logica.BDL.IL;

import chemtools_logica.Entidades.Banco;

import java.util.List;

import javax.ejb.Local;

@Local
public interface BDL_SFBancoLocal {
    Banco persistBanco(Banco banco);

    Banco mergeBanco(Banco banco);

    void removeBanco(Banco banco);

    List<Banco> getBancoFindAll();
}
