package com.collegemanagement.repository;

import com.collegemanagement.model.Parent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParentRepository extends MongoRepository<Parent, String> {
}
