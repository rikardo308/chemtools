package chemtools_logica.BDL.SFBean;

import chemtools_logica.BDL.IL.BDL_SFEmpresaLocal;
import chemtools_logica.BDL.IR.BDL_SFEmpresaRemote;

import chemtools_logica.Entidades.Empresa;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "BDL_SFEmpresa", mappedName = "map-BDL_SFEmpresa")
public class BDL_SFEmpresaBean implements BDL_SFEmpresaRemote, BDL_SFEmpresaLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;

    public BDL_SFEmpresaBean() {
    }

    public Empresa persistEmpresa(Empresa empresa) {
        em.persist(empresa);
        return empresa;
    }

    public Empresa mergeEmpresa(Empresa empresa) {
        return em.merge(empresa);
    }

    public void removeEmpresa(Empresa empresa) {
        empresa = em.find(Empresa.class, empresa.getIdEmpresa());
        em.remove(empresa);
    }

    /** <code>select o from Empresa o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Empresa> getEmpresaFindAll() {
        return em.createNamedQuery("Empresa.findAll", Empresa.class).getResultList();
    }
}
