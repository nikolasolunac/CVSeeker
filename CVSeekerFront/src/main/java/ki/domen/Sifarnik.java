/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ki.domen;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SOLUNAC
 */

public class Sifarnik implements Serializable, IDomenKI {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("naziv")
    private String naziv;

    public Sifarnik() {
    }

    public Sifarnik(Integer id) {
        this.id = id;
    }
    
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }
    
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }
    
    @JsonProperty("naziv")
    public String getNaziv() {
        return naziv;
    }

    @JsonProperty("naziv")
    public void setNaziv(String naziv) {
        this.naziv = naziv;
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
        if (!(object instanceof Sifarnik)) {
            return false;
        }
        Sifarnik other = (Sifarnik) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return naziv;
        return "Sifarnik{id=" + id + ", naziv=" + naziv +"}";
    }
    
}
