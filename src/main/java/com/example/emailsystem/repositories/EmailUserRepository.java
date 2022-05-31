package com.example.emailsystem.repositories;

import com.example.emailsystem.models.EmailUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EmailUserRepository extends MongoRepository<EmailUser,String> {
 Optional<EmailUser>findEmailUserByUsername(String username);
}
