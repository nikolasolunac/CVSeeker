/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.service;

import java.util.List;
import nn.cvserver.domen.Stavka;

/**
 *
 * @author SOLUNAC
 */
public interface StavkaService {
    
    List<Stavka> findAll();

    void delete(Integer segmentId);

    Stavka save(Stavka segment);

    Stavka findByID(Integer SegmentId);
    
}