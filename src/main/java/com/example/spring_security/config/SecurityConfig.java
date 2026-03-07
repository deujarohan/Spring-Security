package com.example.spring_security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //Filters
        //
        //disable csrf
        http.csrf(customizer -> customizer.disable());
        //authorize requests
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        //web login
        http.formLogin(Customizer.withDefaults());
        //for postman
        http.httpBasic(Customizer.withDefaults());
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }


    // Hardcoded users---------------------------------------------
    // @Bean
    // public UserDetailsService userDetailsService() {
    //     UserDetails user1 = User.withDefaultPasswordEncoder()
    //             .username("user")
    //             .password("password")
    //             .roles("USER")
    //             .build();
        
    //     UserDetails user2 = User.withDefaultPasswordEncoder()
    //             .username("admin")
    //             .password("admin")
    //             .roles("ADMIN")
    //             .build();
    //     return new InMemoryUserDetailsManager(user1, user2);
    // }
    
    //BCrypt password encoder------------------------------------------------
    @Bean
    //AuthenticationProvider is an interface in Spring Security
//     Verifying username
//      Verifying password
//      Authenticating the user
    public AuthenticationProvider authenticationProvider() {
        //Database authentication "DaoAuthenticationProvider", DAO = Data Access Object
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        //Password Encoder
        //input password → BCrypt hash → compare with stored hash,  10 = strength
        provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
        //Loading user data from database.
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    
}
