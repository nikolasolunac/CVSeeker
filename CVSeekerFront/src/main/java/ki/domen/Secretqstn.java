/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ki.domen;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author SOLUNAC
 */

public class Secretqstn implements Serializable, IDomenKI {


    private Integer id;
    private String opis;
    private String opisUS;
    //private List<Korisnik> korisnikList;

    public Secretqstn() {
    }

    public Secretqstn(Integer id) {
        this.id = id;
    }
    @JsonCreator
    public Secretqstn( @JsonProperty("id")Integer id,@JsonProperty("opis") String opis,@JsonProperty("opisUS") String opisUS) {
        this.id = id;
        this.opis = opis;
        this.opisUS = opisUS;
    }
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }
    @JsonProperty("opis")
    public String getOpis() {
        return opis;
    }
    @JsonProperty("opis")
    public void setOpis(String opis) {
        this.opis = opis;
    }
    @JsonProperty("opisUS")
    public String getOpisUS() {
        return opisUS;
    }
    @JsonProperty("opisUS")
    public void setOpisUS(String opisUS) {
        this.opisUS = opisUS;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Secretqstn other = (Secretqstn) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.opis, other.opis)) {
            return false;
        }
        if (!Objects.equals(this.opisUS, other.opisUS)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Secretqstn{" + "id=" + id + ", opis=" + opis + ", opisUS=" + opisUS + '}';
    }
    
}
