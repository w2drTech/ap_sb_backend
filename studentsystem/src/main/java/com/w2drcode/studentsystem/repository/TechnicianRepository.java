package com.w2drcode.studentsystem.repository;

import com.w2drcode.studentsystem.model.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TechnicianRepository extends JpaRepository<Technician,Integer> {
    Optional<Technician> findByName(String name);
}
