package com.w2drcode.studentsystem.repository;

import com.w2drcode.studentsystem.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Integer> {
}
