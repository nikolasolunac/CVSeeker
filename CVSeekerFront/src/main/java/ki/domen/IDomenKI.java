/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ki.domen;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.Serializable;

/**
 *
 * @author SOLUNAC
 */
/*@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,
              include = JsonTypeInfo.As.PROPERTY,
              property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Korisnik.class),
    @JsonSubTypes.Type(value = Profil.class),
    @JsonSubTypes.Type(value = Segment.class),
    @JsonSubTypes.Type(value = Stavka.class),
    @JsonSubTypes.Type(value = Rola.class),
    @JsonSubTypes.Type(value = Secretqstn.class),
    
    })*/
public interface IDomenKI extends Serializable{
    
   
       
}
