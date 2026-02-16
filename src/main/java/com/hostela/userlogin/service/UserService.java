package com.hostela.userlogin.service;

import com.hostela.userlogin.dto.UserRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserRequestDto saveUser(UserRequestDto user);
    UserRequestDto updateUser(Integer userid, UserRequestDto user);

    boolean userEmailExist(String email);
    boolean userPhoneNumberExist(String phoneNumber);

    UserRequestDto authenticate(String username, String password);


    List<UserRequestDto> getAllUsers();
}
