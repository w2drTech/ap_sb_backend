package com.w2drcode.studentsystem.service;


import com.w2drcode.studentsystem.model.Appointment;
import com.w2drcode.studentsystem.model.Technician;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TechnicianService {
    public Technician saveTechnician(Technician technician);
    public Technician getTechnicianById(int id);
    public List<Technician> getTechnicians();
    public ResponseEntity<Object> getTechnicianByName(String name);
    public Technician updateTechnician(Technician technician);
    public String deleteTechnician(int id);
}
