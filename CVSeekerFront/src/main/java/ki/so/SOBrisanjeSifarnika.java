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
public class SOBrisanjeSifarnika extends AbstractSO {
    
    public boolean izvrsi(IDomenKI ODKI)
    {
        Sifarnik s = (Sifarnik)ODKI;
        jsonRequest = "";//super.ObjectToJSON(p);
        jsonResponse = super.pozoviRestServis(jsonRequest, RestOperationEnum.OBRISI_SIFARNIK.toString(), s.getId());
        
        if (jsonResponse.equals("Deleted"))
        {
            return true;
        }
        
        return false;
    }
}
