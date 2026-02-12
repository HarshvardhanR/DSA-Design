package Implementations.NotificationDispatcherSystem.NotificationFactory;

import Implementations.NotificationDispatcherSystem.NotificationInterface.EmailNotification;
import Implementations.NotificationDispatcherSystem.NotificationInterface.Notification;
import Implementations.NotificationDispatcherSystem.NotificationInterface.SMSNotification;

public class NotificationFactory {

    public static Notification createNotification(String type, String receiver, String message) {

        switch (type.toLowerCase()) {
            case "email":
                return new EmailNotification(receiver, message);
            case "sms":
                return new SMSNotification(receiver, message);
            default:
                throw new IllegalArgumentException("Invalid notification type");
        }
    }
}

