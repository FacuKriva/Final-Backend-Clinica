package com.example.clinica_final_backend.controllers;

import com.example.clinica_final_backend.model.DentistDTO;
import com.example.clinica_final_backend.service.implementations.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/dentist")
@CrossOrigin(origins = "http://localhost:8080")
public class DentistController {
     @Autowired
     private DentistService service;

     @PostMapping
     public ResponseEntity<String> postDentist(@RequestBody DentistDTO dentistDTO){
         if (bodyValidation(dentistDTO)){
             service.addNewDentist(dentistDTO);
             return ResponseEntity.ok("Dentist added successfully");
         } else return ResponseEntity.badRequest().body("Dentist could not be added, please check that" +
                 " all the fields are filled out correctly");
     }

     @GetMapping
     public ResponseEntity<Set<DentistDTO>> searchAllDentists(){
         return ResponseEntity.ok(service.searchAllDentists());
     }

     @GetMapping("/{id}")
     public ResponseEntity<DentistDTO> searchDentistById(@PathVariable Long id){
         return ResponseEntity.ok(service.searchDentistById(id));
     }

     @PutMapping("/{id}")
     public ResponseEntity<String> updateDentist(@PathVariable Long id, @RequestBody DentistDTO dentistDTO){
         if (bodyValidation(dentistDTO)){
             service.updateDentist(id, dentistDTO);
             return ResponseEntity.ok("Dentist updated successfully");
         } else return ResponseEntity.badRequest().body("Dentist could not be updated, please check that" +
                 " all the fields are filled out correctly");
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<String> removeDentist(@PathVariable Long id){
         service.removeDentist(id);
         return ResponseEntity.ok("Dentist deleted successfully");
     }

    private boolean bodyValidation(DentistDTO dentistDTO){
        boolean a;
        if (dentistDTO.getFirstName() != null && dentistDTO.getLastName() != null
                && dentistDTO.getRegistrationNumber() != null) {
            a = true;
        }
        else a = false;
        return a;
    }
}
