/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.security.service;

import java.util.Collection;
import java.util.List;
import nn.cvserver.domen.Korisnik;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author SOLUNAC
 */
public class TokenUser implements Authentication{
    private final Korisnik korisnik;
    private boolean isAuth;
    private String token;
    private List<GrantedAuthority> grantedAuthorities;

    public TokenUser(Korisnik korisnik, List<GrantedAuthority> grantedAuthorities, String token) {
        super();
        this.korisnik = korisnik;
        this.grantedAuthorities = grantedAuthorities;
        this.token = token;
    }

    public boolean isIsAuth() {
        return isAuth;
    }

    public void setIsAuth(boolean isAuth) {
        this.isAuth = isAuth;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<GrantedAuthority> getGrantedAuthorities() {
        return grantedAuthorities;
    }

    public void setGrantedAuthorities(List<GrantedAuthority> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return korisnik;
    }

    @Override
    public boolean isAuthenticated() {
        return isAuth;
    }

    @Override
    public void setAuthenticated(boolean bln) throws IllegalArgumentException {
        this.isAuth = bln;
    }

    @Override
    public Object getPrincipal() {
        return korisnik.getIme();
    }

    @Override
    public String getName() {
        return korisnik.getPassword();
    }

   
}
