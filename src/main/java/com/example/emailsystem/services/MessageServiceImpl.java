package com.example.emailsystem.services;

import com.example.emailsystem.dtos.MessageDto;
import com.example.emailsystem.models.MailBox;
import com.example.emailsystem.models.MailBoxes;
import com.example.emailsystem.models.Message;
import com.example.emailsystem.models.Notification;
import com.example.emailsystem.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageServiceImpl implements  MessageService{

    @Autowired
    private MessageRepository messageRepository;

//
//    @Autowired
//    public MessageServiceImpl(MessageRepository messageRepository){
//
//        this.messageRepository = messageRepository;
//
//    }

    @Override
    public void createMessage(MailBox mailBox) {
        messageRepository.saveAll(mailBox.getMessages());

    }

    @Override
    public Message inboxMessage(MessageDto messageDto, String username) {
        Message incomingMessage = new Message();
        incomingMessage.setBody(messageDto.getBody());
        incomingMessage.setSender(username);
        incomingMessage.setLocalDateTime(LocalDateTime.now());
        incomingMessage.setReceiver(messageDto.getReceiver());
        Notification notification = new Notification("sent message", "Your mail has been sent");
        Message savedMessage = messageRepository.save(incomingMessage);
      //  mailBoxesService.sendMessage(savedMessage);
        return savedMessage;
    }

        @Override
    public Message retrieveMessage(MessageDto messageDto, String receiver) {

        return null;
    }


}
