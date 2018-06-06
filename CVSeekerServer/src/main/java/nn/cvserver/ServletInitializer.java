/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nn.cvserver;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 *
 * @author SOLUNAC
 */
public class ServletInitializer extends SpringBootServletInitializer {
     @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CVSeekerServer.class);
    }
}
