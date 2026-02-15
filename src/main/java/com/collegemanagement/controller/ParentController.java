package com.collegemanagement.controller;

import com.collegemanagement.model.Parent;
import com.collegemanagement.model.Student;
import com.collegemanagement.model.User;
import com.collegemanagement.repository.ParentRepository;
import com.collegemanagement.repository.StudentRepository;
import com.collegemanagement.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parents")
public class ParentController {

    private final ParentRepository parentRepository;
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;

    public ParentController(
            ParentRepository parentRepository,
            UserRepository userRepository,
            StudentRepository studentRepository) {
        this.parentRepository = parentRepository;
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
    }

    // 🔹 Create Parent (linked to user + student)
    @PostMapping("/{userId}/{studentId}")
    public Parent createParent(
            @PathVariable String userId,
            @PathVariable String studentId,
            @RequestBody Parent parent) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        parent.setUser(user);
        parent.setStudent(student);

        return parentRepository.save(parent);
    }

    // 🔹 Get all parents
    @GetMapping
    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }
}
