package com.example.emailsystem.services;

import com.example.emailsystem.dtos.UserDto;
import com.example.emailsystem.dtos.UserResponse;
import com.example.emailsystem.exceptions.EmailSystemException;
import com.example.emailsystem.models.EmailUser;
import com.example.emailsystem.models.MailBox;
import com.example.emailsystem.models.MailBoxes;
import com.example.emailsystem.models.Type;
import com.example.emailsystem.repositories.EmailUserRepository;
import com.example.emailsystem.repositories.MailBoxRepository;
import com.example.emailsystem.repositories.MailBoxesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmailUserServiceImpl implements EmailUserService{
    private MailBoxesService mailBoxesService;
    private EmailUserRepository emailUserRepository;

    private ModelMapper mapper;
// test user for crud,test that user can send message


    @Autowired
    public  EmailUserServiceImpl(MailBoxesService mailBoxesService, EmailUserRepository emailUserRepository){
        this.mailBoxesService = mailBoxesService;
        this.emailUserRepository = emailUserRepository;
        this.mapper = new ModelMapper();

    }


    @Override
    public UserResponse registerUser(String username, String password) throws EmailSystemException {
        Optional<EmailUser> emailUser = emailUserRepository.findEmailUserByUsername(username);
        if (emailUser.isEmpty()){
            EmailUser user =  new EmailUser(username,password);

            MailBoxes mailBoxes = new MailBoxes(username);
              mailBoxesService.createBoxes(username);

            EmailUser savedUser = emailUserRepository.save(user);

            return mapper.map(savedUser,UserResponse.class);
        }
        else {
            throw new EmailSystemException("user already exists");
        }

    }

    @Override
    public UserResponse loginUser(UserDto userDto) {
        Optional<EmailUser>user = emailUserRepository.findEmailUserByUsername(userDto.getUsername());

        if (user.isPresent()){
            if (Objects.equals(user.get().getPassword(), userDto.getPassword()));
            mapper.map(user.get(),UserResponse.class);
        }
        throw new EmailSystemException("User does not exist");
    }

    @Override
    public void deleteUserById(String username) {
       EmailUser user = emailUserRepository.findEmailUserByUsername(username).orElseThrow(()-> new EmailSystemException("user not found"));
       emailUserRepository.delete(user);
    }

    @Override
    public MailBoxes retrieveUserMailBoxes(String username) {
        MailBoxes mailBoxes = new  MailBoxes();
        // MailBox mailBox = new MailBox();
        mailBoxesService.retrieveInbox(username);
        mailBoxesService.retrieveSentBox(username);
        return mailBoxes;

    }
    @Override
    public EmailUser retrieveUserByUsername(String username) {

        return emailUserRepository.findEmailUserByUsername(username).orElseThrow(()-> new EmailSystemException("user not found"));
    }

    @Override
    public void deleteUser(UserDto userDto) {
        Optional<EmailUser> user = emailUserRepository.findEmailUserByUsername(userDto.getUsername());
        user.ifPresent(emailUser -> emailUserRepository.delete(emailUser));
    }

    @Override
    public UserResponse loginUser(String username, String password) {
        Optional<EmailUser> user = emailUserRepository.findEmailUserByUsername(username);
                UserResponse response = new UserResponse();
        if (user.isPresent()){
            if(user.get().getPassword().equals(password)){
                response.setUsername(user.get().getUsername());
            }
        }
    return response;
    }
}
