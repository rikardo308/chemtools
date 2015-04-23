package chemtools_logica.Entidades;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Tipogasto.findAll", query = "select o from Tipogasto o") })
@Table(name = "\"tipogasto\"")
public class Tipogasto implements Serializable {
    private static final long serialVersionUID = -6444279902988256712L;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Estado")
    private int estado;
    @Id
    @Column(name = "idTipoGasto", nullable = false)
    private int idTipoGasto;
    @OneToMany(mappedBy = "tipogasto", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Gasto> gastoList;

    public Tipogasto() {
    }

    public Tipogasto(String descripcion, int estado, int idTipoGasto) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.idTipoGasto = idTipoGasto;
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

    public int getIdTipoGasto() {
        return idTipoGasto;
    }

    public void setIdTipoGasto(int idTipoGasto) {
        this.idTipoGasto = idTipoGasto;
    }

    public List<Gasto> getGastoList() {
        return gastoList;
    }

    public void setGastoList(List<Gasto> gastoList) {
        this.gastoList = gastoList;
    }

    public Gasto addGasto(Gasto gasto) {
        getGastoList().add(gasto);
        gasto.setTipogasto(this);
        return gasto;
    }

    public Gasto removeGasto(Gasto gasto) {
        getGastoList().remove(gasto);
        gasto.setTipogasto(null);
        return gasto;
    }
}
