package com.w2drcode.studentsystem.controller;

import com.w2drcode.studentsystem.model.Bill;
import com.w2drcode.studentsystem.model.Patient;
import com.w2drcode.studentsystem.service.BillService;
import com.w2drcode.studentsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill")

public class BillController {
    @Autowired
    private BillService billService;
    @Autowired
    private PatientService patientService;
    @PostMapping("/add/{patientId}")
    public Bill addBill(@PathVariable("patientId") int patientId,@RequestBody Bill bill)
    {
        Patient patient = patientService.getPatientById(patientId);
        bill.setPatient(patient);
        return billService.saveBill(bill);
    }
    @GetMapping("/get")
    public List<Bill> findAllBills()
    {
        return billService.getBills();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Object> findBillById(@PathVariable int id)
    {
        return billService.getBill(id);
    }
}
