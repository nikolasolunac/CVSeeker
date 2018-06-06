/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.security.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import nn.cvserver.security.service.TokenService;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author SOLUNAC
 */
@Component
public class TokenFilter extends OncePerRequestFilter{
    
    public static final String NN_HEADER_NAME = "NN-TOKEN";
    
    @Autowired TokenService tokenService; 

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain fc) throws ServletException, IOException {
        final HttpServletRequest httpRequest = (HttpServletRequest) request;

        if ((!"/login".equals(httpRequest.getRequestURI()))&&(!"/register".equals(httpRequest.getRequestURI()))
                &&(!"/passwordReset".equals(httpRequest.getRequestURI()))&&(!"/sq/getUserSq".equals(httpRequest.getRequestURI()))
                &&(!"/sq/getUserSq".equals(httpRequest.getRequestURI()))) {
            String token = httpRequest.getHeader(NN_HEADER_NAME);
            if (StringUtils.hasText(token)) {
                try {
                    Authentication authentication = tokenService.parseUserFromToken(token);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } catch (AccessDeniedException ade) {
                    AccessDeniedHandler acc = new AccessDeniedHandlerImpl();
                    acc.handle(request, response, ade);
                    return;
                }
            } else {
                SecurityContextHolder.getContext().setAuthentication(null);
            }
        }
        fc.doFilter(request, response);
    }
    
}
