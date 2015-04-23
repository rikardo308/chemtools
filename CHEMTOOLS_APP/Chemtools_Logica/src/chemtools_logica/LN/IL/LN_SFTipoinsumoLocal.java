package chemtools_logica.LN.IL;

import chemtools_logica.Beans.TipoinsumoBean;

import java.util.List;

import javax.ejb.Local;

@Local
public interface LN_SFTipoinsumoLocal {
    
    List<TipoinsumoBean> getAlltipoInsumos();
    
    void inserttInsumo(TipoinsumoBean bean);
}
