import java.io.IOException;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;

/*
3 В качестве результата работы пользователь должен получить статистику по
количеству уникальных слов в тексте.
 */
public class Main {
    private static final Logger log = new Logger();
    private static final String path = "data/data.html";

    public static void main(String[] args) throws IOException {
        GetSiteInFile.main(log, path);
        TreeMap <String, Integer> answer = GetUniqueWordsFromFile.main(log, path);
//        System.out.println(answer.descendingKeySet());
//        System.out.println(answer.descendingMap());
//        System.out.println(answer.());
        SortedMap<String,Integer> sm = new ConcurrentSkipListMap<String,Integer>(answer);
        System.out.println(sm);
//        answer.forEach((str, it) -> {
//            System.out.println(str + "-" + it);
//        });
//        System.out.println("Iterate using KeySet: ");
//        for(String i: answer.keySet())
//            System.out.println(i + "=" + answer.get(i));
//    }
}}



/*
   mp.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey());
 */
/*
  SortedSet<Map.Entry<String, Integer>> sortedset = new TreeSet<>
                (Comparator.comparing(Map.Entry::getValue));
        sortedset.addAll(answer.entrySet());
         System.out.println(sortedset);
 */