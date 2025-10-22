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
        User newUser = new User();
        newUser.setName(userRequest.getName());
        newUser.setColor(userRequest.getColor());
        return userRepository.save(newUser);
    }

    // Endpoint para pre-poblar los 5 usuarios
    @PostMapping("/seed")
    public List<User> seedUsers() {
        List<UserRequest> initialUsers = List.of(
                new UserRequest("Tomas", "#f87171"),
                new UserRequest("Raquel", "#60a5fa"),
                new UserRequest("Sagra", "#34d399"),
                new UserRequest("Mari", "#fbbf24"),
                new UserRequest("Juan", "#a78bfa"));

        return initialUsers.stream()
                .map(req -> {
                    User u = new User();
                    u.setName(req.getName());
                    u.setColor(req.getColor());
                    return userRepository.save(u);
                })
                .toList();
    }

}
