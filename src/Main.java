import java.io.IOException;
import java.util.TreeMap;

/*
3 В качестве результата работы пользователь должен получить статистику по
количеству уникальных слов в тексте.
 */
public class Main {
    private static final Logger log = new Logger();
    private static final String path = "data/data.text";
    private static final String url = "https://www.simbirsoft.com/";
    private static HtmlTextBody textBody  ;
    private final static char[] DELIMITERS = {' ', ',', '.', '!', '?', '"', ';', ':', '[', ']', '(', ')', '\n', '\r', '\t'};

    public static void main(String[] args) throws IOException {
        textBody = new HtmlTextBody(GetSiteInFile.main(url, log));

        TreeMap<String, Integer> answer = GetUniqueWordsFromFile.main(DELIMITERS,textBody.getText());

        answer.forEach((str, it) -> {
            System.out.println(str + "=" + it);
        });

    }
}

