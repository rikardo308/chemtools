package chemtools_logica.LN.IL;

import chemtools_logica.Beans.EmpresaBean;

import java.util.List;

import javax.ejb.Local;

@Local
public interface LN_SFEmpresaLocal {
    
    List<EmpresaBean> getAllEmpresas();
}
