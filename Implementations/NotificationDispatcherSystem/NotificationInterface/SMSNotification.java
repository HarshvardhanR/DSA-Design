package Implementations.NotificationDispatcherSystem.NotificationInterface;

public class SMSNotification implements Notification {

    private final String receiver;
    private final String message;

    public SMSNotification(String receiver, String message) {
        this.receiver = receiver;
        this.message = message;
    }

    @Override
    public void send() {
        System.out.println("Sending SMS to " + receiver + " : " + message);
    }
}
