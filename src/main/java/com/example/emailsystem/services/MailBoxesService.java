package com.example.emailsystem.services;

import com.example.emailsystem.models.MailBox;
import com.example.emailsystem.models.MailBoxes;
import com.example.emailsystem.models.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MailBoxesService {
    MailBoxes createBoxes(String username);
    MailBox retrieveInbox(String username);
    MailBox retrieveSentBox(String username);
    MailBoxes findMailBoxes(String username);
    void sendMessage(Message message);
    void deleteMailBoxes(MailBoxes mailBoxes);
    Message retrieveMessagesFromInbox(String username);
}
