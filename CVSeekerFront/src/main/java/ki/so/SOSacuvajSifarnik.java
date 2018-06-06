/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ki.so;

import ki.domen.IDomenKI;
import ki.domen.Profil;
import ki.domen.Sifarnik;
import ki.rest.RestOperationEnum;

/**
 *
 * @author Paun
 */
public class SOSacuvajSifarnik extends AbstractSO {
    
    public IDomenKI izvrsi(IDomenKI ODKI)
    {
        Sifarnik s = (Sifarnik)ODKI;
        jsonRequest = super.ObjectToJSON(s);
        jsonResponse = super.pozoviRestServis(jsonRequest, RestOperationEnum.SACUVAJ_SIFARNIK.toString(),0);
        
        if ((!jsonResponse.equals("Cannot save coded segment changes.")) && (!jsonResponse.equals("Greška prilikom poziva RestCaller-a")))
        {
            s = (Sifarnik)super.JSONToSifarnik(jsonResponse);
            return s;
        }
        
        return null;
    }
}
