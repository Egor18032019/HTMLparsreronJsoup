import java.io.IOException;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;


public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());
    static {
        try {
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("logging.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private static final MongoApp MongoDB = new MongoApp();
    private static final String url = "https://www.simbirsoft.com/";
    private final static char[] DELIMITERS = {' ', ',', '.', '!', '?', '"', ';', ':', '[', ']', '(', ')', '\n', '\r', '\t'};

    public static void main(String[] args) {
        HtmlTextBody textBody = new HtmlTextBody(GetSiteInFile.main(url));
        log.info("INFO we received the data and started analyzing the data");
        TreeMap<String, Integer> answer = GetUniqueWordsFromFile.main(DELIMITERS, textBody.getText());
        log.info("INFO The end analyzing the data");
        MongoDB.main(answer);
        answer.forEach((str, it) -> {
            System.out.println(str + "=" + it);
        });
        log.info("INFO The data was output to the screen");
        log.log(new LogRecord(Level.INFO, "All done"));
    }
}

