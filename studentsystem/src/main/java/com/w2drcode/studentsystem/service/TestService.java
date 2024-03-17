package com.w2drcode.studentsystem.service;

import com.w2drcode.studentsystem.model.Appointment;
import com.w2drcode.studentsystem.model.Test;

import java.util.List;

public interface TestService {
    public Test saveTest(Test test);
    public List<Test> getTests();
    List<Test> getTestsByPatientId(int patientId);
}
