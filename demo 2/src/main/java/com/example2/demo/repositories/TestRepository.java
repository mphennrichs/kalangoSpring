package com.example2.demo.repositories;

import com.example2.demo.domain.TestDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<TestDTO, String> {
    TestDTO findById(String testId);
}
