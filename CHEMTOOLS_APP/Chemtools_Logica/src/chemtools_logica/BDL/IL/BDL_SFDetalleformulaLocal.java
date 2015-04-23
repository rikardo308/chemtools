package chemtools_logica.BDL.IL;

import chemtools_logica.Entidades.Detalleformula;

import java.util.List;

import javax.ejb.Local;

@Local
public interface BDL_SFDetalleformulaLocal {
    Detalleformula persistDetalleformula(Detalleformula detalleformula);

    Detalleformula mergeDetalleformula(Detalleformula detalleformula);

    void removeDetalleformula(Detalleformula detalleformula);

    List<Detalleformula> getDetalleformulaFindAll();
}
