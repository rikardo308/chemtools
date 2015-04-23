package chemtools_logica.LN.IL;

import chemtools_logica.Beans.AlmacenBean;

import java.util.List;

import javax.ejb.Local;

@Local
public interface LN_SFAlmacenLocal {
    
    List<AlmacenBean> getAllAlmacenes();
    
    List<AlmacenBean> getAllAlmacenesBusqeuda(String nombre);
}
