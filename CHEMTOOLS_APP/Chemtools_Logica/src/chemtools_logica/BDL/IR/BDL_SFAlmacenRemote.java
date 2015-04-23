package chemtools_logica.BDL.IR;

import chemtools_logica.Entidades.Almacen;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface BDL_SFAlmacenRemote {
    Almacen persistAlmacen(Almacen almacen);

    Almacen mergeAlmacen(Almacen almacen);

    void removeAlmacen(Almacen almacen);

    List<Almacen> getAlmacenFindAll();
    
    List<Almacen> allAlmacenesActivos();
    
    List<Almacen>getAlmacenBusqueda(String nombreAlmacen);
}
