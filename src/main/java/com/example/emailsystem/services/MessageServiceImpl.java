package com.example.emailsystem.services;

import com.example.emailsystem.models.MailBox;
import com.example.emailsystem.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
