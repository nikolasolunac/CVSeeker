/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ki.domen;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author SOLUNAC
 */

public class Korisnik implements Serializable, IDomenKI{
    
    private Integer id;
    private String ime;
    private String prezime;
    private String username;
    private String password;
    private String token;
    private Boolean lock;
    private Secretqstn qstnId;
    private String qstnAns;
    private List<Profil> profilList;   
    private Rola rolaId;

    public Korisnik() {
    }
    
    public Korisnik(Integer id) {
        this.id = id;
    }
    
    @JsonCreator
    public Korisnik( @JsonProperty("ime") String ime,@JsonProperty("prezime") String prezime,@JsonProperty("username") String username,
            @JsonProperty("password") String password,@JsonProperty("lock") Boolean lock,@JsonProperty("qstnId") Secretqstn qstnId,
            @JsonProperty("qstnAns") String qstnAns,@JsonProperty("profilList") List<Profil> profilList,@JsonProperty("rolaId") Rola rolaId) {
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.lock = lock;
        this.qstnId = qstnId;
        this.qstnAns = qstnAns;
        this.profilList = profilList;
        this.rolaId = rolaId;
    }

    
    //@JsonIgnore
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }
    @JsonIgnore
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }
    @JsonProperty("ime")
    public String getIme() {
        return ime;
    }
    @JsonProperty("ime")
    public void setIme(String ime) {
        this.ime = ime;
    }
    @JsonProperty("prezime")
    public String getPrezime() {
        return prezime;
    }
    @JsonProperty("prezime")
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }
    @JsonProperty("password")    
    public String getPassword() {
        return password;
    }
    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }  
    
    @JsonProperty("lock")
    public Boolean getLock() {
        return lock;
    }
    @JsonProperty("lock")
    public void setLock(Boolean lock) {
        this.lock = lock;
    }
    @JsonProperty("qstnId")
    public Secretqstn getQstnId() {
        return qstnId;
    }
    @JsonProperty("qstnId")
    public void setQstnId(Secretqstn qstnId) {
        this.qstnId = qstnId;
    }
    @JsonProperty("qstnAns")
    public String getQstnAns() {
        return qstnAns;
    }
    @JsonProperty("qstnAns")
    public void setQstnAns(String qstnAns) {
        this.qstnAns = qstnAns;
    }   
    @JsonProperty("rolaId")
    public Rola getRolaId() {
        return rolaId;
    }
    @JsonProperty("profilList")
    public List<Profil> getProfilList() {
        return profilList;
    }
    @JsonProperty("profilList")
    public void setProfilList(List<Profil> profilList) {
        this.profilList = profilList;
    }
    
    @JsonProperty("rolaId")
    public void setRolaId(Rola rolaId) {
        this.rolaId = rolaId;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Korisnik other = (Korisnik) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.lock, other.lock)) {
            return false;
        }
        if (!Objects.equals(this.qstnAns, other.qstnAns)) {
            return false;
        }
        if (!Objects.equals(this.profilList, other.profilList)) {
            return false;
        }
        if (!Objects.equals(this.qstnId, other.qstnId)) {
            return false;
        }
        if (!Objects.equals(this.rolaId, other.rolaId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "Korisnik{" + "id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", username=" + username + ", password=" + password + ", lock=" + lock + ", qstnAns=" + qstnAns + ", profilList=" + profilList + ", qstnId=" + qstnId + ", rolaId=" + rolaId + '}';
        return "Korisnik{ime=" + ime + ", prezime=" + prezime + ", username=" + username +"}";
    }
    
    
    
}
