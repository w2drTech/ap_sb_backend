package com.w2drcode.studentsystem.repository;

import com.w2drcode.studentsystem.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
