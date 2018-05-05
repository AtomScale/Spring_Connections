package Spring.Controller;

import MongoDB_Objects.Connessioni.Modello_MongoDB;
import MongoDB_Objects.Oggetti.Modello;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/modello")
public class Modello_Controller {

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

    Modello_MongoDB mongoModel = new Modello_MongoDB();

    @RequestMapping(value = "/richiedi/{id_modello}", method = RequestMethod.GET)
    public Modello richiediModello(@PathVariable("id_modello") Integer id_modello) {
        return this.mongoModel.getModello(id_modello);
    }

    @RequestMapping(value = "/collezione", method = RequestMethod.GET)
    public HashMap<Integer, Modello> getModelli() {
        return mongoModel.modelliCollection();
    }

    @RequestMapping(value = "/inserisci", method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean inserisciModello(@RequestBody Modello modello) {
        return this.mongoModel.inserisciModello(modello);
    }

    @RequestMapping(value = "/modifica", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean modificaModello(@RequestBody Modello modelloModificato) {
        return this.mongoModel.setModello(modelloModificato);
    }

    @RequestMapping(value = "/elimina/{id_modello}", method = RequestMethod.GET)
    public boolean eliminaModello(@PathVariable("id_modello") Integer id_modello) {
        return this.mongoModel.eliminaModello(id_modello);
    }
}