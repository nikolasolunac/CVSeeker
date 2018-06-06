/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.service.impl;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import nn.cvserver.dao.KorisnikDAO;
import nn.cvserver.dao.SecretQstnDAO;
import nn.cvserver.domen.Korisnik;
import nn.cvserver.domen.Secretqstn;
import nn.cvserver.service.SecretQstnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SOLUNAC
 */
@Service
public class SecretQstnImpl implements SecretQstnService{

    @Autowired
    private SecretQstnDAO secretqstnDAO;
    
    @Autowired
    private KorisnikDAO korisnikDAO;
    
    @Override
    public Secretqstn sqRegister() {  
        int max = 0;
        max  = secretqstnDAO.vratiBrojPitanja();
        Random rand = new Random();
        int randomNum = rand.nextInt(max)+1;
        
        return secretqstnDAO.sqRegister(randomNum); 
    }

    @Override
    public Secretqstn getUserSq(Korisnik k) {
        Korisnik userDB = korisnikDAO.findByUsername(k.getUsername());
        if (userDB != null)
        {
            return userDB.getQstnId();
        }
      return null;  
    }
    
}
