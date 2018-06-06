/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.domen;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SOLUNAC
 */
@Entity
@Table(name = "notifikacija")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notifikacija.findAll", query = "SELECT n FROM Notifikacija n"),
    @NamedQuery(name = "Notifikacija.findById", query = "SELECT n FROM Notifikacija n WHERE n.id = :id"),
    @NamedQuery(name = "Notifikacija.findByProfil", query = "SELECT n FROM Notifikacija n WHERE n.profil = :profil"),
    @NamedQuery(name = "Notifikacija.findByValsnikProfila", query = "SELECT n FROM Notifikacija n WHERE n.valsnikProfila = :valsnikProfila"),
    @NamedQuery(name = "Notifikacija.findByVlasnikZahteva", query = "SELECT n FROM Notifikacija n WHERE n.vlasnikZahteva = :vlasnikZahteva"),
    @NamedQuery(name = "Notifikacija.findByFlagPrikazana", query = "SELECT n FROM Notifikacija n WHERE n.flagPrikazana = :flagPrikazana"),
    @NamedQuery(name = "Notifikacija.findByFlagOdobreno", query = "SELECT n FROM Notifikacija n WHERE n.flagOdobreno = :flagOdobreno"),
    @NamedQuery(name = "Notifikacija.findByTimeStamp", query = "SELECT n FROM Notifikacija n WHERE n.timeStamp = :timeStamp")})
public class Notifikacija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "profil")
    private int profil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valsnikProfila")
    private int valsnikProfila;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vlasnikZahteva")
    private int vlasnikZahteva;
    @Column(name = "flagPrikazana")
    private Boolean flagPrikazana;
    @Column(name = "flagOdobreno")
    private Boolean flagOdobreno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TimeStamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;

    public Notifikacija() {
    }

    public Notifikacija(Integer id) {
        this.id = id;
    }

    public Notifikacija(Integer id, int profil, int valsnikProfila, int vlasnikZahteva, Date timeStamp) {
        this.id = id;
        this.profil = profil;
        this.valsnikProfila = valsnikProfila;
        this.vlasnikZahteva = vlasnikZahteva;
        this.timeStamp = timeStamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getProfil() {
        return profil;
    }

    public void setProfil(int profil) {
        this.profil = profil;
    }

    public int getValsnikProfila() {
        return valsnikProfila;
    }

    public void setValsnikProfila(int valsnikProfila) {
        this.valsnikProfila = valsnikProfila;
    }

    public int getVlasnikZahteva() {
        return vlasnikZahteva;
    }

    public void setVlasnikZahteva(int vlasnikZahteva) {
        this.vlasnikZahteva = vlasnikZahteva;
    }

    public Boolean getFlagPrikazana() {
        return flagPrikazana;
    }

    public void setFlagPrikazana(Boolean flagPrikazana) {
        this.flagPrikazana = flagPrikazana;
    }

    public Boolean getFlagOdobreno() {
        return flagOdobreno;
    }

    public void setFlagOdobreno(Boolean flagOdobreno) {
        this.flagOdobreno = flagOdobreno;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
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
        if (!(object instanceof Notifikacija)) {
            return false;
        }
        Notifikacija other = (Notifikacija) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nn.cvserver.domen.Notifikacija[ id=" + id + " ]";
    }
    
}
