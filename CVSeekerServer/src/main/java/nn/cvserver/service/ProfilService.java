/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.service;

import java.util.List;
import nn.cvserver.domen.Profil;

/**
 *
 * @author SOLUNAC
 */
public interface ProfilService {
    
    List<Profil> findAll();

    void delete(Integer profilId);

    Profil save(Profil profil);

    Profil findByID(Integer profilID);
    
    List<Profil> findByKorisnikID(Integer korisnikId);
    
}
