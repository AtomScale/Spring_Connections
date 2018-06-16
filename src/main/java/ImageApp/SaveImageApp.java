package ImageApp;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
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
            MongoClient mongoClient;
            MongoDatabase mongoDatabase;
            final String Url = "mongodb://Admin:Softable18!@softable-shard-00-00-ip3nr.mongodb.net:27017,softable-shard-00-01-ip3nr.mongodb.net:27017,softable-shard-00-02-ip3nr.mongodb.net:27017/test?ssl=true&replicaSet=Softable-shard-0&authSource=admin";
            final String Db = "Softable";
            mongoClient = new MongoClient(new MongoClientURI(Url));
            mongoDatabase = mongoClient.getDatabase(Db);

            String newFileName = "image";

            File imageFile = new File("A:\\AlMax\\Pictures\\me.jpg");

            // create a "photo" namespace
            GridFS gfsPhoto = new GridFS(mongoClient.getDB("Immagini"));

            // get image file from local drive
            GridFSInputFile gfsFile = gfsPhoto.createFile(imageFile);

            // set a new filename for identify purpose
            gfsFile.setFilename(newFileName);

            // save the image file into mongoDB
            gfsFile.save();

            // print the result
            DBCursor cursor = gfsPhoto.getFileList();
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }

            // get image file by it's filename
            GridFSDBFile imageForOutput = gfsPhoto.findOne(newFileName);

            // save it into a new image file
            imageForOutput.writeTo("A:\\AlMax\\Pictures\\Scan\\me.jpg");



            System.out.println("Done"+imageForOutput);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MongoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
