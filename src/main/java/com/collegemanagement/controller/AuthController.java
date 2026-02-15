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

    User user = userRepository.findByUsername(request.username)
            .orElseThrow(() -> new RuntimeException("User not found"));

    if (!user.getPassword().equals(request.password)) {
        throw new RuntimeException("Invalid password");
    }

    // include USER ID in token (VERY IMPORTANT)
   return JwtUtil.generateToken(user.getUsername(), user.getRole().name());

}



}
