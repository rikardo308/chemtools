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
@NamedQueries({ @NamedQuery(name = "Medida.findAll", query = "select o from Medida o") })
@Table(name = "\"medida\"")
public class Medida implements Serializable {
    private static final long serialVersionUID = 7600171403694432834L;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Estado")
    private int estado;
    @Id
    @Column(name = "idMedida", nullable = false)
    private int idMedida;
    @OneToMany(mappedBy = "medida", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Tipoinsumo> tipoinsumoList;
    @OneToMany(mappedBy = "medida", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Tipoproducto> tipoproductoList;

    public Medida() {
    }

    public Medida(String descripcion, int estado, int idMedida) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.idMedida = idMedida;
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

    public int getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(int idMedida) {
        this.idMedida = idMedida;
    }

    public List<Tipoinsumo> getTipoinsumoList() {
        return tipoinsumoList;
    }

    public void setTipoinsumoList(List<Tipoinsumo> tipoinsumoList) {
        this.tipoinsumoList = tipoinsumoList;
    }

    public Tipoinsumo addTipoinsumo(Tipoinsumo tipoinsumo) {
        getTipoinsumoList().add(tipoinsumo);
        tipoinsumo.setMedida(this);
        return tipoinsumo;
    }

    public Tipoinsumo removeTipoinsumo(Tipoinsumo tipoinsumo) {
        getTipoinsumoList().remove(tipoinsumo);
        tipoinsumo.setMedida(null);
        return tipoinsumo;
    }

    public List<Tipoproducto> getTipoproductoList() {
        return tipoproductoList;
    }

    public void setTipoproductoList(List<Tipoproducto> tipoproductoList) {
        this.tipoproductoList = tipoproductoList;
    }

    public Tipoproducto addTipoproducto(Tipoproducto tipoproducto) {
        getTipoproductoList().add(tipoproducto);
        tipoproducto.setMedida(this);
        return tipoproducto;
    }

    public Tipoproducto removeTipoproducto(Tipoproducto tipoproducto) {
        getTipoproductoList().remove(tipoproducto);
        tipoproducto.setMedida(null);
        return tipoproducto;
    }
}
