package Implementations.Logger;

import java.text.SimpleDateFormat;
import java.util.*;

class Logger {
    private static volatile Logger instance;

    private List<String> logs;
    private int capacity;

    private Logger() {
        logs = new LinkedList<>();
        capacity = 10;
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public synchronized void log(String level, String message) {
        String timestamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
        String fullMessage = "[" + timestamp + "] [" + level.toUpperCase() + "] " + message;

        if (logs.size() >= capacity) {
            logs.remove(0);
        }
        logs.add(fullMessage);

        // print to console
        System.out.println(fullMessage);
    }

    public synchronized List<String> getLogs() {
        return new ArrayList<>(logs);
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
