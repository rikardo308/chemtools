package chemtools_logica.BDL.IR;

import chemtools_logica.Entidades.Detalleformula;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface BDL_SFDetalleformulaRemote {
    Detalleformula persistDetalleformula(Detalleformula detalleformula);

    Detalleformula mergeDetalleformula(Detalleformula detalleformula);

    void removeDetalleformula(Detalleformula detalleformula);

    List<Detalleformula> getDetalleformulaFindAll();
}
