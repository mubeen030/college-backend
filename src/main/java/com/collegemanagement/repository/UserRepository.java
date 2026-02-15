package com.collegemanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.collegemanagement.model.User;

public interface UserRepository extends MongoRepository<User, String> {

    // Optional helper for login
    User findByUsername(String username);
}
