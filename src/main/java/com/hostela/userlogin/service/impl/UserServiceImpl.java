package com.hostela.userlogin.service.impl;


import com.hostela.userlogin.customexception.CustomException;
import com.hostela.userlogin.dao.UserRepository;
import com.hostela.userlogin.dto.UserRequestDto;
import com.hostela.userlogin.jpamodel.User;
import com.hostela.userlogin.service.UserService;
import com.hostela.userlogin.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserRequestDto saveUser(UserRequestDto user) {
        validateUserExistence(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(UserUtil.convertUserToUserJpaModel(user));
        user.setUserid(savedUser.getUserid());
        return user;
    }

    public UserRequestDto updateUser(Integer userid, UserRequestDto user) {
        User existingUser = userRepository.findById(userid)
                .orElseThrow(() -> new RuntimeException("User not found"));

        User updatedUser = userRepository.save(UserUtil.convertUserToUserJpaModel(user));
        return user;
    }

    private void validateUserExistence(UserRequestDto user) {
        if (userRepository.findByPhoneNumber(user.getPhoneNumber()).isPresent()) {
            throw new CustomException("Phone number already exists.");
        }
        if (userRepository.findByGmail(user.getGmail()).isPresent()) {
            throw new CustomException("Email already exists.");
        }
    }

    public boolean userEmailExist(String email) {
        return userRepository.findByGmail(email).isPresent();
    }

    public boolean userPhoneNumberExist(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber).isPresent();
    }

    @Override
    public UserRequestDto authenticate(String phoneNumber, String password) {
       User userDetails = userRepository.findByPhoneNumber(phoneNumber).orElseThrow(() ->
                new CustomException("UserId not found"));

       if(!passwordEncoder.matches(password, userDetails.getPassword())) {
           throw new CustomException("Invalid credentials.");
       }
        return UserUtil.convertUserJpaModelToUser(userDetails);
    }

    @Override
    public  List<UserRequestDto> getAllUsers() {
        List<User> list = userRepository.findAll();
        List<UserRequestDto> modifyList = new ArrayList<>();
        if(!list.isEmpty()) {
           modifyList = list.stream().map(UserUtil::convertUserJpaModelToUser).toList();
        }
        return modifyList;
    }
}