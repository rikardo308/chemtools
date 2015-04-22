package chemtools_logica.LN.IL;

import chemtools_logica.Beans.ContenedoresBean;

import java.util.List;

import javax.ejb.Local;

@Local
public interface LN_SFContenedoresLocal {
    
    List<ContenedoresBean> getContenedoresActivos();
}
