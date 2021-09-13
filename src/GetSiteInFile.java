import org.jsoup.Jsoup;

import java.io.IOException;

//получение данных и запись в файл
public class GetSiteInFile {
    static String contentTypeApp = "application/x-www-form-urlencoded";
    static String contentTypeText = "text/xml";
    private static final String CONTENT_TYPE = "Content-Type";


    public static String main(String url, Logger log)   {

        String response =  getResponse(url,log);

        System.out.println(log.getLog());
        return response;
    }

    public static String getResponse(String url, Logger log)   {
        String response = null;
        try {
            response = Jsoup.parse(Jsoup.connect(url).get().html()).body().text();
        } catch (IOException e) {
            log.setInLog("ERROR no can made GET "+e);
        }

        return response;
    }
}
