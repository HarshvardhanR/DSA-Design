package Implementations.Logger;

public class LoggerDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.setCapacity(5);

        logger.log("INFO", "Application started");
        logger.log("DEBUG", "Loading configuration");
        logger.log("ERROR", "Failed to connect to DB");
        logger.log("INFO", "User login success");
        logger.log("DEBUG", "Cache initialized");
        logger.log("INFO", "Application ready");
        

        System.out.println("\nLog History:");
        for (String log : logger.getLogs()) {
            System.out.println(log);
        }
    }
}