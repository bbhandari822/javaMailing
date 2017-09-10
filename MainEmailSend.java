
/**
 Created by IntelliJ IDEA.
 User: binodbhandari
 Date: 8/2/17
 Time: 6:08 PM
 To change this template use File | Settings | File Templates.
*/


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MainEmailSend {

    private static String emailSubject;
    private static String emailContent;
    private static String emailAddress;

    public static void main(String localHost, String portNumber, final String userName, final String password) throws MessagingException {

        Properties requiredItem = new Properties(); //constructor that creates a requiredItem object

        // Simple Mailing Transfer Protocol properties
        // properties is subclass of Hashtable which takes both key and value both as String
        requiredItem.put("mail.smtp.host", localHost);
        requiredItem.put("mail.smtp.port", portNumber);
        requiredItem.put("mail.smtp.auth", "true");
        requiredItem.put("mail.smtp.starttls.enable", "true");

        //Need to create default session object
        Session session = Session.getInstance(requiredItem);
        Message message = new MimeMessage(session); //create new email in every new session

        //Creating Authentication by importing class Authenticator.
        //Called when password authentication is required.
        javax.mail.Authenticator authenticator = new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return super.getPasswordAuthentication();
            }
        };

        message.setFrom(new InternetAddress(userName));
        message.setSubject(emailSubject);
        message.setText(emailContent);
        message.setSentDate(new Date());
        InternetAddress[] internetAddress = {new InternetAddress(emailAddress)};
        message.setRecipients(Message.RecipientType.TO, internetAddress);

        // extends service class which listens to connecting events and send emails
        //to the specified email addresses.
        Transport.send(message);
    }
}
