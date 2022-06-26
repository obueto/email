package com.example.emailsystem.services;

import com.example.emailsystem.dtos.MessageDto;
import com.example.emailsystem.models.MailBox;
import com.example.emailsystem.models.Message;

public interface MessageService {
    void createMessage(MailBox mailBox);

    Message inboxMessage(MessageDto messageDto, String username);
    Message retrieveMessage(MessageDto messageDto, String username);
}
