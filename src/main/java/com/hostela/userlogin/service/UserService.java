package com.hostela.userlogin.service;

import com.hostela.userlogin.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserDto saveUser(UserDto user);
    UserDto updateUser(Integer userid, UserDto user);

    boolean userEmailExist(String email);
    boolean userPhoneNumberExist(String phoneNumber);

    UserDto authenticate(String username, String password);


    List<UserDto> getAllUsers();
}
