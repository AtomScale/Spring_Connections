package ImageApp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.UnknownHostException;

import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

/**
 * Java MongoDB : Save image example
 *
 */

public class SaveImageApp {
    public static void main(String[] args) {

        try {
            String nome= "me.jpg";
            MongoClient mongoClient;
            MongoDatabase mongoDatabase;
            final String Url = "mongodb://Admin:Softable18!@softable-shard-00-00-ip3nr.mongodb.net:27017,softable-shard-00-01-ip3nr.mongodb.net:27017,softable-shard-00-02-ip3nr.mongodb.net:27017/test?ssl=true&replicaSet=Softable-shard-0&authSource=admin";
            final String Db = "Immagini";
            mongoClient = new MongoClient(new MongoClientURI(Url));
            mongoDatabase = mongoClient.getDatabase(Db);

            GridFSBucket gridBucket = GridFSBuckets.create(mongoDatabase);

            FileOutputStream fileOutputStream = new FileOutputStream("A:\\AlMax\\Documents\\GitHub\\Softable\\NodeWebServer\\views\\img\\"+nome);
            gridBucket.downloadToStream(nome, fileOutputStream);
            fileOutputStream.close();


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MongoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
