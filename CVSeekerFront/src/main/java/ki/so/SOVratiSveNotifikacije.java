/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ki.so;

import java.util.List;
import ki.domen.IDomenKI;
import ki.rest.RestOperationEnum;

/**
 *
 * @author Paun
 */
public class SOVratiSveNotifikacije extends AbstractSO {
    
    public List<IDomenKI> izvrsi()//vrati sve
    {
        jsonRequest = "";//super.ObjectToJSON(null);
        jsonResponse = super.pozoviRestServis(jsonRequest, RestOperationEnum.VRATI_SVE_NOTIFIKACIJE.toString(),0);
        
        if (!jsonResponse.equals("Cannot return notifications.") && (!jsonResponse.equals("Greška prilikom poziva RestCaller-a")))
        {
            List<IDomenKI> lk = super.JSONToNotifikacijaCollection(jsonResponse);
            return lk;
        }
        
        return null;
    }
}
