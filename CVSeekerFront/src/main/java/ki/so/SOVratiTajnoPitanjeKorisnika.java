/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ki.so;

import ki.domen.IDomenKI;
import ki.domen.Korisnik;
import ki.domen.Secretqstn;
import ki.rest.RestOperationEnum;

/**
 *
 * @author P
 */
public class SOVratiTajnoPitanjeKorisnika extends AbstractSO{

    public IDomenKI izvrsi(IDomenKI ODKI)
    {
        Korisnik k = (Korisnik)ODKI;
        
        jsonRequest = super.ObjectToJSON(k);
        
        jsonResponse = super.pozoviRestServis(jsonRequest, RestOperationEnum.TAJNOPITANJE_VRATI_KORISNIK.toString(),0);
        
        if ((!jsonResponse.equals("Unknown user."))&& (!jsonResponse.equals("Greška prilikom poziva RestCaller-a"))&&(!jsonResponse.isEmpty()))
        {
            IDomenKI sq = (Secretqstn)super.JSONToTajnoPitanje(jsonResponse);
            return sq;
        }
        
        return null;
    }
}
