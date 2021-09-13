import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.TreeMap;

public class GetUniqueWordsFromFile {

    public static TreeMap <String, Integer> main(Logger log, String path) {

        String htmlFile = parseFile(path, log);
         Document doc = Jsoup.parse(htmlFile);
        Elements elements = doc.select("div");
        String text = elements.text().trim().toUpperCase();
        String[] textSplit = text.replaceAll("[^a-zA-Zа-яёА-ЯЁ]", " ").split(" ");

        TreeMap<String, Integer> foo = new TreeMap<>(
        );

        int count;
        for (String value : textSplit) {
            count = 0;
            for (String s : textSplit) {
                if (value.equals(s)) {
                    count++;
                }
            }
            foo.put(value, count);
        }
        log.setInLog("Напиши  ");
//        foo.descendingMap();
        return foo;
    }

    /**
     * Получение данных из файла
     *
     * @param path путь к файлу
     * @return строку с данными
     */
    public static String parseFile(String path, Logger log) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
             lines.forEach(line -> builder.append(line).append("\n"));
        } catch (Exception e) {
            log.setInLog("Errors When reading the file " + path + "I received an error of the form" + e);
        }
        return builder.toString();
    }
}

