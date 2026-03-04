package com.example.spring_security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_security.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    User findByUsername(String username);
}
