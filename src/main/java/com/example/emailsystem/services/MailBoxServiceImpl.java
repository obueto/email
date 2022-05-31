package com.example.emailsystem.services;

import com.example.emailsystem.dtos.MessageDto;
import com.example.emailsystem.dtos.MessageResponseDto;
import com.example.emailsystem.exceptions.EmailSystemException;
import com.example.emailsystem.models.*;
import com.example.emailsystem.repositories.EmailUserRepository;
import com.example.emailsystem.repositories.MailBoxRepository;
import com.example.emailsystem.repositories.MailBoxesRepository;
import com.example.emailsystem.repositories.MessageRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MailBoxServiceImpl implements MailBoxService {

@Autowired
    private MailBoxRepository mailBoxRepository;
@Autowired
    private EmailUserRepository emailUserRepository;

    private MessageRepository messageRepository;

    private MessageService messageService;

@Autowired
    public MailBoxServiceImpl(MessageService messageService){this.messageService = messageService;}


    @Override
    public void sendMessage( Message message) {
        EmailUser receiver = emailUserRepository.findEmailUserByUsername(message.getReceiver()).orElseThrow(()-> new  EmailSystemException("user does not exist"));
        MailBox receiverMailBox = mailBoxRepository.findMailBoxByUsername(receiver.getUsername());
        receiverMailBox.getMessages().add(message);
       // Message message1 = messageRepository.save(message);
        receiverMailBox.setBoxType(Type.INBOX);
        mailBoxRepository.save(receiverMailBox);

    }

    @Override
    public void createMailBox(MailBoxes mailBoxes) {
        for (MailBox box:mailBoxes.getBoxes()) {
        messageService.createMessage(box);
        mailBoxRepository.save(box);
        }
    }


    @Override
    public void deleteMailBox(MailBox mailBox) {
        mailBox = mailBoxRepository.findMailBoxByUsername(mailBox.getUsername());
        mailBoxRepository.delete(mailBox);

    }

    @Override
    public void saveMessage(Message message) {



    }

    @Override
    public void sendMessage(String receiver, String body, String sender) {

    }
}
