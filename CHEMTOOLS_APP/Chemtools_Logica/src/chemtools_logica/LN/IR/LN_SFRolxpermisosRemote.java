package chemtools_logica.LN.IR;

import chemtools_logica.Beans.RolxpermisosBean;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface LN_SFRolxpermisosRemote {
    
    List<RolxpermisosBean>allRolxpermisos();
}
