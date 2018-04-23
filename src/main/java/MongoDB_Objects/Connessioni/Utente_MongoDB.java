package MongoDB_Objects.Connessioni;

import MongoDB_Objects.Dao.Utente_Dao;
import MongoDB_Objects.Oggetti.Utente;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Utente_MongoDB implements Utente_Dao {
    ConnectionMongoDb connection;
    MongoCollection collection;

    public Utente_MongoDB() {
        this.connection = new ConnectionMongoDb();
        this.collection = this.connection.getMongoDatabase().getCollection("Utenti");
    }

    public boolean inserisciUtente(Utente utente) {
        ObjectMapper mapper = new ObjectMapper();
        String json;

        try {
            if (this.getUtente(utente.getUsername()) == null) {
                json = mapper.writeValueAsString(utente);
                Document documeto = Document.parse(json);
                this.collection.insertOne(documeto);
                System.out.println("Utente inserito.");
                return true;
            } else {
                System.out.println("L'utente è già stato inserito.");
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminaUtente(String username) {
        try {
            Document documento = (Document) this.collection.find(eq("username", username)).first();
            this.collection.deleteOne(documento);
            System.out.println("L'utente e' stato eliminato.");
            return true;
        } catch (Exception e) {
            System.out.println("L'utente non esiste.");
            return false;
        }
    }

    public boolean setUtente(Utente utente) {
        try {
            String json;
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(utente);
            Document documento = Document.parse(json);
            this.collection.findOneAndReplace(eq("username", utente.getUsername()),documento);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Utente getUtente(String username) {
        try {
            Document documento = (Document) collection.find(eq("username", username)).first();
            Utente utente = new Utente((String) documento.get("username"),(String) documento.get("nome"),(String) documento.get("cognome"),(String)documento.get("email"),(String)documento.get("password"));
            return utente;
        } catch (Exception e) {
            return null;
        }
    }

    public HashMap<String, Utente> utentiCollection() {
        HashMap<String,Utente> utenti = new HashMap();
        List<Document> documents = (List<Document>) collection.find().into(new ArrayList<Document>());
        for(Document documento : documents){
            Utente utente = new Utente((String) documento.get("username"),(String) documento.get("nome"),(String) documento.get("cognome"),(String)documento.get("email"),(String)documento.get("password"));
            utenti.put(utente.getUsername(),utente);
        }
        return utenti;
    }
}
