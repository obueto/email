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
    public void sendMessage( MessageDto message, String username) {
//        EmailUser receiver = emailUserRepository.findEmailUserByUserName(username).orElseThrow(()-> new  EmailSystemException("user does not exist"));
       MailBox receiverMailBox = mailBoxRepository.findMailBoxByUserNameAndBoxType(message.getReceiver(), Type.INBOX);
        if (emailUserRepository.findEmailUserByUsername(message.getReceiver()).isPresent()){
            Message savedMessage = messageService.sendMessage(message,username);
          //  Notification notification = new Notification();
            receiverMailBox.getMessages().add(savedMessage);
            mailBoxRepository.save(receiverMailBox);
        }
        else
            throw new EmailSystemException("User does not exist");

//message.getReceiver()
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
        mailBox = mailBoxRepository.findMailBoxByUserName(mailBox.getName());
        mailBoxRepository.delete(mailBox);

    }

    @Override
    public void saveMessage(Message message) {



    }

    @Override
    public void sendMessage(String receiver, String body, String sender) {

    }

}
