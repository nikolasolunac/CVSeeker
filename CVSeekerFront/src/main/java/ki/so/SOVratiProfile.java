/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ki.so;

import java.util.List;
import ki.domen.IDomenKI;
import ki.domen.Korisnik;
import ki.domen.Profil;
import ki.rest.RestOperationEnum;

/**
 *
 * @author P
 */
public class SOVratiProfile extends AbstractSO{
    
    public List<IDomenKI> izvrsi(IDomenKI ODKI)//vrati sve profile korisnika
    {
        Korisnik k = (Korisnik)ODKI;
        jsonRequest = ""; //super.ObjectToJSON(k);
        jsonResponse = super.pozoviRestServis(jsonRequest, RestOperationEnum.PROFIL_KORISNIK.toString(),k.getId());
        
        if ((!jsonResponse.equals("Cannot return clients profiles.")) && (!jsonResponse.equals("Greška prilikom poziva RestCaller-a")))
        {
            List<IDomenKI> lp = super.JSONToProfilCollection(jsonResponse);
            return lp;
        }
        
        return null;
    }
    
    public List<IDomenKI> izvrsi()//vrati sve
    {
        jsonRequest = "";//super.ObjectToJSON(null);
        jsonResponse = super.pozoviRestServis(jsonRequest, RestOperationEnum.PROFIL_SVI.toString(),0);
        
        if (!jsonResponse.equals("Cannot return profiles.") && (!jsonResponse.equals("Greška prilikom poziva RestCaller-a")))
        {
            List<IDomenKI> lp = super.JSONToProfilCollection(jsonResponse);
            return lp;
        }
        
        return null;
    }
    
    public IDomenKI izvrsi(Integer id)//vrati profil po id-ju
    {
        jsonRequest = ""; //super.ObjectToJSON(null);
        jsonResponse = super.pozoviRestServis(jsonRequest, RestOperationEnum.PROFIL_ID.toString(),id);
        
        if (!jsonResponse.equals("Cannot return selected profile.") && (!jsonResponse.equals("Greška prilikom poziva RestCaller-a")))
        {
            IDomenKI p = super.JSONToProfil(jsonResponse);
            return p;
        }
        
        return null;
    }
}
