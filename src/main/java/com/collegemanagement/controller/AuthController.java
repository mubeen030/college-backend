package com.collegemanagement.controller;

import com.collegemanagement.dto.LoginRequest;
import com.collegemanagement.model.User;
import com.collegemanagement.repository.UserRepository;
import com.collegemanagement.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        User user = userRepository.findAll().stream()
                .filter(u -> u.getUsername().equals(request.username)
                        && u.getPassword().equals(request.password))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        return JwtUtil.generateToken(user.getUsername(), user.getRole().name());
    }
}
