package chemtools_logica.BDL.IL;

import chemtools_logica.Entidades.Almacen;

import java.util.List;

import javax.ejb.Local;

@Local
public interface BDL_SFAlmacenLocal {
    Almacen persistAlmacen(Almacen almacen);

    Almacen mergeAlmacen(Almacen almacen);

    void removeAlmacen(Almacen almacen);

    List<Almacen> getAlmacenFindAll();
    
    List<Almacen> allAlmacenesActivos();
    
    List<Almacen>getAlmacenBusqueda(String nombreAlmacen);
}
