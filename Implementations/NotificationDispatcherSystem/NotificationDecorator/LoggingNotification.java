package Implementations.NotificationDispatcherSystem.NotificationDecorator;

import Implementations.NotificationDispatcherSystem.NotificationInterface.Notification;

public class LoggingNotification extends NotificationDecorator {

    public LoggingNotification(Notification notification) {
        super(notification);
    }

    @Override
    public void send() {
        System.out.println("Logging: Sending notification...");
        super.send();
    }
}
