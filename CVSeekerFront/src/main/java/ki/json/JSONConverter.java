/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ki.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ki.domen.IDomenKI;
import ki.domen.Korisnik;
import ki.domen.Notifikacija;
import ki.domen.Profil;
import ki.domen.Secretqstn;
import ki.domen.Sifarnik;
import ki.so.SOPrijava;

/**
 *
 * @author SOLUNAC
 */
public class JSONConverter {
    
   String jsonRequest = "";
   
   Type tip;
    
    private static JSONConverter instance;
    
    public static JSONConverter getInstance() 
    {
        if (instance == null) {
            instance = new JSONConverter();
        }
        return instance;
    }
    
    public String ObjectToJSON(IDomenKI ODKI)
    {
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        try 
        {
            jsonRequest = mapper.writeValueAsString(ODKI);
            
        } catch (JsonProcessingException ex) {
            Logger.getLogger(SOPrijava.class.getName()).log(Level.SEVERE, "JSONConverter.ObjectToJSON: "+ex.getMessage(), ex);
        }
        
        return jsonRequest;
    }
    
    public Profil JSONToProfil(String json)
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try 
        {
           Profil p = mapper.readValue(json, Profil.class);
           return p;
           
        } catch (IOException ex) {
           Logger.getLogger(SOPrijava.class.getName()).log(Level.SEVERE, "JSONConverter.JSONToProfil: "+ex.getMessage(), ex);
        }
        
       return null;
    }
    
    public Korisnik JSONToKorisnik(String json)
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try 
        {
           Korisnik k = mapper.readValue(json, Korisnik.class);
           return k;
           
        } catch (IOException ex) {
           Logger.getLogger(SOPrijava.class.getName()).log(Level.SEVERE, "JSONConverter.JSONToKorisnik: "+ex.getMessage(), ex);
        }
        
       return null;
    }
    
    public Sifarnik JSONToSifarnik(String json)
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try 
        {
           Sifarnik s = mapper.readValue(json, Sifarnik.class);
           return s;
           
        } catch (IOException ex) {
           Logger.getLogger(SOPrijava.class.getName()).log(Level.SEVERE, "JSONConverter.JSONToSifarnik: "+ex.getMessage(), ex);
        }
        
       return null;
    }
    
    public Secretqstn JSONToTajnoPitanje(String json)
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try 
        {
           Secretqstn s = mapper.readValue(json, Secretqstn.class);
           return s;
           
        } catch (IOException ex) {
           Logger.getLogger(SOPrijava.class.getName()).log(Level.SEVERE, "JSONConverter.JSONToTajnoPitanje: "+ex.getMessage(), ex);
        }
        
       return null;
    }
    
    
    public List<Profil> JSONToProfilCollection(String json)
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try 
        {
           List<Profil> lp =  Arrays.asList(mapper.readValue(json, Profil[].class));
           return lp;
           
        } catch (IOException ex) {
           Logger.getLogger(SOPrijava.class.getName()).log(Level.SEVERE, "JSONConverter.JSONToProfilCollection: "+ex.getMessage(), ex);
        }
        
       return null;
    }
    
    public List<Korisnik> JSONToKorisnikCollection(String json)
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try 
        {
           List<Korisnik> lk =  Arrays.asList(mapper.readValue(json, Korisnik[].class));
           return lk;
           
        } catch (IOException ex) {
           Logger.getLogger(SOPrijava.class.getName()).log(Level.SEVERE, "JSONConverter.JSONToKorisnikCollection: "+ex.getMessage(), ex);
        }
        
       return null;
    }
    
    public List<Sifarnik> JSONToSifarnikCollection(String json)
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try 
        {
           List<Sifarnik> ls =  Arrays.asList(mapper.readValue(json, Sifarnik[].class));
           return ls;
           
        } catch (IOException ex) {
           Logger.getLogger(SOPrijava.class.getName()).log(Level.SEVERE, "JSONConverter.JSONToSifarnikCollection: "+ex.getMessage(), ex);
        }
        
       return null;
    }
    
    public List<Notifikacija> JSONToNotifikacijaCollection(String json)
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try 
        {
           List<Notifikacija> ls =  Arrays.asList(mapper.readValue(json, Notifikacija[].class));
           return ls;
           
        } catch (IOException ex) {
           Logger.getLogger(SOPrijava.class.getName()).log(Level.SEVERE, "JSONConverter.JSONToNotifikacijaCollection: "+ex.getMessage(), ex);
        }
        
       return null;
    }
    /*public IDomenKI JSONToObject(String json)
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try 
        {
           IDomenKI ODKI = mapper.readValue(json, IDomenKI.class);
           return ODKI;
           
        } catch (IOException ex) {
           Logger.getLogger(SOPrijava.class.getName()).log(Level.SEVERE, "JSONConverter.JSONToObject: "+ex.getMessage(), ex);
        }
        
       return null;
    }*/
    
    /*public List<IDomenKI> JSONToObjectCollection(String json)
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try 
        {
           List<IDomenKI> lODKI =  Arrays.asList(mapper.readValue(json, Profil[].class));
           return lODKI;
           
        } catch (IOException ex) {
           Logger.getLogger(SOPrijava.class.getName()).log(Level.SEVERE, "JSONConverter.JSONToObjectCollection: "+ex.getMessage(), ex);
        }
        
       return null;
    }*/

    public IDomenKI JSONToNotifikacija(String json) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try 
        {
           Notifikacija n = mapper.readValue(json, Notifikacija.class);
           return n;
           
        } catch (IOException ex) {
           Logger.getLogger(SOPrijava.class.getName()).log(Level.SEVERE, "JSONConverter.JSONToNotifikacija: "+ex.getMessage(), ex);
        }
        
       return null;
    }
    
}
