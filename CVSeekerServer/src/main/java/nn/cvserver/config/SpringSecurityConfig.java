/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.config;

import nn.cvserver.security.filter.CORSFilter;
import nn.cvserver.security.filter.TokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author SOLUNAC
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private TokenFilter tokenFilter;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //Ovde potrebna izmena kako nama treba sesija
                .and()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/jasper").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/passwordReset").permitAll()
                .antMatchers("/sq/**").permitAll()
                .antMatchers("/profil/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new CORSFilter(), ChannelProcessingFilter.class)
                .addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);

    }
    
}
