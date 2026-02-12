package Implementations.NotificationDispatcherSystem;

import Implementations.NotificationDispatcherSystem.Enum.PriorityType;

public class SimpleLogger {

    public void log(String message, String receiver, PriorityType pt){
        if(pt==PriorityType.HIGH){
            System.out.println("[URGENT] Sending " + pt + " notification to " + receiver );
        }
        else{
            System.out.println("Sending " + pt + " notification to " + receiver);
        }
    }

}
