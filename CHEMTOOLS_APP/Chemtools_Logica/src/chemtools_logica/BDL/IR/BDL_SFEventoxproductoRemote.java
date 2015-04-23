package chemtools_logica.BDL.IR;

import chemtools_logica.Entidades.Eventoxproducto;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface BDL_SFEventoxproductoRemote {
    Eventoxproducto persistEventoxproducto(Eventoxproducto eventoxproducto);

    Eventoxproducto mergeEventoxproducto(Eventoxproducto eventoxproducto);

    void removeEventoxproducto(Eventoxproducto eventoxproducto);

    List<Eventoxproducto> getEventoxproductoFindAll();
}
