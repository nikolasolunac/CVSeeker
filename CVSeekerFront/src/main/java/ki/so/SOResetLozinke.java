/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ki.so;

import ki.domen.IDomenKI;
import ki.domen.Korisnik;
import ki.rest.RestOperationEnum;

/**
 *
 * @author P
 */
public class SOResetLozinke extends AbstractSO{
    public boolean izvrsi(IDomenKI ODKI)
    {
        Korisnik k = (Korisnik)ODKI;
        jsonRequest = super.ObjectToJSON(k);
        jsonResponse = super.pozoviRestServis(jsonRequest, RestOperationEnum.KORISNIK_RESETLOZINKE.toString(),0);
        
        if (jsonResponse != null && (!jsonResponse.equals(""))&& (!jsonResponse.equals("Greška prilikom poziva RestCaller-a")))
        {
            return true;
        }
        
        return false;
    }
}
