package com.example.spring_security.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.spring_security.model.User;
import com.example.spring_security.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {

    @Autowired
    private UserService service;

    //encrypting password
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    @PostMapping("/register/creat")
    public User register(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return service.register(user);
    }

    // public User login(@RequestBody User user) {
    //     return service.login(user);
    // }
}
