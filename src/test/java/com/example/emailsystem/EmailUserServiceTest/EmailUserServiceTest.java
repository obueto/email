package com.example.emailsystem.EmailUserServiceTest;

import com.example.emailsystem.dtos.UserDto;
import com.example.emailsystem.dtos.UserResponse;
import com.example.emailsystem.exceptions.EmailSystemException;
import com.example.emailsystem.services.EmailUserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EmailUserServiceTest {
    @Autowired
    EmailUserService emailUserService;
    ModelMapper mapper;
    UserDto userDto;

    @BeforeEach
    void setup() {
        userDto = new UserDto("dsf","password2");
    }
    @AfterEach
    void tearDown(){
        emailUserService.deleteUser(userDto);
    }

    @Test
    void emailHasUserTest(){
        UserResponse userResponse = emailUserService.registerUser(userDto.getUsername(), userDto.getPassword());
        assertNotNull(userResponse);
    }
    @Test
  void userCanLoginTest(){
    UserResponse userResponse =   emailUserService.registerUser(userDto.getUsername(),userDto.getPassword());

   UserResponse response =  emailUserService.loginUser(userResponse.getUsername(), userDto.getPassword());
       // assertThat(userDto.getUsername()).isEqualTo(userDto);
        assertThat(response.getUsername()).isEqualTo(userDto.getUsername());
        }


        @Test
    void userCanBeDeletedTest(){
        UserResponse userResponse = emailUserService.registerUser(userDto.getUsername(),userDto.getPassword());
        emailUserService.deleteUserById(userResponse.getUsername());
        assertThatThrownBy(()-> emailUserService.retrieveUserByUsername(userDto.getUsername())).isInstanceOf(EmailSystemException.class)
                .hasMessage("user not found");

        }

}
