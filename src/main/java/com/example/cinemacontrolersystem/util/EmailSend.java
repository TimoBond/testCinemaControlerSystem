package com.example.cinemacontrolersystem.util;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSend {

    public static void send(String activationLink, String email){
        Properties properties =new Properties();
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port","587");
        properties.put("mail.smtp.socketFactory.fallback","false");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.ssl.enable","true");
        Session session =Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("tymonbyba@gmail.com","stiyryepnfeajkfc");
            }
        });

        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(new InternetAddress("tymonbyba@gmail.com"));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            mimeMessage.setSubject("hellllo");
            mimeMessage.setText(activationLink);
            Transport.send(mimeMessage);
        }catch (AddressException addressException){
            addressException.printStackTrace();
        }catch (MessagingException messagingException){
            messagingException.printStackTrace();
        }

    }
}
