package chemtools_logica.LN.IR;

import chemtools_logica.Beans.MedidaBean;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface LN_SFMedidaRemote {
    
    List<MedidaBean> allMedidas();
    
    void insertMedida(MedidaBean bean);
}
