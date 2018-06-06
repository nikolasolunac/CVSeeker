/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.dao;

import nn.cvserver.domen.Sifarnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SOLUNAC
 */
@Repository
public interface SifarnikDAO extends JpaRepository <Sifarnik, Integer>{
    Sifarnik save (Sifarnik sifarnik);
}
