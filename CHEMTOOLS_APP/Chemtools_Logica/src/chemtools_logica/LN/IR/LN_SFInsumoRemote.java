package chemtools_logica.LN.IR;

import chemtools_logica.Beans.EventoxinsumoBean;
import chemtools_logica.Beans.InsumoBean;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface LN_SFInsumoRemote {
    
    List<InsumoBean> getInsumosbyAlmacen(int nidAlmacen);
    
    List<InsumoBean> getAllinsumos();
    
    List<InsumoBean> getBusquedaInsumos(InsumoBean bean);
    
    String updateInsumo(InsumoBean insumo);
    
    void insertarInsumo(EventoxinsumoBean eventoxinsumo);
    
    void cambioInsumoAlmacen(EventoxinsumoBean eventoxinsumo);
    
    void cambioInsumoAlmacen(List<EventoxinsumoBean>listaBean);
    
    boolean verificarCodigoDupl(String codigo);
}
