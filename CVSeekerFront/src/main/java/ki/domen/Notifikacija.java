/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ki.domen;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author SOLUNAC
 */

public class Notifikacija implements Serializable, IDomenKI {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("profil")
    private int profil;
    @JsonProperty("valsnikProfila")
    private int valsnikProfila;
    @JsonProperty("vlasnikZahteva")
    private int vlasnikZahteva;
    @JsonProperty("flagPrikazana")
    private Boolean flagPrikazana;
    @JsonProperty("flagOdobreno")
    private Boolean flagOdobreno;
    @JsonProperty("TimeStamp")
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
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }
    @JsonProperty("profil")
    public int getProfil() {
        return profil;
    }
    @JsonProperty("profil")
    public void setProfil(int profil) {
        this.profil = profil;
    }
    @JsonProperty("valsnikProfila")
    public int getValsnikProfila() {
        return valsnikProfila;
    }
    @JsonProperty("valsnikProfila")
    public void setValsnikProfila(int valsnikProfila) {
        this.valsnikProfila = valsnikProfila;
    }
    @JsonProperty("vlasnikZahteva")
    public int getVlasnikZahteva() {
        return vlasnikZahteva;
    }
    @JsonProperty("vlasnikZahteva")
    public void setVlasnikZahteva(int vlasnikZahteva) {
        this.vlasnikZahteva = vlasnikZahteva;
    }
    @JsonProperty("flagPrikazana")
    public Boolean getFlagPrikazana() {
        return flagPrikazana;
    }
    @JsonProperty("flagPrikazana")
    public void setFlagPrikazana(Boolean flagPrikazana) {
        this.flagPrikazana = flagPrikazana;
    }
    @JsonProperty("flagOdobreno")
    public Boolean getFlagOdobreno() {
        return flagOdobreno;
    }
    @JsonProperty("flagOdobreno")
    public void setFlagOdobreno(Boolean flagOdobreno) {
        this.flagOdobreno = flagOdobreno;
    }
    @JsonProperty("TimeStamp")
    public Date getTimeStamp() {
        return timeStamp;
    }
    @JsonProperty("TimeStamp")
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
