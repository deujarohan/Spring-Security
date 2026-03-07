package com.example.spring_security.model;

import java.util.Collection;
import java.util.Collections;

import javax.swing.Spring;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// UserPrinciple is a wrapper class that converts your custom User entity into a format that Spring Security understands.
// Spring Security doesn’t know about your User entity directly — it only works with objects that implement UserDetails.
public class UserPrinciple implements UserDetails {

    private User user;

    public UserPrinciple(User user) {
        this.user = user;
    }

    // This gives the role/authority of the user.
    // Right now, all users have the role "USER".
    // Spring Security uses this for authorization (hasRole("USER") etc.).
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections  .singleton(new SimpleGrantedAuthority("USER"));
    }

    //getPassword() should return the BCrypt-hashed password from the database.
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    //login identifier.
    @Override
    public String getUsername() {
        return user.getUsername();

    }

    // These flags allow advanced user account control
    // Expired accounts, Locked accounts, Disabled accounts
    // all true
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
