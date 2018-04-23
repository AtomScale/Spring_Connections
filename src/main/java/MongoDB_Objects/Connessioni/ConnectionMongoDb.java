package MongoDB_Objects.Connessioni;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionMongoDb {
    MongoClient mongoClient;
    MongoDatabase mongoDatabase;
    final String Url = "mongodb://localhost:27017";
    final String Db = "SofTables";

    public ConnectionMongoDb(){
        try {
            Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
            mongoLogger.setLevel(Level.SEVERE);
            mongoClient = new MongoClient(new MongoClientURI(Url));
            mongoDatabase = mongoClient.getDatabase(Db);
            System.out.println("Instaurazione connessione al Database.");
        }catch(Exception e){
            System.err.println("Errore nella connessione a MongoDB.");
        }
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public MongoDatabase getMongoDatabase() {
        return mongoDatabase;
    }

    public void setMongoDatabase(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }
}
