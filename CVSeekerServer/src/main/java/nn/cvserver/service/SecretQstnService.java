/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.service;

import nn.cvserver.domen.Korisnik;
import nn.cvserver.domen.Secretqstn;

/**
 *
 * @author SOLUNAC
 */
public interface SecretQstnService {
    Secretqstn sqRegister();
    
    Secretqstn getUserSq(Korisnik k);
}
