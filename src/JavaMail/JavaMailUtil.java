/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaMail;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author Stefan
 */
public class JavaMailUtil {
    
    public static void sendMail(String recepient) throws Exception{
        System.out.println("Preparing to send Email...");
        Properties properties = new Properties();
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myAccount = "scrum.teamxp@gmail.com";
        String password = "Planka123";
        
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccount, password);
            }
        });
        
        Message message = prepareMessage(session, myAccount, recepient);
        
        Transport.send(message);
        System.out.println("Message sent!");
    }
    
    private static Message prepareMessage(Session session, String myAccount, String recepient) {
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccount));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Hello world!");
            message.setText("Det fucking funkar!?, \n MASTERCODER HÄR!, \n MVH");
            return message;
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(JavaMailUtil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return null;
    }
}
