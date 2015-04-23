package chemtools_logica.LN.SFBean;

import chemtools_logica.BDL.IR.BDL_SFEmpresaRemote;
import chemtools_logica.BDL.IR.BDL_SFRolxpermisosRemote;

import chemtools_logica.Beans.EmpresaBean;

import chemtools_logica.Entidades.Empresa;

import chemtools_logica.LN.IL.LN_SFEmpresaLocal;
import chemtools_logica.LN.IR.LN_SFEmpresaRemote;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "LN_SFEmpresa", mappedName = "map-LN_SFEmpresa")
public class LN_SFEmpresaBean implements LN_SFEmpresaRemote, LN_SFEmpresaLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;
    
    @EJB
    BDL_SFEmpresaRemote bDL_SFEmpresaRemote;
    
    
    public List<EmpresaBean> getAllEmpresas(){
        List<Empresa> empresas = bDL_SFEmpresaRemote.getEmpresaFindAll();
        List<EmpresaBean> beanEmpresas = new ArrayList<EmpresaBean>();
        
        for(Empresa entidad : empresas){
            EmpresaBean bean = new EmpresaBean();
            bean.setIdEmpresa(entidad.getIdEmpresa());
            bean.setRazonSocial(entidad.getRazonSocial());
            bean.setRuc(entidad.getRuc());
            
            beanEmpresas.add(bean);
        }
        
        return beanEmpresas;
        
    }
}
