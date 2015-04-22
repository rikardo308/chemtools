package chemtools_logica.LN.IL;

import chemtools_logica.Beans.MedidaBean;

import java.util.List;

import javax.ejb.Local;

@Local
public interface LN_SFMedidaLocal {
    
    List<MedidaBean> allMedidas();
}
