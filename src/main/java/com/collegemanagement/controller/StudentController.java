package com.collegemanagement.controller;

import org.springframework.web.bind.annotation.*;
import com.collegemanagement.model.Student;
import com.collegemanagement.repository.StudentRepository;


import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // 🔹 Create Student linked to UserId (Mongo way)
    @PostMapping("/{userId}")
    public Student createStudent(
            @PathVariable String userId,
            @RequestBody Student student) {

        student.setUserId(userId);
   // store only ID
        return studentRepository.save(student);
    }

   @GetMapping("/by-user/{userId}")
    public Student getStudentByUser(@PathVariable String userId) {
        return studentRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
}

}
