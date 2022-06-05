package com.example.emailsystem.services;

import com.example.emailsystem.dtos.MessageDto;
import com.example.emailsystem.models.MailBox;
import com.example.emailsystem.models.Message;
import com.example.emailsystem.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageServiceImpl implements  MessageService{

    private MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    @Override
    public void createMessage(MailBox mailBox) {
        messageRepository.saveAll(mailBox.getMessages());

    }

    @Override
    public Message sendMessage(MessageDto messageDto, String username) {
        Message incomingMessage = new Message();
        incomingMessage.setBody(messageDto.getBody());
        incomingMessage.setSender(username);
        incomingMessage.setLocalDateTime(LocalDateTime.now());
        incomingMessage.setReceiver(messageDto.getReceiver());
        return messageRepository.save(incomingMessage);
    }
}
