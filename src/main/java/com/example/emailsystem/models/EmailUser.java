package com.example.emailsystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document
@NoArgsConstructor
public class EmailUser {
    @Id
 private String username;
 private String password;
    private List<Notification> notifications;


    public EmailUser(String username, String password) {
        this.username =username;
        this.password = password;
    }


}
