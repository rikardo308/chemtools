package chemtools_logica.BDL.IL;

import chemtools_logica.Entidades.Eventoxproducto;

import java.util.List;

import javax.ejb.Local;

@Local
public interface BDL_SFEventoxproductoLocal {
    Eventoxproducto persistEventoxproducto(Eventoxproducto eventoxproducto);

    Eventoxproducto mergeEventoxproducto(Eventoxproducto eventoxproducto);

    void removeEventoxproducto(Eventoxproducto eventoxproducto);

    List<Eventoxproducto> getEventoxproductoFindAll();
}
