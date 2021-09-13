import java.util.TreeMap;


// чтение файла и подсчет ? или в отдельный класс положить и из него читать ?
public class GetUniqueWordsFromFile {
    public static TreeMap <String, Integer> main( char[] delimiters,String text) {

        TreeMap<String, Integer> foo = new TreeMap<>();

        char[] textmakeChar = text.toCharArray();
        boolean isNum = false;
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
                    if (word.equals("—")) continue; // убрать тире
                    if (word.equals("-")) continue; // убрать минус
                    if (isNum = word.matches("[0-9]+[\\.]?[0-9]*")) continue; // убрать цифры

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

}

