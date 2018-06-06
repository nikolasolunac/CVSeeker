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

public class Stavka implements Serializable, IDomenKI {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("datumOd")
    private String datumOd;
    @JsonProperty("datumDo")
    private String datumDo;
    @JsonProperty("heading1")
    private String heading1;
    @JsonProperty("heading2")
    private String heading2;
    @JsonProperty("opis")
    private String opis;
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

    /*@JsonCreator
    public Stavka(@JsonProperty("id")Integer id,@JsonProperty("datumOd") String datumOd,@JsonProperty("datumDo") String datumDo,
            @JsonProperty("heading1") String heading1,@JsonProperty("heading2") String heading2,@JsonProperty("opis") String opis) {
        this.id = id;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.heading1 = heading1;
        this.heading2 = heading2;
        this.opis = opis;
    }*/
    
    
    
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }
    @JsonProperty("datumOd")
    public String getDatumOd() {
        return datumOd;
    }
    @JsonProperty("datumOd")
    public void setDatumOd(String datumOd) {
        this.datumOd = datumOd;
    }
    @JsonProperty("datumDo")
    public String getDatumDo() {
        return datumDo;
    }
    @JsonProperty("datumDo")
    public void setDatumDo(String datumDo) {
        this.datumDo = datumDo;
    }
    @JsonProperty("heading1")
    public String getHeading1() {
        return heading1;
    }
    @JsonProperty("heading1")
    public void setHeading1(String heading1) {
        this.heading1 = heading1;
    }
    @JsonProperty("heading2")
    public String getHeading2() {
        return heading2;
    }
    @JsonProperty("heading2")
    public void setHeading2(String heading2) {
        this.heading2 = heading2;
    }
    @JsonProperty("opis")
    public String getOpis() {
        return opis;
    }
    @JsonProperty("opis")
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
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Stavka other = (Stavka) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.datumOd, other.datumOd)) {
            return false;
        }
        if (!Objects.equals(this.datumDo, other.datumDo)) {
            return false;
        }
        if (!Objects.equals(this.heading1, other.heading1)) {
            return false;
        }
        if (!Objects.equals(this.heading2, other.heading2)) {
            return false;
        }
        if (!Objects.equals(this.opis, other.opis)) {
            return false;
        }
        if (!Objects.equals(this.segmentId, other.segmentId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Stavka{" + "id=" + id + ", datumOd=" + datumOd + ", datumDo=" + datumDo + ", heading1=" + heading1 + ", heading2=" + heading2 + ", opis=" + opis + ", segmentId=" + segmentId + '}';
    }
    
}
