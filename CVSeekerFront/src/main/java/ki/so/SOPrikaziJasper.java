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
public class SOPrikaziJasper extends AbstractSO{
    public void izvrsi(Integer id)//vrati profil po id-ju
    {
        jsonRequest = ""; //super.ObjectToJSON(null);
        super.pozoviRestServis(jsonRequest, RestOperationEnum.PRIKAZI_JASPER.toString(),id);
        
    }
}
