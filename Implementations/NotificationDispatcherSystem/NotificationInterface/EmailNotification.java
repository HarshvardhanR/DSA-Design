package Implementations.NotificationDispatcherSystem.NotificationInterface;

public class EmailNotification implements Notification {

    private final String receiver;
    private final String message;

    public EmailNotification(String receiver, String message) {
        this.receiver = receiver;
        this.message = message;
    }

    @Override
    public void send() {
        System.out.println("Sending Email to " + receiver + " : " + message);
    }
}
