/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.domen;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "secretqstn")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secretqstn.findAll", query = "SELECT s FROM Secretqstn s"),
    @NamedQuery(name = "Secretqstn.findById", query = "SELECT s FROM Secretqstn s WHERE s.id = :id"),
    @NamedQuery(name = "Secretqstn.findByOpis", query = "SELECT s FROM Secretqstn s WHERE s.opis = :opis"),
    @NamedQuery(name = "Secretqstn.findByOpisUS", query = "SELECT s FROM Secretqstn s WHERE s.opisUS = :opisUS")})
public class Secretqstn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "opis")
    private String opis;
    @Basic(optional = false)
    @Column(name = "opis_US")
    private String opisUS;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "qstnId")
    //private List<Korisnik> korisnikList;

    public Secretqstn() {
    }

    

    public Secretqstn(Integer id) {
        this.id = id;
    }

    public Secretqstn(Integer id, String opis, String opisUS) {
        this.id = id;
        this.opis = opis;
        this.opisUS = opisUS;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getOpisUS() {
        return opisUS;
    }

    public void setOpisUS(String opisUS) {
        this.opisUS = opisUS;
    }

    /*@XmlTransient
    public List<Korisnik> getKorisnikList() {
        return korisnikList;
    }

    public void setKorisnikList(List<Korisnik> korisnikList) {
        this.korisnikList = korisnikList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secretqstn)) {
            return false;
        }
        Secretqstn other = (Secretqstn) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nn.cvserver.domen.Secretqstn[ id=" + id + " ]";
    }
    
}
