/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.dao;

import java.util.List;
import nn.cvserver.domen.Korisnik;
import nn.cvserver.domen.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SOLUNAC
 */
@Repository
public interface ProfilDAO extends JpaRepository <Profil, Integer> {
    Profil save(Profil profil);
    
    @Query("SELECT p FROM Profil p WHERE p.korisnikId = ?1")
    List<Profil> findByKorisnikId(Korisnik korisnikId);
}
