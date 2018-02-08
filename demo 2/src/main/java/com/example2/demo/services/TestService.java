package com.example2.demo.services;


import com.example2.demo.domain.TestDTO;

public interface TestService {

    TestDTO findById(String testId);

    void save(TestDTO testItem);
}
