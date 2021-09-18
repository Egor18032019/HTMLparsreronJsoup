import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

//получение данных и запись в файл
public class GetSiteInFile {
    private static Logger log = Logger.getLogger(GetSiteInFile.class.getName());
    static String contentTypeApp = "application/x-www-form-urlencoded";
    static String contentTypeText = "text/xml";
    private static final String CONTENT_TYPE = "Content-Type";


    public static String main(String url)   {

        String response =  getResponse(url);


        return response;
    }

    public static String getResponse(String url)   {
        String response = null;
        try {
            response = Jsoup.parse(Jsoup.connect(url).get().html()).body().text();
            log.info("INFO We made a get request and received the data whith " + url);

        } catch (IOException e) {
            LOGGER.log(Level.WARNING,"ERROR no can made GET" , e);
        }

        return response;
    }
}
