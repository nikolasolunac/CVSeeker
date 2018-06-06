/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.mb;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import ki.domen.Korisnik;
import ki.domen.Profil;
import ki.domen.Rola;
import ki.domen.Secretqstn;
import ki.domen.Segment;
import ki.domen.Stavka;
import ki.kontroler.KontrolerKI;
import ki.rest.RestCaller;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author SOLUNAC
 */
@Named(value = "mbPrijava")
@SessionScoped
public class MBPrijava implements Serializable {

    String username;
    String password;
    public static Korisnik k1;
    public static String token = "";
    
    String porukaPrijava;
    
    String odgovorQstnAns;
    String labelaZaPovratakLozinke = "";
    String noviPassword;
    String noviPasswordProvera;    
    String poruka1;
    String poruka2;
    String poruka3;
    
    static String tema = "default"; //izvuci iz k1 odabranu temu

    /**
     * Creates a new instance of MBPrijava
     */
    public MBPrijava() {
        //KontrolerKI.getInstance();
    }
    
    /*
    public String prijaviKorisnika()
    {
        try {
            
            //RestCaller r = new RestCaller();
            Korisnik k = new Korisnik("Saban", "Saulic", "saki", "123", Boolean.TRUE, new Secretqstn(1), "asdasd", null, new Rola(2));  //(1, "Nikola", "Paunovic", "paun", "123", "asdasd", );
            Korisnik k1 = new Korisnik(3);
            Profil p = new Profil(1);
            
            Stavka ss = new Stavka(3, "2017.01.01");
            ss.setDatumDo("2018.01.01");
            ss.setHeading1("testHeadeing1");
            ss.setHeading2("testHeading2");
            ss.setOpis("opistest");
            List<Stavka> lss = new LinkedList<Stavka>();
            lss.add(ss);
            Segment s = new Segment(3);
            s.setOpis("opisSegmenta");
            s.setHeading("SegmentHeading");
            s.setStavkaList(lss);
            List<Segment> ls = new LinkedList<Segment>();
            ls.add(s);
            Profil p1 = new Profil(3, "2018.01.01");
            p1.setNaziv("test");
            p1.setOpis("testOpis");
            p1.setSegmentList(ls);
            p1.setKorisnikId(k1);
            
            String token = KontrolerKI.getInstance().prijava(k);
            
            boolean registrovan = KontrolerKI.getInstance().registracija(k);
            
            p = (Profil) KontrolerKI.getInstance().vratiProfil(1);
            
            List<Profil> lp = (List<Profil>)(List<?>) KontrolerKI.getInstance().vratiProfileKorisnika(k1);
            
            List<Profil> lp1 = (List<Profil>)(List<?>) KontrolerKI.getInstance().vratiSveProfile();
            
            boolean obrisan = KontrolerKI.getInstance().obrisiProfil(p);
            
            
            p = (Profil) KontrolerKI.getInstance().sacuvajProfil(p1);
            
            String s1 = "";
                    
            return s1;        
            //r.pozoviRestServis("","PROFIL_SVI");
            //r.sendGet();      
        } catch (Exception ex) {
            Logger.getLogger(MBPrijava.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    */
    
    public String prijaviKorisnika() {
        porukaPrijava = "";
        if(username.isEmpty() || password.isEmpty())
        {
            porukaPrijava = "Molimo unesite korisničko ime i lozinku";
            return "index.xhtml";
        }

        k1 = new Korisnik();
        validacijaUsera();
        k1.setUsername(username);
        k1.setPassword(password);
        token = KontrolerKI.getInstance().prijava(k1);
        if (token == "Unknown user." || token == null){
            porukaPrijava = "Pogresno korisničko ime ili lozinka";
            return "index.xhtml";
        }
        else{
            k1.setToken(token);
            k1 = (Korisnik) KontrolerKI.getInstance().vratiKorisnka(k1);
            if(k1.getLock() == true){
                porukaPrijava = "Vaš nalog je blokiran";
                return "index.xhtml";
            }
            return "homepage.xhtml";
        }
    }
    
    
    public void povratakIzgubljeneLozinke()
    {    
         Korisnik k = new Korisnik();
         int br = validacijaZaPovratakSifre();
         if(br == 0)
         {
             k.setUsername(username);
             k.setQstnAns(odgovorQstnAns);
             k.setPassword(noviPassword);
             boolean uspesanReset = KontrolerKI.getInstance().resetLozinke(k);
             if (uspesanReset)
             {
                 labelaZaPovratakLozinke = "Uspešno je postavljena nova lozinka";
             }
             else{
             labelaZaPovratakLozinke = "Nije postavljena nova lozinka";
             }
         }   
    }
   

    public String registracija() {
        return "registracija.xhtml";
    }
    
    
    public String redirectPassword()
    {
        return "zaboravljenaLozinka.xhtml";
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

    public static Korisnik getK1() {
        return k1;
    }

    public static void setK1(Korisnik k1) {
        MBPrijava.k1 = k1;
    }

    public String getPorukaPrijava() {
        return porukaPrijava;
    }

    public void setPorukaPrijava(String porukaPrijava) {
        this.porukaPrijava = porukaPrijava;
    }

    public String getOdgovorQstnAns() {
        return odgovorQstnAns;
    }

    public void setOdgovorQstnAns(String odgovorQstnAns) {
        this.odgovorQstnAns = odgovorQstnAns;
    }
    
    public String getLabelaZaPovratakLozinke() {
        return labelaZaPovratakLozinke;
    }

    public void setLabelaZaPovratakLozinke(String labelaZaPovratakLozinke) {
        this.labelaZaPovratakLozinke = labelaZaPovratakLozinke;
    }
    
    public String getNoviPassword() {
        return noviPassword;
    }

    public void setNoviPassword(String noviPassword) {
        this.noviPassword = noviPassword;
    }

    public String getNoviPasswordProvera() {
        return noviPasswordProvera;
    }

    public void setNoviPasswordProvera(String noviPasswordProvera) {
        this.noviPasswordProvera = noviPasswordProvera;
    }

    public String getPoruka1() {
        return poruka1;
    }

    public void setPoruka1(String poruka1) {
        this.poruka1 = poruka1;
    }

    public String getPoruka2() {
        return poruka2;
    }

    public void setPoruka2(String poruka2) {
        this.poruka2 = poruka2;
    }

    public String getPoruka3() {
        return poruka3;
    }

    public void setPoruka3(String poruka3) {
        this.poruka3 = poruka3;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
    
    public String getK1Ime() {
        return k1.getIme();
    }
    
    public void validacijaUsera()
    {
        username = username.toLowerCase().trim();
        
 
        
    }
    
    public int validacijaZaPovratakSifre()
    {
        int br = 0;
        poruka1="";
        poruka2="";
        poruka3="";
        
        if(!username.isEmpty())
        {
             validacijaUsera();
        }
        else
        {
             poruka1 = "Morate uneti e-mail";  
             br++;
        }
        
        if(odgovorQstnAns.isEmpty())
        {
             poruka2 = "Morate uneti odgovor na tajno pitanje";
             br++;
        } 

        if(noviPassword.isEmpty() || noviPasswordProvera.isEmpty() || !noviPassword.equals(noviPasswordProvera))
        {
             poruka3 = "Lozinke se ne poklapaju ili nisu unete";
             br++;
        }
        
        if(noviPassword.length()<8 || noviPasswordProvera.length()<8)
        {
            poruka3 = "Lozinke moraju biti sacinjene od najmanje 8 karaktera";
            br++;
        }
        
        return br;
    }   
}
