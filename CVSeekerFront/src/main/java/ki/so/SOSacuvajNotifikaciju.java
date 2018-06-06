/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ki.so;

import ki.domen.IDomenKI;
import ki.domen.Notifikacija;
import ki.domen.Profil;
import ki.rest.RestOperationEnum;

/**
 *
 * @author P
 */
public class SOSacuvajNotifikaciju extends AbstractSO{
    public IDomenKI izvrsi(IDomenKI ODKI)
    {
        Notifikacija n = (Notifikacija)ODKI;
        jsonRequest = super.ObjectToJSON(n);
        jsonResponse = super.pozoviRestServis(jsonRequest, RestOperationEnum.SACUVAJ_NOTIFIKACIJU.toString(),0);
        
        if ((!jsonResponse.equals("Cannot save notifications.")) && (!jsonResponse.equals("Greška prilikom poziva RestCaller-a")))
        {
             n = (Notifikacija)super.JSONToNotifikacija(jsonResponse);
            return  n;
        }
        
        return null;
    }
    
}
