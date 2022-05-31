package com.example.emailsystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Message {
    @Id
    private String id;
    private String sender;
    private String receiver;
    private String body;
    private boolean isRead;
    private boolean isDelivered;
    private LocalDateTime localDateTime = LocalDateTime.now();

    public Message(String id, String sender, String receiver, String body, boolean delivered, boolean read) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.body = body;
        this.isDelivered = delivered;
        this.isRead = read;

    }
}
