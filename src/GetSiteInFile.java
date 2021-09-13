import org.jsoup.Jsoup;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

//получение данных и запись в файл
public class GetSiteInFile {
    static String contentTypeApp = "application/x-www-form-urlencoded";
    static String contentTypeText = "text/xml";
    private static final String CONTENT_TYPE = "Content-Type";


    public static String main(String url, Logger log, String path)   {

        String response =  getResponse(url,log);
        try {
            PrintWriter writer = new PrintWriter(path);
            writer.write(response.toString());
            log.setInLog("Get request and write in " + path);
            writer.flush();
            writer.close();
            System.out.println();

        }
       catch (FileNotFoundException e) {
           log.setInLog("ERROR no can wright in file " +path +e);
        }
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
