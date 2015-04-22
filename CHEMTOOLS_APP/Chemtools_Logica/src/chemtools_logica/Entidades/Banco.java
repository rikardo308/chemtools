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
@NamedQueries({ @NamedQuery(name = "Banco.findAll", query = "select o from Banco o") })
@Table(name = "\"banco\"")
public class Banco implements Serializable {
    private static final long serialVersionUID = 1525132002369832949L;
    @Column(name = "Nombre")
    private String nombre;
    @Id
    @Column(name = "idBanco", nullable = false)
    private int idBanco;
    @OneToMany(mappedBy = "banco", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Gasto> gastoList2;

    public Banco() {
    }

    public Banco(int idBanco, String nombre) {
        this.idBanco = idBanco;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
    }

    public List<Gasto> getGastoList2() {
        return gastoList2;
    }

    public void setGastoList2(List<Gasto> gastoList2) {
        this.gastoList2 = gastoList2;
    }

    public Gasto addGasto(Gasto gasto) {
        getGastoList2().add(gasto);
        gasto.setBanco(this);
        return gasto;
    }

    public Gasto removeGasto(Gasto gasto) {
        getGastoList2().remove(gasto);
        gasto.setBanco(null);
        return gasto;
    }
}
