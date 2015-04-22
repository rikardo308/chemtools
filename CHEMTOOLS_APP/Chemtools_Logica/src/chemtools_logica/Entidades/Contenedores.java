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
@NamedQueries({ @NamedQuery(name = "Contenedores.findAll", query = "select o from Contenedores o") })
@Table(name = "\"contenedores\"")
public class Contenedores implements Serializable {
    private static final long serialVersionUID = 2886416436329275345L;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Estado")
    private int estado;
    @Id
    @Column(name = "idContenedores", nullable = false)
    private int idContenedores;
    @OneToMany(mappedBy = "contenedores", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Tipoinsumo> tipoinsumoList1;
    @OneToMany(mappedBy = "contenedores", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Tipoproducto> tipoproductoList1;

    public Contenedores() {
    }

    public Contenedores(String descripcion, int estado, int idContenedores) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.idContenedores = idContenedores;
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

    public int getIdContenedores() {
        return idContenedores;
    }

    public void setIdContenedores(int idContenedores) {
        this.idContenedores = idContenedores;
    }

    public List<Tipoinsumo> getTipoinsumoList1() {
        return tipoinsumoList1;
    }

    public void setTipoinsumoList1(List<Tipoinsumo> tipoinsumoList1) {
        this.tipoinsumoList1 = tipoinsumoList1;
    }

    public Tipoinsumo addTipoinsumo(Tipoinsumo tipoinsumo) {
        getTipoinsumoList1().add(tipoinsumo);
        tipoinsumo.setContenedores(this);
        return tipoinsumo;
    }

    public Tipoinsumo removeTipoinsumo(Tipoinsumo tipoinsumo) {
        getTipoinsumoList1().remove(tipoinsumo);
        tipoinsumo.setContenedores(null);
        return tipoinsumo;
    }

    public List<Tipoproducto> getTipoproductoList1() {
        return tipoproductoList1;
    }

    public void setTipoproductoList1(List<Tipoproducto> tipoproductoList1) {
        this.tipoproductoList1 = tipoproductoList1;
    }

    public Tipoproducto addTipoproducto(Tipoproducto tipoproducto) {
        getTipoproductoList1().add(tipoproducto);
        tipoproducto.setContenedores(this);
        return tipoproducto;
    }

    public Tipoproducto removeTipoproducto(Tipoproducto tipoproducto) {
        getTipoproductoList1().remove(tipoproducto);
        tipoproducto.setContenedores(null);
        return tipoproducto;
    }
}
