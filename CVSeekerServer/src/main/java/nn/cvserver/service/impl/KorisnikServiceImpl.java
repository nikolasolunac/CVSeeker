/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.service.impl;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import nn.cvserver.dao.KorisnikDAO;
import nn.cvserver.domen.Korisnik;
import nn.cvserver.domen.Secretqstn;
import nn.cvserver.service.KorisnikService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SOLUNAC
 */
@Service
public class KorisnikServiceImpl implements KorisnikService{

    @Autowired
    private KorisnikDAO korisnikDAO;
    
    @Override
    public Korisnik login(String username, String password) {
        return korisnikDAO.login(username, password);
    }
    
    @Override
    public Korisnik register(Korisnik korisnik) { 
        if(korisnikDAO.findByUsername(korisnik.getUsername()) != null)
        {
            return korisnikDAO.save(korisnik);
        }
        else
        {
           return null; 
        }
    }
    
    @Override
    public Korisnik findByUsername(String username) {
        return korisnikDAO.findByUsername(username);
    }

    @Override
    public String authenticate(Korisnik korisnik) throws Exception {
        Korisnik userDB = korisnikDAO.login(korisnik.getUsername(), korisnik.getPassword());
        if (userDB == null) {
            throw new Exception("Unknown user.");
        }
        String token = userDB.getUsername() + ":" + userDB.getIme() + ":" + LocalDateTime.now();
        return new String(Base64.encodeBase64(token.getBytes()));
    }

    @Override
    public Korisnik passwordReset(Korisnik korisnik) {
       Korisnik userDB = korisnikDAO.findByUsername(korisnik.getUsername());
           
       if ((userDB != null) && (userDB.getQstnAns().equals(korisnik.getQstnAns())))
       {
           userDB.setPassword(korisnik.getPassword());
           korisnik = korisnikDAO.save(userDB);
           return korisnik;
       }
       return null;
    }
    
    @Override
    public List<Korisnik> findAll() {
        return korisnikDAO.findAll();
    }

    
    
}
