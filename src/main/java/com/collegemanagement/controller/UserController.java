package com.collegemanagement.controller;

import org.springframework.web.bind.annotation.*;

import com.collegemanagement.model.User;
import com.collegemanagement.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 🔹 Create User
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // 🔹 Get All Users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
