package com.w2drcode.studentsystem.controller;

import com.w2drcode.studentsystem.model.Appointment;
import com.w2drcode.studentsystem.model.Patient;
import com.w2drcode.studentsystem.model.Technician;

import com.w2drcode.studentsystem.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/technician")
public class TechnicianController {
    @Autowired
    private TechnicianService technicianService;

    @PostMapping("/add")
    public String add(@RequestBody Technician technician){
        try {
            technicianService.saveTechnician(technician);
            return "New Technician Added";
        } catch (Exception e) {
            return "Failed to add new technician: " + e.getMessage();
        }
    }
    @GetMapping("/get")
    public List<Technician> findTechnicians()
    {
        return technicianService.getTechnicians();
    }
    @GetMapping("/get/{name}")
    public ResponseEntity<Object> findTechnicianByName(@PathVariable String name)
    {
        return technicianService.getTechnicianByName(name);
    }
    @PutMapping("/update")
    public Technician updaTechnician(@RequestBody Technician technician)
    {
        return technicianService.updateTechnician(technician);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteTechnician(@PathVariable int id)
    {
        return technicianService.deleteTechnician(id);
    }
}
