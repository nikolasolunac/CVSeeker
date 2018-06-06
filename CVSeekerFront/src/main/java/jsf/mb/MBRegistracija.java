/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.mb;

import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import ki.domen.Korisnik;
import ki.domen.Rola;
import ki.domen.Secretqstn;
import ki.kontroler.KontrolerKI;

/**
 *
 * @author SOLUNAC
 */
@Named(value = "mbRegistracija")
@SessionScoped
public class MBRegistracija implements Serializable{
              
    Korisnik k;
  
    String ime;
    String prezime;
    String username;
    String password;
    String passwordCheck;
    String qstnAns;
    
    private Rola rolaId;
    private Secretqstn secretQstnId;

    String porukaImePrezime;
    String porukaUsername;
    String porukaPassword;
    String porukaQstnAns;
       
    List<String> korisnici;
    int br = 0;
    boolean uspesnaRegistracija;

    /**
     * Creates a new instance of MBRegistracija
     */
    
    
    public MBRegistracija() {
        
       secretQstnId = (Secretqstn) KontrolerKI.getInstance().TajnoPitanje(); 
       //secretQstnId = KontrolerKI.dajMiSctQstn

    }
    
    /*
    public void vratiKorisnikeZaProveru() {

        korisnici = KontrolerKI.vratiListuKorisnikID();
    }
    */
    
    public void registracija() {
        validacija();
        if (br == 0) {
            
            
            k.setQstnId(secretQstnId);
            
            rolaId = new Rola(2);
            k.setRolaId(rolaId);
            
            uspesnaRegistracija = KontrolerKI.getInstance().registracija(k); 

        }
        
    }

    public Secretqstn getsecretQstnId() {
        return secretQstnId;
    }
    
    public Korisnik getK() {
        return k;
    }

    public void setK(Korisnik k) {
        this.k = k;
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

    public String getPasswordCheck() {
        return passwordCheck;
    }

    public void setPasswordCheck(String passwordCheck) {
        this.passwordCheck = passwordCheck;
    }
    
    public String getQstnAns() {
        return qstnAns;
    }

    public void setQstnAns(String qstnAns) {
        this.qstnAns = qstnAns;
    }

    public Rola getRolaId() {
        return rolaId;
    }

    public void setRolaId(Rola rolaId) {
        this.rolaId = rolaId;
    }

    public Secretqstn getSecretQstnId() {
        return secretQstnId;
    }

    public void setSecretQstnId(Secretqstn secretQstnId) {
        this.secretQstnId = secretQstnId;
    }
    
    public String getPorukaImePrezime() {
        return porukaImePrezime;
    }

    public void setPorukaImePrezime(String porukaImePrezime) {
        this.porukaImePrezime = porukaImePrezime;
    }
    
    public String getPorukaUsername() {
        return porukaUsername;
    }

    public void setPorukaUsername(String porukaUsername) {
        this.porukaUsername = porukaUsername;
    }

    public String getPorukaPassword() {
        return porukaPassword;
    }

    public void setPorukaPassword(String porukaPassword) {
        this.porukaPassword = porukaPassword;
    }

    public String getPorukaQstnAns() {
        return porukaQstnAns;
    }

    public void setPorukaQstnAns(String porukaQstnAns) {
        this.porukaQstnAns = porukaQstnAns;
    }
    
    public List<String> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(List<String> korisnici) {
        this.korisnici = korisnici;
    }
    
    public int getBr() {
        return br;
    }

    public void setBr(int br) {
        this.br = br;
    }

    public boolean isUspesnaRegistracija() {
        return uspesnaRegistracija;
    }

    public void setUspesnaRegistracija(boolean uspesnaRegistracija) {
        this.uspesnaRegistracija = uspesnaRegistracija;
    }

    private void validacija() {

         porukaImePrezime = "";
         porukaUsername = "";
         porukaPassword = "";
         porukaQstnAns = "";
         
        k = new Korisnik();
      
        int brUser = 0;
        br = 0;
        
        if (username.isEmpty()) {
            porukaUsername = "* Korisnicko ime mora biti uneto";
            br++;
        }
        else
        {
            username = username.toLowerCase().trim();
        }

        /*for (String string : korisnici) {
            if (username.equals(string)) {
                brUser++;
            }

        }*/

        if (brUser == 0) {
            k.setUsername(username);
        } else {
            porukaUsername = "* Uneto korisnicko ime vec postoji";
            br++;
        }

        if (password.equals(passwordCheck) && !password.isEmpty()) {
            if (password.length() > 8) {
                k.setPassword(password);
            } else {
                porukaPassword = "* Lozinka mora biti sacinjena od najmanje 8 karaktera";
                br++;
            }
        } else {
            porukaPassword = "* Lozinke se ne poklapaju ili nisu unete";
            br++;
        }

        if (!ime.isEmpty()) {
            k.setIme(ime);
        } else {
            porukaImePrezime = "* Ime i prezime moraju biti uneti";
            br++;
        }

        if (!prezime.isEmpty()) {
            k.setPrezime(prezime);
        } else {
            porukaImePrezime = "* Ime i prezime moraju biti uneti";
           br++;
        }

        if (!qstnAns.isEmpty()) {
            k.setQstnAns(qstnAns);
        } else {
            porukaQstnAns = "* Odgovor na tajno pitanje mora biti unet";
            br++;
        }
    }
}
