package view.backing.Utils;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class MyPhaseListener implements PhaseListener{
    @SuppressWarnings("compatibility:3398716965814542983")
    private static final long serialVersionUID = 1L;

    @Override
    public void afterPhase(PhaseEvent phaseEvent) {
        System.out.println("HOLA1");
        
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
