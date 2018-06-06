/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ki.so;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ki.domen.IDomenKI;
import ki.domen.Korisnik;
import ki.domen.Profil;
import ki.rest.RestOperationEnum;

/**
 *
 * @author P
 */
public class SOPrijava extends AbstractSO{
    
    public String izvrsi(IDomenKI ODKI)
    {
        Korisnik k = (Korisnik)ODKI;
        
        jsonRequest = super.ObjectToJSON(k);
        
        jsonResponse = super.pozoviRestServis(jsonRequest, RestOperationEnum.KORISNIK_PRIJAVA.toString(),0);
        
        if ((!jsonResponse.equals("Unknown user."))&& (!jsonResponse.equals("Greška prilikom poziva RestCaller-a")))
        {
            return jsonResponse;
        }
        
        return null;
    }
}
