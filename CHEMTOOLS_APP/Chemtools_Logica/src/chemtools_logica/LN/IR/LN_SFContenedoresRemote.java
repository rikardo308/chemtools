package chemtools_logica.LN.IR;

import chemtools_logica.Beans.ContenedoresBean;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface LN_SFContenedoresRemote {
    
    List<ContenedoresBean> getContenedoresActivos();
    
    void insertContenedor(ContenedoresBean bean);
}
