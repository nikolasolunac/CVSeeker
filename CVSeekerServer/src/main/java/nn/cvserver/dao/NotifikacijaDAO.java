/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.dao;

import java.util.List;
import nn.cvserver.domen.Korisnik;
import nn.cvserver.domen.Notifikacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SOLUNAC
 */
@Repository
public interface NotifikacijaDAO extends JpaRepository <Notifikacija, Integer>{
    Notifikacija save(Notifikacija profil);
    
    @Query("SELECT n FROM Notifikacija n WHERE n.valsnikProfila = ?1 and n.flagPrikazana = 0")
    List<Notifikacija> findByKorisnikId(Integer kId);
    
    @Query("SELECT n FROM Notifikacija n WHERE n.id = ?1 and n.flagPrikazana = 1 and n.flagOdobreno = 1")
    Notifikacija validate(Integer id);
    
}
