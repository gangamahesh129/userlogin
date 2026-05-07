package com.hostela.userlogin.mongodb.service.impl;

import com.hostela.userlogin.dto.UserRequestDto;
import com.hostela.userlogin.mongodb.collection.User;
import com.hostela.userlogin.mongodb.repo.UserRepository;
import com.hostela.userlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MangoUserSerive")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("mangoUserRepositary")
    private UserRepository repository;

    @Override
    public UserRequestDto saveUser(UserRequestDto user) {
        User mangoUser = User.builder().
                fName(user.getFName()).gmail(user.getGmail()).
                lName(user.getLName()).password(user.getPassword())
                .phoneNumber(user.getPhoneNumber()).
                profilePicture(user.getProfilePicture()).build();

        User save = repository.save(mangoUser);
        user.setUserid(save.getUserid());
        return user;
    }

    @Override
    public UserRequestDto updateUser(Integer userid, UserRequestDto user) {
        return null;
    }

    @Override
    public boolean userEmailExist(String email) {
        return false;
    }

    @Override
    public boolean userPhoneNumberExist(String phoneNumber) {
        return false;
    }

    @Override
    public UserRequestDto authenticate(String username, String password) {
        return null;
    }

    @Override
    public List<UserRequestDto> getAllUsers() {
        return List.of();
    }
}
