package Implementations.NotificationDispatcherSystem;

import java.util.Scanner;

import Implementations.NotificationDispatcherSystem.Enum.PriorityType;
import Implementations.NotificationDispatcherSystem.NotificationInterface.EmailNotification;
import Implementations.NotificationDispatcherSystem.NotificationInterface.Notification;
import Implementations.NotificationDispatcherSystem.NotificationInterface.SMSNotification;

public class NDS {
    public static void main(String arfs[]){
        SimpleLogger logger = new SimpleLogger();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Notification Service:");
        System.out.println("Type the message you want to send:");
        String message = sc.nextLine();
        System.out.println("Whats the priority: ");
        System.out.println("Please Choose the below Option:");
        System.out.println("1.LOW");
        System.out.println("2.MEDIUM");
        System.out.println("3.HIGH");

        int typeNumber = sc.nextInt();
        sc.nextLine();
        PriorityType pt = PriorityType.LOW;
        if(typeNumber==1){
            pt = PriorityType.LOW;
        }
        else if(typeNumber==2){
            pt = PriorityType.MEDIUM;
        }
        else{
            pt = PriorityType.HIGH;
        }

        System.out.println("Finally can you pass the receiver and what mode do you want to use");
        System.out.println("Choose the Mode: ");
        System.out.println("1.Email");
        System.out.println("2.SMS");

        int notiType = sc.nextInt();
        sc.nextLine();

        Notification notification = null;
        String email = "";
        String number = "";
        if(notiType==1){
            System.out.println("Please Enter the receiver's email");
            email = sc.nextLine();
            notification = new EmailNotification(email, message, pt, logger);
        }
        else{
            System.out.println("Please Enter the receiver's email");
            number = sc.nextLine();
            notification = new SMSNotification(number, message, pt, logger);
        }

        notification.notifier();

        System.out.println("Thank you for using the logger service");
    }
}
