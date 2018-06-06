/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ki.so;

import java.util.List;
import ki.domen.IDomenKI;
import ki.domen.Notifikacija;
import ki.domen.Korisnik;
import ki.rest.RestOperationEnum;

/**
 *
 * @author P
 */
public class SOVratiNotifikacijeKorisnika extends AbstractSO{
    public List<IDomenKI> izvrsi(IDomenKI ODKI)//vrati sve profile korisnika
    {
        Korisnik k = (Korisnik)ODKI;
        jsonRequest = ""; //super.ObjectToJSON(k);
        jsonResponse = super.pozoviRestServis(jsonRequest, RestOperationEnum.VRATI_NOTIFIKACIJE.toString(),k.getId());
        
        if ((!jsonResponse.equals(""))&& 
                (!jsonResponse.equals("No new notifications")) && (!jsonResponse.equals("Greška prilikom poziva RestCaller-a")))
        {
            List<IDomenKI> ln = super.JSONToNotifikacijaCollection(jsonResponse);
            return ln;
        }
        
        return null;
    }
}
