/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.controller.rest;

import java.util.List;
import nn.cvserver.domen.Korisnik;
import nn.cvserver.domen.Notifikacija;
import nn.cvserver.domen.Secretqstn;
import nn.cvserver.service.NotifikacijaService;
import nn.cvserver.service.SecretQstnService;
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
@RequestMapping("/notify")
public class NotifikacijaController {
    
    @Autowired
    private NotifikacijaService notifikacijaService;
    
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Object getAll() {
        List<Notifikacija> list = notifikacijaService.findAll();
        try
        {
            return ResponseEntity.status(HttpStatus.OK).body(list);    
        }
         catch (Exception ex) {
            HttpHeaders hh = new HttpHeaders();
            hh.setContentType(MediaType.TEXT_PLAIN);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(hh).body("Cannot return notifications.");
        }
    }
    
    @RequestMapping(value = "/getK/{id}", method = RequestMethod.GET)
    public @ResponseBody Object getK(@PathVariable Integer id) {
        List<Notifikacija> list = notifikacijaService.findByKorisnikID(id);
        try
        {
            if (list.size() > 0)
            {
                return ResponseEntity.status(HttpStatus.OK).body(list);
            }
            else
            {
                HttpHeaders hh = new HttpHeaders();
                hh.setContentType(MediaType.TEXT_PLAIN);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(hh).body("No new notifications");
            }
        }  
         catch (Exception ex) {
            HttpHeaders hh = new HttpHeaders();
            hh.setContentType(MediaType.TEXT_PLAIN);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(hh).body("Cannot return user notifications.");
        }
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Object save(@RequestBody Notifikacija p) {
        Notifikacija notifikacija = notifikacijaService.save(p);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(notifikacija);
        }
        catch (Exception ex) {
            HttpHeaders hh = new HttpHeaders();
            hh.setContentType(MediaType.TEXT_PLAIN);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(hh).body("Cannot save notifications.");
        }
        
    }
    
    @RequestMapping(value = "/validate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Object validate(@RequestBody Notifikacija n) {
        try {
            if (notifikacijaService.validate(n))
            {
                return ResponseEntity.status(HttpStatus.OK).body("");
            }
            else
            {
                HttpHeaders hh = new HttpHeaders();
                hh.setContentType(MediaType.TEXT_PLAIN);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(hh).body("Cannot validate notification."); 
            }
        }
        catch (Exception ex) {
            HttpHeaders hh = new HttpHeaders();
            hh.setContentType(MediaType.TEXT_PLAIN);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(hh).body("Cannot validate notification.");
        }
        
    }
}
