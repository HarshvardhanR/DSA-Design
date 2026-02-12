package Implementations.NotificationDispatcherSystem.NotificationInterface;

import Implementations.NotificationDispatcherSystem.SimpleLogger;
import Implementations.NotificationDispatcherSystem.Enum.PriorityType;

public abstract class Notification {

    SimpleLogger logger;
    public String receiver;
    public String message;
    public PriorityType pt;

    abstract public void notifier();

    public String getReceiver(){
        return receiver;
    }

    public String getMessage(){
        return message;
    }

    public PriorityType getPriorityType(){
        return pt;
    }
}
