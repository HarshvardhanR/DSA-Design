package Implementations.NotificationDispatcherSystem.NotificationInterface;

import Implementations.NotificationDispatcherSystem.SimpleLogger;
import Implementations.NotificationDispatcherSystem.Enum.PriorityType;

public class SMSNotification extends Notification{
    
    public SMSNotification(String receiver, String message, PriorityType pt, SimpleLogger logger){
        this.receiver = receiver;
        this.message = message;
        this.pt = pt;
        this.logger = logger;
    } 

    public void notifier(){
        System.out.println("Sending " + message + " to" + receiver);
        logger.log(message, receiver, pt);
    }

}
