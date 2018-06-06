/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.service.impl;

import java.util.List;
import nn.cvserver.dao.KorisnikDAO;
import nn.cvserver.dao.ProfilDAO;
import nn.cvserver.domen.Korisnik;
import nn.cvserver.domen.Profil;
import nn.cvserver.service.ProfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SOLUNAC
 */
@Service
public class ProfilServiceImpl implements ProfilService {
    
    @Autowired
    private ProfilDAO profilDAO;
    
    @Autowired
    private KorisnikDAO korisnikDAO;

    @Override
    public List<Profil> findAll() {
        return profilDAO.findAll();
    }

    @Override
    public void delete(Integer profilId) {
        profilDAO.delete(profilId);
    }

    @Override
    public Profil save(Profil profil) {
        
        return profilDAO.save(profil);
    }

    @Override
    public Profil findByID(Integer profilID) {
        return profilDAO.findOne(profilID);
    }

    @Override
    public List<Profil> findByKorisnikID(Integer korisnikId) {
        Korisnik k = korisnikDAO.findOne(korisnikId);
        return profilDAO.findByKorisnikId(k);
    }
    
}
