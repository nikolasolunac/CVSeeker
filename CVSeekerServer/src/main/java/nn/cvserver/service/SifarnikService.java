/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.service;

import java.util.List;
import nn.cvserver.domen.Sifarnik;

/**
 *
 * @author SOLUNAC
 */
public interface SifarnikService {
    
    List<Sifarnik> findAll();

    void delete(Integer id);

    Sifarnik save(Sifarnik sifarnik);
}
