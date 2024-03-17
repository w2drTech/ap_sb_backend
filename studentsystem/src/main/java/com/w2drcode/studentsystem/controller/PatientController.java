package com.w2drcode.studentsystem.controller;

import com.w2drcode.studentsystem.model.Patient;
import com.w2drcode.studentsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping("/add")
    public String add(@RequestBody Patient patient){
        patientService.savePatient(patient);
        return "New patient is added";
    }
    @GetMapping("/get")
    public List<Patient> findAllPatients()
    {
        return patientService.getPatients();
    }
    @GetMapping("/get/{name}")
    public ResponseEntity<Object> findPatientByName(@PathVariable String name)
    {
        return patientService.getPatientByName(name);
    }
}
