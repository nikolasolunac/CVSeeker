/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ki.so;

import ki.domen.IDomenKI;
import ki.domen.Profil;
import ki.rest.RestOperationEnum;

/**
 *
 * @author P
 */
public class SOBrisanjeProfila extends AbstractSO{
    
    public boolean izvrsi(IDomenKI ODKI)
    {
        Profil p = (Profil)ODKI;
        jsonRequest = "";//super.ObjectToJSON(p);
        jsonResponse = super.pozoviRestServis(jsonRequest, RestOperationEnum.PROFIL_BRISANJE.toString(), p.getId());
        
        if (jsonResponse.equals("Deleted"))
        {
            return true;
        }
        
        return false;
    }
    
}
