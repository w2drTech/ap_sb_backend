package com.w2drcode.studentsystem.service;

import com.w2drcode.studentsystem.model.Appointment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AppointmentService {
    public Appointment saveAppointment(Appointment appointment);
    public List<Appointment> getAppointments();
    public ResponseEntity<Object> getAppointment(int id);
    public String deleteAppointment(int id);
    public Appointment updateAppointment(Appointment appointment);
}
