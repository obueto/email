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
    private String name;
    private String userName;
    private List<Message> messages;
    private Type boxType;

    public MailBox(String username) {
        this.name = username;
    }

    public MailBox(Type mailType, ArrayList<Message> messages, String userName) {
        boxType = mailType;
        this.messages = messages;
        this.userName = userName;
    }
}
