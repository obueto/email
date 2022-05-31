package com.example.emailsystem.repositories;

import com.example.emailsystem.models.MailBox;
import com.example.emailsystem.models.MailBoxes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MailBoxesRepository extends MongoRepository<MailBoxes, String> {
}
