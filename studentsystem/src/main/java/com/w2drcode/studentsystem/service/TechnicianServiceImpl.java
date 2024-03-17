package com.w2drcode.studentsystem.service;

import com.w2drcode.studentsystem.model.Appointment;
import com.w2drcode.studentsystem.model.Patient;
import com.w2drcode.studentsystem.model.Technician;
import com.w2drcode.studentsystem.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicianServiceImpl implements TechnicianService{
    @Autowired
    private TechnicianRepository technicianRepository;
    @Override
    public Technician saveTechnician(Technician technician) {
        return technicianRepository.save(technician);
    }
    @Override
    public Technician getTechnicianById(int id) {
        Optional<Technician> technicianOptional = technicianRepository.findById(id);
        return technicianOptional.orElse(null);
    }

    @Override
    public List<Technician> getTechnicians() {
        return technicianRepository.findAll();
    }

    @Override
    public ResponseEntity<Object> getTechnicianByName(String name) {
        Optional<Technician> technicianOptional = technicianRepository.findByName(name);
        if (technicianOptional.isPresent()) {
            return ResponseEntity.ok(technicianOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Name not found");
        }
    }

    @Override
    public Technician updateTechnician(Technician technician) {
        Technician existingTechnician = technicianRepository.findById(technician.getId()).orElse(technician);
        existingTechnician.setName(technician.getName());
        existingTechnician.setContactDetails(technician.getContactDetails());
        return technicianRepository.save(existingTechnician);
    }
    @Override
    public String deleteTechnician(int id) {
        technicianRepository.deleteById(id);
        return "Technician removed !!" +id;
    }

}
