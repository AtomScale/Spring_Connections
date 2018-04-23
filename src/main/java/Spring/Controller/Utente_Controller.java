package Spring.Controller;

import MongoDB_Objects.Connessioni.Utente_MongoDB;
import MongoDB_Objects.Oggetti.Utente;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.HashMap;

@RestController
@CrossOrigin (origins = "http://localhost:3000")
@RequestMapping(value = "/utente")

public class Utente_Controller {

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

    Utente_MongoDB mongoUser = new Utente_MongoDB();

    @RequestMapping(value = "/richiedi/{username}", method = RequestMethod.GET)
    public Utente richiediUtente(@PathVariable("username") String username) {
        return this.mongoUser.getUtente(username);
    }

    @RequestMapping(value = "/collezione", method = RequestMethod.GET)
    public HashMap<String, Utente> getUtenti() {
        return mongoUser.utentiCollection();
    }

    @RequestMapping(value = "/inserisci", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean inserisciUtente(@RequestBody Utente utente) {
        return this.mongoUser.inserisciUtente(utente);
    }

    @RequestMapping(value = "/modifica", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean modificaUtente(@RequestBody Utente utente) {
        return this.mongoUser.setUtente(utente);
    }

    @RequestMapping(value = "/elimina/{username}", method = RequestMethod.GET)
    public boolean eliminaUtente(@PathVariable ("username") String username) {
        return this.mongoUser.eliminaUtente(username);
    }
}