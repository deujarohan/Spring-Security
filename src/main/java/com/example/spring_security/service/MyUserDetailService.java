package com.example.spring_security.service;

import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.spring_security.model.User;
import com.example.spring_security.model.UserPrinciple;
import com.example.spring_security.repo.UserRepository;

@Service
//fetch user detail for authentication
public class MyUserDetailService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    //Spring Security calls this method whenever a login attempt happens
    // Spring will execute:
    // loadUserByUsername("rohan")
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        //Fetching the User From Database
        // SELECT * FROM users WHERE username = 'rohan';
        User user = userRepository.findByUsername(username);
        if(user == null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrinciple(user);
    }

}
