package view.backing.Utils.Validator;

import chemtools_logica.BDL.IR.BDL_SFIsumoRemote;

import chemtools_logica.BDL.SFBean.BDL_SFIsumoBean;

import chemtools_logica.LN.IR.LN_SFAlmacenRemote;
import chemtools_logica.LN.IR.LN_SFInsumoRemote;

import java.util.Hashtable;

import javax.annotation.Resource;

import javax.ejb.EJB;

import javax.ejb.SessionContext;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import javax.naming.Context;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class InsumoValidator implements Validator {
    
    private LN_SFInsumoRemote lN_SFInsumoRemote;
    
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object object) {
        
        String codigo = object.toString();
        
        try {
            final Context context = getInitialContext();
            lN_SFInsumoRemote = (LN_SFInsumoRemote) context.lookup("map-LN_SFInsumo#chemtools_logica.LN.IR.LN_SFInsumoRemote"); 
        }catch(Exception e){}
        
        boolean exi = lN_SFInsumoRemote.verificarCodigoDupl(codigo);
        
        if (!exi) {
            FacesMessage fm = new FacesMessage("El codigo de Insumo ya exite");
            throw new ValidatorException(fm);
        }
        
    }
    
    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x/12.x connection details
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, "t3://127.0.0.1:7101");
        return new InitialContext(env);
    }
}