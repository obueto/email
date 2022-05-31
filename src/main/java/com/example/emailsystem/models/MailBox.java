package com.example.emailsystem.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MailBox {
    @Id
    private String username;
    private List<Message> messages;
    private Type boxType;

    public MailBox(String username) {
        this.username = username;
    }

    public <E> MailBox(Type mailType, ArrayList<Message> messages) {
        boxType = mailType;
        this.messages = messages;
    }
}
