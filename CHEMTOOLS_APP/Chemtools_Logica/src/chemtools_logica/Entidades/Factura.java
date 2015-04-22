package chemtools_logica.Entidades;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "Factura.findAll", query = "select o from Factura o") })
@Table(name = "\"factura\"")
public class Factura implements Serializable {
    private static final long serialVersionUID = -1077761020304602856L;
    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha_Emision")
    private Date fecha_Emision;
    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha_Pago")
    private Date fecha_Pago;
    @Column(name = "SubTotal")
    private BigDecimal subTotal;
    @Column(name = "Tipo_Factura")
    private int tipo_Factura;
    @Column(name = "Total")
    private BigDecimal total;
    @Column(name = "Detraccion")
    private BigDecimal detraccion;
    @Column(name = "Total_Detraccion")
    private BigDecimal total_Detraccion;
    @Column(name = "Comentario")
    private String comentario;
    @Id
    @Column(name = "idFactura", nullable = false)
    private int idFactura;

    public Factura() {
    }

    public Factura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public void setFecha_Emision(Date fecha_Emision) {
        this.fecha_Emision = fecha_Emision;
    }

    public Date getFecha_Emision() {
        return fecha_Emision;
    }

    public void setFecha_Pago(Date fecha_Pago) {
        this.fecha_Pago = fecha_Pago;
    }

    public Date getFecha_Pago() {
        return fecha_Pago;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setTipo_Factura(int tipo_Factura) {
        this.tipo_Factura = tipo_Factura;
    }

    public int getTipo_Factura() {
        return tipo_Factura;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setDetraccion(BigDecimal detraccion) {
        this.detraccion = detraccion;
    }

    public BigDecimal getDetraccion() {
        return detraccion;
    }

    public void setTotal_Detraccion(BigDecimal total_Detraccion) {
        this.total_Detraccion = total_Detraccion;
    }

    public BigDecimal getTotal_Detraccion() {
        return total_Detraccion;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getComentario() {
        return comentario;
    }
}
