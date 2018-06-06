/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.service.impl;

import java.sql.Timestamp;
import java.util.List;
import nn.cvserver.dao.KorisnikDAO;
import nn.cvserver.dao.NotifikacijaDAO;
import nn.cvserver.dao.ProfilDAO;
import nn.cvserver.domen.Korisnik;
import nn.cvserver.domen.Notifikacija;
import nn.cvserver.domen.Profil;
import nn.cvserver.service.NotifikacijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SOLUNAC
 */
@Service
public class NotifikacijaServiceImpl implements NotifikacijaService{
    
    @Autowired
    private NotifikacijaDAO notifikacijaDAO;
    
    @Autowired
    private KorisnikDAO korisnikDAO;
    
    @Override
    public List<Notifikacija> findAll() {
        return notifikacijaDAO.findAll();
    }
    
    @Override
    public Notifikacija save(Notifikacija notifikacija) {
        if (notifikacija.getTimeStamp() == null)
        {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            notifikacija.setTimeStamp(timestamp);
        }
        return notifikacijaDAO.save(notifikacija);
    }

    @Override
    public List<Notifikacija> findByKorisnikID(Integer korisnikId) {
        Korisnik k = korisnikDAO.findOne(korisnikId);
        return notifikacijaDAO.findByKorisnikId(k.getId());
    }

    @Override
    public boolean validate(Notifikacija notifikacija) {  
         Notifikacija n = notifikacijaDAO.validate(notifikacija.getId());
         if (n == null)
         {  
             return false;
         }
         return true;
    }
    


}
