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
public class SOUnosProfila extends AbstractSO{
    
    public IDomenKI izvrsi(IDomenKI ODKI)
    {
        Profil p = (Profil)ODKI;
        jsonRequest = super.ObjectToJSON(p);
        jsonResponse = super.pozoviRestServis(jsonRequest, RestOperationEnum.PROFIL_UNOS.toString(),0);
        
        if ((!jsonResponse.equals("Cannot save profile changes.")) && (!jsonResponse.equals("Greška prilikom poziva RestCaller-a")))
        {
            p = (Profil)super.JSONToProfil(jsonResponse);
            return p;
        }
        
        return null;
    }
    
}
