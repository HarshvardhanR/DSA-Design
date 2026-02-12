package Implementations.NotificationDispatcherSystem.NotificationDecorator;

import Implementations.NotificationDispatcherSystem.Enum.PriorityType;
import Implementations.NotificationDispatcherSystem.NotificationInterface.Notification;

public class PriorityNotification extends NotificationDecorator {

    private final PriorityType priority;

    public PriorityNotification(Notification notification, PriorityType priority) {
        super(notification);
        this.priority = priority;
    }

    @Override
    public void send() {
        if (priority == PriorityType.HIGH) {
            System.out.println("[URGENT] High priority notification triggered!");
        }
        super.send();
    }
}

