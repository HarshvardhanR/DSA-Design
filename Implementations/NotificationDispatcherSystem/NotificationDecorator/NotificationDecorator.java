package Implementations.NotificationDispatcherSystem.NotificationDecorator;

import Implementations.NotificationDispatcherSystem.NotificationInterface.Notification;

public abstract class NotificationDecorator implements Notification {

    protected Notification notification;

    public NotificationDecorator(Notification notification) {
        this.notification = notification;
    }

    @Override
    public void send() {
        notification.send();
    }
}
