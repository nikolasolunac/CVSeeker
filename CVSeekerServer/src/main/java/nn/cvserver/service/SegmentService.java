/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.service;

import java.util.List;
import nn.cvserver.domen.Segment;

/**
 *
 * @author SOLUNAC
 */
public interface SegmentService {
    
    List<Segment> findAll();

    void delete(Integer segmentId);

    Segment save(Segment segment);

    Segment findByID(Integer SegmentId);
    
}