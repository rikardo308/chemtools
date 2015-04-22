package chemtools_logica.LN.IR;

import chemtools_logica.Beans.TipoinsumoBean;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface LN_SFTipoinsumoRemote {
    
    List<TipoinsumoBean> getAlltipoInsumos();
}
