package com.w2drcode.studentsystem.repository;

import com.w2drcode.studentsystem.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository <Test,Integer> {
    List<Test> findByPatientId(int patientId);
}
