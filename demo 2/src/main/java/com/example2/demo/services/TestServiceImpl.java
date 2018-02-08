package com.example2.demo.services;


import com.example2.demo.domain.TestDTO;
import com.example2.demo.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private TestRepository repository;

    @Override
    public TestDTO findById(String testId) {
        return repository.findById(testId);
    }

    @Override
    public void save(TestDTO testItem) {
        repository.save(testItem);
    }
}
