/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ki.so;

import ki.domen.IDomenKI;
import ki.rest.RestOperationEnum;

/**
 *
 * @author P
 */
public class SOTajnoPitanje extends AbstractSO{
    public IDomenKI izvrsi()//vrati profil po id-ju
    {
        jsonRequest = ""; //super.ObjectToJSON(null);
        jsonResponse = super.pozoviRestServis(jsonRequest, RestOperationEnum.TAJNOPITANJE_VRATIRANDOM.toString(),0);
        
        if (!jsonResponse.equals("Cannot return secret question.") && (!jsonResponse.equals("Greška prilikom poziva RestCaller-a")))
        {
            IDomenKI s = super.JSONToTajnoPitanje(jsonResponse);
            return s;
        }
        
        return null;
    }
    
}
