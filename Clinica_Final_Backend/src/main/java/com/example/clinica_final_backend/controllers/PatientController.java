package com.example.clinica_final_backend.controllers;

import com.example.clinica_final_backend.model.PatientDTO;
import com.example.clinica_final_backend.service.implementations.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path = "/patient")
@CrossOrigin (origins = "http://localhost:3000")
public class PatientController {
    @Autowired
    private PatientService service;

    @PostMapping
    public ResponseEntity<String> postPatient(@RequestBody PatientDTO patientDTO){
        if (bodyValidation(patientDTO)){
            service.addNewPatient(patientDTO);
            return ResponseEntity.ok("Patient added successfully");
        } else return ResponseEntity.badRequest().body("Patient could not be added, please check that" +
                " all the fields are filled out correctly");
    }

    @GetMapping
    public ResponseEntity<Set<PatientDTO>> searchAllPatients(){
        return ResponseEntity.ok(service.searchAllPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> searchPatientById(@PathVariable Long id){
        return ResponseEntity.ok(service.searchPatientById(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updatePatient(@PathVariable Long id, @RequestBody PatientDTO patientDTO){
        if (bodyValidation(patientDTO)){
            service.updatePatient(id, patientDTO);
            return ResponseEntity.ok("Patient updated successfully");
        } else return ResponseEntity.badRequest().body("Patient could not be updated, please check that" +
                " all the fields are filled out correctly");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removePatient(@PathVariable Long id){
        service.removePatient(id);
        return ResponseEntity.ok("Patient deleted successfully");
    }

    private boolean bodyValidation(PatientDTO patientDTO){
        boolean a;
        if (patientDTO.getFirstName() != null && patientDTO.getLastName() != null
                && patientDTO.getDni() != null) {
            a = true;
        }
        else a = false;
        return a;
    }
}


