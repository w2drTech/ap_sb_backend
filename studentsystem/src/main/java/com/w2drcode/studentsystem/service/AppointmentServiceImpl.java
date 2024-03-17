package com.w2drcode.studentsystem.service;

import com.w2drcode.studentsystem.model.Appointment;
import com.w2drcode.studentsystem.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public ResponseEntity<Object> getAppointment(int id) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
        if (appointmentOptional.isPresent()) {
            return ResponseEntity.ok(appointmentOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID not found");
        }
    }

    @Override
    public String deleteAppointment(int id) {
        appointmentRepository.deleteById(id);
        return "Appointment removed !!" +id;
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        Appointment existingAppointment = appointmentRepository.findById(appointment.getId()).orElse(appointment);
        existingAppointment.setDate(appointment.getDate());
        existingAppointment.setTime(appointment.getTime());
        existingAppointment.setTestType(appointment.getTestType());
        return appointmentRepository.save(existingAppointment);
    }


}
