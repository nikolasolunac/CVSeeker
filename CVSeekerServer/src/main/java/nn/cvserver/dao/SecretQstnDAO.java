/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.dao;


import nn.cvserver.domen.Secretqstn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author SOLUNAC
 */
@Service
public interface SecretQstnDAO extends JpaRepository <Secretqstn, Integer>{
    
    @Query("SELECT COUNT(*) FROM Secretqstn")
    Integer vratiBrojPitanja();
    
    @Query(value = "SELECT s FROM Secretqstn s WHERE s.id = ?1")
    Secretqstn sqRegister(Integer id);
}
