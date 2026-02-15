package com.collegemanagement.repository;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.collegemanagement.model.Student;


public interface StudentRepository extends MongoRepository<Student, String> {
    Optional<Student> findByUserId(String userId);
}
