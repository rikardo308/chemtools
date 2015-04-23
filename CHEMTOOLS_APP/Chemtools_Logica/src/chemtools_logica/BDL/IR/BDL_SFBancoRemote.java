package chemtools_logica.BDL.IR;

import chemtools_logica.Entidades.Banco;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface BDL_SFBancoRemote {
    Banco persistBanco(Banco banco);

    Banco mergeBanco(Banco banco);

    void removeBanco(Banco banco);

    List<Banco> getBancoFindAll();
}
