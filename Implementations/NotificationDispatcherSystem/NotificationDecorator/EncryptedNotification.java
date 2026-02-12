package Implementations.NotificationDispatcherSystem.NotificationDecorator;

import Implementations.NotificationDispatcherSystem.NotificationInterface.Notification;

public class EncryptedNotification extends NotificationDecorator {

    public EncryptedNotification(Notification notification) {
        super(notification);
    }

    @Override
    public void send() {
        System.out.println("Encrypting message...");
        super.send();
    }
}

