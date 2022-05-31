package com.example.emailsystem.repositories;

import com.example.emailsystem.models.MailBox;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailBoxRepository extends MongoRepository<MailBox,String> {
    MailBox findMailBoxByUsername(String username);
}
