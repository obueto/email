package com.example.emailsystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private String id;
    private String sender;
    private String receiver;
    private String body;
    private boolean isRead;
    private boolean isDelivered;
    private LocalDateTime localDateTime = LocalDateTime.now();

}
