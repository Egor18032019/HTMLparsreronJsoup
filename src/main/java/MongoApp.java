import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Collections;
import java.util.TreeMap;

public class MongoApp {
    private static final String MONGO_URL = "mongodb+srv://goro4:Qw222324@cluster0.j220x.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";

    public static void main(TreeMap<String, Integer> args) {

        MongoClient client = new MongoClient(new MongoClientURI(MONGO_URL));
        MongoDatabase database = client.getDatabase("simbirSoft");
        MongoCollection<Document> collection = database.getCollection("static");

        System.out.println("connected db");
        Document stat = new Document("stat",Collections.unmodifiableSortedMap(args));
        collection.insertOne(stat);
        System.out.println("send in db");
    }
}
