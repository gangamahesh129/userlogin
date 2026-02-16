package com.hostela.userlogin.controller;


import com.hostela.userlogin.dto.UserRequestDto;
import com.hostela.userlogin.service.UserService;
import com.hostela.userlogin.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody UserRequestDto user) {
        UserRequestDto saveUser = userService.saveUser(user);
        return new ResponseEntity<>(saveUser, HttpStatus.OK);

    }

    @PutMapping("/update/{userid}")
    public ResponseEntity<?> updateUser(@PathVariable Integer userid, @RequestBody UserRequestDto user) {
        UserRequestDto updateUser = userService.updateUser(userid, user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);

    }

    @GetMapping("/exists/email")
    public boolean checkEmailExists(@RequestParam String email) {
        return userService.userEmailExist(email);
    }

    @GetMapping("/exists/phone")
    public boolean checkPhoneNumberExists(@RequestParam String phoneNumber) {
        return userService.userPhoneNumberExist(phoneNumber);
    }

    @PostMapping("/login")
    public String authenticateUser(@RequestParam String username, @RequestParam String password) {
        // CHANGE: Implement your authentication logic here
        UserRequestDto isAuthenticated = userService.authenticate(username, password);
        if (isAuthenticated !=null) {
            return jwtUtil.generateToken(username);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        List<UserRequestDto> allUsers = userService.getAllUsers();// CHANGE: Call service method to get all users
       return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }


}

