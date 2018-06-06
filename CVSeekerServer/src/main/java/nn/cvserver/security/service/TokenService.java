/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.security.service;

import java.util.ArrayList;
import java.util.List;
import nn.cvserver.domen.Korisnik;
import nn.cvserver.domen.enumtype.UserRoleEnum;
import nn.cvserver.service.KorisnikService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

/**
 *
 * @author SOLUNAC
 */
@Service
public class TokenService {
    
    @Autowired
    private KorisnikService korisnikService;

    public String createTokenForUser(Korisnik korisnik) throws Exception {
        return korisnikService.authenticate(korisnik);
    }

    public Authentication parseUserFromToken(String token) {
        try {
            String decoded = new String(Base64.decodeBase64(token));
            String username = decoded.substring(0, decoded.indexOf(":"));
            Korisnik korisnik = korisnikService.findByUsername(username);
            List<GrantedAuthority> lg = new ArrayList<>();
            for (UserRoleEnum r : UserRoleEnum.values()) {
                if(r.name().equals(korisnik.getRolaId().getNaziv()))
                      lg.add(new SimpleGrantedAuthority(r.name()));
            }
            TokenUser tu = new TokenUser(korisnik, lg, token);
            tu.setAuthenticated(true);
            return tu;
        } catch (Exception ex) {
            throw new AccessDeniedException(ex.getMessage(), ex);
        }
    }

    public Korisnik getUserFromSpringAuthentication(Authentication authentication) {
        try {
            String currentPrincipalName = authentication.getName();
            return korisnikService.findByUsername(currentPrincipalName);
        } catch (Exception ex) {
            throw new AccessDeniedException(ex.getMessage(), ex);
        }
    }
    
}
