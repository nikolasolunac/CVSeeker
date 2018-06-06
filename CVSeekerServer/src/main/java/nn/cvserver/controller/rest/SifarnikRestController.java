/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.controller.rest;

import java.util.List;
import nn.cvserver.domen.Sifarnik;
import nn.cvserver.service.SifarnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author SOLUNAC
 */
@RestController
@RequestMapping("/sifarnik")
public class SifarnikRestController {
    
    @Autowired
    private SifarnikService sifarnikService;                                        

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Object getAll() {
        List<Sifarnik> list = sifarnikService.findAll();
        try
        {
            return ResponseEntity.status(HttpStatus.OK).body(list);    
        }
         catch (Exception ex) {
            HttpHeaders hh = new HttpHeaders();
            hh.setContentType(MediaType.TEXT_PLAIN);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(hh).body("Cannot return coded segments.");
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody Object delete(@PathVariable Integer id) {
        sifarnikService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Object save(@RequestBody Sifarnik s) {
        Sifarnik sifarnik = sifarnikService.save(s);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(sifarnik);
        }
        catch (Exception ex) {
            HttpHeaders hh = new HttpHeaders();
            hh.setContentType(MediaType.TEXT_PLAIN);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(hh).body("Cannot save coded segment changes.");
        }
        
    }
}
