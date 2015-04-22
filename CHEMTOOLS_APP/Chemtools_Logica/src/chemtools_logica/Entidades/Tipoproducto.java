package chemtools_logica.Entidades;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Tipoproducto.findAll", query = "select o from Tipoproducto o") })
@Table(name = "\"tipoproducto\"")
public class Tipoproducto implements Serializable {
    private static final long serialVersionUID = -4563676620250365145L;
    @Column(name = "Comentario")
    private String comentario;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Estado")
    private int estado;
    @Column(name = "Tiempo_Expiracion")
    private BigDecimal tiempo_Expiracion;
    @Column(name = "Temperatura_Maxima")
    private String temperatura_Maxima;
    @Column(name = "Temperatura_Minima")
    private String temperatura_Minima;
    @Id
    @Column(name = "idTipoProducto", nullable = false)
    private int idTipoProducto;
    @OneToMany(mappedBy = "tipoproducto", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Detalleformula> detalleformulaList;
    @OneToMany(mappedBy = "tipoproducto", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Producto> eventoxproductoList;
    @ManyToOne
    @JoinColumn(name = "idMedida")
    private Medida medida;
    @ManyToOne
    @JoinColumn(name = "idContenedores")
    private Contenedores contenedores;

    public Tipoproducto() {
    }

    public Tipoproducto(String comentario, String descripcion, int estado, Contenedores contenedores, Medida medida,
                        int idTipoProducto, String temperatura_Maxima, String temperatura_Minima) {
        this.comentario = comentario;
        this.descripcion = descripcion;
        this.estado = estado;
        this.contenedores = contenedores;
        this.medida = medida;
        this.idTipoProducto = idTipoProducto;
        this.temperatura_Maxima = temperatura_Maxima;
        this.temperatura_Minima = temperatura_Minima;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getTemperatura_Maxima() {
        return temperatura_Maxima;
    }

    public void setTemperatura_Maxima(String temperatura_Maxima) {
        this.temperatura_Maxima = temperatura_Maxima;
    }

    public String getTemperatura_Minima() {
        return temperatura_Minima;
    }

    public void setTemperatura_Minima(String temperatura_Minima) {
        this.temperatura_Minima = temperatura_Minima;
    }


    public int getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public List<Detalleformula> getDetalleformulaList() {
        return detalleformulaList;
    }

    public void setDetalleformulaList(List<Detalleformula> detalleformulaList) {
        this.detalleformulaList = detalleformulaList;
    }

    public Detalleformula addDetalleformula(Detalleformula detalleformula) {
        getDetalleformulaList().add(detalleformula);
        detalleformula.setTipoproducto(this);
        return detalleformula;
    }

    public Detalleformula removeDetalleformula(Detalleformula detalleformula) {
        getDetalleformulaList().remove(detalleformula);
        detalleformula.setTipoproducto(null);
        return detalleformula;
    }

    public List<Producto> getEventoxproductoList() {
        return eventoxproductoList;
    }

    public void setEventoxproductoList(List<Producto> eventoxproductoList) {
        this.eventoxproductoList = eventoxproductoList;
    }

    public Producto addProducto(Producto producto) {
        getEventoxproductoList().add(producto);
        producto.setTipoproducto(this);
        return producto;
    }

    public Producto removeProducto(Producto producto) {
        getEventoxproductoList().remove(producto);
        producto.setTipoproducto(null);
        return producto;
    }


    public void setMedida(Medida medida) {
        this.medida = medida;
    }

    public Medida getMedida() {
        return medida;
    }

    public void setContenedores(Contenedores contenedores) {
        this.contenedores = contenedores;
    }

    public Contenedores getContenedores() {
        return contenedores;
    }

    public void setTiempo_Expiracion(BigDecimal tiempo_Expiracion) {
        this.tiempo_Expiracion = tiempo_Expiracion;
    }

    public BigDecimal getTiempo_Expiracion() {
        return tiempo_Expiracion;
    }
}
