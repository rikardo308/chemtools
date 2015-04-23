package chemtools_logica.LN.IL;

import chemtools_logica.Beans.RolxpermisosBean;

import java.util.List;

import javax.ejb.Local;

@Local
public interface LN_SFRolxpermisosLocal {
    
    List<RolxpermisosBean>allRolxpermisos();
}
