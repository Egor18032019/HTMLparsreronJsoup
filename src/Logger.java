import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;


public class Logger {
    private final LinkedList<String> log = new LinkedList<String>();;


    public void setInLog(String message) {
       log.add(message);
       wrightTextLog(message);
    }

    public  LinkedList <String> getLog() {
        return log;
    }

    public void wrightTextLog(String text){
        try(FileWriter writer = new FileWriter("log.txt", true))
        {
            Date dateNow = new Date();
            writer.write("["+dateNow.toString()+"]" +text);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
