package com.example.emailsystem.services;

import com.example.emailsystem.dtos.UserDto;
import com.example.emailsystem.dtos.UserResponse;
import com.example.emailsystem.exceptions.EmailSystemException;
import com.example.emailsystem.models.EmailUser;
import com.example.emailsystem.models.MailBoxes;

public interface EmailUserService {
    UserResponse registerUser(String email, String password)throws EmailSystemException;
    UserResponse loginUser(UserDto userDto);
    void deleteUserById(String username);
    MailBoxes retrieveUserMailBoxes(String username);
    EmailUser retrieveUserByUsername(String username);

}
