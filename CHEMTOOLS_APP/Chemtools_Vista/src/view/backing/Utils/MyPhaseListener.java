package view.backing.Utils;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import javax.servlet.http.HttpSession;

public class MyPhaseListener implements PhaseListener{
    @SuppressWarnings("compatibility:3398716965814542983")
    private static final long serialVersionUID = 1L;

    @Override
    public void afterPhase(PhaseEvent phaseEvent) {
        /* FacesContext facesContext = phaseEvent.getFacesContext();
                String currentPage = facesContext.getViewRoot().getViewId();
                boolean isLoginPage = (currentPage.lastIndexOf("frm_login.jsf") > -1) ? true : false;
                
                HttpSession sesion = (HttpSession) facesContext.getExternalContext().getSession(true);
                Object usuario = sesion.getAttribute("usuario");
                
                if(!isLoginPage && usuario == null){
                    
                    Utils.redireccionar("frm_login.jsf");
                    
                }else if(usuario!=null){
                  if(isLoginPage){
                    Utils.redireccionar("frm_inicio.jsf");
                }
            }  */
    }

    @Override
    public void beforePhase(PhaseEvent phaseEvent) {
        System.out.println("");
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }
}
