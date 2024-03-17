package com.w2drcode.studentsystem.service;

import com.w2drcode.studentsystem.model.Appointment;
import com.w2drcode.studentsystem.model.Bill;
import com.w2drcode.studentsystem.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImpl implements BillService{
    @Autowired
    private BillRepository billRepository;
    @Override
    public Bill saveBill(Bill bill) {
        return billRepository.save(bill);
    }
    @Override
    public List<Bill> getBills() {
        return billRepository.findAll();
    }
    @Override
    public ResponseEntity<Object> getBill(int id) {
        Optional<Bill> billOptional = billRepository.findById(id);
        if (billOptional.isPresent()) {
            return ResponseEntity.ok(billOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID not found");
        }
    }

}
