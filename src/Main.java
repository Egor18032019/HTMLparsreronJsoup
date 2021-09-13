import java.util.TreeMap;


public class Main {
    private static final Logger log = new Logger();
     private static final String url = "https://www.simbirsoft.com/";
    private static HtmlTextBody textBody  ;
    private final static char[] DELIMITERS = {' ', ',', '.', '!', '?', '"', ';', ':', '[', ']', '(', ')', '\n', '\r', '\t'};

    public static void main(String[] args)  {
        textBody = new HtmlTextBody(GetSiteInFile.main(url, log));
log.setInLog("INFO we received the data and started analyzing the data");
        TreeMap<String, Integer> answer = GetUniqueWordsFromFile.main(DELIMITERS,textBody.getText());
        log.setInLog("INFO The end analyzing the data");

        answer.forEach((str, it) -> {
            System.out.println(str + "=" + it);
        });
        log.setInLog("INFO The data was output to the screen");
        System.out.println(log.getLog());
    }
}

