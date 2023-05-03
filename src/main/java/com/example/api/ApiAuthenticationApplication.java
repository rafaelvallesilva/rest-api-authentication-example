package com.example.api;

import com.example.api.model.User;
import com.example.api.repository.UserRepository;
import com.example.api.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiAuthenticationApplication implements CommandLineRunner {

    @Autowired
    JwtUserDetailsService service;

    @Autowired
    UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(ApiAuthenticationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setRole("USER");
        user.setUserName("fulano");
        user.setEmail("usuario@mail.com");
        user.setPassword("123456");
        user.setLastName("Silva");
        user.setFirstName("Fulano");

//        repository.save(user);
        service.createUserDetails("fulano2", user.getPassword());
    }
}
