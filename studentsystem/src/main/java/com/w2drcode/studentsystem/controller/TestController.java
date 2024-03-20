package com.w2drcode.studentsystem.controller;

import com.w2drcode.studentsystem.model.Appointment;
import com.w2drcode.studentsystem.model.Patient;
import com.w2drcode.studentsystem.model.Technician;
import com.w2drcode.studentsystem.model.Test;
import com.w2drcode.studentsystem.service.PatientService;
import com.w2drcode.studentsystem.service.TechnicianService;
import com.w2drcode.studentsystem.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/test")

public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private TechnicianService technicianService;
    @PostMapping("/add/{patientId}/{technicianId}")
    public Test addTest(@PathVariable("patientId") int patientId,@PathVariable("technicianId") int technicianId, @RequestBody Test test) {

        Patient patient = patientService.getPatientById(patientId);
        Technician technician = technicianService.getTechnicianById(technicianId);
        if(patient == null)
        {
            return null;
        }
        test.setPatient(patient);
        test.setTechnician(technician);
        return testService.saveTest(test);
    }
    @GetMapping("/get")
    public List<Test> findAllTests()
    {
        return testService.getTests();
    }
    @GetMapping("/tests/{patientId}")
    public List<Test> getTestsByPatientId(@PathVariable("patientId") int patientId) {
        return testService.getTestsByPatientId(patientId);
    }
}
