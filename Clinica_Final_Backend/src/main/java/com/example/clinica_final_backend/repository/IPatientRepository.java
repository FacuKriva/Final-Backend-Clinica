package com.example.clinica_final_backend.repository;

import com.example.clinica_final_backend.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPatientRepository extends JpaRepository <Patient, Integer> {
    void deleteById(Long id);

    Optional<Patient> findById(Long id);
}