/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.domen;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SOLUNAC
 */
@Entity
@Table(name = "segment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Segment.findAll", query = "SELECT s FROM Segment s"),
    @NamedQuery(name = "Segment.findById", query = "SELECT s FROM Segment s WHERE s.id = :id"),
    @NamedQuery(name = "Segment.findByHeading", query = "SELECT s FROM Segment s WHERE s.heading = :heading"),
    @NamedQuery(name = "Segment.findByOpis", query = "SELECT s FROM Segment s WHERE s.opis = :opis")})
public class Segment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "heading")
    private String heading;
    @Column(name = "opis")
    private String opis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segmentId")
    @JsonManagedReference
    private List<Stavka> stavkaList;
    @JoinColumn(name = "profilId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Profil profilId;

    public Segment() {
    }

    public Segment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @XmlTransient
    public List<Stavka> getStavkaList() {
        return stavkaList;
    }

    public void setStavkaList(List<Stavka> stavkaList) {
        this.stavkaList = stavkaList;
    }

    public Profil getProfilId() {
        return profilId;
    }

    public void setProfilId(Profil profilId) {
        this.profilId = profilId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Segment)) {
            return false;
        }
        Segment other = (Segment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nn.cvserver.domen.Segment[ id=" + id + " ]";
    }
    
}
