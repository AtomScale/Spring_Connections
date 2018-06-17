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
            File directory = new File("A:\\AlMax\\Documents\\GitHub\\Softable\\NodeWebServer\\views\\img\\");

            File[] files = directory.listFiles();

            for (File file : files)

            {


                if (!file.delete())

                {

                    System.out.println("Failed to delete " + file);

                }
            }


        } catch (Exception e) {

        }

    }
}
