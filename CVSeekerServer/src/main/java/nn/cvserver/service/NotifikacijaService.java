/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.service;

import java.util.List;
import nn.cvserver.domen.Notifikacija;


/**
 *
 * @author SOLUNAC
 */
public interface NotifikacijaService {
    
    List<Notifikacija> findAll();
    
    Notifikacija save(Notifikacija notifikacija);
    
    List<Notifikacija> findByKorisnikID(Integer korisnikId);
    
    boolean validate(Notifikacija notifikacija);
    
}
