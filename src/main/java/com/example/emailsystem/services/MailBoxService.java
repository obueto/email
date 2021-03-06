package com.example.emailsystem.services;

import com.example.emailsystem.dtos.MessageDto;
import com.example.emailsystem.dtos.MessageResponseDto;
import com.example.emailsystem.exceptions.EmailSystemException;
import com.example.emailsystem.models.MailBox;
import com.example.emailsystem.models.MailBoxes;
import com.example.emailsystem.models.Message;

public interface MailBoxService {
    void sendMessage(MessageDto message, String username);
    void createMailBox(MailBoxes mailBoxes);
    void deleteMailBox(MailBox mailBox);
    void sendMessage(String receiver, String body, String sender);

}
