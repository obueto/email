package com.example.emailsystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class  Notification {
    private String  id;
    private String title;
    private String message;

    public Notification(String title,String message){
        this.title = title;
        this.message = message;
    }
}

