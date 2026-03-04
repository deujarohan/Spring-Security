package com.example.spring_security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Rohan", 60),
            new Student(2, "Kshitiz", 70),
            new Student(3, "Prabin", 85)
    ));


    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }


    @PostMapping("/create")
    public Student createStudent(@RequestBody Student std) {
        students.add(std);
        return std;
    }
    
}
