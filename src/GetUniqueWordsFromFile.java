import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.TreeMap;


// чтение файла и подсчет ? или в отдельный класс положить и из него читать ?
public class GetUniqueWordsFromFile {
    public static TreeMap <String, Integer> main(Logger log, String path,char[] delimiters) {

        String text = parseFile(path, log);

        TreeMap<String, Integer> foo = new TreeMap<>();

        char[] textmakeChar = text.toCharArray();

        int indexBegin = 0;
        for (int i = 0; i < textmakeChar.length; i++) {
//        Приложение разбивает текст страницы на отдельные слова с помощью
//        списка разделителей.
            for (char delimiter : delimiters) {
                //если разделитель и символ в тексте равны то вырезаем
                if (delimiter == textmakeChar[i]) {
                    String word = text.substring(indexBegin, i).toUpperCase();
                    indexBegin = i + 1;

                    if (word.length() == 0) continue; // убрать пробелы

                    if (!foo.containsKey(word)) {
                        foo.put(word, 1);
                    } else {
                        foo.put(word, foo.get(word) + 1);
                    }
                }
            }
        }
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

