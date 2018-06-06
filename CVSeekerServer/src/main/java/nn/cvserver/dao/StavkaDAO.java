/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.dao;

import nn.cvserver.domen.Stavka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SOLUNAC
 */
@Repository
public interface StavkaDAO extends JpaRepository <Stavka, Integer> {
    Stavka save(Stavka segment);
}
