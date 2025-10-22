package com.example.aguela.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aguela.dto.UserRequest;
import com.example.aguela.model.User;
import com.example.aguela.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public User newUser(@RequestBody UserRequest userRequest) {
        //TODO: process POST request
        User newUser = new User();
        newUser.setColor(userRequest.getColor());
        newUser.setName(userRequest.getColor());
        
        return userRepository.save(newUser);
    }
    
}

