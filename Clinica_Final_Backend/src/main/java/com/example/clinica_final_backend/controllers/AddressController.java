package com.example.clinica_final_backend.controllers;

import com.example.clinica_final_backend.model.AddressDTO;
import com.example.clinica_final_backend.service.implementations.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "http://localhost:8080")
public class AddressController {

    private AddressService service;

    @Autowired
    private void setService(AddressService service){ this.service = service; }

    @PostMapping
    public ResponseEntity<AddressDTO> addNewAddress(@RequestBody AddressDTO addressDTO){
        return ResponseEntity.ok(service.addNewAddress(addressDTO));
    }

    @GetMapping
    public ResponseEntity<Set<AddressDTO>> searchAll(){ return ResponseEntity.ok(service.searchAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> searchById(@PathVariable Long id){
        return ResponseEntity.ok(service.searchById(id));
    }

    @PutMapping
    public ResponseEntity<?> updateAddress(@RequestBody AddressDTO addressDTO){
        service.updateAddress(addressDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeAddress(@PathVariable Long id){
        service.removeAddress(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
