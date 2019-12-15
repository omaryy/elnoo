package eg.edu.alexu.csd.oop.game.Model.Logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
    private static Log logger;
    public Logger log;
    private Log()
    {
        log=Logger.getLogger("MyLog");
        try
        {
            System.setProperty("java.util.logging.SimpleFormatter.format",
                    "%1$tA %1$td %1$tB %1$tY %1$tH:%1$tM:%1$tS.%1$tL %tZ %4$s %2$s %5$s%6$s%n");
            FileHandler handler = new FileHandler("Logs"+System.getProperty("file.separator")+"MyLog%u.log", true);
            log.addHandler(handler);
            SimpleFormatter formatter = new SimpleFormatter();
            handler.setFormatter(formatter);
        }catch (
                IOException e)
        {
            /*new File("Logs").mkdir();
            new Logger();*/
            e.printStackTrace();
        }
    }
    public static Log getInstance() {

        if (Log.logger == null)
             Log.logger=new Log();

        return Log.logger;
    }

}
