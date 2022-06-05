package com.example.emailsystem.services;

import com.example.emailsystem.exceptions.EmailSystemException;
import com.example.emailsystem.models.MailBox;
import com.example.emailsystem.models.MailBoxes;
import com.example.emailsystem.models.Message;
import com.example.emailsystem.models.Type;
import com.example.emailsystem.repositories.MailBoxRepository;
import com.example.emailsystem.repositories.MailBoxesRepository;
import com.example.emailsystem.repositories.MessageRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@NoArgsConstructor

public class MailBoxesServiceImpl implements MailBoxesService{
    MailBoxesRepository mailBoxesRepository;
    @Autowired
    private MailBoxRepository mailBoxRepository;
    MessageRepository messageRepository;

    @Autowired
    public  MailBoxesServiceImpl( MailBoxesRepository mailBoxesRepository,MailBoxRepository mailBoxRepository,MessageRepository messageRepository){
        this.mailBoxesRepository = mailBoxesRepository;
        this.mailBoxRepository = mailBoxRepository;
        this.messageRepository = messageRepository;
    };
    @Override
    public MailBoxes createBoxes(String username) {
         MailBoxes mailBoxes = new MailBoxes(username);
         mailBoxRepository.saveAll(mailBoxes.getBoxes());
//        mailBoxes.getBoxes().add(new MailBox(Type.INBOX, new ArrayList<>(), username));
//        mailBoxes.getBoxes().add(new MailBox(Type.SENT, new ArrayList<>(), username));
        return mailBoxesRepository.save(mailBoxes);
    }

    @Override
    public MailBox retrieveInbox(String username) {

       return mailBoxRepository.findById(username).orElse(null);
    }

    @Override
    public MailBox retrieveSentBox(String username) {
        return mailBoxRepository.findById(username).orElse(null);
    }

    @Override
    public MailBoxes findMailBoxes(String username) {

        return mailBoxesRepository.findById(username).orElse(null);
    }

    @Override
    public void sendMessage(Message message) {

    }

    @Override
    public void deleteMailBoxes(MailBoxes mailBoxes) {
        MailBoxes mailBoxes1 = mailBoxesRepository.findById(mailBoxes.getUsername()).orElseThrow(() ->new EmailSystemException("Mailboxes not found"));
mailBoxesRepository.delete(mailBoxes1);
    }

    @Override
    public Message retrieveMessagesFromInbox(String username) {
        Message  message = messageRepository.findById(username).orElseThrow(()-> new EmailSystemException("messages not found"));
        return message;
    }




}
