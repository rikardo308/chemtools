package chemtools_logica.BDL.IR;

import chemtools_logica.Entidades.Empresa;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface BDL_SFEmpresaRemote {
    Empresa persistEmpresa(Empresa empresa);

    Empresa mergeEmpresa(Empresa empresa);

    void removeEmpresa(Empresa empresa);

    List<Empresa> getEmpresaFindAll();
}
