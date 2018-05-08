package MongoDB_Objects.Connessioni;

import MongoDB_Objects.Dao.Tabelle_Dao;
import MongoDB_Objects.Oggetti.Tabella;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class Tabella_MongoDB implements Tabelle_Dao {
    ConnectionMongoDb connection;
    MongoCollection collection;

    public Tabella_MongoDB() {
        this.connection = new ConnectionMongoDb();
        this.collection = this.connection.getMongoDatabase().getCollection("Tabelle");
    }

    public boolean inserisciTabella(Tabella tabella) {
        ObjectMapper mapper = new ObjectMapper();
        String json;
        try {
            if (this.getTabella(tabella.getId_tabella()) == null) {
                if(tabella.getId_tabella().intValue()==0){
                    Integer max=0;
                    for(Integer key : tabelleCollection().keySet()){
                        if(key>max){
                            max = key;
                        }
                    }
                    tabella.setId_tabella(max+1);
                }
                json = mapper.writeValueAsString(tabella);
                Document documento = Document.parse(json);
                this.collection.insertOne(documento);
                return true;
            } else {
                return false;
            }
        } catch(Exception e){
            System.out.println(tabella.toString());
            System.out.println(e);
            return false;
        }
    }

    public boolean eliminaTabella(Integer id_tabella) {
        try {
            Document documento = (Document) this.collection.find(eq("id_tabella", id_tabella)).first();
            collection.findOneAndDelete(documento);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean setTabella(Tabella tabella) {
        try {
            String json;
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(tabella);
            Document documento = Document.parse(json);
            collection.findOneAndReplace(eq("id_tabella", tabella.getId_tabella()),documento);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Tabella getTabella(Integer id_tabella) {
        try {
            Document documento = (Document) collection.find(eq("id_tabella", id_tabella)).first();
            Tabella tabella = new Tabella((Integer)documento.get("id_tabella"),(String)documento.get("username_utente"),(Integer)documento.get("id_modelloTabella"),(ArrayList) documento.get("tabella"));
            return tabella;
        } catch (Exception e) {
            return null;
        }
    }

    public HashMap<Integer,Tabella> tabelleCollection() {
        HashMap<Integer,Tabella> tabelle = new HashMap();
        List<Document> documents = (List<Document>) collection.find().into(new ArrayList<Document>());
        for(Document documento : documents){
            Tabella tabella = new Tabella((Integer)documento.get("id_tabella"),(String)documento.get("username_utente"), (Integer)documento.get("id_modelloTabella"),(ArrayList) documento.get("tabella"));
            tabelle.put(tabella.getId_tabella(),tabella);
        }
        return tabelle;
    }
}