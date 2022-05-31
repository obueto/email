package com.example.emailsystem.controllers;

import com.example.emailsystem.dtos.MessageDto;
import com.example.emailsystem.dtos.MessageResponseDto;
import com.example.emailsystem.dtos.UserDto;
import com.example.emailsystem.dtos.UserResponse;
import com.example.emailsystem.models.MailBox;
import com.example.emailsystem.models.Message;
import com.example.emailsystem.services.EmailUserService;
import com.example.emailsystem.services.MailBoxService;
import com.example.emailsystem.services.MailBoxesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class EmailUserController {
    private EmailUserService emailUserService;
    private MailBoxService mailBoxService;
    private MailBoxesService mailBoxesService;

    public EmailUserController(EmailUserService emailUserService,MailBoxService mailBoxService,MailBoxesService mailBoxesService){
        this.emailUserService = emailUserService;
        this.mailBoxService = mailBoxService;
        this.mailBoxesService = mailBoxesService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> createUser(@RequestBody UserDto userResponse){
        emailUserService.registerUser(userResponse.getUsername(),userResponse.getPassword());
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }
@PatchMapping ("/sendMessage")
    public ResponseEntity<?> sendMessages(@RequestBody MessageResponseDto messageResponseDto){
        mailBoxService.sendMessage(messageResponseDto.getReceiver(),messageResponseDto.getBody(),messageResponseDto.getSender());
        return new ResponseEntity<>(messageResponseDto,HttpStatus.OK);
    }


}
