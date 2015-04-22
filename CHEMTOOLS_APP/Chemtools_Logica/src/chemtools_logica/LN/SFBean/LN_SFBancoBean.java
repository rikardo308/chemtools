package chemtools_logica.LN.SFBean;

import chemtools_logica.LN.IL.LN_SFBancoLocal;
import chemtools_logica.LN.IR.LN_SFBancoRemote;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "LN_SFBanco", mappedName = "map-LN_SFBanco")
public class LN_SFBancoBean implements LN_SFBancoRemote, LN_SFBancoLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;

    public LN_SFBancoBean() {
    }
}
