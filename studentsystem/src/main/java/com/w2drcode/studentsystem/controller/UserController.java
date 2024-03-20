package com.w2drcode.studentsystem.controller;

import com.w2drcode.studentsystem.model.Patient;
import com.w2drcode.studentsystem.model.User;
import com.w2drcode.studentsystem.model.UserLoginRequest;
import com.w2drcode.studentsystem.service.PatientService;
import com.w2drcode.studentsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PatientService patientService;

    @PostMapping("/register/{patientId}")
    public User registerUser(@PathVariable Integer patientId, @RequestBody User user) {
        if (patientId != null) {
            // If patient ID is provided, fetch users associated with that patient ID
            Patient patient = patientService.getPatientById(patientId);
            if (patient == null) {
                return null;
            }
            user.setPatient(patient);
        } else {
            // Handle the case where patient ID is not provided
            return null;
        }
        // Register the user
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserLoginRequest loginRequest) {
        try {
            User user = userService.login(loginRequest.getUsername(), loginRequest.getPassword());
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
