import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;


public class Logger {
    private final LinkedList<String> log = new LinkedList<String>();

    public void setInLog(String message) {
        Date dateNow = new Date();
        String text = "[" + dateNow.toString() + "] " + message;
        log.add(text);
        wrightTextLog(text);
    }

    public LinkedList<String> getLog() {
        return log;
    }

    public void wrightTextLog(String text) {
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            Date dateNow = new Date();
            String textError = "[" + dateNow.toString() + "] Error " + ex;
            log.add(textError);
         }
    }
}
