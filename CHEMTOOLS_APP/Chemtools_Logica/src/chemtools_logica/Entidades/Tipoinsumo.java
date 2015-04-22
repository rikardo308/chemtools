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
@NamedQueries({ @NamedQuery(name = "Tipoinsumo.findAll", query = "select o from Tipoinsumo o") })
@Table(name = "\"tipoinsumo\"")
public class Tipoinsumo implements Serializable {
    private static final long serialVersionUID = -2874797076322443208L;
    @Column(name = "Comentario")
    private String comentario;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Estado")
    private int estado;
    @Column(name = "Temperatura_Maxima")
    private String temperatura_Maxima;
    @Column(name = "Temperatura_Minima")
    private String temperatura_Minima;
    @Column(name = "Tiempo_Expiracion")
    private BigDecimal tiempo_Expiracion;
    @Id
    @Column(name = "idTipoInsumo", nullable = false)
    private int idTipoInsumo;
    @OneToMany(mappedBy = "tipoinsumo", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Detalleformula> detalleformulaList1;
    @OneToMany(mappedBy = "tipoinsumo", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Insumo> eventoxinsumoList;
    @ManyToOne
    @JoinColumn(name = "idMedida")
    private Medida medida;
    @ManyToOne
    @JoinColumn(name = "idContenedores")
    private Contenedores contenedores;

    public Tipoinsumo() {
    }

    public Tipoinsumo(String comentario, String descripcion, int estado, Contenedores contenedores, Medida medida,
                      int idTipoInsumo, String temperatura_Maxima, String temperatura_Minima) {
        this.comentario = comentario;
        this.descripcion = descripcion;
        this.estado = estado;
        this.contenedores = contenedores;
        this.medida = medida;
        this.idTipoInsumo = idTipoInsumo;
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


    public int getIdTipoInsumo() {
        return idTipoInsumo;
    }

    public void setIdTipoInsumo(int idTipoInsumo) {
        this.idTipoInsumo = idTipoInsumo;
    }

    public List<Detalleformula> getDetalleformulaList1() {
        return detalleformulaList1;
    }

    public void setDetalleformulaList1(List<Detalleformula> detalleformulaList1) {
        this.detalleformulaList1 = detalleformulaList1;
    }

    public Detalleformula addDetalleformula(Detalleformula detalleformula) {
        getDetalleformulaList1().add(detalleformula);
        detalleformula.setTipoinsumo(this);
        return detalleformula;
    }

    public Detalleformula removeDetalleformula(Detalleformula detalleformula) {
        getDetalleformulaList1().remove(detalleformula);
        detalleformula.setTipoinsumo(null);
        return detalleformula;
    }

    public List<Insumo> getEventoxinsumoList() {
        return eventoxinsumoList;
    }

    public void setEventoxinsumoList(List<Insumo> eventoxinsumoList) {
        this.eventoxinsumoList = eventoxinsumoList;
    }

    public Insumo addInsumo(Insumo insumo) {
        getEventoxinsumoList().add(insumo);
        insumo.setTipoinsumo(this);
        return insumo;
    }

    public Insumo removeInsumo(Insumo insumo) {
        getEventoxinsumoList().remove(insumo);
        insumo.setTipoinsumo(null);
        return insumo;
    }

    public Medida getMedida() {
        return medida;
    }

    public void setMedida(Medida medida) {
        this.medida = medida;
    }

    public Contenedores getContenedores() {
        return contenedores;
    }

    public void setContenedores(Contenedores contenedores) {
        this.contenedores = contenedores;
    }

    public void setTiempo_Expiracion(BigDecimal tiempo_Expiracion) {
        this.tiempo_Expiracion = tiempo_Expiracion;
    }

    public BigDecimal getTiempo_Expiracion() {
        return tiempo_Expiracion;
    }
}
