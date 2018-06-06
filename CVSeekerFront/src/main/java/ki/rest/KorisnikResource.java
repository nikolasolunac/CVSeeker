
package ki.rest;

import ki.domen.Korisnik;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

/**
 *
 * @author SOLUNAC
 */
public interface KorisnikResource {
    
    @Get
    public Korisnik retrieve();

    @Put
    public void store(Korisnik korisnik);

    @Delete
    public void remove();
}
