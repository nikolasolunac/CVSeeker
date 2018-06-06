/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.controller.rest;

import java.util.List;
import nn.cvserver.domen.Korisnik;
import nn.cvserver.service.KorisnikService;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
public class KorisnikRestController {

    @Autowired
    private KorisnikService korisnikService;

  
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody
    Object login(@RequestBody Korisnik korisnik) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(korisnikService.authenticate(korisnik));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unknown user.");
        }
    }
    
    @RequestMapping(value = "/findByUsername", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Object findByUsername(@RequestBody Korisnik korisnik) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(korisnikService.findByUsername(korisnik.getUsername()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unknown user.");
        }
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Object register(@RequestBody Korisnik korisnik) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(korisnikService.register(korisnik));
        }
        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot register user.");
        }
    }
    
    @RequestMapping(value = "/passwordReset", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Object passwordReset(@RequestBody Korisnik korisnik) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(korisnikService.passwordReset(korisnik));
        }
        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot reset user password.");
        }
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Object getAll() {
        List<Korisnik> list = korisnikService.findAll();
        try
        {
            return ResponseEntity.status(HttpStatus.OK).body(list);    
        }
         catch (Exception ex) {
            HttpHeaders hh = new HttpHeaders();
            hh.setContentType(MediaType.TEXT_PLAIN);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(hh).body("Cannot return users.");
        }
    }
    
    
}
