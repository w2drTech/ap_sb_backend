package com.w2drcode.studentsystem.service;

import com.w2drcode.studentsystem.model.Appointment;
import com.w2drcode.studentsystem.model.Patient;
import com.w2drcode.studentsystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }
    @Override
    public Patient getPatientById(int id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        return patientOptional.orElse(null); // Return null if not found
    }

    @Override
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    @Override
    public ResponseEntity<Object> getPatientByName(String name) {
        Optional<Patient> patientOptional = patientRepository.findByName(name);
        if (patientOptional.isPresent()) {
            return ResponseEntity.ok(patientOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Name not found");
        }
    }
}
