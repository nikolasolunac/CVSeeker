/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.service;

import java.util.List;
import nn.cvserver.domen.Korisnik;
import nn.cvserver.domen.Secretqstn;


/**
 *
 * @author SOLUNAC
 */
public interface KorisnikService {
    List<Korisnik> findAll();
    
    Korisnik login(String username, String password);
    
    Korisnik register(Korisnik korisnik);

    Korisnik findByUsername(String username);

    String authenticate(Korisnik korisnik) throws Exception;
    
    Korisnik passwordReset(Korisnik korisnik);
}
