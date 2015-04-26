package chemtools_logica.LN.IL;

import chemtools_logica.Beans.EventoxinsumoBean;
import chemtools_logica.Beans.InsumoBean;

import java.util.List;

import javax.ejb.Local;

@Local
public interface LN_SFInsumoLocal {
    
    List<InsumoBean> getInsumosbyAlmacen(int nidAlmacen);
    
    List<InsumoBean> getAllinsumos();
    
    List<InsumoBean> getBusquedaInsumos(InsumoBean bean);
    
    String updateInsumo(InsumoBean insumo);
    
    void insertarInsumo(EventoxinsumoBean eventoxinsumo);
    
    void cambioInsumoAlmacen(EventoxinsumoBean eventoxinsumo);
    
    void cambioInsumoAlmacen(List<EventoxinsumoBean>listaBean);
    
    boolean verificarCodigoDupl(String codigo);
}
