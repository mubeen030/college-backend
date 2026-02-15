package com.collegemanagement.controller;

import org.springframework.web.bind.annotation.*;

import com.collegemanagement.model.Student;
import com.collegemanagement.model.User;
import com.collegemanagement.repository.StudentRepository;
import com.collegemanagement.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;

    public StudentController(StudentRepository studentRepository, UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }

    // 🔹 Create Student linked to User
    @PostMapping("/{userId}")
    public Student createStudent(
            @PathVariable String userId,
            @RequestBody Student student) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        student.setUser(user);
        return studentRepository.save(student);
    }

    // 🔹 Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
