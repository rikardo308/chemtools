package chemtools_logica.LN.IR;

import chemtools_logica.Beans.EmpresaBean;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface LN_SFEmpresaRemote {
    
    List<EmpresaBean> getAllEmpresas();
}
