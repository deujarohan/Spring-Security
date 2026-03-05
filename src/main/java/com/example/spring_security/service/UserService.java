package com.example.spring_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_security.model.User;
import com.example.spring_security.repo.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User register(User user) {
        return repo.save(user);
    }

    // public User login(User user) {
    //     return repo.findByUsername(user.getUsername());
    // }

}
