/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver.security.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

/**
 *
 * @author SOLUNAC
 */
@Component
public class CORSFilter implements Filter{
    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpresponse = (HttpServletResponse) res;
        HttpServletRequest httpRequest = (HttpServletRequest) req;

        httpresponse.setHeader("Access-Control-Allow-Origin", "*"); //Parametrizacjija otvorena 
        httpresponse.setHeader("Access-Control-Allow-Methods", "PUT, POST, GET, OPTIONS, DELETE");
        httpresponse.setHeader("Access-Control-Max-Age", "3600");
        httpresponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, NN-TOKEN, Content-Disposition");
        httpresponse.setHeader("Access-Control-Expose-Headers", "NN-TOKEN");

        if (!"OPTIONS".equals(httpRequest.getMethod())) {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {
    }
}
