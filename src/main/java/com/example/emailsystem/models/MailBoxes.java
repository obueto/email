package com.example.emailsystem.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document
@AllArgsConstructor
@NoArgsConstructor
public class MailBoxes {
    @Id
    private String username;
    private List<MailBox> boxes;


    public MailBoxes(String username) {
        this.username = username;
        if (this.boxes == null){
            this.boxes = new ArrayList<>();
        }
        boxes.add(new MailBox(Type.INBOX,new ArrayList<>(), username));
        boxes.add(new MailBox(Type.SENT,new ArrayList<>(), username));
    }
}



//    Message message = new MimeMessage(session);
//message.setFrom(new InternetAddress("from@gmail.com"));
//        message.setRecipients(
//        Message.RecipientType.TO, InternetAddress.parse("to@gmail.com"));
//        message.setSubject("Mail Subject");
//
//        String msg = "This is my first email using JavaMailer";
//
//        MimeBodyPart mimeBodyPart = new MimeBodyPart();
//        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");
//
//        Multipart multipart = new MimeMultipart();
//        multipart.addBodyPart(mimeBodyPart);
//
//        message.setContent(multipart);
//
//        Transport.send(message);