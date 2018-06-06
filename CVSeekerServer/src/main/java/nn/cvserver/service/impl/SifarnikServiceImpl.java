/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.service.impl;

import java.util.List;
import nn.cvserver.dao.SifarnikDAO;
import nn.cvserver.domen.Sifarnik;
import nn.cvserver.service.SifarnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SOLUNAC
 */
@Service
public class SifarnikServiceImpl implements SifarnikService {

    @Autowired
    private SifarnikDAO sifarnikDAO;
    
    @Override
    public List<Sifarnik> findAll() {
        return sifarnikDAO.findAll();
    }

    @Override
    public void delete(Integer id) {
        sifarnikDAO.delete(id);
    }

    @Override
    public Sifarnik save(Sifarnik sifarnik) {
        return sifarnikDAO.save(sifarnik);
    }
    
}
