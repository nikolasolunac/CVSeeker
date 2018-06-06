/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.controller.rest;

import nn.cvserver.domen.Korisnik;
import nn.cvserver.domen.Secretqstn;
import nn.cvserver.service.SecretQstnService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/sq")
public class SecretQstnController {
    
    @Autowired
    private SecretQstnService secretQstnService;
    
    @RequestMapping(value = "/RandomOne", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Object getAll() {
        Secretqstn sq = secretQstnService.sqRegister();
        try
        {
            return ResponseEntity.status(HttpStatus.OK).body(sq);    
        }
         catch (Exception ex) {
            HttpHeaders hh = new HttpHeaders();
            hh.setContentType(MediaType.TEXT_PLAIN);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(hh).body("Cannot return secret question.");
        }
    }
    
    @RequestMapping(value = "/getUserSq", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Object getUserSq(@RequestBody Korisnik k) {
        Secretqstn sq = secretQstnService.getUserSq(k);
        try
        {
            return ResponseEntity.status(HttpStatus.OK).body(sq);    
        }
         catch (Exception ex) {
            HttpHeaders hh = new HttpHeaders();
            hh.setContentType(MediaType.TEXT_PLAIN);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(hh).body("Cannot return secret question for selected user.");
        }
    }
}
