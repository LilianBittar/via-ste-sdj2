import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Log {
    private static Log log;
    private ArrayList<LogLine> logLines;
    //need a lock in order to create a synchronized block
    private static Object lock = new Object();

    private Log()
    {
        logLines = new ArrayList<>();
    }

    public static Log getInstance(){
        if (log == null){
            synchronized (lock)
            {
                if (log == null)
                {
                    log = new Log();
                }
            }
        }
        return log;
    }

    public void addLog(String text){
        logLines.add(new LogLine(text));
    }

    public ArrayList<LogLine> getAll(){
        return logLines;
    }

    @Override
    public String toString() {
        return "Log{" +
                "log=" + log +
                ", logLines=" + logLines +
                '}';
    }

    private void addToFile(LogLine log) {
        if (log == null) {
            return;
        }
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter("log", true));
            out.write(log + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
