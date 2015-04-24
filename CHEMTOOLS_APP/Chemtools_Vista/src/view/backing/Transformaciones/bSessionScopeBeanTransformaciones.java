package view.backing.Transformaciones;

import chemtools_logica.Beans.EmpresaBean;
import chemtools_logica.Beans.OrdenproduccionBean;

import chemtools_logica.Entidades.Ordenproduccion;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;


public class bSessionScopeBeanTransformaciones implements Serializable{
    @SuppressWarnings("compatibility:5847678352572892581")
    private static final long serialVersionUID = 1L;
    private TransformacionesFiltro filtro = new TransformacionesFiltro();
    private List<OrdenproduccionBean> ordenesMostradas = new ArrayList<OrdenproduccionBean>();

    public void setOrdenesMostradas(List<OrdenproduccionBean> ordenesMostradas) {
        this.ordenesMostradas = ordenesMostradas;
    }

    public List<OrdenproduccionBean> getOrdenesMostradas() {
        return ordenesMostradas;
    }


    public void setFiltro(TransformacionesFiltro filtro) {
        this.filtro = filtro;
    }

    public TransformacionesFiltro getFiltro() {
        return filtro;
    }
}
