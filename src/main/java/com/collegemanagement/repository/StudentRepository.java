package com.collegemanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.collegemanagement.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
}
