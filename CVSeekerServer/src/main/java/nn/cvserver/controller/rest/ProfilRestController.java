/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.controller.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import nn.cvserver.domen.Profil;
import nn.cvserver.domen.Segment;
import nn.cvserver.domen.Stavka;
import nn.cvserver.service.ProfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
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
@RequestMapping("/profil")
public class ProfilRestController {
    
    @Autowired
    private ProfilService profilService;                                        

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Object getAll() {
        List<Profil> list = profilService.findAll();
        try
        {
            return ResponseEntity.status(HttpStatus.OK).body(list);    
        }
         catch (Exception ex) {
            HttpHeaders hh = new HttpHeaders();
            hh.setContentType(MediaType.TEXT_PLAIN);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(hh).body("Cannot return profiles.");
        }
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public @ResponseBody Object get(@PathVariable Integer id) {
        Profil p = profilService.findByID(id);
        return ResponseEntity.status(HttpStatus.OK).body(p);
    }
    
    @RequestMapping(value = "/getK/{id}", method = RequestMethod.GET)
    public @ResponseBody Object getK(@PathVariable Integer id) {
        List<Profil> list = profilService.findByKorisnikID(id);
        try
        {
            return ResponseEntity.status(HttpStatus.OK).body(list);
        }  
         catch (Exception ex) {
            HttpHeaders hh = new HttpHeaders();
            hh.setContentType(MediaType.TEXT_PLAIN);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(hh).body("Cannot return clients profiles.");
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody Object delete(@PathVariable Integer id) {
        profilService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Object save(@RequestBody Profil p) {
        Profil profil = profilService.save(p);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(profil);
        }
        catch (Exception ex) {
            HttpHeaders hh = new HttpHeaders();
            hh.setContentType(MediaType.TEXT_PLAIN);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(hh).body("Cannot save profile changes.");
        }
        
    } 
    
    @RequestMapping(value = "/jasper/{id}", method = RequestMethod.GET, produces = "application/pdf") 
    public @ResponseBody Object vratiJasper(@PathVariable Integer id) throws JRException {
        try {
            Profil p = profilService.findByID(id);

            String sourceFileName = "C:\\Users\\SOLUNAC\\Desktop\\CVSeeker-master\\CVSeekerServer\\src\\main\\java\\nn\\cvserver\\jrxml\\report5.jrxml";
            JasperReport jasperReport = JasperCompileManager.compileReport(sourceFileName);
            Map<String,Object> params = new HashMap<String,Object>();
            params.put("param_profilid", p.getId());

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nn_nst_2018",  "root", "1111");
            JasperPrint reportPrint = JasperFillManager.fillReport(jasperReport, params, con);
            JasperExportManager.exportReportToPdfFile(reportPrint,"tmp.pdf");
            
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentLength(Files.size(Paths.get("tmp.pdf")));
            headers.add("Content-Disposition",  "inline; filename=tmp.pdf");
            headers.add("pragma", "public");
            
            String filePath = "tmp.pdf";
            InputStream inputStream = new FileInputStream(new File(filePath));
            InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
            return new ResponseEntity(inputStreamResource, headers, HttpStatus.OK);
            
        } catch (Exception ex) {
            Logger.getLogger(ProfilRestController.class.getName()).log(Level.SEVERE, null, ex);
            HttpHeaders hh = new HttpHeaders();
            hh.setContentType(MediaType.TEXT_PLAIN);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(hh).body("Cannot generate pdf.");
        }
    }
    
    
}
