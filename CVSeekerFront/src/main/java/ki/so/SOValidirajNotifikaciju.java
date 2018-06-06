/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ki.so;

import ki.domen.IDomenKI;
import ki.domen.Notifikacija;
import ki.rest.RestOperationEnum;

/**
 *
 * @author P
 */
public class SOValidirajNotifikaciju extends AbstractSO {
    public boolean izvrsi(IDomenKI ODKI)
    {
        Notifikacija n = (Notifikacija)ODKI;
        jsonRequest = super.ObjectToJSON(n);
        jsonResponse = super.pozoviRestServis(jsonRequest, RestOperationEnum.VALIDIRAJ_NOTIFIKACIJU.toString(),0);
        
        if ((!jsonResponse.equals("Cannot validate notification.")) && (!jsonResponse.equals("Greška prilikom poziva RestCaller-a")))
        {
             n = (Notifikacija)super.JSONToNotifikacija(jsonResponse);
            return  true;
        }
        
        return false;
    }
}
