/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.dao;

import nn.cvserver.domen.Korisnik;
import nn.cvserver.domen.Secretqstn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SOLUNAC
 */
@Repository
public interface KorisnikDAO extends JpaRepository<Korisnik, Integer> {
    
    @Query("SELECT k FROM Korisnik k WHERE k.username = ?1 AND k.password = ?2")
    Korisnik login(String username, String password);
    
    Korisnik save(Korisnik korisnik);
   
    @Query("SELECT k FROM Korisnik k WHERE k.username = ?1")
    Korisnik findByUsername(String username);
    
    

}
