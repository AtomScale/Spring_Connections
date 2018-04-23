package MongoDB_Objects.Connessioni;

import MongoDB_Objects.Dao.Modello_Dao;
import MongoDB_Objects.Oggetti.Modello;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class Modello_MongoDB implements Modello_Dao {
    ConnectionMongoDb connection;
    MongoCollection collection;

    public Modello_MongoDB() {
        this.connection = new ConnectionMongoDb();
        this.collection = this.connection.getMongoDatabase().getCollection("Modelli");
    }

    public boolean inserisciModello(Modello modello) {
        ObjectMapper mapper = new ObjectMapper();
        String json;

        try {
            if (this.getModello(modello.getId_modello()) == null) {
                json = mapper.writeValueAsString(modello);
                Document documento = Document.parse(json);
                collection.insertOne(documento);
                System.out.println("Modello inserito.");
                return true;
            } else {
                System.out.println("Questo modello è già stato inserito.");
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminaModello(Integer id_modello) {
        try {
            Document doc = (Document) this.collection.find(eq("id_modello", id_modello)).first();
            this.collection.findOneAndDelete(doc);
            System.out.println("Il modello e' stato eliminato.");
            return true;
        } catch (Exception e) {
            System.out.println("Il modello non esiste.");
            return false;
        }
    }

    public boolean setModello(Modello modello) {
        try {
            String json;
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(modello);
            Document documento = Document.parse(json);
            collection.findOneAndReplace(eq("id_modello", modello.getId_modello()),documento);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Modello getModello(Integer id_modello) {
        try {
            Document documento = (Document) collection.find(eq("id_modello", id_modello)).first();
            Modello modello = new Modello(documento.get("id_modello"),(String)documento.get("nome"), (ArrayList) documento.get("attributi"));
            return modello;
        } catch (Exception e) {
            return null;
        }
    }

    public HashMap<Integer,Modello> modelliCollection() {
        HashMap<Integer,Modello> modelli = new HashMap();
        List<Document> documents = (List<Document>) collection.find().into(new ArrayList<Document>());
        for(Document documento : documents){
            Modello modello = new Modello(documento.get("id_modello"),(String)documento.get("nome"), (ArrayList) documento.get("attributi"));
            modelli.put(modello.getId_modello(),modello);
        }
        return modelli;
    }
}
