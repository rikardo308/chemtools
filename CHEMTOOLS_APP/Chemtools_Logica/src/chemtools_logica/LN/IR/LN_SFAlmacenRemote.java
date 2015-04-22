package chemtools_logica.LN.IR;

import chemtools_logica.Beans.AlmacenBean;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface LN_SFAlmacenRemote {
    
    List<AlmacenBean> getAllAlmacenes();
    
    List<AlmacenBean> getAllAlmacenesBusqeuda(String nombre);
}
