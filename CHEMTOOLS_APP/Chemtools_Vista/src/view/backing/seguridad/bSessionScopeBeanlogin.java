package view.backing.seguridad;

import chemtools_logica.Beans.PermisosBean;


import java.util.ArrayList;
import java.util.List;

import oracle.adf.view.rich.component.rich.input.RichInputText;

public class bSessionScopeBeanlogin{

    //LOGIN
    private String usuario;
    private String contrasena;
    private RichInputText contraInput;
    
    //MENU
    List<PermisosBean> permisosMenu = new ArrayList<PermisosBean>();

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }


    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContraInput(RichInputText contraInput) {
        this.contraInput = contraInput;
    }

    public RichInputText getContraInput() {
        return contraInput;
    }

    public void setPermisosMenu(List<PermisosBean> permisosMenu) {
        this.permisosMenu = permisosMenu;
    }

    public List<PermisosBean> getPermisosMenu() {
        return permisosMenu;
    }
}
