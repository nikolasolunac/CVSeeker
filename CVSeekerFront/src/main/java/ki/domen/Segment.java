/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ki.domen;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author SOLUNAC
 */

public class Segment implements Serializable, IDomenKI {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("heading")
    private String heading;
    @JsonProperty("opis")
    private String opis;
    @JsonProperty("stavkaList")
    private List<Stavka> stavkaList;
    private Profil profilId;

    public Segment() {
    }

    public Segment(Integer id) {
        this.id = id;
    }
    
    /*@JsonCreator
    public Segment( @JsonProperty("id") Integer id, @JsonProperty("heading") String heading,@JsonProperty("opis") String opis,
            @JsonProperty("stavkaList") List<Stavka> stavkaList) {
        this.id = id;
        this.heading = heading;
        this.opis = opis;
        this.stavkaList = stavkaList;
    }*/
    
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }
    @JsonProperty("heading")
    public String getHeading() {
        return heading;
    }
    @JsonProperty("heading")
    public void setHeading(String heading) {
        this.heading = heading;
    }
    @JsonProperty("opis")
    public String getOpis() {
        return opis;
    }
    @JsonProperty("opis")
    public void setOpis(String opis) {
        this.opis = opis;
    }
    @JsonProperty("stavkaList")
    public List<Stavka> getStavkaList() {
        return stavkaList;
    }
    @JsonProperty("stavkaList")
    public void setStavkaList(List<Stavka> stavkaList) {
        this.stavkaList = stavkaList;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Segment other = (Segment) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.heading, other.heading)) {
            return false;
        }
        if (!Objects.equals(this.opis, other.opis)) {
            return false;
        }
        if (!Objects.equals(this.stavkaList, other.stavkaList)) {
            return false;
        }
        if (!Objects.equals(this.profilId, other.profilId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Segment{" + "id=" + id + ", heading=" + heading + ", opis=" + opis + ", stavkaList=" + stavkaList + ", profilId=" + profilId + '}';
    }

}
