package Implementations.NotificationDispatcherSystem;

import Implementations.NotificationDispatcherSystem.Enum.PriorityType;
import Implementations.NotificationDispatcherSystem.NotificationDecorator.EncryptedNotification;
import Implementations.NotificationDispatcherSystem.NotificationDecorator.LoggingNotification;
import Implementations.NotificationDispatcherSystem.NotificationDecorator.PriorityNotification;
import Implementations.NotificationDispatcherSystem.NotificationDecorator.RetryNotification;
import Implementations.NotificationDispatcherSystem.NotificationFactory.NotificationFactory;
import Implementations.NotificationDispatcherSystem.NotificationInterface.Notification;

public class NDS {

    public static void main(String[] args) {

        Notification notification =
                NotificationFactory.createNotification("email", "harsh@email.com", "Server Down!");

        // Dynamically add behaviors
        notification = new PriorityNotification(notification, PriorityType.HIGH);
        notification = new LoggingNotification(notification);
        notification = new EncryptedNotification(notification);
        notification = new RetryNotification(notification, 2);

        notification.send();
    }
}
