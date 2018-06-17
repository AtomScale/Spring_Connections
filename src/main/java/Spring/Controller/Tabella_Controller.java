package Spring.Controller;

import MongoDB_Objects.Connessioni.Tabella_MongoDB;
import MongoDB_Objects.Oggetti.Tabella;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/tabella")
public class Tabella_Controller {

    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }

    Tabella_MongoDB mongoTable = new Tabella_MongoDB();

    @RequestMapping(value = "/richiedi/{id_tabella}", method = RequestMethod.GET)
    public Tabella richiediTabella(@PathVariable("id_tabella") Integer id_tabella) {
        return this.mongoTable.getTabella(id_tabella);
    }

    @RequestMapping(value = "/collezione", method = RequestMethod.GET)
    public HashMap<Integer, Tabella> getTabelle() {
        return mongoTable.tabelleCollection();
    }

    @RequestMapping(value = "/inserisci", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean inserisciTabella(@RequestBody Tabella tabella) {
        return this.mongoTable.inserisciTabella(tabella);
    }

    @RequestMapping(value = "/modifica", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean modificaTabella(@RequestBody Tabella tabellaModificata) {
        return this.mongoTable.setTabella(tabellaModificata);
    }

    @RequestMapping(value = "/elimina/{id_tabella}", method = RequestMethod.GET)
    public boolean eliminaTabella(@PathVariable("id_tabella") Integer id_tabella) {
        return this.mongoTable.eliminaTabella(id_tabella);
    }

    @RequestMapping(value = "/tabelle_utente/{username}", method = RequestMethod.GET)
    public ArrayList<Integer> id_tabelle_utenteSpecifico(@PathVariable("username") String username) {
        return this.mongoTable.id_tabelle_utenteSpecifico(username);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean aggiungiFile(@RequestBody String nome) {
        return this.mongoTable.aggiungiFile(nome);
    }

    @RequestMapping(value = "/richiediFile/{nome}", method = RequestMethod.GET)
    public boolean riceviFile(@PathVariable("nome") String nome) {
        return this.mongoTable.riceviFile(nome);
    }

    @RequestMapping(value = "/eliminaTuttiFile", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean eliminaTutto() {
        return this.mongoTable.eliminaTutto();
    }
}