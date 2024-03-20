package com.w2drcode.studentsystem.controller;
import com.w2drcode.studentsystem.model.Appointment;
import com.w2drcode.studentsystem.model.Patient;
import com.w2drcode.studentsystem.service.AppointmentService;
import com.w2drcode.studentsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientService patientService;
    @PostMapping("/add/{patientId}")
    public Appointment addAppointment(@PathVariable("patientId") int patientId, @RequestBody Appointment appointment) {

        Patient patient = patientService.getPatientById(patientId);
        if(patient == null)
        {
            return null;
        }
        appointment.setPatient(patient);
        return appointmentService.saveAppointment(appointment);
    }
    @GetMapping("/get")
    public List<Appointment> findAllAppointments()
    {
        return appointmentService.getAppointments();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Object> findAppointmentById(@PathVariable int id)
    {
        return appointmentService.getAppointment(id);
    }
    @PutMapping("/update")
    public Appointment updateAppointment(@RequestBody Appointment appointment)
    {
        return appointmentService.updateAppointment(appointment);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable int id)
    {
        return appointmentService.deleteAppointment(id);
    }
}
