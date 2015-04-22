package chemtools_logica.Entidades;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "Gasto.findAll", query = "select o from Gasto o") })
@Table(name = "\"gasto\"")
public class Gasto implements Serializable {
    private static final long serialVersionUID = 5415834935415439140L;
    @Column(name = "Comentario")
    private String comentario;
    @Column(name = "Estado")
    private int estado;
    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha")
    private Date fecha;
    @Column(name = "Imagen")
    private byte[] imagen;
    @Column(name = "Monto")
    private int monto;
    @Id
    @Column(name = "idGastos", nullable = false)
    private int idGastos;
    @ManyToOne
    @JoinColumn(name = "idTipoGasto")
    private Tipogasto tipogasto;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "idBanco")
    private Banco banco;

    public Gasto() {
    }

    public Gasto(String comentario, int estado, Date fecha, Banco banco, int idGastos, Tipogasto tipogasto,
                 Usuario usuario, int monto) {
        this.comentario = comentario;
        this.estado = estado;
        this.fecha = fecha;
        this.banco = banco;
        this.idGastos = idGastos;
        this.tipogasto = tipogasto;
        this.usuario = usuario;
        this.monto = monto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }


    public int getIdGastos() {
        return idGastos;
    }

    public void setIdGastos(int idGastos) {
        this.idGastos = idGastos;
    }


    public Tipogasto getTipogasto() {
        return tipogasto;
    }

    public void setTipogasto(Tipogasto tipogasto) {
        this.tipogasto = tipogasto;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
}
