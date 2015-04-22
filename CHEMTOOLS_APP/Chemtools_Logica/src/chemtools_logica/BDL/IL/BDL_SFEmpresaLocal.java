package chemtools_logica.BDL.IL;

import chemtools_logica.Entidades.Empresa;

import java.util.List;

import javax.ejb.Local;

@Local
public interface BDL_SFEmpresaLocal {
    Empresa persistEmpresa(Empresa empresa);

    Empresa mergeEmpresa(Empresa empresa);

    void removeEmpresa(Empresa empresa);

    List<Empresa> getEmpresaFindAll();
}
