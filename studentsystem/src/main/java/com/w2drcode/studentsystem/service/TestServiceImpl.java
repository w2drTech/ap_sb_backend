package com.w2drcode.studentsystem.service;

import com.w2drcode.studentsystem.model.Test;
import com.w2drcode.studentsystem.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService{
    @Autowired
    private TestRepository testRepository;
    @Override
    public Test saveTest(Test test) {
        return testRepository.save(test);
    }

    @Override
    public List<Test> getTests() {
        return testRepository.findAll();
    }
    @Override
    public List<Test> getTestsByPatientId(int patientId) {
        return testRepository.findByPatientId(patientId);
    }
}
