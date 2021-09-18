import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;
import java.util.TreeMap;

public class MongoApp {
    private static final String MONGO_URL = getKeyFromFile();

    public static void main(TreeMap<String, Integer> args) {
        MongoClient client = new MongoClient(new MongoClientURI(MONGO_URL));
        MongoDatabase database = client.getDatabase("simbirSoft");
        MongoCollection<Document> collection = database.getCollection("static");

        System.out.println("connected db");
        Document stat = new Document("name", "statistics");
        stat.put("stat", Collections.unmodifiableSortedMap(args));
        Document isFounded = collection.find(Filters.eq("name", "statistics")).first();
        if (isFounded == null) {
            collection.insertOne(stat);
        } else {
            collection.updateOne(Filters.eq("name", "statistics"), new Document("$set", Collections.unmodifiableSortedMap(args)));
        }
        System.out.println("send in db");
    }

    /**
     * Получение ключ для монго из properti файла
     *
     * @return строку с данными
     */
    public static String getKeyFromFile() {
        FileInputStream fis = null;
        Properties property = new Properties();
        String path = "src/main/resources/config.properties";
        try {
            fis = new FileInputStream(path);
            property.load(fis);

            String key = property.getProperty("mongoDB");

            System.out.println("Key find ! ");
            fis.close();
            return key;
        } catch (IOException e) {
            System.err.println("Error: no can find properties file!");
        }

        return null;
    }
}

