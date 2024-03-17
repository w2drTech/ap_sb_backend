package com.w2drcode.studentsystem.service;

import com.w2drcode.studentsystem.model.Appointment;
import com.w2drcode.studentsystem.model.Bill;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BillService {
    public Bill saveBill(Bill bill);
    public List<Bill> getBills();
    public ResponseEntity<Object> getBill(int id);
}
