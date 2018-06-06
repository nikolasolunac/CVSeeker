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
import org.springframework.jmx.export.annotation.ManagedResource;

/**
 *
 * @author SOLUNAC
 */
@Entity
@Table(name = "korisnik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Korisnik.findAll", query = "SELECT k FROM Korisnik k"),
    @NamedQuery(name = "Korisnik.findById", query = "SELECT k FROM Korisnik k WHERE k.id = :id"),
    @NamedQuery(name = "Korisnik.findByIme", query = "SELECT k FROM Korisnik k WHERE k.ime = :ime"),
    @NamedQuery(name = "Korisnik.findByPrezime", query = "SELECT k FROM Korisnik k WHERE k.prezime = :prezime"),
    @NamedQuery(name = "Korisnik.findByUsername", query = "SELECT k FROM Korisnik k WHERE k.username = :username"),
    @NamedQuery(name = "Korisnik.findByPassword", query = "SELECT k FROM Korisnik k WHERE k.password = :password"),
    @NamedQuery(name = "Korisnik.findByLock", query = "SELECT k FROM Korisnik k WHERE k.lock = :lock"),
    @NamedQuery(name = "Korisnik.findByQstnAns", query = "SELECT k FROM Korisnik k WHERE k.qstnAns = :qstnAns")})
public class Korisnik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ime")
    private String ime;
    @Basic(optional = false)
    @Column(name = "prezime")
    private String prezime;
    @Basic(optional = false)
    @Column(name = "`username`")
    private String username;
    @Basic(optional = false)
    @Column(name = "`password`")
    private String password;
    @Column(name = "`lock`")
    private Boolean lock;
    @Basic(optional = false)
    @Column(name = "qstnAns")
    private String qstnAns;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "korisnikId")
    @JsonBackReference
    private List<Profil> profilList;
    @JoinColumn(name = "qstnId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Secretqstn qstnId;
    @JoinColumn(name = "rolaId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Rola rolaId;

    public Korisnik() {
    }

    public Korisnik(Integer id) {
        this.id = id;
    }

    public Korisnik(Integer id, String ime, String prezime, String username, String password, String qstnAns) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.qstnAns = qstnAns;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLock() {
        return lock;
    }

    public void setLock(Boolean lock) {
        this.lock = lock;
    }

    public String getQstnAns() {
        return qstnAns;
    }

    public void setQstnAns(String qstnAns) {
        this.qstnAns = qstnAns;
    }

    @XmlTransient
    public List<Profil> getProfilList() {
        return profilList;
    }

    public void setProfilList(List<Profil> profilList) {
        this.profilList = profilList;
    }

    public Secretqstn getQstnId() {
        return qstnId;
    }

    public void setQstnId(Secretqstn qstnId) {
        this.qstnId = qstnId;
    }

    public Rola getRolaId() {
        return rolaId;
    }

    public void setRolaId(Rola rolaId) {
        this.rolaId = rolaId;
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
        if (!(object instanceof Korisnik)) {
            return false;
        }
        Korisnik other = (Korisnik) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nn.cvserver.domen.Korisnik[ id=" + id + " ]";
    }
    
}
