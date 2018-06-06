/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.domen;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SOLUNAC
 */
@Entity
@Table(name = "stavka")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stavka.findAll", query = "SELECT s FROM Stavka s"),
    @NamedQuery(name = "Stavka.findById", query = "SELECT s FROM Stavka s WHERE s.id = :id"),
    @NamedQuery(name = "Stavka.findByDatumOd", query = "SELECT s FROM Stavka s WHERE s.datumOd = :datumOd"),
    @NamedQuery(name = "Stavka.findByDatumDo", query = "SELECT s FROM Stavka s WHERE s.datumDo = :datumDo"),
    @NamedQuery(name = "Stavka.findByHeading1", query = "SELECT s FROM Stavka s WHERE s.heading1 = :heading1"),
    @NamedQuery(name = "Stavka.findByHeading2", query = "SELECT s FROM Stavka s WHERE s.heading2 = :heading2"),
    @NamedQuery(name = "Stavka.findByOpis", query = "SELECT s FROM Stavka s WHERE s.opis = :opis")})
public class Stavka implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "datumOd")
    private String datumOd;
    @Column(name = "datumDo")
    private String datumDo;
    @Column(name = "heading1")
    private String heading1;
    @Column(name = "heading2")
    private String heading2;
    @Column(name = "opis")
    private String opis;
    @JoinColumn(name = "segmentId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Segment segmentId;

    public Stavka() {
    }

    public Stavka(Integer id) {
        this.id = id;
    }

    public Stavka(Integer id, String datumOd) {
        this.id = id;
        this.datumOd = datumOd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(String datumOd) {
        this.datumOd = datumOd;
    }

    public String getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(String datumDo) {
        this.datumDo = datumDo;
    }

    public String getHeading1() {
        return heading1;
    }

    public void setHeading1(String heading1) {
        this.heading1 = heading1;
    }

    public String getHeading2() {
        return heading2;
    }

    public void setHeading2(String heading2) {
        this.heading2 = heading2;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Segment getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(Segment segmentId) {
        this.segmentId = segmentId;
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
        if (!(object instanceof Stavka)) {
            return false;
        }
        Stavka other = (Stavka) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nn.cvserver.domen.Stavka[ id=" + id + " ]";
    }
    
}
