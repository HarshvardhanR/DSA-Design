package Implementations.NotificationDispatcherSystem.NotificationDecorator;

import Implementations.NotificationDispatcherSystem.NotificationInterface.Notification;

public class RetryNotification extends NotificationDecorator {

    private final int attempts;

    public RetryNotification(Notification notification, int attempts) {
        super(notification);
        this.attempts = attempts;
    }

    @Override
    public void send() {
        for (int i = 1; i <= attempts; i++) {
            System.out.println("Attempt " + i);
            super.send();
        }
    }
}

