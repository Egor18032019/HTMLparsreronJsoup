import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class GetSiteInFile {
    static String contentTypeApp = "application/x-www-form-urlencoded";
    static String contentTypeText = "text/xml";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String url = "https://www.simbirsoft.com/";



    public static void main(Logger log, String path) throws IOException {
        try {
            URL myUrl = new URL(url);
            GetSiteInFile parser = new GetSiteInFile();
            Object response =  getResponse(myUrl,log);
            // Сохранять в файл или тут разбирать ?
            PrintWriter writer = new PrintWriter(path);
            writer.write(String.valueOf(response));
            log.setInLog("Get request and write in " + path);

            System.out.println();
            System.out.println(log.getLog());
        }
       catch (MalformedURLException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Object getResponse(URL myUrl, Logger log) throws IOException {
        Document response = Jsoup.connect(url).get();
//        try {
//            HttpURLConnection connection = (HttpURLConnection) myUrl.openConnection();
//            log.setInLog("made GET on " + url);
//            connection.setRequestProperty(CONTENT_TYPE, contentTypeText);
//            connection.setConnectTimeout(10000);
//            connection.setRequestMethod("GET");
//
//            if (connection.getResponseCode() != 200) {
//                System.err.println("connection failed");
//                return null;
//            }
//
//            try
//                    (
//                            BufferedReader reader = new BufferedReader(
//                                    new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
//                Object response = Optional.of(reader.lines().collect(Collectors.joining(System.lineSeparator()))
//                );
//                log.setInLog("read request on " + url);
//                connection.disconnect();
//                log.setInLog("close connection on " + url);
//                return response;
//            }
//        } catch (IOException e) {
//            log.setInLog("Errors " + e);
//        }
        return response;
    }
}
