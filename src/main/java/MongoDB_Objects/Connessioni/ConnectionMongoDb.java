package MongoDB_Objects.Connessioni;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionMongoDb {
    MongoClient mongoClient;
    MongoDatabase mongoDatabase;
    final String Url = "mongodb://Admin:Softable18!@softable-shard-00-00-ip3nr.mongodb.net:27017,softable-shard-00-01-ip3nr.mongodb.net:27017,softable-shard-00-02-ip3nr.mongodb.net:27017/test?ssl=true&replicaSet=Softable-shard-0&authSource=admin";
    final String Db = "Softable";

    public ConnectionMongoDb(){
        try {
            Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
            mongoLogger.setLevel(Level.SEVERE);
            mongoClient = new MongoClient(new MongoClientURI(Url));
            mongoDatabase = mongoClient.getDatabase(Db);
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
