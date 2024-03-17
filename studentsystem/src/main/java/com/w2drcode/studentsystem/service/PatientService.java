package com.w2drcode.studentsystem.service;

import com.w2drcode.studentsystem.model.Patient;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientService {
    public Patient savePatient (Patient patient);
    public Patient getPatientById(int id);
    public List<Patient> getPatients();
    public ResponseEntity<Object> getPatientByName(String name);

}
