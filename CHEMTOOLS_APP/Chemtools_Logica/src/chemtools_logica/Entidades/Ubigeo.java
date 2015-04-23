package chemtools_logica.Entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Ubigeo.findAll", query = "select o from Ubigeo o") })
@Table(name = "\"ubigeo\"")
public class Ubigeo implements Serializable {
    private static final long serialVersionUID = 7740722279159192193L;
    @Column(name = "Desc_Ubigeo")
    private String desc_Ubigeo;
    @Id
    @Column(name = "idUbigeo", nullable = false)
    private int idUbigeo;

    public Ubigeo() {
    }

    public Ubigeo(String desc_Ubigeo, int idUbigeo) {
        this.desc_Ubigeo = desc_Ubigeo;
        this.idUbigeo = idUbigeo;
    }

    public String getDesc_Ubigeo() {
        return desc_Ubigeo;
    }

    public void setDesc_Ubigeo(String desc_Ubigeo) {
        this.desc_Ubigeo = desc_Ubigeo;
    }

    public int getIdUbigeo() {
        return idUbigeo;
    }

    public void setIdUbigeo(int idUbigeo) {
        this.idUbigeo = idUbigeo;
    }
}
