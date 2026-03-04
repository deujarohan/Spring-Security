package com.example.spring_security;

import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HelloController {
    @GetMapping("/")
    public String greet(HttpServletRequest request) {
        return "Welcome to Spring Security Demo " + request.getSession().getId();
    }
    
}
