/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ki.domen;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author SOLUNAC
 */
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY)
public class Profil implements Serializable, IDomenKI {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("datum")
    private String datum;
    @JsonProperty("naziv")
    private String naziv;
    @JsonProperty("opis")
    private String opis;
    private Korisnik korisnikId;
    @JsonProperty("segmentList")
    private List<Segment> segmentList;

    
    @JsonCreator
    public Profil(@JsonProperty("id") Integer id, @JsonProperty("datum") String datum, @JsonProperty("naziv") String naziv, @JsonProperty("opis") String opis,
    @JsonProperty("segmentList") List<Segment> segmentList) {
        this.id = id;
        this.datum = datum;
        this.naziv = naziv;
        this.opis = opis;
        this.segmentList = segmentList;
    }
        
    public Profil() {
    }

    public Profil(Integer id) {
        this.id = id;
    }

    public Profil(Integer id, String datum) {
        this.id = id;
        this.datum = datum;
    }
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }
    @JsonProperty("datum")
    public String getDatum() {
        return datum;
    }
    @JsonProperty("datum")
    public void setDatum(String datum) {
        this.datum = datum;
    }
    @JsonProperty("naziv")
    public String getNaziv() {
        return naziv;
    }
    @JsonProperty("naziv")
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    @JsonProperty("opis")
    public String getOpis() {
        return opis;
    }
    @JsonProperty("opis")
    public void setOpis(String opis) {
        this.opis = opis;
    }
    @JsonProperty("korisnikId")
    public Korisnik getKorisnikId() {
        return korisnikId;
    }
    @JsonProperty("korisnikId")
    public void setKorisnikId(Korisnik korisnikId) {
        this.korisnikId = korisnikId;
    }

    @JsonProperty("segmentList")
    public List<Segment> getSegmentList() {
        return segmentList;
    }
    
    @JsonProperty("segmentList")
    public void setSegmentList(List<Segment> segmentList) {
        this.segmentList = segmentList;
    }   
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Profil other = (Profil) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.datum, other.datum)) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.opis, other.opis)) {
            return false;
        }
        if (!Objects.equals(this.korisnikId, other.korisnikId)) {
            return false;
        }
        if (!Objects.equals(this.segmentList, other.segmentList)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Profil{" + "id=" + id + ", datum=" + datum + ", naziv=" + naziv + ", opis=" + opis + ", korisnikId=" + korisnikId + ", segmentList=" + segmentList + '}';
    }

    
    
}

