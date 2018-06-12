/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ki.so;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ki.domen.IDomenKI;
import ki.json.JSONConverter;
import ki.rest.RestCaller;

/**
 *
 * @author P
 */
public abstract class AbstractSO {
    
    String jsonRequest = "";
    String jsonResponse = "";
    
    String token = "";
         
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    public String ObjectToJSON(IDomenKI ODKI)
    {
        return JSONConverter.getInstance().ObjectToJSON(ODKI);
    }
    
    public IDomenKI JSONToProfil(String json)
    {
        return JSONConverter.getInstance().JSONToProfil(json);
    }
    
    public IDomenKI JSONToSifarnik(String json)
    {
        return JSONConverter.getInstance().JSONToSifarnik(json);
    }
    
    public List<IDomenKI> JSONToProfilCollection(String json)
    {
        return (List<IDomenKI>)(List<?>)JSONConverter.getInstance().JSONToProfilCollection(json);
    }
    
    public IDomenKI JSONToKorisnik(String json)
    {
        return JSONConverter.getInstance().JSONToKorisnik(json);
    }
    
    public List<IDomenKI> JSONToKorisnikCollection(String json)
    {
        return (List<IDomenKI>)(List<?>)JSONConverter.getInstance().JSONToKorisnikCollection(json);
    }
    
    public IDomenKI JSONToTajnoPitanje(String json)
    {
        return JSONConverter.getInstance().JSONToTajnoPitanje(json);
    }
    
    public List<IDomenKI> JSONToSifarnikCollection(String json)
    {
        return (List<IDomenKI>)(List<?>)JSONConverter.getInstance().JSONToSifarnikCollection(json);
    }
    
    public List<IDomenKI> JSONToNotifikacijaCollection(String json)
    {
        return (List<IDomenKI>)(List<?>)JSONConverter.getInstance().JSONToNotifikacijaCollection(json);
    }
    public IDomenKI JSONToNotifikacija(String json)
    {
        return JSONConverter.getInstance().JSONToNotifikacija(json);
    }
    /*public IDomenKI JSONToObject(String json)
    {
        return JSONConverter.getInstance().JSONToObject(json);
    }*/
    
    /*public List<IDomenKI> JSONToObjectCollection(String json)
    {
        return JSONConverter.getInstance().JSONToObjectCollection(json);
    }*/
    
    public String pozoviRestServis(String json, String roe, Integer i)
    {
        
        try {
            
            return RestCaller.getInstance().pozoviRestServis(json, roe, i, token);
            
        } catch (Exception ex) {
            Logger.getLogger(AbstractSO.class.getName()).log(Level.SEVERE, "AbstractSO.pozoviRestServis: "+ex.getMessage(), ex);
            return "Greška prilikom poziva RestCaller-a";
        }
    }
    
    
    
    
}
