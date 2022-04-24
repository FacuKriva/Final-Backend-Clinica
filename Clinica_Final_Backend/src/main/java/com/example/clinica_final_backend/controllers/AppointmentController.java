package com.example.clinica_final_backend.controllers;

import com.example.clinica_final_backend.model.AppointmentDTO;
import com.example.clinica_final_backend.service.implementations.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/appointment")
@CrossOrigin(origins = "http://localhost:8080")
public class AppointmentController {

    private AppointmentService service;

    @Autowired
    public void setService(AppointmentService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<AppointmentDTO> addNewAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        return ResponseEntity.ok(service.addNewAppointment(appointmentDTO));
    }

    @GetMapping
    public ResponseEntity<Set<AppointmentDTO>> searchAllAppointments() {
        return ResponseEntity.ok(service.searchAllAppointments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> searchAppointmentById(@PathVariable Long id) {
        return ResponseEntity.ok(service.searchAppointmentById(id));
    }

    @PutMapping
    public ResponseEntity<?> updateAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        service.updateAppointment(appointmentDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeAppointment(@PathVariable Long id) {
        service.removeAppointment(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}