package chemtools_logica.Beans;

import chemtools_logica.Entidades.Almacen;
import chemtools_logica.Entidades.Evento;
import chemtools_logica.Entidades.Producto;
import chemtools_logica.Entidades.Usuario;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class EventoxproductoBean implements Serializable {
    private Date fecha_Evento;
    private EventoBean evento;
    private ProductoBean producto;
    private AlmacenBean almacen;
    private UsuarioBean usuario;
}
